package parser1;

import Pojos.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
        final String DELIMITER = ",";
        Map<Integer,Project> projects = new HashMap<>();
        System.out.println( "Hello World!" );
        try (BufferedReader br = new BufferedReader(new FileReader("data/Projects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                projects.put(Integer.parseInt(values[1]), new Project(values[1], values[2]));
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("data/Participants.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                String projectId = values[1];
                String role = values[3];
                if(role.equals("editor")){
                    int editorCount = (projects.get(projectId)).getNumber_of_participant_types().getEditor();
                    (projects.get(projectId)).getNumber_of_participant_types().setEditor(editorCount+1);
                }
                if(role.equals("writer")){
                    int writerCount = (projects.get(projectId)).getNumber_of_participant_types().getWriter();
                    (projects.get(projectId)).getNumber_of_participant_types().setEditor(writerCount+1);
                }
                if(role.equals("publisher")){
                    int publisherCount = (projects.get(projectId)).getNumber_of_participant_types().getPublisher();
                    (projects.get(projectId)).getNumber_of_participant_types().setEditor(publisherCount+1);
                }
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
