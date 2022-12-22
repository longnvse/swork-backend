package com.swork.common.file.rest.internal.service;

import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.common.file.constant.SearchFields;
import com.swork.common.file.helper.api.CommonFileHelper;
import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v1_0.FileManager;
import com.swork.common.file.rest.dto.v1_0.Metadata;
import com.swork.common.file.rest.internal.mapper.FileManagerMapper;
import com.swork.common.file.service.FileManagerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Collections;

@Component(immediate = true, service = FileManagerService.class)
public class FileManagerService {
    private static final String METADATA_KEY = "metadata";

    public void postFileManager(long businessId,
                                long creatorId,
                                Long projectId,
                                Long phaseId,
                                Long workId,
                                MultipartBody multipartBody,
                                ServiceContext serviceContext
    ) throws PortalException, IOException {
        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        FileEntry fileEntry = commonFileHelper.uploadFile(
                serviceContext.getScopeGroupId(),
                businessId,
                String.valueOf(businessId),
                metadata.getModuleId(),
                metadata.getAppId(),
                multipartBody,
                serviceContext);

        FileManagerMapperModel model = mapper.mapFileToMapperModel(fileEntry, metadata);

        localService.addFileManager(
                businessId,
                creatorId,
                projectId,
                phaseId,
                workId,
                model,
                serviceContext
        );
    }

    public Page<FileManager> getFileManagerPages(long businessId,
                                                 Long projectId,
                                                 Long phaseId,
                                                 Long workId,
                                                 String moduleId,
                                                 String appId,
                                                 String search,
                                                 Filter filter,
                                                 Pagination pagination,
                                                 Sort[] sorts,
                                                 ThemeDisplay themeDisplay,
                                                 ServiceContext serviceContext) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));
                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
                    if (Validator.isNotNull(projectId)) {
                        TermFilter projectIdFilter =
                                new TermFilter(SearchFields.PROJECT_ID, String.valueOf(projectId));

                        booleanFilter.add(projectIdFilter, BooleanClauseOccur.MUST);
                    }
                    if (Validator.isNotNull(phaseId)) {
                        TermFilter phaseIdFilter =
                                new TermFilter(SearchFields.PHASE_ID, String.valueOf(phaseId));

                        booleanFilter.add(phaseIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(workId)) {
                        TermFilter workIdFilter =
                                new TermFilter(SearchFields.WORK_ID, String.valueOf(workId));

                        booleanFilter.add(workIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(moduleId)) {
                        TermFilter moduleIdFilter =
                                new TermFilter(SearchFields.MODULE_ID, moduleId);

                        booleanFilter.add(moduleIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(appId)) {
                        TermFilter appIdFilter =
                                new TermFilter(SearchFields.APP_ID, appId);

                        booleanFilter.add(appIdFilter, BooleanClauseOccur.MUST);
                    }
                },
                filter,
                FileManagerEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long fileManagerId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapEntryToDTO(localService.fetchFileManagerEntry(fileManagerId), themeDisplay);
                });

    }

    public void deleteFile(long id) throws PortalException {
        FileManagerEntry entry = localService.deleteFileManagerEntry(id);

        dlFileEntryLocalService.deleteDLFileEntry(entry.getFileId());
    }

    public void deleteFiles(Long[] ids) throws PortalException {
        for (Long id : ids) {
            deleteFile(id);
        }
    }

    @Reference
    private FileManagerMapper mapper;
    @Reference
    private FileManagerEntryLocalService localService;
    @Reference
    private DLFileEntryLocalService dlFileEntryLocalService;
    @Reference
    private CommonFileHelper commonFileHelper;
}
