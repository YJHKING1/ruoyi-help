package com.ruoyi.job.task;

import com.ruoyi.system.api.feignclient.StudyFeignClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author YJH
 */
@Component("jobTask")
public class JobTask {
    @Resource
    private StudyFeignClient studyFeignClient;
    public void countJob() {
        studyFeignClient.jobTask();
    }
}
