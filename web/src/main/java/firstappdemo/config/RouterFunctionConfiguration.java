package firstappdemo.config;

import firstappdemo.domain.User;
import firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author wcz
 * 路由器函数 配置
 * @date 2019-06-08 14:14
 **/
@Configuration
public class RouterFunctionConfiguration {

	@Bean
	@Autowired
	public RouterFunction<ServerResponse> personFindeAll(UserRepository userRepository){
		return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
				request->{
					//返回所有用户对象
					Collection<User> users = userRepository.findAll();
					Flux<User> userFlux = Flux.fromIterable(users);
					return ServerResponse.ok().body(userFlux,User.class);
				});
	}
}
