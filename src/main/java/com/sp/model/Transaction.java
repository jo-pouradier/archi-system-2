package com.sp.model;

import lombok.Getter;

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

}
