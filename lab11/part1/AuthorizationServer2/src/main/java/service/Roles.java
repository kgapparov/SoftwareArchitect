package service;

public enum Roles {
    CUSTOMER("CUSTOMER"),
    MANAGER("MANAGER"),
    EMPLOYEE("EMPLOYEE");

    public final String label;
    Roles(String label) {
        this.label = label;
    }
}
