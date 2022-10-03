package com.swork.account.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class AccountEntityModel implements EntityModel {

    public AccountEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME))
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
