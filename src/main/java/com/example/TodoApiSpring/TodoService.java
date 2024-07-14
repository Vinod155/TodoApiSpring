package com.example.TodoApiSpring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoService  implements FakeTodoService{

    @TimeMonitor
    @Override
    public String todoService() {
        for (int i = 0; i <1000000 ; i++) {

        }
        return "todo service";
    } //join point
}
