package org.launchcode.liftoff_kcb_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KCBAPIException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;
}
