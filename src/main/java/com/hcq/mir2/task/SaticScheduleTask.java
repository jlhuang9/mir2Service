package com.hcq.mir2.task;


import com.hcq.mir2.entries.Model;
import com.hcq.mir2.service.Mir2Service;
import com.hcq.mir2.service.UrlParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private Mir2Service mir2Service;

    @Autowired
    private UrlParseService urlParseService;
    //3.添加定时任务
    @Scheduled(cron = "0 0/1 * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        try {
            List<Model> current = urlParseService.getCurrent();
            if (current != null && current.size() > 0) {
                mir2Service.setCurrent(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
