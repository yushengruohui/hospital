package com.ys.hospital.config.security;

import org.springframework.security.core.GrantedAuthority;


public class CustomizedGrantedAuthority implements GrantedAuthority {

    private String roleName;
    private String permissionUrl;
    private String method;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public CustomizedGrantedAuthority(String roleName, String permissionUrl, String method) {
        this.roleName = roleName;
        this.permissionUrl = permissionUrl;
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
