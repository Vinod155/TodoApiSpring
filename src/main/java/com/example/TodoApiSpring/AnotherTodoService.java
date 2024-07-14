package com.example.TodoApiSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("anotherTodoService")
public class AnotherTodoService implements FakeTodoService {
    @Override
    public String todoService() {
        return "another todo service";
    }
}
