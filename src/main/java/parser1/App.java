package parser1;

import Pojos.Project;
import Pojos.numberOfParticipantTypes;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ) throws Exception{//no catch{}. Stop operation if anything goes wrong
        final String DELIMITER = ",";
        Map<String,Project> projects = new HashMap<>();
        Map<String, String> orderProjectMap = new HashMap<>();
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        try (BufferedReader br = new BufferedReader(new FileReader("/home/user1/IdeaProjects/parser1/src/main/java/data/Projects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values = line.split(DELIMITER);
                projects.put((values[0]), new Project(values[0], values[1]));
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("/home/user1/IdeaProjects/parser1/src/main/java/data/Participants.csv"))) {
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
                    Project project = projects.get(projectId);
                    numberOfParticipantTypes numberOfParticipantTypes = project.getNumber_of_participant_types();
                    int writerCount = numberOfParticipantTypes.getWriter();
                    projects.get(projectId).getNumber_of_participant_types().setWriter(writerCount+1);
                }
                if(role.equals("publisher")){
                    int publisherCount = (projects.get(projectId)).getNumber_of_participant_types().getPublisher();
                    projects.get(projectId).getNumber_of_participant_types().setPublisher(publisherCount+1);
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("/home/user1/IdeaProjects/parser1/src/main/java/data/Orders.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values     = line.split(DELIMITER);
                String orderId      = values[0];
                String projectId    = values[1];
                String pendingTask  = values[3]; //writer task, Manager task etc
                String state        = values[4]; // pending or not

                orderProjectMap.put(orderId, projectId);

                if(state.equals("pending")){
                    if(pendingTask.equals("WriterTask")){
                        int writerTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getWriterTask();
                        projects.get(projectId).getNumber_of_pending_types().setWriterTask(writerTaskCount+1);
                    }
                    if(pendingTask.equals("WebSearchTask")){
                        int webSearchTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getWebSearchTask();
                        projects.get(projectId).getNumber_of_pending_types().setWebSearchTask(webSearchTaskCount+1);
                    }
                    if(pendingTask.equals("EditorTask")){
                        int editorTaskCount = (projects.get(projectId)).getNumber_of_pending_types().getEditorTask();
                        projects.get(projectId).getNumber_of_pending_types().setEditorTask(editorTaskCount+1);
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
        }

        try (BufferedReader br = new BufferedReader(new FileReader("/home/user1/IdeaProjects/parser1/src/main/java/data/Activities.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values    = line.split(DELIMITER);
                String orderId     = values[1];
                String taskType    = values[2];
                String projectId   = orderProjectMap.get(orderId); //join
                    if(taskType.equals("WriterTask")){
                        int writerTaskCount = (projects.get(projectId)).getNumber_of_activity_types().getWriterTask();
                        projects.get(projectId).getNumber_of_activity_types().setWriterTask(writerTaskCount+1);
                    }
                    if(taskType.equals("EditorTask")){
                        int editorTaskCount = (projects.get(projectId)).getNumber_of_activity_types().getEditorTask();
                        projects.get(projectId).getNumber_of_activity_types().setEditorTask(editorTaskCount+1);
                    }
                    if(taskType.equals("WebSearchTask")){
                        int webSearchTaskCount = (projects.get(projectId)).getNumber_of_activity_types().getWebSearchTask();
                        projects.get(projectId).getNumber_of_activity_types().setWebSearchTask(webSearchTaskCount+1);
                    }
                    if(taskType.equals("PublisherTask")){
                        int publisherTaskCount = (projects.get(projectId)).getNumber_of_activity_types().getPublisherTask();
                        projects.get(projectId).getNumber_of_activity_types().setPublisherTask(publisherTaskCount+1);
                    }
                    if(taskType.equals("ManagerTask")){
                        int managerTaskCount = (projects.get(projectId)).getNumber_of_activity_types().getManagerTask();
                        projects.get(projectId).getNumber_of_activity_types().setManagerTask(managerTaskCount+1);
                    }

                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Object json = objectMapper.readValue(
                    objectMapper.writeValueAsString(projects), Object.class);

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(json));
        }
    }
