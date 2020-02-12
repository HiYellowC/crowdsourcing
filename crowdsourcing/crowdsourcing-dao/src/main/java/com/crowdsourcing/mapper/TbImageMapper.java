package com.crowdsourcing.mapper;

import com.crowdsourcing.pojo.TbImage;
import com.crowdsourcing.pojo.TbImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImageMapper {
    long countByExample(TbImageExample example);

    int deleteByExample(TbImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbImage record);

    int insertSelective(TbImage record);

    List<TbImage> selectByExampleWithBLOBs(TbImageExample example);
    
    List<TbImage> selectByExampleWithBLOBsDone(TbImageExample example);

    List<TbImage> selectByExample(TbImageExample example);
    
    List<Long> selectByExampleOnlyIdDone(TbImageExample example);

    TbImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbImage record, @Param("example") TbImageExample example);

    int updateByExampleWithBLOBs(@Param("record") TbImage record, @Param("example") TbImageExample example);

    int updateByExample(@Param("record") TbImage record, @Param("example") TbImageExample example);

    int updateByPrimaryKeySelective(TbImage record);

    int updateByPrimaryKeyWithBLOBs(TbImage record);

    int updateByPrimaryKey(TbImage record);
}