package Main;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Semaforo.LightPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel1 = new LightPanel();

        frame.add(panel1);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
