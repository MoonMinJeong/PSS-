package comment;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.present.dto.CommentRequest;
import com.example.pss.domain.comment.service.CommentService;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CommentSaveUseCase {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private NoticeFacade noticeFacade;

    @InjectMocks
    private CommentService commentService;

    @Test
    void 댓글_테스트() {
        String content = "댓글";

        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        Notice notice = Notice.builder()
                .id(UUID.randomUUID())
                .build();

        Comment comment = Comment.builder()
                .id(UUID.randomUUID())
                .content(content)
                .isMine(true)
                .user(user)
                .notice(notice)
                .build();

        CommentRequest commentRequest = CommentRequest
                .builder()
                .content(content)
                .build();

        given(commentRepository.save(comment).getId()).willReturn(comment.getId());

        assertEquals(user, comment.getUser());
        assertEquals(notice, comment.getNotice());

        commentService.create(notice.getId(), commentRequest);
    }
}