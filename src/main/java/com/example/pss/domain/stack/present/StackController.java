package com.example.pss.domain.stack.present;

import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.present.dto.StackRequest;
import com.example.pss.domain.stack.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stack")
public class StackController {
    private final StackService service;
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long stackId) {
        service.deleteStack(stackId);
    }
}
