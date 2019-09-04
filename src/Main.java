import model.LifeWorld;
import view.LifePanel;
import controller.PauseListener;

import javax.swing.*;
import java.awt.*;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        LifeWorld world = new LifeWorld(10, 10);
        world.randomize();
        // TODO 12: изначально мир должен быть случайным - вызовите соответствующий метод у world

        JFrame frame = new JFrame();

        LifePanel panel = new LifePanel(world);

        JButton pauseButton = new JButton("Pause");
        JButton restartButton = new JButton("Restart");

        PauseListener pauseListener = new PauseListener();
        pauseButton.addActionListener(pauseListener);

        restartButton.addActionListener(e -> world.randomize());

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 1));
        controls.add(pauseButton);
        controls.add(restartButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);  // по центру будет панель рисующая красоту
        frame.add(controls, BorderLayout.EAST); // справа будет панель с управлением

        frame.setSize(300, 300);
        frame.setLocation(800,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Thread.sleep(3000);

        while (true) {
            Thread.sleep(1);
            if (!pauseListener.getPaused()) {
                panel.repaint();
                world.updateWorld();
            }
        }
    }
}
