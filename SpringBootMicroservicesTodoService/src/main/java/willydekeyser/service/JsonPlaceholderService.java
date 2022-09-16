package willydekeyser.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Todo;

@RequiredArgsConstructor
@Service
public class JsonPlaceholderService {

	
	private final String TODO_API_URL = "https://jsonplaceholder.typicode.com/todos";
	private final RestTemplate restTemplate;
	
	public List<Todo> getTodos() {
		ResponseEntity<List<Todo>> exchamge =  restTemplate.exchange(TODO_API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Todo>>() {});
		return exchamge.getBody();
	}
}
