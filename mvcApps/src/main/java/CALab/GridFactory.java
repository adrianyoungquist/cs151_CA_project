package CALab;


import mvc.*;


public class GridFactory implements AppFactory {
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
        return "RUN1:     Runs the observe, interact, update loop once\n" +
                "RUN50:    Runs RUN1 50 times \n" +
                "POPULATE: Fills the grid with cells with different statuses\n" +
                "CLEAR:    Sets the grid to a specified default status";
    }

    @Override
    public String about() {
        return "A Cellular Automata is a grid of cells where each cell represents the behavior of a region, household, individual, etc. \n" +
                "The behavior of each cell can be simple, but when viewed holistically, the behavior of the entire grid can be complex.";
    }

    @Override
    public String getTitle() {
        return "CALab";
    }
}
