package student_managment_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_managment_project.dto.*;
import student_managment_project.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentListDto>> getAll(){

        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetailDto> detail(@RequestParam("id") Long studentId){
        return ResponseEntity.ok(studentService.findByStudent(studentId));
    }

    @PutMapping
    public ResponseEntity<StudentResponseDto> update(@RequestBody StudentUpdateDto update){
        return ResponseEntity.ok(studentService.updateStudent(update));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentCreateDto createDto){
        return ResponseEntity.status(201).body(studentService.createStudent(createDto));
    }

    @DeleteMapping
    public ResponseEntity<StudentResponseDto> delete(@RequestBody StudentDeleteDto deleteDto){
        return ResponseEntity.status(200).body(studentService.deleteStudent(deleteDto));
    }


}
