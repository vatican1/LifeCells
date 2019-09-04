package model;


import controller.MyThread;

import java.util.Random;

public class LifeWorld {

    private CellState[][] cells;

    private int width;
    private int height;

    public LifeWorld(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new CellState[width][height];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                this.cells[x][y] = CellState.DEAD;
            }
        }
    }

    public void randomize() {
        Random random = new Random(239);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if(random.nextFloat()>0.4){
                    cells[x][y]=CellState.DEAD;
                } else {
                    cells[x][y]=CellState.ALIVE;
                }
            }
        }
    }

    public void updateWorld() throws InterruptedException {
        int widthOfSmall = width/2;
        CellState[][] cellStates= new CellState[widthOfSmall+2][height];
        CellState[][] cellStates1= new CellState[widthOfSmall+2][height];
//        CellState[][] cellStates2= new CellState[widthOfSm+2][height];
//        CellState[][] cellStates3= new CellState[widthOfSm+2][height];

        cellStates[0] = new CellState[height];
        cellStates1[0]= cells[widthOfSmall-1];
        for (int i = 1; i <widthOfSmall-1 ; i++) {
            cellStates[i] = cells[i-1];
            cellStates1[i] = cells[widthOfSmall+i-1];
        }
        cellStates[widthOfSmall+1] = cells[widthOfSmall+1];
        cellStates1[widthOfSmall+1]= new CellState[height];

        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();

        thread.setUp(cellStates,widthOfSmall+2, height);
        thread1.setUp(cellStates1,widthOfSmall+2, height);

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
//        MyThread thread2 = new MyThread();
//        MyThread thread3 = new MyThread();

        for (int i = 0; i <widthOfSmall ; i++) {
            cells[i]= thread.getCells()[i+1];
            cells[widthOfSmall+i] = thread1.getCells()[i+1];
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {

        return height;
    }

    public boolean isAlive(int x, int y) {
        if (cells[x][y]==CellState.ALIVE) {
            return true;
        } else {
            return false;
        }
    }

}
