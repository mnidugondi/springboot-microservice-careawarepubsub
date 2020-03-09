package com.cerner.careaware.context.config.parent;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.cerner.careaware.ibus.data.spring.mysql.IBusHikariDataSource;
import com.cerner.careaware.ibus.data.spring.mysql.MultiTenantJpaConfig;
import com.cerner.careaware.ibus.data.spring.mysql.SchemaNameHelper;


@Component
public class ParentContextProvider implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}

	public static ApplicationContext getApplicationContext() {
	      return applicationContext;
	}
	
	public static DataSource getHikariDataSource() throws Exception {
		MultiTenantJpaConfig multiTenantJpaConfig  =  getApplicationContext()
				.getBean(MultiTenantJpaConfig.class);
		
		IBusHikariDataSource ds =  (IBusHikariDataSource) multiTenantJpaConfig.createNewDataSource();
		
		SchemaNameHelper schemaNameHelper = ParentContextProvider.getApplicationContext()
				.getBean(SchemaNameHelper.class);
		ds.setSchemaHelper(schemaNameHelper);
		return ds;

	}
}
