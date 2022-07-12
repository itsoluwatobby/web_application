package com.itsoluwatobby.spring.email.client.applicaton;

public enum AppUserPermission {

    APPLICATION_READ("application:read"),
    APPLICATION_WRITE("application:write");

    private final String permissions;

    AppUserPermission(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
