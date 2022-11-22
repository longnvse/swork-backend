package com.swork.core.work.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.core.work.service.constant.SearchFields;

import java.util.Map;

public class WorkEntryModel implements EntityModel {

    private final String SORTABLE = "_String_sortable";

    public WorkEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        SearchFields.START_DATE,
                        locale -> Field.getSortableFieldName(SearchFields.START_DATE)),
                new StringEntityField(
                        SearchFields.END_DATE,
                        locale -> Field.getSortableFieldName(SearchFields.END_DATE)),
                new StringEntityField(
                        SearchFields.ACTUAL_START_DATE,
                        locale -> Field.getSortableFieldName(SearchFields.ACTUAL_START_DATE)),
                new StringEntityField(
                        SearchFields.ACTUAL_START_DATE,
                        locale -> Field.getSortableFieldName(SearchFields.ACTUAL_START_DATE)),
                new StringEntityField(
                        SearchFields.STATUS, locale -> SearchFields.STATUS + SORTABLE)
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
