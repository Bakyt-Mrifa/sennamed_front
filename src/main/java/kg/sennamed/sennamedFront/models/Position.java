package kg.sennamed.sennamedFront.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Position {
    @Id
    @GeneratedValue
    @Column(name="position_id")
    private Long id;
    private String position;
    private String speciality;
    private boolean isActive;

}
