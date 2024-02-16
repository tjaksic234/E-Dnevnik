package listeners.adminPanelListeners;

import java.util.EventListener;

public interface AdminPanelActionListener extends EventListener {

     void adminPanelEventOccured(AdminPanelEvent event);
}
