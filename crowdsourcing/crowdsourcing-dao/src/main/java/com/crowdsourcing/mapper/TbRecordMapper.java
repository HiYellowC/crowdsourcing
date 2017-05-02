package com.crowdsourcing.mapper;

import com.crowdsourcing.pojo.TbRecord;
import com.crowdsourcing.pojo.TbRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRecordMapper {
    int countByExample(TbRecordExample example);

    int deleteByExample(TbRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbRecord record);

    int insertSelective(TbRecord record);

    List<TbRecord> selectByExample(TbRecordExample example);

    TbRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbRecord record, @Param("example") TbRecordExample example);

    int updateByExample(@Param("record") TbRecord record, @Param("example") TbRecordExample example);

    int updateByPrimaryKeySelective(TbRecord record);

    int updateByPrimaryKey(TbRecord record);
}