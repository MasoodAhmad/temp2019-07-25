package Pojos;

public class Project {
    private String id;
    private String name;
    private int number_of_orders; //Java style is camel case but ignore for data output
    private numberOfPendingTypes number_of_pending_types = new numberOfPendingTypes();
    private numberOfParticipantTypes number_of_participant_types = new numberOfParticipantTypes();
    private numberOfActivityTypes number_of_activity_types = new numberOfActivityTypes();

    public Project(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_orders() {
        return number_of_orders;
    }

    public void setNumber_of_orders(int number_of_orders) {
        this.number_of_orders = number_of_orders;
    }

    public numberOfPendingTypes getNumber_of_pending_types() {
        return number_of_pending_types;
    }

    public void setNumber_of_pending_types(numberOfPendingTypes number_of_pending_types) {
        this.number_of_pending_types = number_of_pending_types;
    }

    public numberOfParticipantTypes getNumber_of_participant_types() {
        return number_of_participant_types;
    }

    public void setNumber_of_participant_types(numberOfParticipantTypes number_of_participant_types) {
        this.number_of_participant_types = number_of_participant_types;
    }

    public numberOfActivityTypes getNumber_of_activity_types() {
        return number_of_activity_types;
    }

    public void setNumber_of_activity_types(numberOfActivityTypes number_of_activity_types) {
        this.number_of_activity_types = number_of_activity_types;
    }


}
