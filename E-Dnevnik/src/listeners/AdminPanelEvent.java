package listeners;

import java.util.EventObject;

public class AdminPanelEvent extends EventObject {



    private String name;
    private String surname;
    private String uniqueID;
    private String actionCommand;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    public AdminPanelEvent(Object source, String name, String surname, String uniqueID, String actionCommand) {
        super(source);
        this.name = name;
        this.surname = surname;
        this.uniqueID = uniqueID;
        this.actionCommand = actionCommand;
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getActionCommand() {
        return actionCommand;
    }

    @Override
    public String toString() {
        return "AdminPanelEvent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", actionCommand='" + actionCommand + '\'' +
                '}';
    }
}
