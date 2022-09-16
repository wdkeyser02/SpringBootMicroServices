package willydekeyser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Todo;

@Repository
public interface TodoRepository  extends CrudRepository<Todo, Integer>{

}
