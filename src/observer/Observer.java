package observer;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Observer<T> {

    private List<Listener<T>> listeners;

    public Observer() {
        this.listeners = new ArrayList<>();
    }

    public void notificar(T element) {
        for (Listener listener : this.listeners)
            listener.notificar(new EventObject(this), element);
    }

    public void subscriver(Listener<T> listener) {
        if (!this.listeners.contains(listener))
            this.listeners.add(listener);
    }

    public void unsubscriver(Listener listener) {
        this.listeners.remove(listener);
    }
}
