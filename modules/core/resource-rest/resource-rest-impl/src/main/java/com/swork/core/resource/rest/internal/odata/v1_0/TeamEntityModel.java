package com.swork.core.resource.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.BooleanEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.core.resource.service.constant.SearchFields;

import java.util.Map;

public class TeamEntityModel implements EntityModel {

    public TeamEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        SearchFields.PROJECT_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PROJECT_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.PHASE_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PHASE_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.PROJECT_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PROJECT_ID)),
                new StringEntityField(
                        SearchFields.PHASE_ID,
                        locale -> Field.getSortableFieldName(SearchFields.PHASE_ID)),
                new StringEntityField(
                        SearchFields.WORK_ID,
                        locale -> Field.getSortableFieldName(SearchFields.WORK_ID_NUMBER)),
                new StringEntityField(
                        SearchFields.WORK_ID,
                        locale -> Field.getSortableFieldName(SearchFields.WORK_ID)),
                new StringEntityField(
                        SearchFields.NAME,
                        locale -> Field.getSortableFieldName(SearchFields.NAME_STRING)),
                new BooleanEntityField(
                        SearchFields.IS_ACTIVE,
                        locale -> Field.getSortableFieldName(SearchFields.IS_ACTIVE_STRING)),
                new StringEntityField(
                        SearchFields.TOTAL_SPENDING,
                        locale -> Field.getSortableFieldName(SearchFields.TOTAL_SPENDING_NUMBER)),
                new StringEntityField(
                        SearchFields.TOTAL_INCOMING,
                        locale -> Field.getSortableFieldName(SearchFields.TOTAL_INCOMING_NUMBER))

        );

    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
