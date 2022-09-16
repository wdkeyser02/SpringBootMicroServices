package willydekeyser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import willydekeyser.service.TodoClient;

@Configuration
public class AppConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	TodoClient todoClient(HttpServiceProxyFactory httpServiceProxyFactory) {
		return httpServiceProxyFactory.createClient(TodoClient.class);
	}
	
	@Bean
	HttpServiceProxyFactory httpServiceProxyFactory() {
		WebClient webClient = WebClient.create();
		HttpServiceProxyFactory httpServiceProxyFactory = WebClientAdapter.createHttpServiceProxyFactory(webClient);
		return httpServiceProxyFactory;
	}
	
}
