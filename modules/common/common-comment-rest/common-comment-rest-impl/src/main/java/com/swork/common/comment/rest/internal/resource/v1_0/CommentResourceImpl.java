package com.swork.common.comment.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.comment.rest.dto.v1_0.Comment;
import com.swork.common.comment.rest.internal.odata.v1_0.CommentEntryModel;
import com.swork.common.comment.rest.internal.service.CommentService;
import com.swork.common.comment.rest.resource.v1_0.CommentResource;
import com.swork.common.file.helper.api.CommonFileHelper;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/comment.properties",
        scope = ServiceScope.PROTOTYPE, service = CommentResource.class
)
public class CommentResourceImpl extends BaseCommentResourceImpl {

    private final CommentEntryModel commentEntryModel = new CommentEntryModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return commentEntryModel;
    }

    @Override
    public Page<Comment> getCommentPages(Long classPkId, String classPkName, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        return service.getCommentPages(
                classPkId,
                classPkName,
                search,
                filter,
                pagination,
                sorts,
                getThemeDisplay(),
                getServiceContext()
        );
    }

    @Override
    public void postComment(Comment comment) throws Exception {
        service.postComment(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                comment,
                getServiceContext()
        );
    }

    @Override
    public Comment getComment(Long commentId) throws Exception {
        return service.getComment(commentId, getThemeDisplay());
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        service.deleteComment(commentId);
    }

    @Override
    public void putComment(Long commentId, Comment comment) throws Exception {
        service.putComment(
                commentId,
                comment,
                getServiceContext());
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return tokenHelper.getUserToken(contextHttpServletRequest);
    }

    private ThemeDisplay getThemeDisplay() {
        return commonFileHelper.getThemeDisplay(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper tokenHelper;
    @Reference
    private CommonFileHelper commonFileHelper;
    @Reference
    private CommentService service;
}