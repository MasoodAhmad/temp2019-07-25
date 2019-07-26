package Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT )
public class NumberOfPendingTypes {
    private int writerTask;
    private int webSearchTask;
    private int publisherTask;
    private int editorTask;
    private int managerTask;


    public int getWriterTask() {
        return writerTask;
    }

    public void setWriterTask(int writerTask) {
        this.writerTask = writerTask;
    }

    public int getWebSearchTask() {
        return webSearchTask;
    }

    public void setWebSearchTask(int webSearchTask) {
        this.webSearchTask = webSearchTask;
    }

    public int getPublisherTask() {
        return publisherTask;
    }

    public void setPublisherTask(int publisherTask) {
        this.publisherTask = publisherTask;
    }

    public int getEditorTask() {
        return editorTask;
    }

    public void setEditorTask(int editorTask) {
        this.editorTask = editorTask;
    }

    public int getManagerTask() {
        return managerTask;
    }

    public void setManagerTask(int managerTask) {
        this.managerTask = managerTask;
    }


}
