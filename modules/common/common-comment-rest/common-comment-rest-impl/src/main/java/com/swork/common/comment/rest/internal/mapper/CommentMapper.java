package com.swork.common.comment.rest.internal.mapper;

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
