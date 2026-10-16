package student_managment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_managment_project.models.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
