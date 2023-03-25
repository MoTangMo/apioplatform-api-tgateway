package tang.designpattern.mydesignpatterndemo.BuilderMode;

import javax.swing.*;
import java.awt.*;

public class demo1 extends JFrame {
    public demo1(){
        super("demo1");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawOval(150,120,30,30);
        g.drawRect(160,150,10,50);
        g.drawLine(160,150,140,200);
        g.drawLine(170,150,190,200);
        g.drawLine(160,200,145,250);
        g.drawLine(170,200,185,250);
    }

    public static void main(String[] args) {
        new demo1();
    }

}
