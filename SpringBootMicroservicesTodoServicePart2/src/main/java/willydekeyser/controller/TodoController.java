package willydekeyser.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Todo;
import willydekeyser.service.TodoClient;

@RestController
@RequiredArgsConstructor
public class TodoController {

	private final TodoClient todoClient;
		
	@GetMapping("/todos")
	public ResponseEntity<String> getTodos() {
		List<Todo> todos = todoClient.todos().getBody();
		return todoClient.sendToDashboard(todos);
	}
}
