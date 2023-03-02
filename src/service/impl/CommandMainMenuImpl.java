package service.impl;

import enums.Command;
import enums.Roles;
import enums.RolesFind;
import service.*;

import java.util.Objects;
import java.util.Scanner;

public class CommandMainMenuImpl implements CommandMainMenu {
    Scanner scanner = new Scanner(System.in);
    StudentService studentService = new StudentServiceImpl();
    MentorService mentorService = new MentorServiceImpl();
    ManagerService managerService = new ManagerServiceImpl();
    CourseFormatService courseFormatService = new CourseFormatServiceImpl();
    @Override
    public void mainMenu() {
        loop:
        while (true) {
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("Enter command:");
            System.out.println("SAVE");
            System.out.println("FIND");
            System.out.println("EXIT");
            Command command = null;
            RolesFind rolesFind = null;
            try {
                command = Command.valueOf(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (command != null) {
                switch (command) {
                    case EXIT:
                        break loop;
                    case SAVE:
                        System.out.println("Select object to save: ");
                        System.out.println(Roles.STUDENT);
                        System.out.println(Roles.MENTOR);
                        System.out.println(Roles.MANAGER);
                        Roles roles = null;
                        try {
                            roles = Roles.valueOf(scanner.nextLine());
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        if (roles != null) {
                            switch (roles) {
                                case STUDENT:
                                    System.out.println("saving student...");
                                    studentService.run();
                                    System.out.println("saved!");
                                    break;
                                case MENTOR:
                                    System.out.println("saving mentor...");
                                    mentorService.run();
                                    System.out.println("save!");
                                    break;
                                case MANAGER:
                                    System.out.println("saving manager...");
                                    managerService.run();
                            }
                        }break;

                    case FIND:
                        System.out.println("Select object to find: ");
                        System.out.println(RolesFind.STUDENT);
                        System.out.println(RolesFind.MENTOR);
                        System.out.println(RolesFind.MANAGER);
                        System.out.println(RolesFind.COURSEFORMAT);
                        try {
                            rolesFind = RolesFind.valueOf(scanner.nextLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        switch (Objects.requireNonNull(rolesFind)) {
                            case STUDENT:
                                System.out.println("searching students...");
                                studentService.find();
                                break;
                            case MENTOR:
                                System.out.println("searching mentors...");
                                mentorService.find();
                                break;
                            case MANAGER:
                                System.out.println("searching managers...");
                                managerService.find();
                                break;
                            case COURSEFORMAT:
                                System.out.println("Course formats...");
                                courseFormatService.find();
                                break;
                        }
                }
            }
        }
    }
}
