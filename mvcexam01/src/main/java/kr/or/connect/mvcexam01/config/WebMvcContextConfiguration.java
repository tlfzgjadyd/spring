package kr.or.connect.mvcexam01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"kr.or.connect.mvcexam01.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
    //url요청에 img같은 요청 들어올수도 있는데 .do로 찾는 방식은 구식이니까 이렇게 미리 지정해놓고
	//"/img/**"같은 요청이 들어오면 "/img/"에서 찾으라는 설정
	//미리 어플리케이션 루트디렉터리 아래에 /img/ 만들어놓고 쓰겠단뜻
	//이게 없으면 프론트 컨트롤러가 가진 RequestMapping에서만 찾으려 하니 에러가 나겠지
	
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }	 // default servlet handler를 사용하게 합니다. 매핑되는 url없으면 스프링의 디폴트 서블릿 핸들러에게 넘기고
    	// 스프링은 그걸 또 was의 디폴트 핸들러에게 넘기고 그럼 걔가 static한 자원 읽어서 보여줌
    
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main");
        //여기있는 main만 가지곤 못찾으니까 아래의 Bean을 이용
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");    //view찾아주는 viewResolver객체 생성해두고
        resolver.setSuffix(".jsp");		        //prefix와 suffix를 미리 작성해두어
        return resolver;		        //위에서 써둔 main과 이어 /WEB-INF/views밑에있는
				        				//main.jsp를 찾아 보여주게 된다
    }
}
