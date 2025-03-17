package cz.upce.fei.nnpiavovaaa312.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vytvoř DTO pro REST API, které bude obsahovat informace o uživateli. Narozdíl od User.java neobsahuje
 * atributy které nechceme v rámci REST API poskytovat. Neobsahuje ani zděděné atributy z rodičovských tříd.
 * Tím zamezíme riziku že v rámci API poskytneme informace, které by neměly být dostupné.
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String role;
    private boolean active;
}
