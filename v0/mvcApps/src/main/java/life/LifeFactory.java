package life;

import CALab.GridFactory;
import mvc.Model;
import mvc.View;

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
    public String getHelp() {
        // TODO
        return super.getHelp();
    }

    @Override
    public String about() {
        // TODO
        return super.about();
    }

    @Override
    public String getTitle() {
        return "Cellular Automata: Life";
    }
}
