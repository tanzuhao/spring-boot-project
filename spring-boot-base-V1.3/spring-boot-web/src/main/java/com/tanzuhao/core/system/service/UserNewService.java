package com.tanzuhao.core.system.service;

import java.util.List;

import com.tanzuhao.core.base.Service;
import com.tanzuhao.core.model.NewUser;

/**
 * 用户Service接口
 * @author tanzuhao
 * @date: 2019年9月9日 下午5:30:04
 */
public interface UserNewService extends Service<NewUser> {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);
	/**
	 * 
	 * @return
	 */
	public List<NewUser> listUser();
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(NewUser user);
	 /**
	  * 
	  * @param user
	  * @return
	  */
	public int updateUser(NewUser user);
}