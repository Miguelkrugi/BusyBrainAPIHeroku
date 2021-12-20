package com.busybrain.api.prototipo.views;

public interface TaskView {
    
    String getTaskTitle();
    String getTaskDesc();
    Integer getTaskTypeId();
    String getDueDate();
    Integer getTaskPriorityId();
    Integer getUserTaskId();

}
