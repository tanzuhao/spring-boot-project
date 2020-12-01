package com.tanzuhao.core.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanzuhao.core.base.BaseService;
import com.tanzuhao.core.model.NewUser;
import com.tanzuhao.core.system.mapper.UserNewMapper;
import com.tanzuhao.core.system.service.UserNewService;

/**
 * 用户Service实现类
 * @author tanzuhao
 * @date: 2019年9月9日 下午5:29:48
 */
@Service
public class UserNewServiceImpl extends BaseService<NewUser> implements UserNewService {
	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserNewMapper userNewMapper;
	
	public int deleteById(Long id){
		log.info(">>>>>>>>>>>>>>>>>>根据ID进行删除");
		int count=userNewMapper.deleteById(id);
		return count;
	}
	
	public List<NewUser> listUser(){
		log.info(">>>>>>>>>>>>>>>>>>查询所有记录");
		return userNewMapper.listUser();
	}
	
	 public int insertUser(NewUser user){
		 log.info(">>>>>>>>>>>>>>>>>>新增记录");
		 return userNewMapper.insertUser(user);
	 };
	 
	 public int updateUser(NewUser user){
		 log.info(">>>>>>>>>>>>>>>>>>更新记录");
		 return userNewMapper.updateUser(user);
	 };

}