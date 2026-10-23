package student_managment_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_managment_project.dto.test.Human;

@RestController
@RequestMapping("/patch")
public class DemoPatchController {

    @PostMapping
    public Human create(@RequestBody Human human){

        Human dbHuman = new Human("Orxan", "Hesenli", 20);



        if (human.getName() != null) {
            dbHuman.setName(human.getName());
        }

        if (human.getSurname() != null) {
            dbHuman.setSurname(human.getSurname());
        }

        if (human.getAge() != 0){
            dbHuman.setAge(human.getAge());
        }

        return dbHuman;

    }

}
