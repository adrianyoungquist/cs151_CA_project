package CALab;

import mvc.*;


// TODO
public class GridFactory implements AppFactory {
    // TODO must be overridden?
    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return new GridView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"CLEAR", "RUN1", "RUN50", "POPULATE"};
    }

    @Override
    public Command makeEditCommand(Model model, String commandName, Object source) {
        Command command = null;
        switch (commandName) {
            case "CLEAR" -> command = new ClearCommand(model);
            case "RUN1" -> command = new RunCommand(model, 1);
            case "RUN50" -> command = new RunCommand(model, 50);
            case "POPULATE" -> command = new PopulateCommand(model);
            default -> Utilities.error("Invalid command " + commandName);
        }
        return command;
    }

    @Override
    public String getHelp() {
        // TODO
        return "Idk I need help too";
    }

    @Override
    public String about() {
        // TODO
        return "Hi I'm a grid!";
    }

    @Override
    public String getTitle() {
        return "CALab";
    }
}
