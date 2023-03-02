package model;

public class Mentor extends User{
    private double salary;
    private int exp;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                "salary=" + getSalary() +
                ", exp=" + getExp() +
                '}';
    }
}
