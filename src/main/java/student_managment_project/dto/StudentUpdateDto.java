package student_managment_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {

    private Long studentId;

    private String name;

    private String surname;

    private String email;

    private Integer age;

}
