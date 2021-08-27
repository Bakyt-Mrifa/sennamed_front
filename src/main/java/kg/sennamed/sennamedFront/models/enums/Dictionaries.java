package kg.sennamed.sennamedFront.models.enums;

public enum Dictionaries {
    USERS("Пользователи"),
    CUSTOMERS("Клиенты"),
    POSITIONS("Должности");

    private String label;

    Dictionaries (String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

}
