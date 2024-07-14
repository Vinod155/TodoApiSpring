package com.example.TodoApiSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private static List<Todo> todos;

    private final  FakeTodoService todoService;//composition means you have kept instance of another class as your class property

    private final  FakeTodoService todoService2;//composition means you have kept instance of another class as your class property

    public TodoController(@Qualifier("anotherTodoService") FakeTodoService todoService, @Qualifier("todoService") FakeTodoService todoService2)
    {
        this.todoService2 = todoService2;
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
        todos.add(new Todo(3,false,"Todo 1",3));
        this.todoService=todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos()
    {
        System.out.println(this.todoService.todoService());
        System.out.println(this.todoService2.todoService());
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> createtodo(@RequestBody Todo newTodo)
    {
       todos.add(newTodo);
       return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable long todoId)
    {
        for(Todo todo: todos)
        {
            if(todo.getId()==todoId)
            {
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.badRequest().body("ToDo not found");
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deletebyId(@PathVariable long todoId)
    {
        for(Todo todo:todos)
        {
            if(todo.getId()==todoId)
            {
                todos.remove(todo);
                return ResponseEntity.ok().body("deleted Successfully");
            }
        }
        return ResponseEntity.badRequest().body("deletion  Unsuccessfull");
    }

    @GetMapping("/complete")
    public ResponseEntity<List<Todo>> todoIsCompeleted(@RequestParam(required = false,defaultValue = "true") boolean isCompleted) {
        List<Todo> res=new ArrayList<>();
        for (Todo todo : todos) {


            if (todo.isCompleted()==isCompleted) {
                res.add(todo) ;
            }
        }

        return ResponseEntity.ok(res);
    }

}
