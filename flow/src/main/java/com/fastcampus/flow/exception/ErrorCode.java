package com.fastcampus.flow.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {

    QUEUE_ALREADY_REGISTERD_USER(HttpStatus.CONFLICT, "UQ-001", "ALREADY REGISTERD IN QUEUE");
    private HttpStatus status;
    private String code;
    private String reason;

    public ApplicationException build(){
        return new ApplicationException(status, code, reason);
    }
}
