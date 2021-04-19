package springcourse.bookstore.recursos.exceptions;

import java.util.LinkedList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new LinkedList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String message) {
        super(timestamp, status, message);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
