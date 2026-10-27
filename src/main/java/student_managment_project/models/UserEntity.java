package student_managment_project.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

}
