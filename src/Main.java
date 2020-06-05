import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MainMenu mainMenu = new MainMenu();

        mainMenu.setUpMenu();
        mainMenu.pack();
        mainMenu.setVisible(true);
        mainMenu.setSize(new Dimension(1000,600));

    }
}
