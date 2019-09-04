package controller;

import model.CellState;

public class MyThread extends Thread {
    private CellState[][] cells;
    private int width;
    private  int height;

    public void setUp(CellState[][] cellState, int width,int height){
        this.cells = cellState;
        this.width=width;
        this.height=height;
    }

    public CellState[][] getCells() {
        return cells;
    }

    @Override
    public void run() {
        CellState[][] nextState = new CellState[width][height];
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                int neighboursAlive = 0;
                for (int dx = -1; dx <= 1; ++dx) {
                    for (int dy = -1; dy <= 1; ++dy) {
                        if (dx==0&&dy==0){
                            continue;
                        }
                        int xn = x + dx;
                        int yn = y + dy;
                        if (xn>=0&&yn>=0&&xn<width&&yn<height) {
                            if (cells[xn][yn] == CellState.ALIVE) {
                                neighboursAlive++;
                            }
                        }

                    }
                }
                if (cells[x][y]==CellState.ALIVE) {
                    if (neighboursAlive == 2 || neighboursAlive == 3) {
                        nextState[x][y] = CellState.ALIVE;
                    } else {
                        nextState[x][y] = CellState.DEAD;
                    }
                }
                else {
                    if (neighboursAlive==3)
                        nextState[x][y]=CellState.ALIVE;
                    else
                        nextState[x][y]=CellState.DEAD;
                }
            }
        }
        cells=nextState;
    }

}
