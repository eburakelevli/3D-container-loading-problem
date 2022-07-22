import java.awt.*;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;

public class Heuristic {
    public ProblemData problemData;
    public ArrayList<Item> list1;
    public ArrayList<Item> list2;

    ArrayList<Item> puttedItems;
    public HashMap<Item, Point> location;
    public HashMap<Item, Point> locationDummy;
    public HashMap<Container, HashMap<Item, Point>> container_location;
    public ArrayList<Integer> locationheightline1;
    public ArrayList<Integer> locationheightline2;
    public ArrayList<Integer> locationheightline3;
    public ArrayList<Integer> locationheightline4;
    public ArrayList<Integer> locationheightline5;
    public ArrayList<Integer> locationheightline6;


    Heuristic(ProblemData problemData) {
        this.problemData = problemData;

    }

    public void useAlgorithm1() {

        this.problemData.container[1].setOccupation(false);
        this.problemData.container[2].setOccupation(false);
        this.problemData.container[3].setOccupation(false);


        this.locationheightline1 = locationheightline1;
        //hangi itemlerin konulacağının seçimi
        this.list1 = new ArrayList<>();


        //heuristic

        for (Item i : this.problemData.item) {
            if (i.getType() == 1 && i.getLength() == 7315) {
                list1.add(i);
            }

        }//itemleri 2şer ikişer götür ki homojen dağılım sağlansın

        for (Item i : this.problemData.item) {
            if (i.getType() == 1 && i.getLength() == 5100) {
                list1.add(i);
            }

        }

        for (Item i : this.problemData.item) {
            if (i.getType() == 0 && i.getLength() == 7315) {
                list1.add(i);
            }

        }

        for (Item i : this.problemData.item) {
            if (i.getType() == 0 && i.getLength() == 5100) {
                list1.add(i);
            }

        }

        this.list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i = i + 2) {
            list2.add(list1.get(i));
        }
        for (int i = 1; i < list1.size(); i = i + 2) {
            list2.add(list1.get(i));
        }

        int ğ = 0;

