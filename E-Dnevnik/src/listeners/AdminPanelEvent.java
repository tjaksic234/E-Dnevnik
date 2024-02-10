package listeners;

import java.util.EventObject;

public class AdminPanelEvent extends EventObject {



    private String name;
    private String surname;
    private String actionCommand;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    public AdminPanelEvent(Object source, String name, String surname, String actionCommand) {
        super(source);
        this.name = name;
        this.surname = surname;
        this.actionCommand = actionCommand;
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getActionCommand() {
        return actionCommand;
    }

    @Override
    public String toString() {
        return "AdminPanelEvent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
