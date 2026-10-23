package student_managment_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

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

        return ResponseEntity.ok("Hello world!");
    }

}
