package willydekeyser.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import willydekeyser.model.Todo;
import willydekeyser.repository.TodoRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyCommandLineRunner implements CommandLineRunner{

	private final TodoService todoService;
	private final TodoRepository todoRepository;
	private final JsonPlaceholderService jsonPlaceholderService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Todo> todos = jsonPlaceholderService.getTodos();
		todoRepository.saveAll(todos);
		log.info("Saved {} todos in the Todos database.", todos.size());
		todoService.sendtoDashboard(todos);
		
	}

}