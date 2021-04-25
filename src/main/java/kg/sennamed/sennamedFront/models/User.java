package kg.sennamed.sennamedFront.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User {
    private String userName;
    private String userPassword;
    private boolean isActive;
    private Role role;
}
