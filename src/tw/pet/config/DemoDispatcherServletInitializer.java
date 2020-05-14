package tw.pet.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//request請求的servlet
//此類別會順便把Web版本的IOC容器給建立起來  一定要繼承這個AbstractAnnotationConfigDispatcherServletInitializer 父類別
public class DemoDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//需要有兩個方法提供BEAN的組態資訊  分別為getRootConfigClasses() ,getServletConfigClasses() 
	
//getRootConfigClasses() 用來定義共用的Bean，比如說同一個資料庫  也就是說跟資料庫有關的都要寫在這個類別，	
//getServletConfigClasses() 跟資料庫沒有關係的類別都寫在這裡
//RootConfig :	 使用 Spring 來管理 UserService、AccountDAOJdbcImpl、MessageDAOJdbcImpl、DataSource 等元件之組合
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("使用getRootConfigClasses()方法");
		//new 為動態產生陣列  並且把元素放進去
		//RootAppConfig.class 這樣寫表示他是一個物件 類似String.class int.class double.clss 都是物件
		return new Class[] {RootAppConfig.class}; //沒有Root WebApplicationContext
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("使用getServletConfigClasses() 方法");
		System.out.println("SpringMVCjavaConfig.class ="+SpringMVCjavaConfig.class);
		return new Class[] {SpringMVCjavaConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("使用getServletMappings() 方法  並且回傳 new String[] {\"/\"}");
		//定義何種請求需要分配器
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		System.out.println("使用getServletFilters()的方法去做編譯 回傳一個Filter[] 的陣列");
		CharacterEncodingFilter charEncodeFilter = new CharacterEncodingFilter();
		HiddenHttpMethodFilter  hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		charEncodeFilter.setEncoding("UTF-8");
		//.setForceEncoding :設定強制編碼
		charEncodeFilter.setForceEncoding(true);
		return new Filter[] {charEncodeFilter,hiddenHttpMethodFilter};
	}
	
	
}









