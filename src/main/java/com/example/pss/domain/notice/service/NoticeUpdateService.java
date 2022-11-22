package com.example.pss.domain.notice.service;

import com.example.pss.domain.member.facade.MemberFacade;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.request.UpdateRequest;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoticeUpdateService {
    private final NoticeFacade noticeFacade;
    private final StackFacade stackFacade;
    private final MemberFacade memberFacade;
    private final UserFacade userFacade;

    @Transactional
    public void update(UpdateRequest request, UUID uuid) {
        Notice notice = noticeFacade.findById(uuid);
        User user = userFacade.getCurrentUser();

        notice.UpdateNotice(
                request.getTitle(),
                request.getContent(),
                stackFacade.findByList(request.getStacks(), notice),
                memberFacade.findByList(request.getNicknames(), notice, user)
        );
    }
}