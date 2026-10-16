package student_managment_project.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class StudentListDto {

    private Long studentId;

    private String name;

    private String surname;

}
