package student_managment_project.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist // entity create olduqda
    protected void onCreate(){
        createdAt = LocalDateTime.now(); // 13.11.2026-19:50
        updatedAt = LocalDateTime.now(); // 13.11.2026-19:50
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now(); // 17.11.2026-20:50
    }


}
