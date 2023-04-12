package newpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService<Todo> {

    @Autowired
    private TodoRepository<Todo> todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long todoId) throws Throwable {
        return todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found for this id :: " + todoId));
    }

    public Todo createTodo(Todo todo) {
        return (Todo) todoRepository.save(todo);
    }

    public Todo updateTodo(Long todoId, Todo todoDetails) throws Throwable {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found for this id :: " + todoId));

      //  todo.setTitle(todoDetails.getTitle());
      //  todo.setDescription(todoDetails.getDescription());
       // todo.setCompleted(todoDetails.getCompleted());

        return (Todo) todoRepository.save(todo);
    }

    public void deleteTodoById(Long todoId) throws Throwable {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found for this id :: " + todoId));

        todoRepository.delete(todo);
    }

    public <Todo> List<Todo> getTodos() {
        return null;
    }

    public <Todo> Todo addTodo(Todo todo) {
        return todo;
    }

    public <Todo> Todo updateTodoById(Long id, Todo todo) {
        return todo;
    }
}
