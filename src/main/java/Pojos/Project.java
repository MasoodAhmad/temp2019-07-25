package Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT )
public class Project {
    private String id;
    private String name;
    private int numberOfOrders; //Java style is camel case but ignore for data output
    private NumberOfPendingTypes numberOfPendingTypes = new NumberOfPendingTypes();
    private NumberOfParticipantTypes numberOfParticipantTypes = new NumberOfParticipantTypes();
    private NumberOfActivityTypes numberOfActivityTypes = new NumberOfActivityTypes();

    public Project(){

    }
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

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public NumberOfPendingTypes getNumberOfPendingTypes() {
        return numberOfPendingTypes;
    }

    public void setNumberOfPendingTypes(NumberOfPendingTypes numberOfPendingTypes) {
        this.numberOfPendingTypes = numberOfPendingTypes;
    }

    public NumberOfParticipantTypes getNumberOfParticipantTypes() {
        return numberOfParticipantTypes;
    }

    public void setNumberOfParticipantTypes(NumberOfParticipantTypes numberOfParticipantTypes) {
        this.numberOfParticipantTypes = numberOfParticipantTypes;
    }

    public NumberOfActivityTypes getNumberOfActivityTypes() {
        return numberOfActivityTypes;
    }

    public void setNumberOfActivityTypes(NumberOfActivityTypes numberOfActivityTypes) {
        this.numberOfActivityTypes = numberOfActivityTypes;
    }


}
