package com.swork.core.phase.service.constant;

import java.util.List;

public class KeyPermission {

    public static final String NORMAL = "normal";
    public static final String PROJECT = "project";

    public static final String STATUS = "status";
    public static final String MEMBER = "member";
    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_TIME_ACTUAL = "updateTimeActual";
    public static final String UPDATE_DESCRIPTION = "updateDescription";
    public static final String EDIT = "edit";
    public static final String DELETE = "delete";
    public static final String ADD_TASK_PROJECT = "addTaskProject";
    public static final String ADD_PROCESS_PROJECT = "addProcessProject";
    public static final String ADD_TASK_PHASE = "addTaskPhase";
    public static final String ADD_PROCESS_PHASE = "addProcessPhase";
    public static final String ADD_RESOURCE = "addResource";
    public static final String ADD_OBJECT_GROUP = "addObjectGroup";
    public static final String ADD_PHASE = "addPhase";
    public static final String EDIT_PHASE = "editPhase";
    public static final String DELETE_PHASE = "deletePhase";

    public static final List<String> ARRAY_ACTIONS = List.of( STATUS, MEMBER, UPDATE_TIME, UPDATE_TIME_ACTUAL,
            UPDATE_DESCRIPTION, EDIT, ADD_TASK_PROJECT, ADD_PROCESS_PROJECT,
            ADD_TASK_PHASE, ADD_PROCESS_PHASE, ADD_RESOURCE, ADD_OBJECT_GROUP , ADD_PHASE ,
            EDIT_PHASE , DELETE_PHASE );

    public static final List<String> ARRAY_ACTION_DENIED = List.of(STATUS, DELETE , DELETE_PHASE);

    public static final List<String> ARRAY_ACTION_INACTIVE = List.of(STATUS, UPDATE_DESCRIPTION);

    public static final List<String> ARRAY_ACTION_APPROVED = List.of(STATUS, UPDATE_TIME_ACTUAL);

    public static final List<String> ARRAY_ACTION_ASSIGNEE = List.of(MEMBER,
            ADD_TASK_PROJECT, ADD_PROCESS_PROJECT, ADD_TASK_PHASE, ADD_PROCESS_PHASE,
            ADD_RESOURCE, ADD_OBJECT_GROUP , ADD_PHASE );

    public static final List<String> ARRAY_ACTION_FOLLOWER = List.of(
            ADD_TASK_PROJECT, ADD_PROCESS_PROJECT, ADD_TASK_PHASE, ADD_PROCESS_PHASE,
            ADD_RESOURCE, ADD_OBJECT_GROUP , ADD_PHASE );

}
