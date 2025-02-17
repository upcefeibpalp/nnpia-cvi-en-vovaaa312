package cz.upce.fei.nnpiavovaaa312.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private final Long Id;
    private final String password;
    private final String email;
}
