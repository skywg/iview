package com.ovit.bee;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.ovit.bee.common.BrowserFilter;
import com.ovit.bee.common.HttpServletResponseFilter;
import com.ovit.bee.common.WebMvcConfig;



/**
 * Created by on 2016/9/2.
 */
@SpringBootApplication
@Configuration
@EnableRedisHttpSession
public class Application extends  SpringBootServletInitializer {

	private static Logger logger = LogManager.getLogger(Application.class);

	@Value("${client.addr}")
	private String clientAddr;

	@Value("${include}")
	private String include;
	
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private String port;
	
	@Value("${spring.redis.password}")
	private String passwd;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		logger.info("spring boot start");
	}
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connection = new JedisConnectionFactory();
		connection.setPort(Integer.parseInt(port));
		connection.setHostName(host);
		connection.setPassword(passwd);
		return connection;
	}

	@Bean
	@Order(0)
	public FilterRegistrationBean filterRegistrationBean() {
		logger.info("register filter");
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HttpServletResponseFilter filter = new HttpServletResponseFilter();
		registrationBean.setFilter(filter);
		registrationBean.setName("HttpServletResponse filter");
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.addInitParameter("address", clientAddr);
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	@Bean
	@Order(1)
	public FilterRegistrationBean encodingFilterRegistrationBean() {
		logger.info("register encoding filter");
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(characterEncodingFilter);
		registrationBean.setName("characterEncoding filter");
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
	@Bean
	@Order(2)
	public FilterRegistrationBean browserFilterRegistrationBean() {
		logger.info("register browser filter");
		BrowserFilter browserFilter = new BrowserFilter();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(browserFilter);
		registrationBean.setName("browser filter");
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.addInitParameter("include", include);
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
	@Configuration
	class WebMvcConfig extends WebMvcConfigurerAdapter {
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry)  {
	        registry.addResourceHandler("/resource/static/**").addResourceLocations("/resource/static/");
	        super.addResourceHandlers(registry);
	    }
	}
}