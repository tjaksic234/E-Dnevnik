package listeners;

import java.util.EventListener;

public interface MenuBarEventListener extends EventListener {

    void menuBarEventOccurred(String command);
}
