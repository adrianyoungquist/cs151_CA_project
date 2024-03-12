package CALab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {
    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        // Assuming Grid is the specific type of Model
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            // Updated to meet the requirement
            grid.repopulate(true);
            System.out.println("Populate!");
        } else {
            System.out.println("Populate command is applicable only to Grid models.");
        }
    }
}