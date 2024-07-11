import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGUI extends JFrame {

    private SnakePanel snakePanel;

    public SnakeGUI() {
        setTitle("Snake Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snakePanel = new SnakePanel();
        add(snakePanel);

        // Add a key listener to the frame to handle arrow key events
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snakePanel.handleKeyPress(e);
            }
        });

        setFocusable(true);
        setLocationRelativeTo(null);  // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGUI().setVisible(true));
    }