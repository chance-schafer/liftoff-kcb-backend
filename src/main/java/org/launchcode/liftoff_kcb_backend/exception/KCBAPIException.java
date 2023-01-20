package org.launchcode.liftoff_kcb_backend.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class KCBAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public KCBAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public KCBAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }


}
