package student_managment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_managment_project.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}

