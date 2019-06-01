package models;

import java.util.*;

public abstract class Observable {

    private List<Observator> observators = new ArrayList<Observator>();

    public void subscribe(Observator observator) {
        this.observators.add(observator);
    }

    public void notifyObservators() {
        for (Observator o : observators) {
            o.onUpdate();
        }
    }
}
