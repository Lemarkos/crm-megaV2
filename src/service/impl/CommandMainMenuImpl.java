package service.impl;

import enums.Command;

import model.Student;
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
        loop:
        while (true) {
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("Enter command:");
            System.out.println("SAVE");
            System.out.println("FINDALL");
            Command command = null;
            try {
                command = Command.valueOf(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (command != null) {
                switch (command) {
                    case SAVE:
                        System.out.println("Select object to save:");
                        System.out.println("STUDENT");
                        System.out.println("MENTOR");
                    case STUDENT:
                        Command.valueOf(scanner.nextLine());
                        System.out.println("saving student...");
                        studentService.run();
                        break;
                    case MENTOR:
                        System.out.println("saving mentor...");
                        mentorService.run();
                        break;
                }
            }
                switch (command){
                    case FINDALL:
                        System.out.println("Select object to find");
                        System.out.println("Student");
                        System.out.println("MENTOR");

                    case STUDENT:
                        Command.valueOf(scanner.nextLine());
                        System.out.println("finding student...");
                        studentService.find();
                        break;
                    case MENTOR:
                        Command.valueOf(scanner.nextLine());
                        System.out.println("finding mentor...");
                        mentorService.find();
                        break;
                }
        }
    }
}
