package com.ovit.bee.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableRedisHttpSession
@MapperScan(basePackages = "com.ovit.bee.IDao", sqlSessionFactoryRef = "sqlSessionFactory")
public class DatasourceConfig {

	private static Logger logger = LogManager.getLogger(DatasourceConfig.class);

	@Autowired
	private Environment env;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setPoolName("springHikariCP");
		config.setJdbcUrl(env.getProperty("jdbc.url"));
		config.setUsername(env.getProperty("jdbc.username"));
		config.setPassword(env.getProperty("jdbc.password"));
		config.setReadOnly(false);
		config.setAutoCommit(false);
		config.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("useServerPrepStmts", "true");
		// config.setMinimumIdle(minPoolSize);
		// config.setMaximumPoolSize(maxPoolSize);
		config.setConnectionInitSql("SELECT 1");
		config.setConnectionTimeout(Long.parseLong(env.getProperty("jdbc.connectontimeout")) * 1000L);
		return new HikariDataSource(config);
	}

	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connection = new JedisConnectionFactory();
		connection.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
		//connection.setPassword(env.getProperty("spring.redis.password"));
		connection.setHostName(env.getProperty("spring.redis.host"));
		return connection;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources(env.getProperty("mybatis.mapper-locations")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		// 解决Mybatis-springboot打包jar找不到对应class问题
		VFS.addImplClass(SpringBootVFS.class);
		bean.setDataSource(dataSource());
		bean.setFailFast(true);
		bean.setTypeAliasesPackage("com.ovit.bee.pojo");
		PageInterceptor inceptor = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("params", "pageNum=pageNumKey;pageSize=pageSizeKey;");
		inceptor.setProperties(p);
		bean.setPlugins(new Interceptor[] { inceptor });
		return bean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * 分页插件
	 *
	 * @param dataSource
	 * @return
	 * @author SHANHY
	 * @create 2016年2月18日
	 */
	@Bean
	public PageHelper pageHelper(DataSource dataSource) {
		logger.info("注册MyBatis分页插件PageHelper");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("params", "pageNum=start;pageSize=limit;");
		p.setProperty("supportMethodsArguments", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}