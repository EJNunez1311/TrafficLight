package Semaforo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class FirstLight extends JComponent {

        Color go = Color.GRAY;
        Color slow = Color.GRAY;
        Color stop = Color.red;

        String activeLight = "red";

        public void paintComponent (Graphics g){
            g.setColor(Color.black);
            g.setColor(Color.black);
            g.fillRect(0, 0, 50, 130);

            g.setColor(stop);
            g.fillOval(10, 10, 25, 25);

            g.setColor(slow);
            g.fillOval(10, 50, 25, 25);

            g.setColor(go);
            g.fillOval(10, 90, 25, 25);
        }
}
