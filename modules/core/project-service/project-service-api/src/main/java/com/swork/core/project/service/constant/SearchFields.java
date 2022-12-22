package com.swork.core.project.service.constant;

public class SearchFields {
    private SearchFields() {}

    public static final String PROJECT_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.project.service.model.ProjectEntry";
    public static final String WORK_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.work.service.model.WorkEntry";
    public static final String RESOURCE_ENTRY_INDEXER_CLASS =
            "indexer.class.name=com.swork.core.resource.service.model.ResourceEntry";
    public static final String BUSINESS_ID = "businessId";
    public static final String PROJECT_ID = "projectId";
    public static final String TEAMS = "teams";
    public static final String TEAM_ID_SORT = "teamId_Number_sortable";
    public static final String CREATOR_ID = "creatorId";
    public static final String EXTERNAL_REFERENCE_CODE = "externalReferenceCode";

    public static final String PROJECT_CODE = "projectCode";
    public static final String PROJECT_NAME = "projectName";
    public static final String PROJECT_NAME_STRING = "projectName_String";
    public static final String BUDGET = "budget";
    public static final String BUDGET_SORT = "budget_Number_sortable";
    public static final String DESCRIPTION = "description";
    public static final String START_DATE = "startDate";
    public static final String START_DATE_SORT = "startDate_Number_sortable";
    public static final String END_DATE = "endDate";
    public static final String END_DATE_SORT = "endDate_Number_sortable";
    public static final String PROJECT_MANAGE = "projectManage";
    public static final String PROJECT_MANAGE_STRING = "projectManage_String";
    public static final String STATUS = "status";
    public static final String STATUS_SORT = "status_String_sortable";
    public static final String PROJECT_PARTICIPATE_ACCOUNT = "projectParticipateAccount";
    public static final String PROJECT_PARTICIPATE_ACCOUNT_STRING = "projectParticipateAccount_String";
    public static final String PROJECT_PARTICIPATE_DEPARTMENT = "projectParticipateDepartment";
    public static final String PROJECT_HANDLE_ACCOUNT = "projectHandleAccount";
    public static final String PROJECT_HANDLE_ACCOUNT_STRING = "projectHandleAccount_String";
    public static final String PROJECT_HANDLE_DEPARTMENT = "projectHandleDepartment";

    public static final String ACTUAL_TIME = "actualTime";
    public static final String YEAR_START_DATE = "yearStartDate";
    public static final String YEAR_ACTUAL_TIME = "yearActualTime";
    public static final String YEAR_ACTUAL_TIME_SORT = "yearActualTime_Number_sortable";

    public static final String YEAR_MONTH_END_DATE = "yearMonthEndDate";
    public static final String PROGRESS = "progress";
    public static final String WORK_NUMBER = "workNumber";

    public static final String TYPE_RESOURCE = "typeResource";
    public static final String TOTAL_AMOUNT_SORT = "totalAmount_Number_sortable";

    public static final String YEAR_MONTH_DAY_START_DATE_SORT = "yearMonthDayStartDate_String_sortable";
    public static final String YEAR_MONTH_WEEK_START_DATE_SORT = "yearMonthWeekStartDate_String_sortable";
    public static final String YEAR_MONTH_PRECIOUS_START_DATE_SORT = "yearMonthPreciousStartDate_String_sortable";
    public static final String YEAR_MONTH_ACTUAL_TIME_SORT = "yearMonthActualTime_String_sortable";
    public static final String YEAR_MONTH_DAY_ACTUAL_TIME_SORT = "yearMonthDayActualTime_String_sortable";
    public static final String YEAR_MONTH_WEEK_ACTUAL_TIME_SORT = "yearMonthWeekActualTime_String_sortable";
    public static final String YEAR_MONTH_PRECIOUS_ACTUAL_TIME_SORT = "yearMonthPreciousActualTime_String_sortable";
    public static final String YEAR_SORT = "year_Number_sortable";
    public static final String YEAR_MONTH_SORT = "yearMonth_String_sortable";

}
