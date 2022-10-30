package com.example.pss.domain.stack.present;

import com.example.pss.domain.stack.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
