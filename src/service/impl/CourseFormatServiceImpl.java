package service.impl;

import dao.CourseFormatDao;
import dao.impl.CourseFormatDaoImpl;
import model.CourseFormat;
import service.CourseFormatService;

import static enums.Format.BOOTCAMP;
import static enums.Format.ORDINARY;

public class CourseFormatServiceImpl implements CourseFormatService {
    CourseFormat courseFormat = new CourseFormat();
    CourseFormatDao courseFormatDao = new CourseFormatDaoImpl();

    @Override
    public void run() {
        courseFormat.setId(1);
        courseFormat.setFormat(BOOTCAMP);
        courseFormat.setDuration(18);
        courseFormat.setOnline(true);
        courseFormat.setLessonDuration(3);
        courseFormat.setLessonsInWeek(5);
//        courseFormatDao.save(courseFormat);
//        System.out.println(courseFormatDao.findAll());

        courseFormat.setId(2);
        courseFormat.setFormat(ORDINARY);
        courseFormat.setDuration(36);
        courseFormat.setOnline(true);
        courseFormat.setLessonDuration(2);
        courseFormat.setLessonsInWeek(3);
//        courseFormatDao.save(courseFormat);
    }
    @Override
    public void find() {
        System.out.println(courseFormatDao.findAll().toString());
    }
}
