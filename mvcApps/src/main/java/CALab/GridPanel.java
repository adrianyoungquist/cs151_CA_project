package CALab;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
    public GridPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(new ControlPanel());
    }

    class ControlPanel extends JPanel {
        public ControlPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JPanel rowOnePanel = new JPanel();
            rowOnePanel.setLayout(new BoxLayout(rowOnePanel, BoxLayout.X_AXIS));

            rowOnePanel.add(Box.createHorizontalGlue());

            JButton run1 = new JButton("RUN1");
            run1.addActionListener(GridPanel.this);
            rowOnePanel.add(run1);

            rowOnePanel.add(Box.createHorizontalGlue());

            JButton run50 = new JButton("RUN50");
            run50.addActionListener(GridPanel.this);
            rowOnePanel.add(run50);

            rowOnePanel.add(Box.createHorizontalGlue());

            add(rowOnePanel);
            rowOnePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());


            JPanel rowTwoPanel = new JPanel();
            rowTwoPanel.setLayout(new BoxLayout(rowTwoPanel, BoxLayout.X_AXIS));

            rowTwoPanel.add(Box.createHorizontalGlue());

            JButton populate = new JButton("POPULATE");
            populate.addActionListener(GridPanel.this);
            rowTwoPanel.add(populate);

            rowTwoPanel.add(Box.createHorizontalGlue());

            JButton clear = new JButton("CLEAR");
            clear.addActionListener(GridPanel.this);
            rowTwoPanel.add(clear);

            rowTwoPanel.add(Box.createHorizontalGlue());

            add(rowTwoPanel);
            rowTwoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());
        }
    }
}
