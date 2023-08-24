package tn.esprit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import tn.esprit.services.MyLogDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private MyLogDetailsService logDetailsService;
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();

		}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	}

	@Bean
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(logDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests() .antMatchers("/authenticate").permitAll()
		                          .antMatchers("/article").permitAll()
							 	 .antMatchers("/admin/**").permitAll()
							 	 //.antMatchers("/agent/**").permitAll()
							 	.antMatchers("/report/**").permitAll()
							 	.antMatchers("/log/**").permitAll()
							 	.antMatchers("/companyclient/**}").permitAll()
		                        .antMatchers("/Contract/**").permitAll()
		                        .antMatchers("/product/**").permitAll()
		                        .antMatchers("/payment/**").permitAll()
		                        .antMatchers("/sinister/**").permitAll()
                                 .anyRequest().authenticated()
                                 //.and().formLogin().loginPage("/login").permitAll()
                     			 .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                 .logoutSuccessUrl("/authenticate?logout")
                                 .deleteCookies("JSESSIONID")
                                 .invalidateHttpSession(true).permitAll()
                                 .and().httpBasic().
                                  and().
                                  exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                                  and().
                  				// make sure we use stateless session; session won't be used to
                  				// store user's state.
                  				  sessionManagement()
                  				 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                                  and().csrf().disable();
                                 
		// Add a filter to validate the tokens with every request
				http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				return http.build();
	}*/
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();

		}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(logDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() .antMatchers("/authenticate").permitAll()
		                          .antMatchers("/article").permitAll()
							 	 .antMatchers("/admin/**").permitAll()
							 	 //.antMatchers("/agent/**").permitAll()
							 	.antMatchers("/report/**").permitAll()
							 	.antMatchers("/log/**").permitAll()
							 	.antMatchers("/companyclient/**}").permitAll()
		                        .antMatchers("/Contract/**").permitAll()
		                        .antMatchers("/product/**").permitAll()
		                        .antMatchers("/payment/**").permitAll()
		                        .antMatchers("/sinister/**").permitAll()
		                          //.antMatchers("/pdf/generate").permitAll()
		                         //.antMatchers("/product/retrieve-all-products").permitAll()
		                        // .antMatchers("/product/retrieve-product/**").permitAll()
		                         .antMatchers("/product/**").access("hasAnyRole('ADMIN','AGENT')")
		                         //.antMatchers("/Contract/add-contract").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT','COMPANYCLIENT')")
		                         //.antMatchers("/Contract/**").access("hasAnyRole('ADMIN','AGENT')")
		                         //.antMatchers("payment/add-payment/**").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT','COMPANYCLIENT')")
                                // .antMatchers("/payment/**").access("hasAnyRole('ADMIN','AGENT')")
		                         //.antMatchers("/APIPayment/createPayment").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT','COMPANYCLIENT')")
		                         .antMatchers("/companyclient/add-companyclient").permitAll()
		                         //.antMatchers("/companyclient/modify-companyclient").access("hasAnyRole('ADMIN','AGENT','COMPANYCLIENT')")
		                        // .antMatchers("/companyclient/**").access("hasAnyRole('ADMIN','AGENT')")
		                         //.antMatchers("/particularclient/add-particularclient").permitAll()
		                        // .antMatchers("/particularclient/modify-particularclient").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT')")
		                         //.antMatchers("/particularclient/**").access("hasAnyRole('ADMIN','AGENT')")
		                        // .antMatchers("/agent/**").access("hasRole('ADMIN')")
		                         //.antMatchers("/expert/**").access("hasRole('ADMIN')")
		                        // .antMatchers("/sinister/add-sinister").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT','COMPANYCLIENT')")
		                         //.antMatchers("/sinister/modify-sinister").access("hasAnyRole('ADMIN','AGENT','PARTICULARCLIENT','COMPANYCLIENT','EXPERT')")
		                         //.antMatchers("/sinister/**").access("hasAnyRole('AGENT','ADMIN')")
		                        // .antMatchers("/report/**").access("hasRole('ADMIN')")
		                         .antMatchers("/pdf/generateReport/**").permitAll()  
		                         //.antMatchers("/log/**").access("hasRole('ADMIN')") 
		                         //.antMatchers("/api/**").access("hasRole('ADMIN')")   
		                         //.antMatchers("/admin/**").access("hasRole('ADMIN')")
		                         
		                         //.antMatchers("/Contract/retrieve-all-contracts").access("hasRole('ADMIN')")
		                         //.antMatchers("/Contract/add-contract").access("hasRole('ADMIN')")
                                 /*.antMatchers("/agent/**}").hasAuthority("Role_ADMIN")
                                 .antMatchers("/report/**}").hasAuthority("Role_ADMIN")
                                 .antMatchers("/companyclient/**}").hasAuthority("Role_ADMIN")
                                 .antMatchers("/particularclient/**}").hasAnyAuthority("Role_ADMIN","Role_PARTICULARCLIENT")
                                 .antMatchers("/companyclient/**}").hasAnyAuthority("Role_ADMIN","Role_COMPANYCLIENT")
                                 .antMatchers("/product/**}").hasAnyAuthority("Role_ADMIN","AGENT")
                                 .antMatchers("/contract/**}").hasAnyAuthority("Role_ADMIN","AGENT")
                                 .antMatchers("/sinister/**}").hasAnyAuthority("Role_PARTICULARCLIENT","Role_COMPANYCLIENT","Expert")*/
                                 .anyRequest().authenticated()
                                 //.and().formLogin().loginPage("/login").permitAll()
                     			 .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                 .logoutSuccessUrl("/authenticate?logout")
                                 .deleteCookies("JSESSIONID")
                                 .invalidateHttpSession(true).permitAll()
                                 .and().httpBasic().
                                  and().
                                  exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                                  and().
                  				// make sure we use stateless session; session won't be used to
                  				// store user's state.
                  				  sessionManagement()
                  				 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                                  and().csrf().disable();
                                 
		// Add a filter to validate the tokens with every request
				http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
