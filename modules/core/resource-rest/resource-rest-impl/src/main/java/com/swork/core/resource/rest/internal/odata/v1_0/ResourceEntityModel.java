package com.swork.core.resource.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.DateEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.core.resource.service.constant.SearchFields;

import java.util.Map;

public class ResourceEntityModel implements EntityModel {

    public ResourceEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        SearchFields.PROJECT_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PROJECT_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.PHASE_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PHASE_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.WORK_ID,
                        locale -> Field.getSortableFieldName(SearchFields.WORK_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.PROJECT_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PROJECT_ID)),
                new StringEntityField(
                        SearchFields.PHASE_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PHASE_ID)),
                new StringEntityField(
                        SearchFields.WORK_ID,
                        locale -> Field.getSortableFieldName(SearchFields.WORK_ID)),
                new StringEntityField(
                        SearchFields.TYPE_RESOURCE,
                        locale -> Field.getSortableFieldName(SearchFields.TYPE_RESOURCE_STRING)),
                new StringEntityField(
                        SearchFields.TEAM_ID,
                        locale -> Field.getSortableFieldName(SearchFields.TEAM_ID)),
                new StringEntityField(
                        SearchFields.RESOURCE_TYPE_NAME,
                        locale -> Field.getSortableFieldName(SearchFields.RESOURCE_TYPE_NAME_STRING)),
                new DateEntityField(
                        SearchFields.DATE_RESOURCE,
                        locale -> Field.getSortableFieldName(SearchFields.DATE_RESOURCE),
                        locale -> Field.getSortableFieldName(SearchFields.DATE_RESOURCE))
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
