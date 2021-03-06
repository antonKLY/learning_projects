package gamedev;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame extends JFrame implements KeyListener {

    private MyJPanel frame;

    public MyJFrame() {
        super();
        setSize(500,500);
        frame = new MyJPanel();
        add(frame);
        pack();
        addKeyListener(this);
        repaint();
    }

    public static void main(String[] args) {
        MyJFrame window = new MyJFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setTitle("Test");
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        frame.keyPressed(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}