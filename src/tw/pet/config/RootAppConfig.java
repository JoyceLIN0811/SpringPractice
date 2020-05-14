package tw.pet.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;





@Configuration
@EnableTransactionManagement
public class RootAppConfig {

	@Bean
	public DataSource sqlServerDataSource() {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=PETDB");
//		ds.setUsername("sa");
//		ds.setPassword("sa123456");
//		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		
// ---------------------------------------------------------------------------------
		ComboPooledDataSource ds = new ComboPooledDataSource();
		System.out.println("sqlServerDataSource()");
		ds.setUser("sa");
		ds.setPassword("sa123456");
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=PETDB");
		ds.setInitialPoolSize(4);
		ds.setMaxPoolSize(8);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan(new String[] {
					"tw.pet.model"
				});

			factory.setDataSource(sqlServerDataSource());
			factory.setHibernateProperties(additionalPropertiesMsSQL());
	    System.out.println("factory"+factory);
		return factory;
	}
	
	@Bean("transactionManager") //用來開啟交易
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
         HibernateTransactionManager txManager = new HibernateTransactionManager();
         txManager.setSessionFactory(sessionFactory);
         return txManager;
      }	
	
	
	private Properties additionalPropertiesMsSQL() {
		Properties properties=new Properties();
		//org.hibernate.dialect.SQLServer2012Dialect.class 
		//這個很重要  要用2012的類別  dialect:方言,目前沒有最新的
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		//要不要展示語法，專題的時候建議關掉
		//因為會吃系統速度
		//但是開發的時候必須要打開
		properties.put("hibernate.show_sql", Boolean.TRUE);
		//秀出來以後要不要排版
		properties.put("hibernate.format_sql", Boolean.TRUE);
		//此為存取效能有關
		properties.put("default_batch_fetch_size", 10);
		//create 為刪掉表格重新啟動
		//update 專題一定要用這個  去做更新
		//如果專題的資料亂掉了  不要用create去重建 因為如果忘記改回來會造成資料再次銷毀
		//update 的特性  如果啟動的時候沒有的表格會自動去重建
		//如果有的話會自動去尋找對應的關係 @ENTITY
		//會跟表格對應 ，如果不再會建立新的  在的話會去看對應的屬性有沒有正確
		//少了會幫我們加上，多了不會幫我們刪掉
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
}
