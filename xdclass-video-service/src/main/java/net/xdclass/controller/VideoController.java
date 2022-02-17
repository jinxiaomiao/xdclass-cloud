package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinxm
 * @date 2022-02-11
 * @description
 */
@RestController
@RequestMapping("api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("find_by_id")
    public Object findById(int videoId, HttpServletRequest request) {
        Video video = videoService.findById(videoId);
        video.setServeInfo(request.getServerName()+":"+request.getServerPort());
        return video;
    }

    @RequestMapping("save")
    public Object save(@RequestBody Video video) {
        System.out.println(video.getTitle());
        return 1;
    }
}
