package CALab;

import mvc.Command;
import mvc.Model;

public class ClearCommand extends Command {
    public ClearCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        // Assuming Grid is the specific type of Model
        if (model instanceof Grid grid) {
            // Existing logic for clearing the grid (from the clearGrid method)
            grid.clear();
        } else {
            System.out.println("Clear command is applicable only to Grid models.");
        }
    }
}
