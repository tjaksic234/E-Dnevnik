package listeners.loginPanelListeners;

import java.util.EventListener;

public interface LoginPanelEventListener extends EventListener {

    void loginPanelEventOccurred(LoginPanelEvent event);
}
