package com.geekbrains.backend.enums;

public enum OrderStatus {

    ACCEPT(1),

    PROCESS(2),

    SEND(3),

    DONE(4);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }
}