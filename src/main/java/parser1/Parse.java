package parser1;

import Pojos.NumberOfActivityTypes;
import Pojos.NumberOfParticipantTypes;
import Pojos.NumberOfPendingTypes;
import Pojos.Project;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parse implements IConstants{
    public static Map<String, Project> parseCsv() throws Exception{//no catch{}. Stop operation if anything goes wrong
        Map<String,Project> projects = new HashMap<>();
        Map<String, String> orderProjectMap = new HashMap<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(dataDirectory+"Projects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values = line.split(DELIMITER);
                projects.put((values[0]), new Project(values[0], values[1]));
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(dataDirectory+"Participants.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values     = line.split(DELIMITER);
                String projectId    = values[1];
                String role         = values[3];
                NumberOfParticipantTypes numberOfParticipantTypes = projects.get(projectId).getNumberOfParticipantTypes();
                if(role.equals("editor")){
                    int editorCount = numberOfParticipantTypes.getEditor();
                    numberOfParticipantTypes.setEditor(editorCount+1);
                }
                if(role.equals("writer")){
                    int writerCount = numberOfParticipantTypes.getWriter();
                    numberOfParticipantTypes.setWriter(writerCount+1);
                }
                if(role.equals("publisher")){
                    int publisherCount = numberOfParticipantTypes.getPublisher();
                    numberOfParticipantTypes.setPublisher(publisherCount+1);
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(dataDirectory+"Orders.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values     = line.split(DELIMITER);
                String orderId      = values[0];
                String projectId    = values[1];
                String pendingTask  = values[3]; //writer task, Manager task etc
                String state        = values[4]; // pending or not

                orderProjectMap.put(orderId, projectId);
                NumberOfPendingTypes numberOfPendingTypes = projects.get(projectId).getNumberOfPendingTypes();
                int numberOfOrdersCount = projects.get(projectId).getNumberOfOrders();
                projects.get(projectId).setNumberOfOrders(numberOfOrdersCount+1);

                if(state.equals("pending")){
                    if(pendingTask.equals("WriterTask")){
                        int writerTaskCount = numberOfPendingTypes.getWriterTask();
                        numberOfPendingTypes.setWriterTask(writerTaskCount+1);
                    }
                    if(pendingTask.equals("WebSearchTask")){
                        int webSearchTaskCount = numberOfPendingTypes.getWebSearchTask();
                        numberOfPendingTypes.setWebSearchTask(webSearchTaskCount+1);
                    }
                    if(pendingTask.equals("EditorTask")){
                        int editorTaskCount = numberOfPendingTypes.getEditorTask();
                        numberOfPendingTypes.setEditorTask(editorTaskCount+1);
                    }
                    if(pendingTask.equals("ManagerTask")){
                        int managerTaskCount = numberOfPendingTypes.getManagerTask();
                        numberOfPendingTypes.setManagerTask(managerTaskCount+1);
                    }
                    if(pendingTask.equals("PublisherTask")){
                        int publisherTaskCount = numberOfPendingTypes.getPublisherTask();
                        numberOfPendingTypes.setPublisherTask(publisherTaskCount+1);
                    }
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(dataDirectory+"Activities.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))continue;
                String[] values    = line.split(DELIMITER);
                String orderId     = values[1];
                String taskType    = values[2];
                String projectId   = orderProjectMap.get(orderId); //join table
                NumberOfActivityTypes numberOfActivityTypes = projects.get(projectId).getNumberOfActivityTypes();

                if(taskType.equals("WriterTask")){
                    int writerTaskCount = numberOfActivityTypes.getWriterTask();
                    numberOfActivityTypes.setWriterTask(writerTaskCount+1);
                }
                if(taskType.equals("EditorTask")){
                    int editorTaskCount = numberOfActivityTypes.getEditorTask();
                    numberOfActivityTypes.setEditorTask(editorTaskCount+1);
                }
                if(taskType.equals("WebSearchTask")){
                    int webSearchTaskCount = numberOfActivityTypes.getWebSearchTask();
                    numberOfActivityTypes.setWebSearchTask(webSearchTaskCount+1);
                }
                if(taskType.equals("PublisherTask")){
                    int publisherTaskCount = numberOfActivityTypes.getPublisherTask();
                    numberOfActivityTypes.setPublisherTask(publisherTaskCount+1);
                }
                if(taskType.equals("ManagerTask")){
                    int managerTaskCount = numberOfActivityTypes.getManagerTask();
                    numberOfActivityTypes.setManagerTask(managerTaskCount+1);
                }
            }
        }
        List<Project> projectsForOutPut = new ArrayList<>();
        projectsForOutPut.addAll(projects.values());
        ObjectMapper objectMapper = new ObjectMapper();
        Object json = objectMapper.readValue(
//                    objectMapper.writeValueAsString(projects), Object.class); //works
                objectMapper.writeValueAsString(projectsForOutPut), Object.class);// just prints 'true'

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json));
        return projects;
    }

}
