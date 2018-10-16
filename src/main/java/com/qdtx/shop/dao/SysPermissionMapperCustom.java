package com.qdtx.shop.dao;

import com.qdtx.shop.pojo.SysPermission;

import java.util.List;

/**
 * Created by yn on 2018-10-16
 */
public interface SysPermissionMapperCustom {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid) throws Exception;

    //根据用户id查询权限URL
    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;

}

