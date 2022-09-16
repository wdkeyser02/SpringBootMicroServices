package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import willydekeyser.model.Todo;
import willydekeyser.repository.TodoRepository;

@RestController
@RequestMapping("/api/dashboard")
@Slf4j
@RequiredArgsConstructor
public class DashboardController {

	private final TodoRepository todoRepository;
	
	@PostMapping("/todos")
	public String loadTodos(@RequestBody List<Todo> todos) {
		log.info("Saved {} todos in the Dashboard database.", todos.size());
		todoRepository.saveAll(todos);
		return "Saved " + todos.size() + " todos in the Dashboard database.";
	}
}
