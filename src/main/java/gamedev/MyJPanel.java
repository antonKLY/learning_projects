package gamedev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyJPanel extends JPanel {

    private int x = 200;
    private int y = 200;

    public MyJPanel() {
        setPreferredSize(new Dimension(200,200));
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x,y,100,100);
    }

    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        switch (k) {
            case KeyEvent.VK_D:
                x++;
                break;
            case KeyEvent.VK_A:
                x--;
                break;
            case KeyEvent.VK_W:
                y--;
                break;
            case KeyEvent.VK_S:
                y++;
                break;
        }
    }
}
