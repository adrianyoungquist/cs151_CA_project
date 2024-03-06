package life;

import CALab.GridPanel;

public class LifeTest {
    public static void main(String[] args) {
        GridPanel app = new GridPanel(new LifeFactory());
        app.display();
    }
}
