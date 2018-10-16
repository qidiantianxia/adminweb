package com.qdtx.shop.service;

import com.qdtx.shop.pojo.ActiveAdmin;
import com.qdtx.shop.pojo.SysAdmin;
import com.qdtx.shop.pojo.SysPermission;

import java.util.List;

/**
 * Created by yn on 2018-10-16
 */
public class SysService {

    //根据用户的身份和密码进行认证，如果认证通过，返回用户身份信息
    public ActiveAdmin authenticat(String usercode, String password) throws Exception;

    //根据用户账号查询用户信息
    public SysAdmin findSysUserByUserCode(String userCode) throws Exception;

    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid) throws Exception;

    //根据用户id查询URL
    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
