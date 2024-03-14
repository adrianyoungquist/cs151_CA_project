package life;

import CALab.GridPanel;

public class LifeMain {
    public static void main(String[] args) {
        GridPanel app = new GridPanel(new LifeFactory());
        app.display();
    }
}
