package aop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:app.properties")
public class Main {
	
	@Autowired
	Environment env;
	
	@Bean
	public CustomerService disc() {
		CustomerService service =  new CustomerService();
		service.setName(env.getProperty("app.name"));
		service.setName(env.getProperty("app.url"));
		return service ;
		}
	
	@Bean
	public BeforeAdvise beforeAdvise() {
		return new BeforeAdvise();
		}
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = 
			      new AnnotationConfigApplicationContext(Main.class);
			   
		CustomerService service = ctx.getBean(CustomerService.class);
		service.printName();
		
	}
	
	
	

}
