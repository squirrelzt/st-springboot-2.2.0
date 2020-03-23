package com.controller.jvm.bug;

import com.controller.jvm.bug.domain.Metaspace;
import com.controller.jvm.bug.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("jvm")
public class HeapController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<Class<?>>();

    /**
     * 堆内存溢出
     * -Xmx32M -Xms32M
     * @return
     */
    @GetMapping("heap")
    public String heap() {
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * 非堆内存溢出
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     */
    @GetMapping("nonheap")
    public String nonheap() {
        int i = 0;
        while (true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
