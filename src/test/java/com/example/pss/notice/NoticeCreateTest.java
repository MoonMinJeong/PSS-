package com.example.pss.notice;

import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class NoticeCreateTest {

    @Mock
    private NoticeRepository noticeRepository;
    
    @Test
    public void createNoticeCase() throws Exception{

    }
}
