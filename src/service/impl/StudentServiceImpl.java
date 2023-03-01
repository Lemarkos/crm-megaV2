package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import enums.Roles;
import enums.RolesFind;
import model.Student;
import service.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    Scanner scanner = new Scanner(System.in);
    Student student = new Student();
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public void run() {
        System.out.println("Enter name: ");
        student.setName(scanner.nextLine());
        System.out.println("Enter last name:");
        student.setLastName(scanner.nextLine());
        System.out.println("Enter phone number: ");
        student.setPhone(scanner.nextLine());
        System.out.println("Enter e-mail");
        student.setEmail(scanner.nextLine());
        studentDao.save(student);
    }
    @Override
    public void find() {
        System.out.println(studentDao.findAll().toString());
    }
}
