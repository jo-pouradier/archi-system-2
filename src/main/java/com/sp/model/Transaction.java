package com.sp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Transaction {

    @Getter
    private UUID transcationUUID;
    @Getter
    private UUID cardUUID;
    @Getter
    private UUID fromUserUUID;
    @Getter
    private UUID toUserUUID;
    @Getter
    @Setter
    private float price = 0;
    @Getter
    @Setter
    private String status = "uncomplete";

}
