package parser1;

public interface IConstants {
    String DELIMITER = ",";
    String dataDirectory = System.getProperty("user.dir") + "/src/main/java/data/"; //can also use .getResourceAsStream for relative path
    String ignoreStringWhileParsing = "#";

    String TASK_STATE_PENDING = "pending";
    String TASK_STATE_WRITER_TASK = "WriterTask";
    String TASK_STATE_WEB_SEARCH_TASK = "WebSearchTask";
    String TASK_STATE_EDITOR_TASK = "EditorTask";
    String TASK_STATE_MANAGER_TASK = "ManagerTask";
    String TASK_STATE_PUBLISHER_TASK = "PublisherTask";

    String ROLE_WRITER = "writer";
    String ROLE_EDITOR = "editor";
    String ROLE_PUBLISHER = "publisher";

}

//enum TaskState {
//    PENDING("pending"),
//    WRITER_TASK("WriterTask"),
//    WEB_SEARCH_TASK("WebSearchTask"),
//    EDITOR_TASK("EditorTask"),
//    MANAGER_TASK("ManagerTask"),
//    PUBLISHER_TASK("PublisherTask");
//
//    String value;
//    TaskState(String value) {
//        this.value = value;
//    }
//}