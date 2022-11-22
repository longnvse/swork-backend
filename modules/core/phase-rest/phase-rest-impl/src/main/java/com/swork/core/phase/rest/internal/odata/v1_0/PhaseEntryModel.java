package com.swork.core.phase.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.core.phase.service.constant.SearchFields;

import java.util.Map;

public class PhaseEntryModel implements EntityModel {

    public PhaseEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(SearchFields.PHASE_NAME_STRING)),
                new StringEntityField(
                        SearchFields.START_DATE, locale -> Field.getSortableFieldName(SearchFields.START_DATE)),
                new StringEntityField(
                        SearchFields.END_DATE, locale -> Field.getSortableFieldName(SearchFields.END_DATE)),
                new StringEntityField(
                        SearchFields.STATUS, locale -> Field.getSortableFieldName(SearchFields.STATUS_STRING)),
                new StringEntityField(
                        SearchFields.THU, locale -> Field.getSortableFieldName(SearchFields.THU)),
                new StringEntityField(
                        SearchFields.CHI, locale -> Field.getSortableFieldName(SearchFields.CHI)),
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
