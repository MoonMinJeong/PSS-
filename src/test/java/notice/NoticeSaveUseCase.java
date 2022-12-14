package notice;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.service.NoticeCreateService;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class NoticeSaveUseCase {

    @Mock
    private NoticeRepository noticeRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private StackRepository stackRepository;

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private NoticeCreateService noticeCreateService;

    @Test
    void 소개글_작성() {

        List<String> stacks = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        stacks.add("스프링");
        nicknames.add("문정민");

        CreateRequest createRequest = CreateRequest.builder()
                .title("반갑고")
                .content("어서오고어서오고어서오고어서오고어서오고어서오고어서오고어서오고")
                .imageUrl("https://xquare.s3.ap-northeast-2.amazonaws.com/953bcfae-9958-432c-8874-ed81fb1f174d%40310520800_660849638711599_3334234336648915120_n.webp.jpeg")
                .stacks(stacks)
                .nicknames(nicknames)
                .build();

        Notice notice = Notice.builder()
                .id(UUID.randomUUID())
                .build();

        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        List<Stack> stackList = List.of(
                Stack.builder()
                        .techName(createRequest.getStacks().get(0))
                        .notice(notice)
                        .build()
        );

        List<Member> memberList = List.of(
                Member.builder()
                        .user(user)
                        .notice(notice)
                        .nickname(createRequest.getNicknames().get(0))
                        .build()
        );

        given(noticeRepository.save(any()))
                .willReturn(notice);

        assertEquals(stackList.get(0).getNotice(), notice);
        assertEquals(memberList.get(0).getNotice(), notice);

        assertThat(notice)
                .isNotNull();

        noticeCreateService.create(createRequest);
    }
}