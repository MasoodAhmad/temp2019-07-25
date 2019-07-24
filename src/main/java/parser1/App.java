package parser1;

import Pojos.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        final String DELIMITER = ",";
        List<Project> projectList = new ArrayList<>();
        System.out.println( "Hello World!" );
        try (BufferedReader br = new BufferedReader(new FileReader("parser1/data/Projects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                projectList.add(new Project(values[1], values[2]));
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
