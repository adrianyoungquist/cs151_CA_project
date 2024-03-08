// Adapted from https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java

package CALab;

import mvc.Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim;
    protected final Cell[][] cells;

    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }

    public Grid() {
        this(20);
    }

    public int getDim() {
        return dim;
    }

    public int getTime() {
        return time;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public abstract Cell makeCell(boolean uniform);

    protected void populate() {
        // TODO??
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int r = 0; r < dim; ++r) {
            for (int c = 0; c < dim; ++c) {
                cells[r][c] = makeCell(true); // true??
                // TODO here?
                cells[r][c].row = r;
                cells[r][c].col = c;
            }
        }
        for (int r = 0; r < dim; ++r) {
            for (int c = 0; c < dim; ++c) {
                cells[r][c].neighbors = getNeighbors(cells[r][c], 1); // radius???
            }
        }
        notifySubscribers();
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        // TODO
        if (randomly) {
            // randomly set the status of each cell
        } else {
            // set the status of each cell to 0 (dead)
        }
        // notify subscribers
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        Set<Cell> neighbors = new HashSet<>();
        for (int r = asker.row - radius; r <= asker.row + radius; ++r) {
            for (int c = asker.col - radius; c <= asker.col + radius; ++c) {
                int row, col;
                if (r == asker.row && c == asker.col) { // is self
                    continue;
                }
                if (r < 0) {
                    row = r + dim;
                } else if (r >= dim) {
                    row = r - dim;
                } else {
                    row = r;
                }
                if (c < 0) {
                    col = c + dim;
                } else if (c >= dim) {
                    col = c - dim;
                } else {
                    col = c;
                }
                // not self and within bounds
                neighbors.add(cells[row][col]);
            }
        }
        return neighbors;
    }

    // override these
    public int getStatus() {
        return 0;
    }

    public Color getColor() {
        return Color.GREEN;
    }

    // cell phases:

    public void observe() {
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                cell.observe();
            }
        }
        notifySubscribers();
        // call each cell's observe method and notify subscribers
    }

    public void interact() {
        // ???
        // TODO supposed to reset neighbors?
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                cell.interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        // ???
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                cell.update();
            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}