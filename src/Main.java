import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;
import service.CommandMainMenu;
import service.impl.CommandMainMenuImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        CommandMainMenu commandMainMenu = new CommandMainMenuImpl();
        commandMainMenu.mainMenu();
    }
}