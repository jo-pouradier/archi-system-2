package com.sp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Transaction {

    @Getter
    @Setter
    private UUID transcationUUID = null;
    @Getter
    @Setter
    private UUID cardUUID = null;
    @Getter
    @Setter
    private UUID fromUserUUID = null;
    @Getter
    @Setter
    private UUID toUserUUID = null;
    @Getter
    @Setter
    private float price = 0;
    @Getter
    @Setter
    private String status = "uncomplete";

}
