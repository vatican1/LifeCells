package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseListener implements ActionListener {
    private Boolean paused;

    public PauseListener() {
        paused=false;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public Boolean getPaused() {
        return paused;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paused=!paused;
    }
}