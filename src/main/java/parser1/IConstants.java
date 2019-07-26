package parser1;

public interface IConstants {
    final String DELIMITER = ",";
    final String dataDirectory = System.getProperty("user.dir") + "/src/main/java/data/"; //can also use .getResourceAsStream for relative path
    final String ignoreStringWhileParsing = "#";

    final String TASK_STATE_PENDING = "pending";
    final String TASK_STATE_WRITER_TASK = "WriterTask";
    final String TASK_STATE_WEB_SEARCH_TASK = "WebSearchTask";
    final String TASK_STATE_EDITOR_TASK = "EditorTask";
    final String TASK_STATE_MANAGER_TASK = "ManagerTask";
    final String TASK_STATE_PUBLISHER_TASK = "PublisherTask";

    final String ROLE_WRITER = "writer";
    final String ROLE_EDITOR = "editor";
    final String ROLE_PUBLISHER = "publisher";

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