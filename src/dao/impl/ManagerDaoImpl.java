package dao.impl;

import dao.ManagerDao;
import model.Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ManagerDaoImpl implements ManagerDao {
    private final String PATH_FILE = "C:\\Users\\Home\\IdeaProjects\\Learning\\lib\\Manager.txt";
    private final File MANAGER_FILE = new File(PATH_FILE);
    int count = 0;

    public ManagerDaoImpl(){
        boolean isCreated = false;
        if (!MANAGER_FILE.exists()){
            try {
                isCreated = MANAGER_FILE.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (isCreated) System.out.println("New file is created!!!");
    }
    @Override
    public void save(Manager manager) {
        count = getCount();
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            out.print(++count + " ");
            out.print(manager.getName() + " ");
            out.print(manager.getLastName() + " ");
            out.print(manager.getPhone() + " ");
            out.print(manager.getEmail() + " ");
//            out.print(manager.getSalary() + " ");
//            out.print("(" + convertTo(manager) + ")");
            out.print(manager.getDateCreated().toString().substring(0,22));
            out.println();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(out);
        }
    }

    @Override
    public ArrayList<Manager> findAll() {
        ArrayList <Manager> managers = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(MANAGER_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Manager manager = new Manager();
                manager.setId(scanner.nextLong());
                manager.setName(scanner.next());
                manager.setLastName(scanner.next());
                manager.setPhone(scanner.next());
                manager.setEmail(scanner.nextLine());
                manager.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));
//                manager.setSalary(scanner.nextLong());
                managers.add(i, manager);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(scanner);
        }
        return managers;
    }
    int getCount() {
        int count = 0;
        try {
            Scanner scanner = new Scanner(MANAGER_FILE);
            while (scanner.hasNextLine()){
                count++;
                scanner.nextLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
    Date convertTo(Manager manager){
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(manager.getDateCreated().atZone(zoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyy HH:mm");
        calendar.setTime(date);
        df.format(date);
        return date;
    }
}

