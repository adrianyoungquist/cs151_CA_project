package life;

import CALab.Cell;
import CALab.Grid;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    public static int percentAlive = 50;
    // TODO

    // TODO
    @Override
    public Cell makeCell(boolean uniform) {
        return new Agent(this);
    }
}
