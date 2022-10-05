package com.swork.business.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.swork.business.service.constant.SearchField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BusinessEntityIndexModel implements EntityModel {

    public BusinessEntityIndexModel() {
        entityFieldMap = Stream.of(
                new StringEntityField(
                        SearchField.NAME, locale -> Field.getSortableFieldName(SearchField.NAME_STRING)
                ),
                new StringEntityField(
                        SearchField.STATUS, locale -> Field.getSortableFieldName(SearchField.STATUS_STRING)
                )
        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return entityFieldMap;
    }

    private final Map<String, EntityField> entityFieldMap;
}
