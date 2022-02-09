package ua.com.foxminded.quick.poll.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException() { }

    public ResourceNotFoundException(String massage) {
        super(massage);
    }

    public ResourceNotFoundException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
