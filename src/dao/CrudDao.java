package dao;

import model.Student;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public interface CrudDao <E> {
    default void close(Closeable closeable) {
        try {
            if (closeable != null){
                closeable.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void save (E e) ;

    ArrayList<E> findAll();
}
