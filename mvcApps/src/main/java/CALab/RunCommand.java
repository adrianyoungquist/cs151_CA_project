package CALab;

import mvc.Command;
import mvc.Model;

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
        if (model instanceof Grid grid) {
            // Existing logic for running the grid (from the updateLoop method)
            grid.updateLoop(numTimes);
        } else {
            System.out.println("Run command is applicable only to Grid models.");
        }
    }
}