package model;

public class Manager extends User {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

//    @Override
//    public String toString() {
//        return "Manager{" +
//                "id=' " + getId() + '\'' +
//                ", name='" + getName() + '\'' +
//                ", lastName='" + getLastName() + '\'' +
//                ", phone='" + getPhone() + '\'' +
//                ", email='" + getEmail() + '\'' +
////                "salary=" + getSalary() +
//                '}';
//    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                "salary=" + salary + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated='" + dateCreated +
                '}';
    }
}
