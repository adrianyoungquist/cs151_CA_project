package CALab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {
    public PopulateCommand(Model model) {
        super(model);
    }

    // TODO
    @Override
    public void execute() {
        System.out.println("Populate!");
    }
}
