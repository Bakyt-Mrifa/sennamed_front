package kg.sennamed.sennamedFront.models;

import lombok.Data;

@Data
public class Result {
    private int status;
    private String message;
    private User object;
}
