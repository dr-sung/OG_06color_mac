
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class BackgroundColor extends JFrame {

    JPanel canvas, buttonPanel;
    JButton yellowButton, redButton, blueButton;

    public void initialize() {
        
        // GUI LookAndFeel differs among platforms.
        // JButton's background color cannot be set on Mac GUI
        // "Metal" LookAndFeel is platform-independent

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


        yellowButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        // background colors of buttons themselves
        yellowButton.setBackground(Color.yellow);
        blueButton.setBackground(Color.blue);
        redButton.setBackground(Color.red);

        ButtonObserver observer = new ButtonObserver();

        yellowButton.addActionListener(observer);
        blueButton.addActionListener(observer);
        redButton.addActionListener(observer);

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        Container contentPane = getContentPane();
        canvas = new JPanel();
        contentPane.add(canvas, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // When one of buttons are clicked...
            Object source = event.getSource();
            Color color = Color.black;
            if (source == yellowButton) {
                color = Color.yellow;
            } else if (source == blueButton) {
                // color = Color.blue;
                color = new Color(0, 0, 255);
            } else if (source == redButton) {
                // color = Color.red;
                color = new Color(1.0F, 0F, 0F);
            }
            canvas.setBackground(color);
        }
    }
}
