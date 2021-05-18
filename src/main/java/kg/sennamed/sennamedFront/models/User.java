package kg.sennamed.sennamedFront.models;

import lombok.Data;

@Data
public class User {
    private Long id;


    private String name;
    private String address;
    private Account account;
    //private Position position;
    private Role role;
}
