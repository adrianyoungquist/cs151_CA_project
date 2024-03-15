package CALab;

import life.Society;
import mvc.*;


// TODO
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
        // TODO
        return  "RUN1:  Observes the status and ambience of each agent, then updates status based on ambience. Increments time by 1\n" +
                "RUN50: Executes RUN1 50 times\n" +
                "POPULATE: Randomly populates the society with living and dead agents (" + Society.percentAlive + "% of cells alive)\n" +
                "CLEAR: Kills all agents";
    }

    @Override
    public String about() {
        // TODO
        return "Life contains a society (grid) with agents (cells) occupying each space.\n" +
                "Each agent's status is either dead or alive (0 = dead, 1 = alive) based on the amount of living neighbors surrounding it (ambience).\n" +
                "If an agent has 0, 1, 4, 5, 6, 7, or 8 living neighbors, the agent dies.\n" +
                "If an agent has exactly 3 living neighbors, a dead agent comes back to life. ";
    }

    @Override
    public String getTitle() {
        return "CALab";
    }
}
