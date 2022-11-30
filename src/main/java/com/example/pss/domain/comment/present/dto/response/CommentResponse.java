package com.example.pss.domain.comment.present.dto.response;

import com.example.pss.domain.reply.domain.Reply;
import com.example.pss.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class CommentResponse {
    private final UUID id;
    private final String nickname;
    private final String content;
    private final String imageUrl;
    private final Boolean isMine;
    private final LocalDateTime createdAt;
    private final List<ReplyDto> replyDtoList;

    @Getter
    @AllArgsConstructor
    public static class ReplyDto {
        private final UUID id;
        private final String nickname;
        private final String content;
        private final String imageUrl;
        private final Boolean isMine;
        private final LocalDateTime createdAt;
    }

    public CommentResponse(UUID id, String nickname, String content, String imageUrl, Boolean isMine, LocalDateTime createdAt, List<Reply> list, User user) {
        this.id = id;
        this.nickname = nickname;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isMine = isMine;
        this.createdAt = createdAt;
        this.replyDtoList = new ArrayList<>();
        for (Reply reply : list) {
            replyDtoList.add(new ReplyDto(reply.getId(), reply.getUser().getNickname(), reply.getContent(), reply.getUser().getImageUrl(), reply.getUser().equals(user), reply.getCreateTime().plusHours(9)));
        }
    }
}