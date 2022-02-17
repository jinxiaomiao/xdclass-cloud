package net.xdclass.service;

import net.xdclass.domain.Video;

/**
 * @author jinxm
 * @date 2022-02-11
 * @description
 */
public interface VideoService {

    Video findById(int videoId);
}
