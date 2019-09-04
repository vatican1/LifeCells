package model;


import controller.MyThread;

import java.util.Random;

public class LifeWorld {

    // private модификатор непозволит случайно напрямую изменить значения этих полей из других классов тем самым снизив риск ошибиться
    private CellState[][] cells;

    private int width;
    private int height;

    public LifeWorld(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new CellState[width][height];

        // Изначально этот мир мертв внутри на этапе создания
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
                // TODO 1: используя random.nextFloat() возвращающий случайное число от 0 до 1
                //  сделайте клетку живой с некоторой вероятностью (потом попробуйте подобрать вероятность так, чтобы мир жил поинтереснее)
            }
        }
    }

    public void updateWorld()  {
        int widthOfSm = width/4;
        CellState[][] cellStates= new CellState[widthOfSm+2][height];
        CellState[][] cellStates1= new CellState[widthOfSm+2][height];
        CellState[][] cellStates2= new CellState[widthOfSm+2][height];
        CellState[][] cellStates3= new CellState[widthOfSm+2][height];


        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

    }

    public int getWidth() {
        // Это так называемый getter - метод который позволяет узнать значение private-поля.
        // Он нужен т.к. прямого доступа к полю нет из-за модификатора private у поля (чтобы например случайно не изменить размер мира извне, тем самым сломав его).
        // Этот метод не private, а public, чтобы его можно было вызвать отовсюду.
        return this.width;
    }

    public int getHeight() {
        // TODO 5: сделайте возможным извне узнать высоту мира (см. выше как реализован другой getter - getWidth)
        //  для этого нужно изменить следующую строчку:
        return height;
    }

    public boolean isAlive(int x, int y) {
        // TODO 6: поправьте этот метод так, чтобы он позволял узнать, жива ли конкретная клетка
        if (cells[x][y]==CellState.ALIVE) {
            return true;
        } else {
            return false;
        }
    }

}
