package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jinxm
 * @date 2022-02-11
 * @description
 */
@RestController
@RequestMapping("api/v1/video_order")
@RefreshScope
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    VideoService videoService;

    @Value("${video.title}")
    private String videoTitle;

    @RequestMapping("/find_by_id")
    public Object findById(int videoId) {
        //Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId="+videoId, Video.class);

//        List<ServiceInstance> instances = discoveryClient.getInstances("xdclass-video-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        Video video = restTemplate.getForObject("http://xdclass-video-service:/api/v1/video/find_by_id?videoId="+videoId, Video.class);

        Video video = videoService.findById(videoId);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(videoTitle);
        videoOrder.setCreateTime(new Date());
        videoOrder.setServeInfo(video.getServeInfo());
        return videoOrder;
    }

    @RequestMapping("/save")
    public Object save(@RequestBody Video video) {
        int rows = videoService.save(video);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",rows);
        return map;
    }

    int temp = 0;
    @RequestMapping("list")
    public Object list(HttpServletRequest request){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        temp++;
        if(temp%3 == 0){
            throw  new RuntimeException();
        }
        Map<String,String> map  = new HashMap<>();
        map.put("title1","ALibabaCloud微服务专题");
        map.put("title2","小滴课堂面试专题第一季");
        map.put("port",request.getServerPort()+"");
        return map;
    }
}
