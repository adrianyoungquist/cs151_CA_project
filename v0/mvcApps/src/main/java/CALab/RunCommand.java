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
        System.out.println("Run " + numTimes + "!");
    }
}
