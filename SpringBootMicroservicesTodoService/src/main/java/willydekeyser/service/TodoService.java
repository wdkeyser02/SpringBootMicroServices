package willydekeyser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import willydekeyser.model.Todo;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

	private final String DASHBOARD_API_URL = "http://localhost:8081/api/dashboard/todos";
	private final RestTemplate restTemplate;
	
	public void sendtoDashboard(List<Todo> todos) {
		ResponseEntity<String> reponse = restTemplate.postForEntity(DASHBOARD_API_URL, todos, String.class);
		if (reponse.getStatusCode().is2xxSuccessful()) {
			log.info("Todos send to Dashnoard successfully!");
		}
	}
}
