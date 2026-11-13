package student_managment_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_managment_project.models.HumanEntity;
import student_managment_project.repository.HumanRepository;

@RestController
@RequestMapping("/api/public/human")
public class HumanTestController {

    private final HumanRepository repository;

    public HumanTestController(HumanRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public ResponseEntity<String> createTest(){

        HumanEntity human = new HumanEntity();
        human.setAge(22);
        human.setName("Azer");
        human.setSurname("Hesenli");

        HumanEntity savedEntity = repository.save(human);

        savedEntity.setSurname("Yusifli");

        repository.save(savedEntity);

        return ResponseEntity.ok("Test create success");
    }


}
