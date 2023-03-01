package service.impl;
import dao.MentorDao;
import dao.impl.MentorDaoImpl;
import model.Mentor;
import service.MentorService;
import java.util.Scanner;

public class MentorServiceImpl implements MentorService {
    Scanner scanner = new Scanner(System.in);
    Mentor mentor = new Mentor();
    MentorDao mentorDao = new MentorDaoImpl();
    @Override
    public void run() {
        System.out.println("Enter name: ");
        mentor.setName(scanner.nextLine());
        System.out.println("Enter last name:");
        mentor.setLastName(scanner.nextLine());
        System.out.println("Enter phone number: ");
        mentor.setPhone(scanner.nextLine());
        System.out.println("Enter e-mail");
        mentor.setEmail(scanner.nextLine());
        mentorDao.save(mentor);
    }

    @Override
    public void find() {
        System.out.println(mentorDao.findAll().toString());
    }
}
