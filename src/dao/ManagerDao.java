package dao;

import model.Manager;

import java.util.ArrayList;

public interface ManagerDao extends  CrudDao <Manager>{
    @Override
    default void save(Manager manager) {

    }

    @Override
    default ArrayList<Manager> findAll() {
        return null;
    }
}
