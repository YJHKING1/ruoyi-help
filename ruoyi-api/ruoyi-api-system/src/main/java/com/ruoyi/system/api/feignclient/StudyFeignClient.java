package com.ruoyi.system.api.feignclient;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author YJH
 */
@FeignClient(value = "study", fallbackFactory = StudyFeignClientFallbackFactory.class)
public interface StudyFeignClient {
    @PostMapping("/teacher/save")
    public AjaxResult save(@RequestBody SysUser user);
    @GetMapping("/job/jobTask")
    public AjaxResult jobTask();
}
