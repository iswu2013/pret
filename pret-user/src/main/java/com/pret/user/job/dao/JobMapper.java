package com.pret.user.job.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pret.user.job.domain.Job;

import java.util.List;

public interface JobMapper extends BaseMapper<Job> {
	
	List<Job> queryList();
}