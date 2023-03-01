package model;

public class Mentor extends User{
    private double salary;
    private int exp;

    @Override
    public String toString() {
        return "Mentor{" +
                "name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                "salary=" + salary +
                ", exp=" + exp +
                '}';
    }
}
