package Pojos;

public class Project {
    private String id;
    private String name;
    private int number_of_orders; //Java style is camel case but ignore for data output
    private numberOfPendingTypes number_of_pending_types;
    private numberOfParticipantTypes number_of_participant_types;
    private numberOfActivityTypes number_of_activity_types;

    public Project(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
