package mvc;


public interface Subscriber {
    void update();

    // TODO?
    public void update(String msg, Object oldState, Object newState);
}


