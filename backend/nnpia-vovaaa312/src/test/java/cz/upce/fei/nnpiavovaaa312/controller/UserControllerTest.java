package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.configuration.TestSecurityConfig;
import cz.upce.fei.nnpiavovaaa312.domain.SystemRole;
import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserAlreadyExistsException;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserNotFoundException;
import cz.upce.fei.nnpiavovaaa312.service.JwtService;
import cz.upce.fei.nnpiavovaaa312.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
/*
 *Nastav TestSecurityConfig jako konfiguraci pro Spring security. Tím vypneš autentifikaci a autorizaci pro tuto testovací
 * třídu.
 * */
@Import(TestSecurityConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    /* Přidáme mock pro JwtService protože JwtAuthenticationFilter jej využívá jako závilost.
     * Tím zajistíme, že neselže načítání kontextu.
     * */
    @MockitoBean
    private JwtService jwtService;

    @Test
    public void testFindById() throws Exception {
        Long userId = 1L;
        User expectedUser = new User();
        expectedUser.setId(userId);
        expectedUser.setUsername("John Doe");

        Mockito.when(userService.findById(userId)).thenReturn(expectedUser);

        mockMvc.perform(get("/api/users/" + 1))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"username\":\"John Doe\"}"));
    }


    @Test
    public void testFindByIdNotFound() throws Exception {
        Long userId = 1L;

        Mockito.when(
                userService.findById(userId))
                .thenThrow(new UserNotFoundException("User with id " + userId + " not found")
                );

        mockMvc.perform(get("/api/users/" + userId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setId(1L);
        newUser.setPassword("password");
        newUser.setUsername("John Doe");
        newUser.setEmail("john.doe@example.com");
        newUser.setRole(SystemRole.SYSTEM_USER);

        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(newUser);

        mockMvc.perform(post("/api/users/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateUserConflict() throws Exception {
        User newUser = new User();
        newUser.setId(1L);
        newUser.setPassword("password");
        newUser.setUsername("John Doe");
        newUser.setEmail("john.doe@example.com");
        newUser.setRole(SystemRole.SYSTEM_USER);

        Mockito.when(userService.save(Mockito.any(User.class)))
                .thenThrow(new UserAlreadyExistsException("User with email john.doe@example.com already exists"));

        mockMvc.perform(post("/api/users/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isConflict());
    }
}