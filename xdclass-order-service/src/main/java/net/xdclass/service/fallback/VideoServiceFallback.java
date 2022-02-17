package net.xdclass.service.fallback;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * @author jinxm
 * @date 2022-02-15
 * @description
 */
@Service
public class VideoServiceFallback implements VideoService {

    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("熔断降级数据");
        return video;
    }

    @Override
    public int save(Video video) {
        return 0;
    }
}