        System.out.print(" ürün diziliş sırası: ");

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i).getID() + " ");
        }


        location = new HashMap<>();
        locationDummy = new HashMap<>();
        this.container_location = new HashMap<>();


        int max_y = 0;

        for (int p = 1; p < 3; p++) {
            while (problemData.container[p].getOccupation() == false && max_y < 2300) {

                //1.satır
                int x = 0;
                int y = 0;
                int t = -500;

                locationheightline1 = new ArrayList<>();
                puttedItems = new ArrayList<>();


                int iteration = 0;


                for (int i = 0; i < list1.size(); i++) {

                    Item selected_item = list1.get(i);

                    //false true

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, 0));

                    if (p == 1) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, 0));
                    }


                    if (p == 2) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, 0));
                    }

                    locationheightline1.add(selected_item.getHeight());

                    puttedItems.add(selected_item);

                    x = x + list1.get(i).getWidht() + t;

                    t = 0;

                    iteration = iteration + 1;

                    if (x == 1500) {


                        break;
                    }

                }
                System.out.println();


                //2.satır
                x = 0;
                y = 0;
                int iteration1 = 0;
                t = -500;

                locationheightline2 = new ArrayList<>();


                for (int i = 0; i < list1.size(); i++) {
                    Item selected_item = this.list1.get(i + iteration);

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, locationheightline1.get(i)));

                    if (p == 1) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline1.get(i)));
                    }

                    if (p == 2) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline1.get(i)));
                    }


                    //container_location.put(problemData.container[p],location);

                    locationheightline2.add(locationheightline1.get(i) + selected_item.getHeight());

                    puttedItems.add(selected_item);


                    x = x + list1.get(i).getWidht() + t;

                    t = 0;

                    iteration1 = iteration1 + 1;

                    if (x == 1500) break;

                }


                int z = 0;

                //3.satır
                iteration1 = iteration1 + iteration;
                int iteration2 = 0;
                x = 0;
                y = 0;
                t = -500;


                locationheightline3 = new ArrayList<>();


                for (int i = 0; i < list1.size(); i++) {

                    Item selected_item = this.list1.get(i + iteration1);

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, locationheightline2.get(i)));

                    if (p == 1) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline2.get(i)));
                    }

                    if (p == 2) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline2.get(i)));
                    }


                    //container_location.put(problemData.container[p],location);

                    locationheightline3.add(locationheightline2.get(i) + selected_item.getHeight());

                    puttedItems.add(selected_item);


                    x = x + list1.get(i).getWidht() + t;

                    t = 0;


                    iteration2 = iteration2 + 1;


                    if (x == 1500) break;

                }

                //4.satır

                iteration2 = iteration2 + iteration1;
                x = 0;
                y = 0;
                int iteration3 = 0;
                t = -500;

                locationheightline4 = new ArrayList<>();


                int v = 0;

                for (int i = 0; i < list1.size(); i++) {

                    Item selected_item = list1.get(i + iteration2);

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, locationheightline3.get(i)));

                    if (p == 1) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline3.get(i)));
                    }

                    if (p == 2) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline3.get(i)));
                    }


                    //container_location.put(problemData.container[p],location);

                    locationheightline4.add(locationheightline3.get(i) + selected_item.getHeight());


                    puttedItems.add(selected_item);


                    x = x + list1.get(i).getWidht() + t;

                    t = 0;

                    iteration3 = iteration3 + 1;

                    if (x == 1500) break;

                }


                //5.satır
                iteration3 = iteration3 + iteration2;

                int iteration4 = 0;
                x = 0;
                y = 0;
                t = -500;

                locationheightline5 = new ArrayList<>();
                int iteration_height=0;
                int iteration_height1=0;



                for (int i = 0; i < list1.size(); i++) {

                    Item selected_item = list1.get(i + iteration3);

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, locationheightline4.get(i)));

                    if (p == 1 && locationheightline4.get(i) + selected_item.getHeight()<2301) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline4.get(i)));
                    }

                    if (p == 2 && locationheightline4.get(i) + selected_item.getHeight()<2301) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline4.get(i)));
                    }


                    //container_location.put(problemData.container[p],location);

                    locationheightline5.add(locationheightline4.get(i) + selected_item.getHeight());

                    puttedItems.add(selected_item);


                    if (p == 1) {
                        iteration_height = iteration_height + 1;
                    }
                    if (p == 2) {
                        iteration_height1 = iteration_height1 + 1;
                    }


                    x = x + list1.get(i).getWidht() + t;

                    t = 0;

                    iteration4 = iteration4 + 1;

                    /*if(locationheightline4.get(i) + selected_item.getHeight() > 2300)
                    {
                        max_y=locationheightline4.get(i) + selected_item.getHeight();
                        for (int a = 0; a < 4; a++)
                        {
                            locationheightline1.remove(0);
                            locationheightline2.remove(0);
                            locationheightline3.remove(0);
                            locationheightline4.remove(0);

                        }
                        for (int a = 0; a < iteration_height; a++) {
                            locationheightline5.remove(0);
                        }

                        for (Item b : puttedItems) {
                            list1.remove(b);

                        }
                        if (p == 1) {
                            container_location.put(problemData.container[p], location);
                        }

                        if (p == 2) {
                            container_location.put(problemData.container[p], locationDummy);
                        }

                        problemData.container[p].setOccupation(true);
                        break;

                    }*/


                    if (x == 1500 || locationheightline4.get(i) + selected_item.getHeight() > 2300) {

                        for (int a = 0; a < 4; a++) {
                            locationheightline1.remove(0);
                            locationheightline2.remove(0);
                            locationheightline3.remove(0);
                            locationheightline4.remove(0);
                        }
                        if (p == 1) {
                            for (int a = 0; a < iteration_height; a++) {
                                locationheightline5.remove(0);
                            }
                        }
                        if (p == 2) {
                            for (int a = 0; a < iteration_height1; a++) {
                                locationheightline5.remove(0);
                            }
                        }


                        for (Item b : puttedItems) {
                            list1.remove(b);

                        }
                        if (p == 1) {
                            container_location.put(problemData.container[p], location);
                        }

                        if (p == 2) {
                            container_location.put(problemData.container[p], locationDummy);
                        }

                        problemData.container[p].setOccupation(true);
                        break;
                    }
                }




             /*   //6.satır


                iteration4 = iteration4 + iteration3;


                x = 0;
                y = 0;
                t = -500;
                int iteration5 = 0;

                locationheightline6 = new ArrayList<>();


                for (int i = 0; i < list1.size(); i++) {

                    Item selected_item = list1.get(i + iteration4);

                    selected_item.setLocation(new Point(x + selected_item.getWidht() + t, locationheightline5.get(i)));

                    if (p == 1) {
                        location.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline5.get(i)));
                    }

                    if (p == 2) {
                        locationDummy.put(selected_item, new Point(x + selected_item.getWidht() + t, locationheightline5.get(i)));
                    }


                    //container_location.put(problemData.container[p],location);

                    locationheightline6.add(locationheightline4.get(i) + selected_item.getHeight());

                    puttedItems.add(selected_item);


                    x = x + list1.get(i).getWidht() + t;

                    t = 0;

                    iteration5 = iteration5 + 1;

                    if (x == 1500) {

                        break;
                        /*for (int a = 0; a < 4; a++) {
                            locationheightline1.remove(0);
                            locationheightline2.remove(0);
                            locationheightline3.remove(0);
                            locationheightline4.remove(0);
                            locationheightline5.remove(0);
                        }

                        for (Item b : puttedItems) {
                            list1.remove(b);

                        }
                        if (p == 1) {
                            container_location.put(problemData.container[p], location);
                        }

                        if (p == 2) {
                            container_location.put(problemData.container[p], locationDummy);
                        }

                        problemData.container[p].setOccupation(true);
                        break;
                */


            }
        }
        System.out.print("ContainerID" + " ItemID" + " ItemType" + " ItemWeight" + " ItemLength" + " ItemHeight" + " ItemCoordinates");

        for (int i = 1; i < 3; i++) {
            for (int q = 0; q < problemData.item.length; q++) {

                //System.out.println("Container ID " + problemData.container[i].getContainerID() + " / Item ID: -> " + problemData.item[t].getID() + " / Item type: -> " + problemData.item[t].getType() + " / Item weight: -> " + problemData.item[t].getWeight() + " / Item length: -> " + problemData.item[t].getLength() + " / Item height: -> " + problemData.item[t].getHeight() + " / Item Coordinates -> " + container_location.get(problemData.container[i]).get(problemData.item[t]));
                System.out.println(problemData.container[i].getContainerID() + "           " + problemData.item[q].getID() + "      " + problemData.item[q].getType() + "        " + problemData.item[q].getWeight() + "        " + problemData.item[q].getLength() + "        " + problemData.item[q].getHeight() + "        " + container_location.get(problemData.container[i]).get(problemData.item[q]));
            }
        }


    }
}




