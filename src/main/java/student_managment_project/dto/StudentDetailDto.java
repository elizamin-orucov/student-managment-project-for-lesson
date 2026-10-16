package student_managment_project.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailDto {
    private Long studentId;

    private String name;

    private String surname;

    private String email;

    private Integer age;
}
