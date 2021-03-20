package com.dmi.linker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class ExceptionResponse {
    private LocalDateTime dateTime;
    private String message;
    private String details;
}
