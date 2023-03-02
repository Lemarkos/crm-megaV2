package service.impl;

import enums.Command;

import enums.Roles;
import enums.RolesFind;
import service.CommandMainMenu;
import service.MentorService;
import service.StudentService;


import java.util.Scanner;

public class CommandMainMenuImpl implements CommandMainMenu {
    Scanner scanner = new Scanner(System.in);
    StudentService studentService = new StudentServiceImpl();
    MentorService mentorService = new MentorServiceImpl();

    @Override
    public void mainMenu() {
        while (true) {
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("Enter command:");
            System.out.println("SAVE");
            System.out.println("FINDALL");
            Command command = null;
            Roles roles = null;
            RolesFind rolesFind = null;
            try {
                command = Command.valueOf(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (command != null){
                switch (command){
                    case SAVE :
                        System.out.println("Select object to save: ");
                        System.out.println(Roles.STUDENT);
                        System.out.println(Roles.MENTOR);
                        try {
                            roles = Roles.valueOf(scanner.nextLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        switch (roles){
                            case STUDENT:
                                System.out.println("saving student...");
                                studentService.run();
                                break;
                            case MENTOR:
                                System.out.println("saving mentor...");
                                mentorService.run();
                                break;
                        }break;
                    case FINDALL:
                        System.out.println("Select object to find: ");
                        System.out.println(RolesFind.STUDENT);
                        System.out.println(RolesFind.MENTOR);
                        try {
                            rolesFind = RolesFind.valueOf(scanner.nextLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        switch (rolesFind){
                            case STUDENT:
                                System.out.println("searching student...");
                                studentService.find();
                                break;
                            case MENTOR:
                                System.out.println("searching mentor...");
                                mentorService.find();
                                break;
                        }
                }
            }
        }
    }
}
