package listeners.loginPanelListeners;

import java.util.EventObject;

public class LoginPanelEvent extends EventObject {

    private String userName;
    private String password;
    private String actionCommand;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public LoginPanelEvent(Object source, String userName, String password, String actionCommand) {
        super(source);
        this.userName = userName;
        this.password = password;
        this.actionCommand = actionCommand;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getActionCommand() {
        return actionCommand;
    }

    @Override
    public String toString() {
        return "LoginPanelEvent{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", actionCommand='" + actionCommand + '\'' +
                '}';
    }
}
