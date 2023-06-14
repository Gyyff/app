package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.NonCore;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface NonCoreMapper {
    @Select("SELECT * FROM noncore WHERE NonCoreID = #{NonCoreID}")
    NonCore getNonCoreByNonCoreID(@Param("NonCoreID") int NonCoreID);

    @Select("SELECT * FROM noncore WHERE UserID = #{UserID}")
    NonCore getNonCoreByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO noncore(NonCoreID, UserID, InAndEx, Confidence, MoralSense, Cure, Emotion, Risk, LeaderShip, ResPonSiBiLiTy, Respect,Reason,WillPower,AutoNoMy,Secular,Investment,Romantic,Challenge,Solitude,East,Achieve) VALUES(#{NonCoreID}, #{UserID}, #{InAndEx}, #{Confidence}, #{MoralSense}, #{Cure}, #{Emotion}, #{Risk}, #{LeaderShip}, #{ResPonSiBiLiTy}, #{Respect},#{Reason},#{WillPower},#{AutoNoMy},#{Secular},#{Investment},#{Romantic},#{Challenge},#{Solitude},#{East},#{Achieve})")
    @Options(useGeneratedKeys = true, keyProperty = "NonCoreID")
    int insertNonCore(NonCore nonCore);

    @Insert("INSERT INTO noncore_Text(NonCoreID, UserID, InAndEx, Confidence, MoralSense, Cure, Emotion, Risk, LeaderShip, ResPonSiBiLiTy, Respect,Reason,WillPower,AutoNoMy,Secular,Investment,Romantic,Challenge,Solitude,East,Achieve) VALUES(#{NonCoreID}, #{UserID}, #{InAndEx}, #{Confidence}, #{MoralSense}, #{Cure}, #{Emotion}, #{Risk}, #{LeaderShip}, #{ResPonSiBiLiTy}, #{Respect},#{Reason},#{WillPower},#{AutoNoMy},#{Secular},#{Investment},#{Romantic},#{Challenge},#{Solitude},#{East},#{Achieve})")
    @Options(useGeneratedKeys = true, keyProperty = "NonCoreID")
    int insertNonCoreText(NonCore nonCore);





    @Delete("DELETE FROM noncore WHERE UserID = #{UserID}")
    int deleteNonCoreByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM noncore WHERE NonCoreID = #{NonCoreID}")
    int deleteNonCoreByNonCoreID(@Param("NonCoreID") int NonCoreID);


}
