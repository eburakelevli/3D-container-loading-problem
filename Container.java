import java.awt.*;
import java.util.HashMap;

public class Container {
    public int containerID;
    public Boolean occupation;
    private HashMap<Container, HashMap<Item, Point>> container_location;




    public int getContainerID() {
        return containerID;
    }

    Container (int containerID) {
        this.containerID = containerID;
    }


    public Boolean getOccupation() {
        return occupation;
    }

    public void setOccupation(Boolean occupation) {
        this.occupation = occupation;
    }

    public HashMap<Container, HashMap<Item, Point>> getContainer_location() {
        return container_location;
    }

    public void setContainer_location(HashMap<Container, HashMap<Item, Point>> container_location) {
        this.container_location = container_location;
    }
}
