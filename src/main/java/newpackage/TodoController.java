package newpackage;

//import com.example.demo.entity.Todo;
//import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController<Todo> {

    @Autowired
    private TodoService<Todo> todoService;

    @GetMapping("/")
    public List getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Long id) throws Throwable {
        return todoService.getTodoById(id);
    }

    @PostMapping("/")
    public Todo addTodo(@RequestBody Todo todo) {
        return (Todo) todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        return (Todo) todoService.updateTodoById(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") Long id) throws Throwable {
        todoService.deleteTodoById(id);
    }
}
