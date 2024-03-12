package life;

import CALab.Cell;
import CALab.Grid;

import java.awt.*;

public class Agent extends Cell {
    int status = 0;
    int ambience = 8;
    public Agent(Grid myGrid) {
        this.myGrid = myGrid;
    }

    @Override
    public void observe() {

    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {

    }

    @Override
    public void nextState() {

    }

    @Override
    public void reset(boolean randomly) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }
}
