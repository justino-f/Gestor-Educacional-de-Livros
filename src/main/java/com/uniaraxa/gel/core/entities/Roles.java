package com.uniaraxa.gel.core.entities;

import lombok.Getter;

@Getter
public enum Roles {

    ADMIN("admin"),
    EXTERNAL("user"),
    INTERNAL("student");

    private final String role;

    Roles(String role){
        this.role = role;
    }
}
