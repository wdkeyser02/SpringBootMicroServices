package willydekeyser.repository;

import org.springframework.data.repository.CrudRepository;

import willydekeyser.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer>{

}
