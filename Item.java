import java.awt.*;

public class Item {
    private String itemId;
    private int type;
    private int weight;
    private int width;
    private int height;
    private int date_priority;
    private int length;
    public Point location ;


    Item(String itemId){
        this.itemId=itemId;
    }

    public String getID(){
        return itemId;
    }

    /*public int getLocation() {
        return type;
    }

    public void setLocation(int location) {
        this.location = new Point();
    }*/




    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWidht() {
        return width;
    }

    public void setWidht(int widht) {
        this.width = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDate_priority() {
        return date_priority;
    }

    public void setDate_priority(int date_priority) {
        this.date_priority = date_priority;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
