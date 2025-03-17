package cz.upce.fei.nnpiavovaaa312.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static cz.upce.fei.nnpiavovaaa312.domain.SystemPermission.*;

@RequiredArgsConstructor
public enum SystemRole {


    //system level roles
    SYSTEM_USER(getUserPermissions()),
    SYSTEM_ADMIN(getAllPermissions());

    @Getter
    private final Set<SystemPermission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }
}
