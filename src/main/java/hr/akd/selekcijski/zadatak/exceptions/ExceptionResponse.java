package hr.akd.selekcijski.zadatak.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExceptionResponse {
    private LocalDateTime timestamp;

    private String message;


    public ExceptionResponse(){
        timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
