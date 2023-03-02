package service.impl;

import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import model.Manager;
import service.ManagerService;

import java.util.Scanner;

public class ManagerServiceImpl implements ManagerService {
    Scanner scanner = new Scanner(System.in);
    Manager manager = new Manager();
    ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public void run() {
        System.out.println("Enter name");
        manager.setName(scanner.nextLine());
        System.out.println("Enter last name");
        manager.setLastName(scanner.nextLine());
        System.out.println("Enter phone number");
        manager.setPhone(scanner.nextLine());
        System.out.println("Enter e-mail");
        manager.setEmail(scanner.nextLine());
//        System.out.println("Enter salary");
//        manager.setSalary(scanner.nextDouble());
//        scanner.nextLine();
        managerDao.save(manager);
    }

    @Override
    public void find() {
        System.out.println(managerDao.findAll().toString());
    }
}
