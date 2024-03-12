package CALab;

import mvc.Command;
import mvc.Model;

// TODO
public class ClearCommand extends Command {
    public ClearCommand(Model model) {
        super(model);
    }

    // TODO
    @Override
    public void execute() {
        // Assuming Grid is the specific type of Model
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            // Existing logic for clearing the grid (from the clearGrid method)
            grid.clear();
            System.out.println("Clear!");
        } else {
            System.out.println("Clear command is applicable only to Grid models.");
        }
    }
}
