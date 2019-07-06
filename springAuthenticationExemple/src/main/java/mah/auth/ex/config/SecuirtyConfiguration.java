package mah.auth.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import mah.auth.ex.repos.UserRepo;
import mah.auth.ex.services.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
@Configuration 
public class SecuirtyConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 	 auth.userDetailsService(userDetailsService)
		 .passwordEncoder(getPasswordEncoder()); 
	}
	
	protected void configure(HttpSecurity httpSecure) throws Exception {
		httpSecure.csrf().disable();
		httpSecure.authorizeRequests()
			.antMatchers("**/secuired/**").authenticated()
			.anyRequest().permitAll()
			.and().formLogin().permitAll();//loginPage("")
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) { 
				return true;
			}
			
			@Override
			public String encode(CharSequence rawPassword) { 
				return rawPassword.toString();
			}
		};
	}

}
