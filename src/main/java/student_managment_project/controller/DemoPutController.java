package student_managment_project.controller;

import org.springframework.web.bind.annotation.*;
import student_managment_project.dto.test.Human;

@RestController
@RequestMapping("/put")
public class DemoPutController {


    @PostMapping
    public Human create(@RequestBody Human human){

        Human dbHuman = new Human();

        dbHuman.setName(human.getName());
        dbHuman.setSurname(human.getSurname());
        dbHuman.setAge(human.getAge());

        return human;

    }

}
