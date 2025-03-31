package cz.upce.fei.nnpiavovaaa312.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import cz.upce.fei.nnpiavovaaa312.dto.UserResponseDto;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String password;
    private String username;
    private String email;
    @Enumerated(EnumType.STRING)
    private SystemRole role;

    private boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin(){
        return role.equals(SystemRole.SYSTEM_ADMIN);
    }

    // Pomocná metoda pro převod entity na DTO.
    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .id(Id)
                .username(username)
                .email(email)
                .role((role != null) ? role.name() : null)
                .active(active)
                .build();
    }
}
