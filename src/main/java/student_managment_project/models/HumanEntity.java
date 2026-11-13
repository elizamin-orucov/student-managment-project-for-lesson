package student_managment_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@SuperBuilder
@Table(name = "human")
public class HumanEntity extends BaseEntity{
    private String name;
    private String surname;
    private Integer age;
}
