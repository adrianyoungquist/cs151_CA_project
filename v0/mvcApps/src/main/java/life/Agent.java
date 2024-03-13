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
        int count = 0;
        for (Cell neighbor: neighbors) {
            Agent agentNeighbor = (Agent)neighbor;
            if (agentNeighbor.getStatus() == 1)
                count++;
        }
        ambience = count;
    }

    @Override
    public void interact() { // no interaction phase

    }

    @Override
    public void update() {

    }

    @Override
    public void nextState() { // no nextState

    }

    @Override
    public void reset(boolean randomly) {

    }

    @Override
    public Color getColor() {
        if (status == 0)
            return Color.RED;
        else
            return Color.GREEN;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
