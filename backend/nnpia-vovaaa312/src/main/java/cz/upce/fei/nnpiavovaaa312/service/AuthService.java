package cz.upce.fei.nnpiavovaaa312.service;

import cz.upce.fei.nnpiavovaaa312.domain.SystemRole;
import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.domain.request.AuthRequest;
import cz.upce.fei.nnpiavovaaa312.domain.request.RegisterRequest;
import cz.upce.fei.nnpiavovaaa312.domain.response.AuthResponse;
import cz.upce.fei.nnpiavovaaa312.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(SystemRole.SYSTEM_USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .jwtResponse(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
       // if(user == null) throw new NullPointerException("User not found");

        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .jwtResponse(jwtToken)
                .build();
    }


}