package com.swork.common.comment.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.common.comment.rest.dto.v1_0.Comment;
import com.swork.common.comment.rest.internal.mapper.CommentMapper;
import com.swork.common.comment.service.constant.SearchFields;
import com.swork.common.comment.service.model.CommentEntry;
import com.swork.common.comment.service.service.CommentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(
        immediate = true,
        service = CommentService.class
)
public class CommentService {

    public void postComment(long businessId,
                            long creatorId,
                            Comment comment,
                            ServiceContext serviceContext) {

        localService.addCommentEntry(
                businessId,
                creatorId,
                comment.getContent(),
                comment.getParentId(),
                comment.getClassPkId(),
                comment.getClassPkNameAsString(),
                serviceContext);

    }

    public void putComment(long commentId,
                           Comment comment,
                           ServiceContext serviceContext) {

        localService.
                updateCommentEntry(
                        commentId,
                        comment.getContent(),
                        serviceContext);

    }

    public Comment getComment(long commentId,
                              ThemeDisplay themeDisplay) throws PortalException {

        CommentEntry commentEntry = localService.getCommentEntry(commentId);

        return mapper.mapEntryToDTO(commentEntry, themeDisplay);
    }

    public void deleteComment(long commentId) throws PortalException {
        localService.deleteCommentEntry(commentId);
    }

    public Page<Comment> getCommentPages(Long classPkId,
                                         String classPkName,
                                         String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ThemeDisplay themeDisplay,
                                         ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

                    TermFilter classPkIdFilter = new TermFilter(SearchFields.CLASS_PK_ID, String.valueOf(classPkId));
                    TermFilter classPkNameFilter = new TermFilter(SearchFields.CLASS_PK_NAME, classPkName);
                    TermFilter parentIdFilter = new TermFilter(SearchFields.PARENT_ID, String.valueOf(GetterUtil.DEFAULT_LONG));

                    booleanFilter.add(classPkIdFilter, BooleanClauseOccur.MUST);
                    booleanFilter.add(classPkNameFilter, BooleanClauseOccur.MUST);
                    booleanFilter.add(parentIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                CommentEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK
                ),
                searchContext -> searchContext.setCompanyId(serviceContext.getCompanyId()),
                sorts,
                document -> {
                    long commentId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapEntryToDTO(
                            localService.getCommentEntry(commentId), themeDisplay);
                }
        );
    }

    @Reference
    private CommentEntryLocalService localService;

    @Reference
    private CommentMapper mapper;
}
