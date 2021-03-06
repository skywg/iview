package com.ovit.bee.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

//@Configuration
@EnableWebMvc  
@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages={"com.ovit.bee.web"},useDefaultFilters = false, includeFilters = @ComponentScan.Filter(value = {Controller.class, RestController.class}))  
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static Logger logger = LogManager.getLogger(WebMvcConfig.class);

	@Autowired
	private Environment env;
	/**
	 * fastJson相关设置
	 */
	private FastJsonConfig getFastJsonConfig() {
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 在serializerFeatureList中添加转换规则
		List<SerializerFeature> serializerFeatureList = new ArrayList<SerializerFeature>();
		serializerFeatureList.add(SerializerFeature.PrettyFormat);
		serializerFeatureList.add(SerializerFeature.WriteMapNullValue);
		serializerFeatureList.add(SerializerFeature.WriteNullStringAsEmpty);
		serializerFeatureList.add(SerializerFeature.WriteNullListAsEmpty);
		serializerFeatureList.add(SerializerFeature.DisableCircularReferenceDetect);
		SerializerFeature[] serializerFeatures = serializerFeatureList.toArray(new SerializerFeature[serializerFeatureList.size()]);
		fastJsonConfig.setSerializerFeatures(serializerFeatures);
		return fastJsonConfig;
	}

	/**
	 * fastJson相关设置
	 */
	private FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("application/json"));
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(getFastJsonConfig());
		return fastJsonHttpMessageConverter;
	}

	/**
	 * 添加fastJsonHttpMessageConverter到converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(fastJsonHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());  
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)                         {
        registry.addResourceHandler("/resource/static/**").addResourceLocations("/resource/static/");
    }

	@Override  
    public void addFormatters(FormatterRegistry registry) {  
        super.addFormatters(registry);  
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ss");  
        dateFormatter.setLenient(true);  
        registry.addFormatter(dateFormatter);  
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
	public FilterRegistrationBean sessionFilterRegistrationBean() {
		logger.info("register session filter");
		SessionStatusFilter sessionFilter = new SessionStatusFilter();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(sessionFilter);
		registrationBean.setName("session filter");
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.addInitParameter("exclude", env.getProperty("exclude"));
		return registrationBean;
	}	

	@Bean  
    public ServletRegistrationBean mvcDispatcherRegistration() {  
        DispatcherServlet dispatcherServlet = new DispatcherServlet();  
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();  
        dispatcherServlet.setApplicationContext(applicationContext);  
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/");  
        servletRegistrationBean.setName("springMvc");  
        return servletRegistrationBean;  
    }
}
