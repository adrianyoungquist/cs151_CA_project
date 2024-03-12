package CALab;

import mvc.Command;
import mvc.Model;

// TODO
public class RunCommand extends Command {
    int numTimes;

    public RunCommand(Model model) {
        super(model);
    }

    public RunCommand(Model model, int numTimes) {
        super(model);
        this.numTimes = numTimes;
    }

    @Override
    public void execute() {
        // Assuming Grid is the specific type of Model
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            // Existing logic for running the grid (from the updateLoop method)
            grid.updateLoop(numTimes);
            System.out.println("Run " + numTimes + "!");
        } else {
            System.out.println("Run command is applicable only to Grid models.");
        }
    }
}