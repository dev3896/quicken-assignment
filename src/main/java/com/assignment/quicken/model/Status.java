package com.assignment.quicken.model;

import lombok.Getter;

@Getter
public enum Status {
    PENDING(0),
    PROCESSING(1),
    COMPLETED(2),
    FAILED(-1);

    private final int value;

    Status(int value) {
        this.value = value;
    }

}
