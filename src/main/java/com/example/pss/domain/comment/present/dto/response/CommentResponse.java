package com.example.pss.domain.comment.present.dto.response;

import com.example.pss.domain.reply.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentResponse {
    private final String nickname;
    private final String content;
    private final String imageUrl;
    private final Boolean isMine;
    private final List<ReplyDto> replyDtoList;

    @Getter
    @AllArgsConstructor
    public static class ReplyDto{
        private final String nickname;
        private final String content;
        private final String imageUrl;
        private final Boolean isMine;
    }

    public CommentResponse(String nickname, String content, String imageUrl, Boolean isMine, List<Reply> list) {
        this.nickname = nickname;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isMine = isMine;
        this.replyDtoList = new ArrayList<>();
        for(Reply reply : list) {
            replyDtoList.add(new ReplyDto(reply.getUser().getNickname(), reply.getContent(), reply.getUser().getImageUrl(), reply.isMine()));
        }
    }
}