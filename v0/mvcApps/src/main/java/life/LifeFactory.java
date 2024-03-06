package life;

import CALab.GridFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

// TODO ?????
public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new Society();
    }

    @Override
    public View makeView(Model model) {
        return super.makeView(model);
    }

    @Override
    public String[] getEditCommands() {
        return super.getEditCommands();
    }

    @Override
    public Command makeEditCommand(Model model, String commandName, Object source) {
        return super.makeEditCommand(model, commandName, source);
    }

    @Override
    public String getHelp() {
        // TODO?
        return super.getHelp();
    }

    @Override
    public String about() {
        // TODO?
        return super.about();
    }

    @Override
    public String getTitle() {
        return "Cellular Automata: Life";
    }
}
