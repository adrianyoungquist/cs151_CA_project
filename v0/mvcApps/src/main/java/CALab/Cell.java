// From https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java
package CALab;

import mvc.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
            for (Cell neighbor : neighbors) {
                neighborArray[i] = neighbor;
                i++;
            }

            Random random = new Random();
            int startIndex = random.nextInt(neighborArray.length);
            int index;
            for (int j = 0; j < neighborArray.length; j++) { // loops until partner found, what if all have partners?
                index = (startIndex + j) % neighborArray.length;
                if (neighborArray[index] != null && neighborArray[index].partner == null) {
                    partner = neighborArray[index];
                    neighborArray[index].partner = this;
                    break;
                }
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

    public abstract Color getColor();

    public abstract int getStatus();
}