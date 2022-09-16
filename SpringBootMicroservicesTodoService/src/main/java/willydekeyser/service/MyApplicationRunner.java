package willydekeyser.service;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import willydekeyser.model.Todo;
import willydekeyser.repository.TodoRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyApplicationRunner implements ApplicationRunner{

	private final TodoClient todoClient;
	private final TodoRepository todoRepository;
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
			List<Todo> todos = todoClient.todos().getBody();
			todoRepository.saveAll(todos);
			log.info("Saved {} todos in the database.", todos.size());
			String text = todoClient.create(todos).getBody();
			log.info(text);
			log.info("{} Todos send to Dashboard.", todos.size());
		
	
		
	}

}
