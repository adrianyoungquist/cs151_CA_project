package mvc;


public interface Subscriber {
    void update();

    // TODO?
    void update(String msg, Object oldState, Object newState);
}


