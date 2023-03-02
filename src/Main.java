import service.CommandMainMenu;
import service.CourseFormatService;
import service.impl.CommandMainMenuImpl;
import service.impl.CourseFormatServiceImpl;

public class Main {
    public static void main(String[] args)  {
        CommandMainMenu commandMainMenu = new CommandMainMenuImpl();
        CourseFormatService courseFormatService = new CourseFormatServiceImpl();
        courseFormatService.run();
        commandMainMenu.mainMenu();
    }
}