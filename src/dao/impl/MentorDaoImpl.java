package dao.impl;

import dao.MentorDao;
import model.Mentor;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MentorDaoImpl implements MentorDao {

    private final String PATH_FILE = "C:\\Users\\Home\\IdeaProjects\\Learning\\lib\\Mentor.txt";
    private final File MENTOR_FILE = new File(PATH_FILE);
    int count = 0;

    public MentorDaoImpl(){
        boolean isCreated = false;
        if (!MENTOR_FILE.exists()){
            try {
                isCreated = MENTOR_FILE.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void save(Mentor mentor)  {
        count = getCount();
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(PATH_FILE), true);
            out.print(++count + " ");
            out.print(mentor.getName() + " ");
            out.print(mentor.getLastName() + " ");
            out.print(mentor.getPhone() + " ");
            out.print(mentor.getEmail() + " ");
            out.print("(" + convertTo(mentor) + ")");
            out.println();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(out);
        }
    }

    @Override
    public ArrayList<Mentor> findAll() {
        ArrayList <Mentor> mentors = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(MENTOR_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Mentor mentor = new Mentor();
                mentor.setId(scanner.nextLong());
                mentor.setName(scanner.next());
                mentor.setLastName(scanner.next());
                mentor.setPhone(scanner.next());
                mentor.setEmail(scanner.nextLine());

                mentors.add(i, mentor);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(scanner);
        }
        return mentors;
    }
    int getCount() {
        int count = 0;
        try {
            Scanner scanner = new Scanner(MENTOR_FILE);
            while (scanner.hasNextLine()){
                count++;
                scanner.nextLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
    Date convertTo(Mentor mentor){
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(mentor.getDateCreated().atZone(zoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyy HH:mm");
        calendar.setTime(date);
        df.format(date);
        return date;
    }
}
