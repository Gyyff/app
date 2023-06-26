package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Metrics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetricsMapper {
    @Select("SELECT * FROM metrics WHERE MetricID = #{MetricID}")
    Metrics getMetricsByMetricID(@Param("MetricID") int MetricID);

    @Select("SELECT * FROM metrics WHERE UserID = #{UserID}")
    Metrics getMetricsByUserID(@Param("UserID") int UserID);

    @Select("SELECT * FROM metrics WHERE ScoRel BETWEEN #{ScoRelMin} and #{ScoRelMax}")
    List<Metrics> findUserByScoRel(@Param("ScoRelMax")int ScoRelMax, @Param("ScoRelMin")int ScoRelMin);

    @Update("UPDATE metrics SET ScoRel = #{ScoRel} WHERE MetricID = #{MetricID}")
    int insertScoRel(int MetricID,int ScoRel);

    @Insert("INSERT INTO metrics(MetricID, UserID, MBTI, Principle, Knowledge, Openness, Curiosity, Abstraction,NewAThings, Intellect, Idea, Standard,Pet,Freedom,ChineseMed,Star,FS,ScoRel) VALUES(#{MetricID}, #{UserID}, #{MBTI}, #{Principle}, #{Knowledge}, #{Openness}, #{Curiosity}, #{Abstraction},#{NewAThings}, #{Intellect}, #{Idea}, #{Standard},#{Pet},#{Freedom},#{ChineseMed},#{Star},#{FS},#{ScoRel})")
    @Options(useGeneratedKeys = true, keyProperty = "MetricID")
    int insertMetrics(Metrics metrics);

    @Delete("DELETE FROM metrics WHERE UserID = #{UserID}")
    int deleteByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM metrics WHERE MetricID = #{MetricID}")
    int deleteByMetricID(@Param("MetricID") int MetricID);


}
