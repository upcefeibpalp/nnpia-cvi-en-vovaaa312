package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.domain.request.AuthRequest;
import cz.upce.fei.nnpiavovaaa312.domain.request.RegisterRequest;
import cz.upce.fei.nnpiavovaaa312.domain.response.AuthResponse;
import cz.upce.fei.nnpiavovaaa312.repository.UserRepository;
import cz.upce.fei.nnpiavovaaa312.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request)  {
        if (userRepository.findByUsername(request.getUsername()) !=null) {
            String errorMessage = "User with username: {" + request.getUsername() + "} already exists";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        if(userRepository.findByEmail(request.getEmail()) != null) {
            String errorMessage = "User with email: {" + request.getEmail() + "} already exists";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

        }
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }




}
