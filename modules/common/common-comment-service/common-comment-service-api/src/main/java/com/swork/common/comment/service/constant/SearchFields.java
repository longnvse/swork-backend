package com.swork.common.comment.service.constant;

public class SearchFields {
    private SearchFields() {
    }

    public static final String COMMENT_INDEXER_CLASS =
            "indexer.class.name=com.swork.common.comment.service.model.CommentEntry";
    public static final String BUSINESS_ID = "businessId";
    public static final String PARENT_ID = "parentId";
    public static final String CONTENT = "content";
    public static final String CLASS_PK_ID = "classPkId";
    public static final String CLASS_PK_NAME = "classPkName";
    public static final String CREATOR_ID = "creatorId";
    public static final String MODIFIED_DATE = "modifiedDate";
    public static final String MODIFIED_DATE_SORTABLE = "modifiedDate_Date";
}
