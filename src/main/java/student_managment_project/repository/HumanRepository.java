package student_managment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_managment_project.models.HumanEntity;

public interface HumanRepository extends JpaRepository<HumanEntity, Long> {
}
