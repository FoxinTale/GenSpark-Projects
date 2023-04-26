package org.clientproject.Controllers;

import org.clientproject.Services.ClientService;
import org.clientproject.Services.ProjectService;
import org.clientproject.Services.TaskService;
import org.clientproject.Services.UserService;
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
