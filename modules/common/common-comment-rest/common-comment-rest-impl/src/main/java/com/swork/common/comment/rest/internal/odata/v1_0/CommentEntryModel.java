package com.swork.common.comment.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.DateEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.swork.common.comment.service.constant.SearchFields;

import java.util.Map;

public class CommentEntryModel implements EntityModel {

    public CommentEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new DateEntityField(
                        SearchFields.MODIFIED_DATE,
                        locale -> Field.getSortableFieldName(SearchFields.MODIFIED_DATE),
                        locale -> Field.getSortableFieldName(SearchFields.MODIFIED_DATE_SORTABLE))
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;
}
