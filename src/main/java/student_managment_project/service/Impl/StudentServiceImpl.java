package student_managment_project.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student_managment_project.dto.*;
import student_managment_project.exceptions.UserNotFoundException;
import student_managment_project.models.StudentEntity;
import student_managment_project.repository.StudentRepository;
import student_managment_project.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<StudentListDto> getAllStudent() {

        List<StudentEntity> students = repository.findAll();

        return students.stream().map(this::toListDto).toList();
    }

    @Override
    public StudentDetailDto findByStudent(Long studentId){

        StudentEntity student = repository.findById(studentId).orElseThrow(UserNotFoundException::new);

        return toDetailDto(student);
    }

    @Override
    public StudentResponseDto updateStudent(StudentUpdateDto updateDto) {

        repository.findById(updateDto.getStudentId()).orElseThrow(UserNotFoundException::new);

        StudentEntity updateStudent = toEntity(updateDto);

        repository.save(updateStudent);

        return toResponse("updated user", true);
    }

    @Override
    public StudentResponseDto createStudent(StudentCreateDto createDto) {
        StudentEntity entity = toEntity(createDto);

        repository.save(entity);

        return toResponse("created user", true);
    }

    @Override
    public StudentResponseDto deleteStudent(StudentDeleteDto deleteDto) {

        StudentEntity entity = repository.findById(deleteDto.getStudentId()).orElseThrow(UserNotFoundException::new);

        repository.delete(entity);

        return toResponse("deleted user", true);
    }

    // helper methods

    // to dto
    private StudentListDto toListDto(StudentEntity entity){
        return StudentListDto.builder()
                .studentId(entity.getStudentId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }

    private StudentDetailDto toDetailDto(StudentEntity entity){
        return StudentDetailDto.builder()
                .studentId(entity.getStudentId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .age(entity.getAge())
                .build();
    }

    // to entity
    private StudentEntity toEntity(StudentCreateDto createDto){
        return StudentEntity.builder()
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail())
                .age(createDto.getAge())
                .build();
    }

    private StudentEntity toEntity(StudentUpdateDto updateDto){
        return StudentEntity.builder()
                .studentId(updateDto.getStudentId())
                .name(updateDto.getName())
                .surname(updateDto.getSurname())
                .email(updateDto.getEmail())
                .age(updateDto.getAge())
                .build();
    }

    public StudentResponseDto toResponse(String message, boolean success){
        return StudentResponseDto.builder()
                .message(message)
                .success(success)
                .build();
    }





}
