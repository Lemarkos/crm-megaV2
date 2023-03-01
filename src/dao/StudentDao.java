package dao;

import model.Student;

import java.io.IOException;
import java.util.ArrayList;

public interface StudentDao extends CrudDao <Student>{
    @Override
    default void save(Student student)  {

    }

    @Override
    default ArrayList<Student> findAll() {
        return null;
    }
}
