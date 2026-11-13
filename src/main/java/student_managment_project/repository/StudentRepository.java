package student_managment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_managment_project.models.ProductEntity;
import student_managment_project.models.StudentEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {



}
