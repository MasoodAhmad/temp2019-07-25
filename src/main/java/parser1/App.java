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
                if(line.startsWith("#"))continue;
                String[] values = line.split(DELIMITER);
                projects.put(Integer.parseInt(values[1]), new Project(values[0], values[1]));
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("data/Participants.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values     = line.split(DELIMITER);
                String projectId    = values[1];
                String role         = values[3];
                if(role.equals("editor")){
                    int editorCount = (projects.get(projectId)).getNumber_of_participant_types().getEditor();
                    projects.get(projectId).getNumber_of_participant_types().setEditor(editorCount+1);
                }
                if(role.equals("writer")){
                    int writerCount = (projects.get(projectId)).getNumber_of_participant_types().getWriter();
                    projects.get(projectId).getNumber_of_participant_types().setWriter(writerCount+1);
                }
                if(role.equals("publisher")){
                    int publisherCount = (projects.get(projectId)).getNumber_of_participant_types().getPublisher();
                    projects.get(projectId).getNumber_of_participant_types().setPublisher(publisherCount+1);
                }
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }

        //Project Id,Keyword,Pending Task,State

        try (BufferedReader br = new BufferedReader(new FileReader("data/Orders.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values     = line.split(DELIMITER);
                String projectId    = values[1];
                String pendingTask  = values[3]; //writer task, Manager task etc
                String state        = values[4]; // pending or not

                if(state.equals("pending")){
                    if(pendingTask.equals("WriterTask")){
                        int writerTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getWriterTask();
                        projects.get(projectId).getNumber_of_pending_types().setWriterTask(writerTaskCount+1);
                    }
                    if(pendingTask.equals("WebSearchTask")){
                        int webSearchTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getWebSearchTask();
                        projects.get(projectId).getNumber_of_pending_types().setWriterTask(webSearchTaskCount+1);
                    }
                    if(pendingTask.equals("EditorTask")){
                        int editorTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getEditorTask();
                        projects.get(projectId).getNumber_of_pending_types().setWriterTask(editorTaskCount+1);
                    }
                    if(pendingTask.equals("ManagerTask")){
                        int managerTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getManagerTask();
                        projects.get(projectId).getNumber_of_pending_types().setManagerTask(managerTaskCount+1);
                    }
                    if(pendingTask.equals("PublisherTask")){
                        int publisherTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getPublisherTask();
                        projects.get(projectId).getNumber_of_pending_types().setPublisherTask(publisherTaskCount+1);
                    }
                }
            }
        }catch (IOException ioe){
            System.out.println(ioe);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
