
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        BackgroundColor frame = new BackgroundColor();
        frame.setTitle("Changing Background Colors");
        frame.setSize(500, 300);
        frame.setLocation(100, 100);
        frame.initialize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
