package Semaforo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LightPanel extends JPanel implements ActionListener {

    FirstLight light = new FirstLight();

    public Timer t;
    public int h, m, s, cs;
    public int h2, m2, s2, cs2;
    public int h3, m3, s3, cs3;
    public int h4, m4, s4, cs4;

    Timer tim = new Timer(5, this);
    double x = 0, y = 0, velx = 0, vely = 0;

    JLabel label = new JLabel("00:00");
    JLabel label2 = new JLabel("00:00");
    JLabel label3 = new JLabel("00:00");
    JLabel label4 = new JLabel("00:00");
    JButton start = new JButton("Start");
    JButton pause = new JButton("Pause");
    JButton stop = new JButton("Stop");

    public LightPanel() {

        t = new Timer(10, acciones);

        JButton changeButton = new JButton("Switch");
        light.setPreferredSize(new Dimension(50, 130));
        buttonListener l = new buttonListener();
        changeButton.addActionListener(l);

        buttonStart bs = new buttonStart();
        start.addActionListener(bs);

        buttonPause bst = new buttonPause();
        pause.addActionListener(bst);

        buttonStop bsp = new buttonStop();
        stop.addActionListener(bsp);

//        add(mov2);
//        add(mov3);
        add(label);
        add(light);
        add(label2);
//        add(light2);
//        add(label3);
//        add(light3);
//        add(label4);
//        add(light4);
        add(changeButton);
        add(start);
        add(pause);
        add(stop);
    }
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae)
        {

            cs++;
            cs2++;
            cs3++;
            cs4++;
            if(cs==100)
            {
                cs = 0;
                ++s;
            }
            if(cs2==100)
            {
                cs2 = 0;
                ++s2;
            }
            if(cs3==100)
            {
                cs3 = 0;
                ++s3;
            }
            if(cs4==100)
            {
                cs4 = 0;
                ++s4;
            }
            if(light.activeLight.equals("red") && s==15)
            {
                s = 0;
                light.activeLight = "green";
                light.go = Color.green;
                light.stop = Color.gray;
//                mov2.down();
            }
//            if (light2.activeLight.equals("red") && s2==45)
//            {
//                s2 = 0;
//                light2.activeLight = "green";
//                light2.go = Color.green;
//                light2.stop = Color.gray;
//                mov3.up();
//            }
//            //if(light2.activeLight.equals("red") && s2==15)
//            if (light3.activeLight.equals("red") && s3==45)
//            {
//                s3 = 0;
//                light3.activeLight = "green";
//                light3.go = Color.green;
//                light3.stop = Color.gray;
//            }
//            if (light4.activeLight.equals("red") && s4==45)
//            {
//                s4 = 0;
//                light4.activeLight = "green";
//                light4.go = Color.green;
//                light4.stop = Color.gray;
//            }
            if(light.activeLight.equals("green") && s==10)
            {
                s = 0;
                light.activeLight = "yellow";
                light.slow = Color.yellow;
                light.go = Color.gray;
            }
//            if(light2.activeLight.equals("green") && s2==10)
//            {
//                s2 = 0;
//                light2.activeLight = "yellow";
//                light2.slow = Color.yellow;
//                light2.go = Color.gray;
//            }
//            if(light3.activeLight.equals("green") && s3==10)
//            {
//                s3 = 0;
//                light3.activeLight = "yellow";
//                light3.slow = Color.yellow;
//                light3.go = Color.gray;
//            }
//            if(light4.activeLight.equals("green") && s4==10)
//            {
//                s4 = 0;
//                light4.activeLight = "yellow";
//                light4.slow = Color.yellow;
//                light4.go = Color.gray;
//            }
            if(light.activeLight.equals("yellow") && s==3)
            {
                s = 0;
                s2 = 0;
                light.activeLight = "red";
                light.stop = Color.red;
                light.slow = Color.gray;
//                light2.activeLight = "green";
//                light2.go = Color.green;
//                light2.stop = Color.gray;
//                mov2.stop();
//                mov3.up();
            }
//            if(light2.activeLight.equals("yellow") && s2==5)
//            {
//                s2 = 0;
//                s3 = 0;
//                light2.activeLight = "red";
//                light2.stop = Color.red;
//                light2.slow = Color.gray;
//                light3.activeLight = "green";
//                light3.go = Color.green;
//                light3.stop = Color.gray;
//                mov3.stop();
//            }
//            if(light3.activeLight.equals("yellow") && s3==5)
//            {
//                s3 = 0;
//                light3.activeLight = "red";
//                light3.stop = Color.red;
//                light3.slow = Color.gray;
//            }
//            if(light4.activeLight.equals("yellow") && s4==5)
//            {
//                s4 = 0;
//                light4.activeLight = "red";
//                light4.stop = Color.red;
//                light4.slow = Color.gray;
//            }
			/*if(m==60)
			{
				m = 0;
				++h;
			}*/
            actualizarLabel();
            repaint();
        }
    };
    private void actualizarLabel()
    {
        String tiempo1 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        String tiempo2 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s2<=9?"0":"")+s2+":"+(cs2<=9?"0":"")+cs2;
        String tiempo3 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s3<=9?"0":"")+s3+":"+(cs3<=9?"0":"")+cs3;
        String tiempo4 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s4<=9?"0":"")+s4+":"+(cs4<=9?"0":"")+cs4;
        label.setText(tiempo1);
        label2.setText(tiempo2);
        label3.setText(tiempo3);
        label4.setText(tiempo4);

    }
    private static void delaySegundo()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {

        }
    }
    class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //light.changeColor();
            //light2.changeColor();
        }
    }
    class buttonStart implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            t.start();
            start.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);

            //tim.start();
            //addKeyListener(this);
            //setFocusable(true);
            //setFocusTraversalKeysEnabled(false);
           // mov2.down();
            //mov3.up();
            light.activeLight = "green";
            light.go = Color.green;
            light.stop = Color.gray;

        }
    }
    class buttonPause implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            t.stop();
            pause.setEnabled(false);
            start.setEnabled(true);
            stop.setEnabled(true);
        }
    }

    class buttonStop implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            if(t.isRunning())
            {
                t.stop();
                start.setEnabled(true);
              //  mov2.stop();
                //mov3.stop();

            }
            pause.setEnabled(false);
            stop.setEnabled(false);
            h=0; m=0; s=0; cs=0;
            h2=0; m2=0; s2=0; cs2=0;
            h3=0; m3=0; s3=0; cs3=0;
            h4=0; m4=0; s4=0; cs4=0;
            actualizarLabel();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}