package com.ulasevich.scooters.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;

    public String getAuthority() {
        return name();
    }
}
