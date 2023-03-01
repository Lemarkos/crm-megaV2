package dao.impl;

import dao.MentorDao;
import dao.StudentDao;
import model.Mentor;
import model.Student;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {
    private final String PATH_FILE = "C:\\Users\\Home\\IdeaProjects\\Learning\\lib\\Student.txt";
    private final File STUDENT_FILE = new File(PATH_FILE);
    int count = 0;

    public StudentDaoImpl(){
        boolean isCreated = false;
        if (!STUDENT_FILE.exists()){
            try {
                isCreated = STUDENT_FILE.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Student student) {
        count = getCount();
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            out.print(++count + " ");
            out.print(student.getName()+ " ");
            out.print(student.getLastName() + " ");
            out.print(student.getPhone() + " ");
            out.print(student.getEmail() + " ");
            out.print("(" + convertTo(student) + ")");
            out.println();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(out);
        }
    }

    @Override
    public ArrayList<Student> findAll() {
        ArrayList <Student> students = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(STUDENT_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Student student = new Student();
                student.setId(scanner.nextLong());
                student.setName(scanner.next());
                student.setLastName(scanner.next());
                student.setPhone(scanner.next());
                student.setEmail(scanner.nextLine());

                students.add(i,student);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(scanner);
        }
        return students;
    }

    int getCount(){
        int count = 0;
        try {
            Scanner scanner = new Scanner(STUDENT_FILE);
            while (scanner.hasNextLine()){
                count++;
                scanner.nextLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
    Date convertTo(Student student){
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(student.getDateCreated().atZone(zoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyy HH:mm");
        calendar.setTime(date);
        df.format(date);
        return date;
    }
}

