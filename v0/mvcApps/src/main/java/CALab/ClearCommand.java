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
        System.out.println("Clear!");
    }
}
