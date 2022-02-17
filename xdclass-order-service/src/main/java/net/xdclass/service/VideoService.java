package net.xdclass.service;

import net.xdclass.domain.Video;
import net.xdclass.service.fallback.VideoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jinxm
 * @date 2022-02-14
 * @description
 */
@FeignClient(value = "xdclass-video-service", fallback = VideoServiceFallback.class)
public interface VideoService {

    @GetMapping(value = "/api/v1/video/find_by_id")
    Video findById(@RequestParam("videoId") int videoId);

    @PostMapping(value = "/api/v1/video/save")
    int save(@RequestBody Video video);
}
