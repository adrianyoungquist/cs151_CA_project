// Adapted from https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java


package CALab;

import mvc.Model;
import mvc.Utilities;
import mvc.View;

import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;

    public GridView(Model model) {
        if (!(model instanceof Grid grid)) {
            Utilities.error("Somehow the model is not a grid :o");
            return;
        }
        this.model = model;
        model.subscribe(this);
        setLayout(new GridLayout(grid.getDim(), grid.getDim()));
        cellViews = new CellView[grid.getDim()][grid.getDim()];
        for (int r = 0; r < grid.getDim(); ++r) {
            for (int c = 0; c < grid.getDim(); ++c) {
                CellView cell = new CellView(grid.getCell(r, c));
                cellViews[r][c] = cell;
                add(cell);
            }
        }
    }

    @Override
    public void setModel(Model model) {
        super.setModel(model);
        if (!(model instanceof Grid grid)) {
            Utilities.error("Somehow the model is not a grid :o");
            return;
        }
        for (int r = 0; r < cellViews.length; ++r) {
            for (int c = 0; c < cellViews.length; ++c) {
                cellViews[r][c].setMyCell(grid.getCell(r, c));
            }
        }
    }

    @Override
    public void update(String msg, Object oldState, Object newState) {
        // call update method of each CellView
        for (CellView[] row : cellViews) {
            for (CellView cellView : row) {
                // message?
                cellView.update();
            }
        }
        repaint();
    }

    @Override
    public void update() {
        update("?", null, null);
    }
}