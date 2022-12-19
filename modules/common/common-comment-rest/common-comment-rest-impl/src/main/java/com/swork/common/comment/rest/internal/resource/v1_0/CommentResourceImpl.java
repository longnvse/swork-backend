package com.swork.common.comment.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.comment.rest.dto.v1_0.Comment;
import com.swork.common.comment.rest.internal.service.CommentService;
import com.swork.common.comment.rest.resource.v1_0.CommentResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/comment.properties",
        scope = ServiceScope.PROTOTYPE, service = CommentResource.class
)
public class CommentResourceImpl extends BaseCommentResourceImpl {
    @Override
    public Page<Comment> getCommentPages(Long classPkId, String classPkName, Pagination pagination) throws Exception {
        return service.getCommentPages(
                classPkId,
                classPkName,
                pagination,
                getServiceContext()
        );
    }

    @Override
    public Comment postComment(Comment comment) throws Exception {
        return service.postComment(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                comment,
                getServiceContext()
        );
    }

    @Override
    public Comment getComment(Long commentId) throws Exception {
        return service.getComment(commentId);
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        service.deleteComment(commentId);
    }

    @Override
    public Comment putComment(Long commentId, Comment comment) throws Exception {
        return service.putComment(
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

    @Reference
    private CommonTokenHelper tokenHelper;

    @Reference
    private CommentService service;
}