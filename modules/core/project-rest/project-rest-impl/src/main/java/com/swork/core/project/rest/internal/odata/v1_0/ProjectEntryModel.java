package com.swork.core.project.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.core.project.service.constant.SearchFields;

import java.util.Map;

public class ProjectEntryModel implements EntityModel {

    public ProjectEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(SearchFields.PROJECT_NAME_STRING)),
                new StringEntityField(
                        SearchFields.START_DATE, locale -> Field.getSortableFieldName(SearchFields.START_DATE)),
                new StringEntityField(
                        SearchFields.END_DATE, locale -> Field.getSortableFieldName(SearchFields.END_DATE)),
                new StringEntityField(
                        SearchFields.WORK_NUMBER, locale -> Field.getSortableFieldName(SearchFields.WORK_NUMBER)),
                new StringEntityField(
                        SearchFields.PROJECT_HANDLE_ACCOUNT, locale -> Field.getSortableFieldName(SearchFields.PROJECT_HANDLE_ACCOUNT)),
                new StringEntityField(
                        SearchFields.PROJECT_MANAGE, locale -> Field.getSortableFieldName(SearchFields.PROJECT_MANAGE)),
                new StringEntityField(
                        SearchFields.PROJECT_PARTICIPATE_ACCOUNT, locale -> Field.getSortableFieldName(SearchFields.PROJECT_PARTICIPATE_ACCOUNT)),
                new StringEntityField(
                        SearchFields.STATUS, locale -> SearchFields.STATUS + "_String_sortable"),
                new StringEntityField(
                        Field.ENTRY_CLASS_PK,
                        locale -> Field.ENTRY_CLASS_PK)
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;
}
