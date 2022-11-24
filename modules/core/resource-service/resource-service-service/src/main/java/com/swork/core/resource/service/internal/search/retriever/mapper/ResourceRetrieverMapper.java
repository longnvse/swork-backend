package com.swork.core.resource.service.internal.search.retriever.mapper;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = ResourceRetrieverMapper.class)
public class ResourceRetrieverMapper {

    public List<ResourceMapperModel> mapResourceMapperModelToElastic(Document[] documents) {
        return Arrays.stream(documents)
                .map(this::mapperResourceMapperModel)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ResourceMapperModel mapperResourceMapperModel(Document doc) {

        ResourceMapperModel to = new ResourceMapperModel();

        to.setResourceTypeId(GetterUtil.getLong(doc.get(SearchFields.RESOURCE_TYPE_ID)));
        to.setQuantity(GetterUtil.getLong(doc.get(SearchFields.QUANTITY)));
        to.setCreatorId(GetterUtil.getLong(doc.get("creatorId")));
        to.setResourceId(GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK)));
        return to;

    }
}
