package com.emazon.api.stock.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomError {

    private int errorCode;
    private String msg;
}
