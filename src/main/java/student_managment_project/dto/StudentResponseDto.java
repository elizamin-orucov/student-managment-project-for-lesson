package student_managment_project.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private String message;

    private boolean success;
}
