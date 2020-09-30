package Cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car extends JPanel implements ActionListener {
    Timer t = new Timer(5, this);
    int x = 10, y = 10;
    int velx = 0, vely = 0;

    public Car()
    {
        t.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(x, y, 40, 80);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Graphics g = null;
        if(x<0 || x>200)
        {
            x = 0;
        }
        if(y<0 || y>200)
        {
            y = 0;
        }
        x += velx;
        y += vely;
        repaint();

    }

    public void up()
    {
        vely = -1;
        velx = 0;
    }

    public void down()
    {
        vely = 1;
        velx = 0;
    }

    public void left()
    {
        velx = -1;
        vely = 0;
    }

    public void right()
    {
        velx = 1;
        vely = 0;
    }

    public void stop()
    {
        velx = 0;
        vely = 0;
    }
}
