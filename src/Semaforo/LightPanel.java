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
import Cars.*;
public class LightPanel extends JPanel implements ActionListener {

    FirstLight light = new FirstLight();
    SecondLight light2 = new SecondLight();

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
    Car car1 = new Car();

    public LightPanel() {

        t = new Timer(10, acciones);

        JButton changeButton = new JButton("Switch");
        light.setPreferredSize(new Dimension(500, 400));
        light2.setPreferredSize(new Dimension(500, 400));
//        car1.setPreferredSize(new Dimension(500, 500));
        buttonListener l = new buttonListener();
        changeButton.addActionListener(l);

        buttonStart bs = new buttonStart();
        start.addActionListener(bs);

        buttonPause bst = new buttonPause();
        pause.addActionListener(bst);

        buttonStop bsp = new buttonStop();
        stop.addActionListener(bsp);


//        add(mov3);
//        add(label);
        add(light);
//        add(label2);
        add(light2);
//        add(label3);
//        add(light3);
//        add(label4);
//        add(light4);
        add(changeButton);
        add(start);
        add(pause);
        add(stop);
//        add(car1);
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


            if(light.activeLight.equals("red") && s==6){
                s = 0;
                light.activeLight = "green";
                light.stop = Color.gray;
                light.go = Color.green;
                light2.activeLight = "red";
                light2.slow = Color.gray;
                light2.stop = Color.red;

            }
            if(light.activeLight.equals("green") && s==3){
                s = 0;
                light.activeLight = "yellow";
                light.go = Color.gray;
                light.slow = Color.yellow;

            }
            if(light.activeLight.equals("yellow") && s==3){
                s = 0;
                light.activeLight = "red";
                light.slow = Color.gray;
                light.stop = Color.red;
                light2.activeLight="green";
                light2.stop = Color.gray;
                light2.go = Color.green;
                s2 = 0;
            }
            if(light2.activeLight.equals("green")&& s2==5){
                light2.activeLight = "yellow";
                light2.go = Color.gray;
                light2.slow = Color.yellow;
            }
            if(light2.activeLight.equals("yellow") && s==3){
                s=0;
                s2 = 0;
                light2.activeLight = "red";
                light2.slow = Color.gray;
                light2.stop = Color.red;
                light.activeLight = "green";
                light.go = Color.green;
                light.stop = Color.gray;

            }


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
//        label.setText(tiempo1);
//        label2.setText(tiempo2);
//        label3.setText(tiempo3);
//        label4.setText(tiempo4);

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

            light.activeLight = "green";
            light.go = Color.green;
            light.stop = Color.gray;
            light2.activeLight = "red";
            light2.go = Color.gray;
            light2.stop = Color.red;


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