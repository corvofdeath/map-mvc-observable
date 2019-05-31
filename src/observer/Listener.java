package observer;

import java.util.EventObject;

public interface Listener<T> {

    void notificar(EventObject e, T element);
}
