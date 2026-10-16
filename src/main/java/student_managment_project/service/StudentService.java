package student_managment_project.service;


import student_managment_project.dto.*;

import java.util.List;

public interface StudentService {

    List<StudentListDto> getAllStudent();

    StudentDetailDto findByStudent(Long studentId);

    StudentResponseDto updateStudent(StudentUpdateDto updateDto);

    StudentResponseDto createStudent(StudentCreateDto createDto);

    StudentResponseDto deleteStudent(StudentDeleteDto deleteDto);

}
