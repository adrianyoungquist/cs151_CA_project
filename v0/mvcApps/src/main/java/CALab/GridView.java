// Adapted from https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/CALab/src/Grid.java


package CALab;

import mvc.Model;
import mvc.Utilities;
import mvc.View;

import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;

    public GridView(Model model) {
        // ???
        if (!(model instanceof Grid grid)) {
            Utilities.error("Somehow the model is not a grid :o");
            return;
        }
        // TODO ??
        setLayout(new GridLayout(grid.getDim(), grid.getDim()));
        cellViews = new CellView[grid.getDim()][grid.getDim()];
        for (int r = 0; r < grid.getDim(); ++r) {
            for (int c = 0; c < grid.getDim(); ++c) {
                CellView cell = new CellView(grid.getCell(r, c));
                cellViews[r][c] = cell;
                add(cell);
                grid.getCell(r, c).row = r;
                grid.getCell(r, c).col = c;
            }
        }
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
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
    }

    @Override
    public void update() {
        // TODO idk what this is supposed to do?
        update("?", null, null);
    }
}