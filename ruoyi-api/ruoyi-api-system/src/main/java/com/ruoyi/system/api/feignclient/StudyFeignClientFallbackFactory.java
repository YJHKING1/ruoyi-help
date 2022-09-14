package com.ruoyi.system.api.feignclient;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author YJH
 */
@Component
public class StudyFeignClientFallbackFactory implements FallbackFactory<StudyFeignClient> {
    @Override
    public StudyFeignClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new StudyFeignClient() {
            @Override
            public AjaxResult save(SysUser user) {
                return AjaxResult.error();
            }
            @Override
            public AjaxResult jobTask() {
                return AjaxResult.error();
            }
        };
    }
}
