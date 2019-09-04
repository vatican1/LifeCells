package view;

import model.LifeWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifePanel extends JPanel  {

    LifeWorld world;
    int cellSize = 15;

    public LifePanel(LifeWorld world) {
        this.world = world;
    }

    @Override
    protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            // TODO 11: нарисуйте прямоугольниками одного цвета - живые клетки, а прямоугольниками другого цвета - мертвые
            for (int x = 0; x < world.getWidth(); x++) {
                for (int y = 0; y < world.getHeight(); y++) {

                    if (world.isAlive(x, y)) {
                        g.setColor(new Color(0, 0, 0));
                    } else {
                        g.setColor(new Color(255, 255, 255));
                    }
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);

                }
            }
        g.setColor(new Color(255, 255, 188));
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

    }


}
