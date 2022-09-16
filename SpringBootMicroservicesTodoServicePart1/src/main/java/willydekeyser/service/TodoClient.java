package willydekeyser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import willydekeyser.model.Todo;

@HttpExchange
public interface TodoClient {
	
	@GetExchange("${jsonPlaceholder.url}")
	ResponseEntity<List<Todo>> todos();
}
