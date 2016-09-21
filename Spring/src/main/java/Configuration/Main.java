package Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Main {
	
	public static void main(String[] args) {
		 ApplicationContext ctx = 
			      new AnnotationConfigApplicationContext(Main.class);
			   
			      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

			      
	}

}
