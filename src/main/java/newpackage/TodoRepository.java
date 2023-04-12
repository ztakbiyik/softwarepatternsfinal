package newpackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository<Todo> extends JpaRepository<Todo, Long> {

}
