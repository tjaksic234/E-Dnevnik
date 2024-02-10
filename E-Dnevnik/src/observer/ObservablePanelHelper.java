package observer;

import java.util.ArrayList;
import java.util.List;

public class ObservablePanelHelper implements Observable {


    private List<Observer> observers;

    public ObservablePanelHelper() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
