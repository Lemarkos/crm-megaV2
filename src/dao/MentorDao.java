package dao;

import model.Mentor;

import java.util.ArrayList;

public interface MentorDao extends CrudDao <Mentor>{
    @Override
    default void save(Mentor mentor)  {

    }
    @Override
    default ArrayList<Mentor> findAll() {
        return null;
    }
}
