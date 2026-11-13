package student_managment_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import student_managment_project.service.StudentService;

@RestController
public class DemoController {

    private final StudentService studentService;

    public DemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/user")
    public ResponseEntity<String> student(){

        return ResponseEntity.ok("Bu seyfreni studentler gorecek");
    }

    @GetMapping("/api/admin")
    public ResponseEntity<String> admin(){

        return ResponseEntity.ok("Bu seyfreni admin gorecek");
    }

    @GetMapping("/api/public")
    public ResponseEntity<String> publicEndpoint(){

        studentService.createStudent();

        return ResponseEntity.ok("Hello world!");
    }

}
