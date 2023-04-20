package org.example.Controllers;

import org.example.Services.ClientService;
import org.example.Services.ProjectService;
import org.example.Services.TaskService;
import org.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProjectService projectservice;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(){
        return "<HTML></h1>The home page of the application.</h1></HTML>";
    }

    /*
    The rest of everything I think I need to implement the services first.
     */

}
