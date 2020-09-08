package blog.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource myDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.jdbcAuthentication().dataSource(myDataSource);
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/administration/company-info").hasRole("admin")
		.antMatchers("/administration/company-info-update").hasRole("admin")
		.antMatchers("/administration/front-text").hasRole("admin")
		.antMatchers("/administration/front-text-update").hasRole("admin")
		.antMatchers("/administration/slider-element-list").hasRole("admin")
		.antMatchers("/administration/slider-element-form").hasRole("admin")
		.antMatchers("/administration/message-list").hasRole("admin")
		.antMatchers("/administration/message-unread-list").hasRole("admin")
		.antMatchers("/administration/blogger-list").hasRole("admin")
		.antMatchers("/administration/blogger-banned-list").hasRole("admin")
		.antMatchers("/administration/blogger-form").hasRole("admin")
		.antMatchers("/administration/category-list").hasRole("admin")
		.antMatchers("/administration/category-form").hasRole("admin")
		.antMatchers("/administration/tag-list").hasRole("admin")
		.antMatchers("/administration/tag-form").hasRole("admin")
		.antMatchers("/administration/comment-list").hasRole("admin")
		.antMatchers("/administration/blog-post-list").hasRole("admin")
		
		.antMatchers("/administration/**").hasAnyRole("employee, admin")
		.and().formLogin().loginPage("/login").
		loginProcessingUrl("/authenticateTheUser").permitAll();

		
	}
	
}
