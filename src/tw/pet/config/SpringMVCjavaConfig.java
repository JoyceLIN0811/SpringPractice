package tw.pet.config;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//此類別為spring web的容器

/*@Configuration  代表設定Spring組態的Java類別
 * @ComponentScan相當於<context:component-scan base-package="一組套件" />
 * 標籤，讓MVC架構自動註冊元件
 * @EnableWebMvc 代表使用<mvc:annotation-driven /> ，預設會幫我們注射預設處理請求，
 * 參數和回傳直的類別
 */
//WebMvcConfigurer配置類其實是Spring內部的一種配置方式，
//採用JavaBean的形式來代替傳統的xml配置檔案形式進行鍼對框架個性化定製

@Configuration 
@EnableWebMvc
@ComponentScan(basePackages = "tw.pet")
public class SpringMVCjavaConfig implements WebMvcConfigurer { 
	//WebMvcConfigurer:提供回乎函數客製化MVC應用程式介面
	//屬於org.springframework.web.servlet.config.annotataion套件
	//是一個interface，定義多個回乎函數(call back)的方法，讓應用程式
	//修改MVC架構的預設設定
	
	@Autowired
	ServletContext context;
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//Default:默認
		//Handling:處理方式
		//啟用config檔案
		configurer.enable();
		System.out.println("config檔案啟動");
	}
	
	//@Bean放在方法 代表一個Bean元件的定義，方法名稱對應Bean的id屬性、方法
	//回傳型別對應Bean的class屬性、Bean元件的相依關係對應方法與方法的呼叫
	@Bean 
	public InternalResourceViewResolver viewResolver() {
		System.out.println("使用viewResolver() 方法  將網頁前面增加/WEB-INF/pet/");
		System.out.println("網頁後面增加.jsp");
		System.out.println("優先度為2，只低於DispatcherServletInitalizer");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class); //預設就有  JSTL
		viewResolver.setPrefix("/WEB-INF/pet/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}

		//自定義資源對映
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/petImage/");
		registry.addResourceHandler("/fragment/topcss/css/**").addResourceLocations("/WEB-INF/pet/fragment/topcss/css/");

		//		WebMvcConfigurer.super.addResourceHandlers(registry);
		//通過addResourceHandler新增對映路徑，然後通過addResourceLocations來指定路徑。
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    OpenSessionInViewInterceptor openSessionInViewInterceptor = new OpenSessionInViewInterceptor();
	    openSessionInViewInterceptor.setSessionFactory(sessionFactory);
	    registry.addWebRequestInterceptor(openSessionInViewInterceptor).addPathPatterns("/**");
	}
	
	
	
}
