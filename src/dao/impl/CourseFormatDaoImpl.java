package dao.impl;

import dao.CourseFormatDao;
import enums.Format;
import model.CourseFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CourseFormatDaoImpl implements CourseFormatDao {
    private final String PATH_FILE = "C:\\Users\\Home\\IdeaProjects\\Learning\\lib\\CourseFormat.txt";
    private final File COURSE_FORMAT_FILE = new File(PATH_FILE);
    int count = 0;

    public CourseFormatDaoImpl(){
        boolean isCreated = false;
        if (!COURSE_FORMAT_FILE.exists()){
            try {
                isCreated = COURSE_FORMAT_FILE.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (isCreated) System.out.println("New file is created!!!");
    }
    @Override
    public void save(CourseFormat courseFormat) {
        count = getCount();
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(PATH_FILE,true));
            out.print(++count + " ");
            out.print(courseFormat.getFormat() + " ");
            out.print(courseFormat.getDuration() + " ");
            out.print(courseFormat.isOnline() + " ");
            out.print(courseFormat.getLessonDuration() + " ");
            out.print(courseFormat.getLessonsInWeek() + " ");
            out.print(convertTo(courseFormat));
            out.println();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(out);
        }
    }

    @Override
    public ArrayList<CourseFormat> findAll() {
        ArrayList<CourseFormat> courseFormats = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(COURSE_FORMAT_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                CourseFormat courseFormat = new CourseFormat();

                courseFormat.setId(scanner.nextLong());
                courseFormat.setFormat(Format.valueOf(scanner.next()));
                courseFormat.setDuration(scanner.nextInt());
                courseFormat.setOnline(scanner.nextBoolean());
                courseFormat.setLessonDuration(scanner.nextInt());
                courseFormat.setLessonsInWeek(scanner.nextInt());
//                courseFormat.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));
                scanner.nextLine();

                courseFormats.add(i, courseFormat);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            close(scanner);
        }
        return courseFormats;
    }

    int getCount(){
        int count = 0;
        try {
            Scanner scanner = new Scanner(COURSE_FORMAT_FILE);
            while (scanner.hasNextLine()){
                count++;
                scanner.nextLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }

    Date convertTo(CourseFormat courseFormat){
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(courseFormat.getDateCreated().atZone(zoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyy HH:mm");
        calendar.setTime(date);
        df.format(date);
        return date;
    }
}
