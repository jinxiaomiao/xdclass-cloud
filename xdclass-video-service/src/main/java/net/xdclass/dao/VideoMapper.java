package net.xdclass.dao;

import net.xdclass.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author jinxm
 * @date 2022-02-11
 * @description
 */
@Repository
public interface VideoMapper {

    @Select("select * from video where id=#{videoId}")
    Video findById(@Param("videoId") int videoId);
}
