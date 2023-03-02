package dao;

import model.CourseFormat;

import java.util.ArrayList;

public interface CourseFormatDao extends CrudDao<CourseFormat>{
    @Override
    default void save(CourseFormat courseFormat) {

    }

    @Override
    default ArrayList<CourseFormat> findAll() {
        return null;
    }
}
