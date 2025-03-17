package cz.upce.fei.nnpiavovaaa312.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum SystemPermission {
    ADMIN_CREATE("admin:create"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),

    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");

    private final String permission;

    public static Set<SystemPermission> getAllPermissions() {
        return Set.of(SystemPermission.values());
    }
    public static Set<SystemPermission> getUserPermissions() {

        Set<SystemPermission> permissions = new HashSet<>();
        permissions.add(USER_CREATE);
        permissions.add(USER_READ);
        permissions.add(USER_UPDATE);
        permissions.add(USER_DELETE);


        return permissions;
    }

}
