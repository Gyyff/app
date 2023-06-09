package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Metrics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface MetricsMapper {
    @Select("SELECT * FROM metrics WHERE MetricID = #{MetricID}")
    Metrics getMetricsByMetricID(@Param("MetricID") int MetricID);

    @Select("SELECT * FROM metrics WHERE UserID = #{UserID}")
    Metrics getMetricsByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO metrics(MetricID, UserID, MBTI, Principle, Knowledge, Openness, Curiosity, Abstraction, Intellect, Idea, Standard,Pet,Freedom,ChineseMed,Star,FS) VALUES(#{MetricID}, #{UserID}, #{MBTI}, #{Principle}, #{Knowledge}, #{Openness}, #{Curiosity}, #{Abstraction}, #{Intellect}, #{Idea}, #{Standard},#{Pet},#{Freedom},#{ChineseMed},#{Star},#{FS})")
    @Options(useGeneratedKeys = true, keyProperty = "MetricID")
    int insertMetrics(Metrics metrics);

    @Delete("DELETE FROM metrics WHERE UserID = #{UserID}")
    int deleteByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM metrics WHERE MetricID = #{MetricID}")
    int deleteByMetricID(@Param("MetricID") int MetricID);


}
