package com.crowdsourcing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.crowdsourcing.common.pojo.Rectangle;
import com.crowdsourcing.common.util.JsonUtil;
import com.crowdsourcing.common.util.StringUtil;
import com.crowdsourcing.jedis.JedisClient;
import com.crowdsourcing.mapper.TbRecordMapper;
import com.crowdsourcing.pojo.TbRecord;
import com.crowdsourcing.pojo.TbRecordExample;
import com.crowdsourcing.pojo.TbRecordExample.Criteria;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class RecordService {

	@Autowired
	private TbRecordMapper tbRecordMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_RECORD_KEY}")
	private String REDIS_RECORD_KEY;
	
	
	public void saveRecord(int step, Long editorId, Rectangle rectangle, String cls, Long round) throws JsonProcessingException {
		TbRecord tbRecord = new TbRecord();
		
		tbRecord.setStep(step);
		tbRecord.setEditorId(editorId);
		tbRecord.setRectangle(rectangle);
		tbRecord.setCls(cls);
		tbRecord.setRound(round);
		tbRecord.setGmtCreate(new Date());
		tbRecord.setGmtModified(new Date());
		
		tbRecordMapper.insert(tbRecord);
		
		//将task1的record添加到缓存
		String json = JsonUtil.objectToJson(tbRecord);
		jedisClient.hset(REDIS_RECORD_KEY, rectangle.getId() + "", json);
		
	}
	
	public void saveRecord(int step, Long editorId, Rectangle rectangle, boolean isPass, Long round) {
		TbRecord tbRecord = new TbRecord();
		
		tbRecord.setStep(step);
		tbRecord.setEditorId(editorId);
		tbRecord.setRectangle(rectangle);
		tbRecord.setIsPass(isPass);
		tbRecord.setRound(round);
		tbRecord.setGmtCreate(new Date());
		tbRecord.setGmtModified(new Date());
		
		tbRecordMapper.insert(tbRecord);
		
	}
	
	public void saveRecord(int step, Long editorId, Long imageId, boolean isPass, Long round) {
		
		TbRecord tbRecord = new TbRecord();
		
		tbRecord.setStep(step);
		tbRecord.setEditorId(editorId);
		tbRecord.setImageId(imageId);
		tbRecord.setIsPass(isPass);
		tbRecord.setRound(round);
		tbRecord.setGmtCreate(new Date());
		tbRecord.setGmtModified(new Date());
		
		tbRecordMapper.insert(tbRecord);
		
	}
	
	// 更新任务一标注检验结果
	public void updateRecordIsPassById(Long id, boolean isPass) {
	    TbRecord tbRecord = new TbRecord();
	    tbRecord.setId(id);
	    tbRecord.setIsPass(isPass);
	    tbRecord.setGmtModified(new Date());
	    tbRecordMapper.updateByPrimaryKeySelective(tbRecord);
	}
	
	// 显示未评测的标注
	public List<TbRecord> getNullIsPassRecords(Long imageId, Long round) {
	    TbRecordExample tbRecordExample = new TbRecordExample();
        Criteria criteria = tbRecordExample.createCriteria();
        criteria.andImageIdEqualTo(imageId);
        criteria.andRoundEqualTo(round);
        criteria.andStepEqualTo(1);
        criteria.andIsPassIsNull();
        
        return tbRecordMapper.selectByExample(tbRecordExample);
	}
	
	// 显示符合要求的框
	public List<TbRecord> getRecords(Long imageId, Long round) {
	    TbRecordExample tbRecordExample = new TbRecordExample();
	    Criteria criteria1 = tbRecordExample.createCriteria();
	    criteria1.andImageIdEqualTo(imageId);
	    criteria1.andRoundEqualTo(round);
	    criteria1.andStepEqualTo(1);
	    criteria1.andIsPassEqualTo(true);
	    Criteria criteria2 = tbRecordExample.or();
	    criteria2.andImageIdEqualTo(imageId);
        criteria2.andRoundEqualTo(round);
        criteria2.andStepEqualTo(1);
        criteria2.andIsPassIsNull();
	    
        return tbRecordMapper.selectByExample(tbRecordExample);
	    
	}
	
	public TbRecord geTbRecordById(Long Id) {
	    return tbRecordMapper.selectByPrimaryKey(Id);
	}
	
	public TbRecord getRecordByImageId(Long imageId) {
		
		try {
			String json = jedisClient.hget(REDIS_RECORD_KEY, imageId + "");
			if (!StringUtil.isBlankString(json)) {
				TbRecord tbRecord = JsonUtil.jsonToObject(json, TbRecord.class);
				return tbRecord;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbRecordExample example = new TbRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andImageIdEqualTo(imageId);
		example.setOrderByClause("gmt_create DESC");
		List<TbRecord> list = new ArrayList<>();
		list = tbRecordMapper.selectByExample(example);
		
		if (list.size() != 0) {
			TbRecord tbRecord = list.get(0);
			try {
				String json = JsonUtil.objectToJson(tbRecord);
				jedisClient.hset(REDIS_RECORD_KEY, imageId + "", json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return tbRecord;
		}
		
		return null;
	}
	
}
