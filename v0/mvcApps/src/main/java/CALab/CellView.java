// https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java

package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        super();
        setOpaque(true);
        myCell = c;
        if (c != null) {
            c.subscribe(this);
        }
        this.addActionListener(this);
        update();
    }

    public CellView() {
        this(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        // call update needed?
        update();
    }

    // called by notifySubscribers and GridView.update

    @Override
    public void update(String msg, Object oldState, Object newState) {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText(String.valueOf(myCell.getStatus()));
        repaint();
    }

    @Override
    public void update() {
        update(null, null, null);
    }
}
