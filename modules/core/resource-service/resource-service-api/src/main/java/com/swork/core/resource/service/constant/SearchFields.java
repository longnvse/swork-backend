package com.swork.core.resource.service.constant;

import com.liferay.portal.kernel.util.StringBundler;

;

public class SearchFields {
    private SearchFields() {
    }

    public static final String RESOURCE_TYPE_ENTRY_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.resource.service.model.ResourceTypeEntry";
    public static final String TEAM_ENTRY_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.resource.service.model.TeamEntry";
    public static final String RESOURCE_ENTRY_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.resource.service.model.ResourceEntry";

    public static final String BUSINESS_ID = "businessId";
    public static final String CREATOR_ID = "creatorId";

    public static final String NAME = "name";
    public static final String NAME_STRING = "name_String";

    public static final String CODE = "code";
    public static final String CODE_STRING = "code_String";

    public static final String UNIT = "unit";
    public static final String UNIT_STRING = "unit_String";

    public static final String PARENT_ID = "parentId";
    public static final String WORK_ID = "workId";
    public static final String TASK_ID_NUMBER = "taskId_Number";
    public static final String PHASE_ID = "phaseId";
    public static final String PHASE_ID_NUMBER = "phaseId_Number";
    public static final String PROJECT_ID = "projectId";
    public static final String PROJECT_ID_NUMBER = "projectId_Number";
    public static final String RESOURCE_TYPE_ID = "resourceTypeId";
    public static final String TEAM_ID = "teamId";
    public static final String QUANTITY = "quantity";

    public static final String TEAM_NAME = "teamName";
    public static final String RESOURCE_TYPE_NAME = "resourceTypeName";
    public static final String RESOURCE_TYPE_NAME_STRING = "resourceTypeName_String";

    public static final String TASK_INDEXER_CLASS =
            "com.dogoo.core.task.service.model.TaskEntry";

    public static final String EMPLOYEE_INDEXER_CLASS =
            "com.dogoo.employee.service.model.EmployeeEntry";

    public static final String PHASE_INDEXER_CLASS =
            "com.dogoo.core.project.service.model.PhaseEntry";

    public static final String IS_ACTIVE = "isActive";
    public static final String IS_ACTIVE_STRING = "isActive_String";
    public static final String MONTH = "month";
    public static final String YEAR = "year";
    public static final String YEAR_MONTH = "yearMonth";
    public static final String DATE_RESOURCE = "dateResource";
    public static final String CREATE_DATE = "createDate";
    public static final String PRICE = "price";
    public static final String TOTAL_AMOUNT = "totalAmount";
    public static final String TOTAL_INCOMING = "totalIncoming";
    public static final String TOTAL_INCOMING_NUMBER = "totalIncoming_Number";
    public static final String TOTAL_SPENDING = "totalSpending";
    public static final String TOTAL_SPENDING_NUMBER = "totalSpending_Number";

    public static String getDateSortable(String field) {
        return StringBundler.concat(new String[]{field, "_Number_sortable"});
    }

    public static String getCreatorDateSortable(String field) {
        return StringBundler.concat(new String[]{field, "_sortable"});
    }

}
