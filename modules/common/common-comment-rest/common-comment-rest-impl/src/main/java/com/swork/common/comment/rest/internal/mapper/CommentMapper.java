package com.swork.common.comment.rest.internal.mapper;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalServiceUtil;
import com.swork.common.comment.rest.dto.v1_0.Comment;
import com.swork.common.comment.service.model.CommentEntry;
import com.swork.common.comment.service.service.CommentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = CommentMapper.class
)
public class CommentMapper {
    public Comment mapEntryToDTO(CommentEntry from) {
        Comment to = new Comment();

        to.setId(from.getCommentId());
        to.setContent(from.getContent());
        to.setCreatorId(from.getAccountId());

        AccountEntry accountEntry = AccountEntryLocalServiceUtil.fetchAccountEntry(from.getAccountId());

        to.setCreatorName(Validator.isNotNull(accountEntry) ? accountEntry.getFullName() : "Nhân viên đã bị xoá");
        to.setDate(from.getCreateDate());
        List<CommentEntry> children = localService.getByParentId(from.getCommentId());

        to.setComments(mapEntriesToDTO(children));

        return to;
    }

    public Comment[] mapEntriesToDTO(List<CommentEntry> from) {
        return from.stream().map(this::mapEntryToDTO).toArray(Comment[]::new);
    }

    @Reference
    private CommentEntryLocalService localService;
}
