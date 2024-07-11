import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Snake extends JFrame{
    private int []x ;
    private int []y ;
    private int size = 1;

    public Snake(){
        x = new int[500];
        y = new int[500];
        x[0] = 50;
        y[0] = 50;
        x[1] = 51;
        y[1] = 50;
    }

    InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = getRootPane().getActionMap();




    public void moveSnake(String direction){
        if(direction.equals("up")){
            for(int i = size; i >= 1; i--){
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            y[0] = y[0] - 1;
        }
        else if(direction.equals("down")){
            for(int i = size; i >= 1; i--){
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            y[0] = y[0] + 1;
        }
        else if(direction.equals("left")){
            for(int i = size; i >= 1; i--){
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            y[0] = y[0] - 1;
        }
        else if(direction.equals("right")){
            for(int i = size; i >= 1; i--){
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            x[0] = x[0] + 1;
        }

    }
    public void showSnake(Graphics g){
        g.setColor(Color.green);
        for(int i = 0; i <= size;i++) {
            g.fillRect(x[i], y[i], 20, 20);
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                moveSnake("up");
                break;
            case KeyEvent.VK_DOWN:
                moveSnake("down");
                break;
            case KeyEvent.VK_LEFT:
                moveSnake("left");
                break;
            case KeyEvent.VK_RIGHT:
                moveSnake("right");
                break;
        }
        repaint();
    }
}
