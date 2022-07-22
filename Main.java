import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ReadData();

        ProblemData problemData = ReadData();





        Heuristic heuristic = new Heuristic(problemData);
        heuristic.useAlgorithm1();
        //heuristic.useAlgorithm2();


        //ExactSolution exactSolution = new ExactSolution(problemData);

    }

    public static ProblemData ReadData() {

        ProblemData problemData=new ProblemData();
        FileReader fileReader;
        Item[] item;
        Container[] container;

        try {
            fileReader = new FileReader("80_2.csv");
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            String line=bufferedReader.readLine(); //1

            String[] names=line.split(";");
            //int numberofItems=names.length-1;

            int numberofItems=names.length;

            item=new Item[numberofItems];
            for(int i=0;i<numberofItems;i++)
            {
                item[i]=new Item(names[i]);
            }

            line=bufferedReader.readLine();//2
            line=bufferedReader.readLine();//3

            line=bufferedReader.readLine();//4
            String[] values=line.split(";");
            for(int i=0;i<numberofItems-1;i++)
            {
                item[i+1].setType(Integer.parseInt(values[i+1]));
            }


            line=bufferedReader.readLine();//5

            line=bufferedReader.readLine();//6
            String[] weights=line.split(";");
            for(int i=0;i<numberofItems-1;i++)
            {
                item[i+1].setWeight(Integer.parseInt(weights[i+1]));
            }

            line=bufferedReader.readLine();//7
            String[] widhts=line.split(";");
            for(int i=0;i<numberofItems-1;i++)
            {
                item[i+1].setWidht(Integer.parseInt(widhts[i+1]));
            }

            line=bufferedReader.readLine();//8
            String[] heights=line.split(";");
            for(int i=0;i<numberofItems-1;i++)
            {
                item[i+1].setHeight(Integer.parseInt(heights[i+1]));
            }

            line=bufferedReader.readLine();//9
            String[] lengths=line.split(";");
            for(int i=0;i<numberofItems-1;i++)
            {
                item[i+1].setLength(Integer.parseInt(lengths[i+1]));
            }



            problemData.item=item;



            container=new Container[4];
            container[1] = new Container(1);
            container[2] = new Container(2);
            container[3] = new Container(3);


            problemData.container=container;


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return problemData;

    }
}
