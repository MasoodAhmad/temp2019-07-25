package Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT )
public class NumberOfActivityTypes {
    private int writerTask;
    private int WebSearchTask;
    private int editorTask;
    private int publisherTask;
    private int managerTask;

    public int getWriterTask() {
        return writerTask;
    }

    public void setWriterTask(int writerTask) {
        this.writerTask = writerTask;
    }

    public int getWebSearchTask() {
        return WebSearchTask;
    }

    public void setWebSearchTask(int webSearchTask) {
        WebSearchTask = webSearchTask;
    }

    public int getEditorTask() {
        return editorTask;
    }

    public void setEditorTask(int editorTask) {
        this.editorTask = editorTask;
    }

    public int getPublisherTask() {
        return publisherTask;
    }

    public void setPublisherTask(int publisherTask) {
        this.publisherTask = publisherTask;
    }

    public int getManagerTask() {
        return managerTask;
    }

    public void setManagerTask(int managerTask) {
        this.managerTask = managerTask;
    }
}
