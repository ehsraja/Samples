package com.sam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import com.sam.security.RestUnauthorizedEntryPoint;




@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.sam.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
	 public static final String REMEMBER_ME_KEY = "rememberme_key";
	 
	 @Autowired
	    private AuthenticationSuccessHandler successHandler;

	    @Autowired
	    private AuthenticationFailureHandler failureHandler;
	    
	    @Autowired
	    private RestUnauthorizedEntryPoint restUnauthorizedEntryPoint;

	    @Autowired
	    private AccessDeniedHandler restAccessDeniedHandler;
	    
	/*    @Autowired
	    private CoustmAuthProvider CoustmAuthProvider ;
*/
	    
	    @Autowired
	    private UserDetailsService userDetailsService;
	 
	 public SecurityConfig() {
	        super();
	        System.out.println("loading SecurityConfig ................................................ ");
	    }
	 
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	         System.out.println("checking login");
		     auth.inMemoryAuthentication().withUser("asd").password("123").roles("USER");
	     //    auth.authenticationProvider(CoustmAuthProvider).userDetailsService(userDetailsService);
	    }
	 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/").permitAll()
	        .anyRequest().authenticated().and()
	        .exceptionHandling()
            .authenticationEntryPoint(restUnauthorizedEntryPoint)
            .accessDeniedHandler(restAccessDeniedHandler)
            .and()
	        .formLogin()
            .loginProcessingUrl("/authenticate")
            .successHandler(successHandler)
            .failureHandler(failureHandler)
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .and()
            .rememberMe().rememberMeParameter("rememberme").and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .deleteCookies("JSESSIONID")
            .permitAll()
            .and();
	 }   
	 
	 
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**", "/index.html", "/view/login.html",
	                "/partials/**", "/template/**", "/", "/error/**","/js/**","/css/*",
	                "/bower_components/**");
	    }

	        

}
