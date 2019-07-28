package firstappdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wcz
 * @date 2019-07-26 22:29
 * Spring Security
 * Java 代码中配置用户名密码
 **/
/**
 * Add this annotation to an {@code @Configuration} class to have the Spring Security
 * configuration defined in any {@link //WebSecurityConfigurer} or more likely by extending
 * the {@link WebSecurityConfigurerAdapter} base class and overriding individual methods:
 *
 * 意思是说， 该注解和 @Configuration 注解一起使用,
 * 注解 WebSecurityConfigurer 类型的类，或者利用 @EnableWebSecurity 注解
 * 继承 WebSecurityConfigurerAdapter的类，这样就构成了 Spring Security 的配置。
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//下面这两行配置表示在内存中配置了两个用户
		auth.inMemoryAuthentication()
				.withUser("javaboy").roles("admin").password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe")
				.and()
				.withUser("lisi").roles("user").password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//过滤掉该地址，即该地址不走 Spring Security 过滤器链
		web.ignoring().antMatchers("/vercode");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SecurityConfig securityConfig = new SecurityConfig();
		String pwd = "123456";
		String s = securityConfig.passwordEncoder().encode(pwd);
		logger.info();
		s.matches(pwd);
	}

}


