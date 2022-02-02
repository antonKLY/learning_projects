package gamedev;
import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame{
    public Paint(){
        setTitle("Circle");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] a){
        new Paint();
    }

    public void paint(Graphics g){
         //FOR CIRCLE
        for (int i = 10; i < 60; i++) {
            g.drawOval(i + i * 10, 90, 90, 90);
            
        }
//        g.drawRect(80, 30, 200, 200); // FOR SQUARE
//        g.drawRect(200, 100, 100, 200); // FOR RECT
    }
}
