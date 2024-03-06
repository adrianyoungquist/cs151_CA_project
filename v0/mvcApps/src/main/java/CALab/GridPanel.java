package CALab;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
    public GridPanel(AppFactory factory) {
        super(factory);
        controlPanel.add(new ControlPanel());
    }

    // TODO ???
    class ControlPanel extends JPanel {
        public ControlPanel() {
            //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JButton run1 = new JButton("RUN1");
            run1.addActionListener(GridPanel.this);
            add(run1);
            //run1.setAlignmentX(Component.LEFT_ALIGNMENT);

            JButton run50 = new JButton("RUN50");
            run50.addActionListener(GridPanel.this);
            add(run50);
            //run50.setAlignmentX(Component.RIGHT_ALIGNMENT);

            add(Box.createVerticalGlue());

            JButton populate = new JButton("POPULATE");
            populate.addActionListener(GridPanel.this);
            add(populate);
            //populate.setAlignmentX(Component.LEFT_ALIGNMENT);

            JButton clear = new JButton("CLEAR");
            clear.addActionListener(GridPanel.this);
            add(clear);
            //populate.setAlignmentX(Component.RIGHT_ALIGNMENT);

            add(Box.createVerticalGlue());
        }
    }
}
