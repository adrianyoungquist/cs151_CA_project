// From https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java
package CALab;

import mvc.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<>();
    protected Grid myGrid = null;
    protected Cell partner = null;


    // choose a random neighbor as a partner
    public void choosePartner() {
        // set partner to null?
        if (partner == null && neighbors != null) {
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
            Cell[] neighborArray = new Cell[neighbors.size()];
            int i = 0;
            for (Cell neighbor: neighbors) {
                neighborArray[i] = neighbor;
                i++;
            }

            Random random = new Random();
            int index = random.nextInt(neighborArray.length);


            while (partner == null) { // loops until partner found, what if all have partners?
                if (neighborArray[index] != null) {
                    partner = neighborArray[index];
                    neighborArray[index].partner = this;
                }
                if (index >= neighborArray.length - 1) // correct edge case?
                    index = 0;
                else
                    index++;
            }
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract void observe();

    // interact with a random neighbor
    public abstract void interact();

    // update my state
    public abstract void update();

    // set status to status + 1 mod whatever
    public abstract void nextState();

    // set status to a random or initial value
    public abstract void reset(boolean randomly);

    // TODO
    public abstract Color getColor();

    // TODO
    public abstract int getStatus();
}