package com.sp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class User implements OwnerUUID{


    private UUID uuid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

    private User(){

    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
