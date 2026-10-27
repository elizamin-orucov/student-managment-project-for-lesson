package student_managment_project.security;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import student_managment_project.models.UserEntity;
import student_managment_project.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity databaseUser = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("user tapilmadi")
        );

        return User.builder()
                .username(databaseUser.getUsername())
                .password(databaseUser.getPassword())
                .roles(databaseUser.getRole().name())
                .build();
    }
}
