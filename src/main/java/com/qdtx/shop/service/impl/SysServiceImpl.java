package com.qdtx.shop.service.impl;

import com.qdtx.shop.dao.SysAdminMapper;
import com.qdtx.shop.dao.SysPermissionMapperCustom;
import com.qdtx.shop.pojo.*;
import com.qdtx.shop.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yn on 2018-10-16
 */
public class SysServiceImpl implements SysService {
    @Autowired
    private SysAdminMapper sysAdminMapper;
    @Autowired
    private SysPermissionMapperCustom sysPermissionMapperCustom;

    public ActiveAdmin authenticat(String usercode, String password) throws Exception {

        /**
         * 认证过程： 根据用户身份(账号)查询数据库，如果查询不到则用户不存在
         * 对输入的密码和数据库密码进行比对，如果一致则认证通过
         */
        // 根据用户账号查询数据库
        SysAdmin sysAdmin = this.findSysUserByUserCode(usercode);

        if (sysAdmin == null) {
            // 抛出异常
            throw new CustomException("用户账号不存在");
        }

        // 数据库密码（MD5加密后的密码）
        String password_db = sysAdmin.getPassword();

        // 对输入的密码和数据库密码进行比对，如果一致，认证通过
        // 对页面输入的密码进行MD5加密
        String password_input_md5 = new MD5().getMD5ofStr(password);
        if (!password_db.equalsIgnoreCase(password_input_md5)) {
            //抛出异常
            throw new CustomException("用户名或密码错误");
        }

        //得到用户id
        String userid = sysAdmin.getId();
        //根据用户id查询菜单
        List<SysPermission> menus = this.findMenuListByUserId(userid);
        //根据用户id查询权限url
        List<SysPermission> permissions = this.findPermissionListByUserId(userid);

        //认证通过，返回用户身份信息
        ActiveAdmin activeAdmin = new ActiveAdmin();
        activeAdmin.setUserid(userid);
        activeAdmin.setUsercode(usercode);
        activeAdmin.setUsername(sysAdmin.getUsername());

        //放入权限范围的菜单和url
        activeAdmin.setMenus(menus);
        activeAdmin.setPermissions(permissions);

        return activeAdmin;
    }

    public SysAdmin findSysUserByUserCode(String userCode) throws Exception {
        SysAdminExample sysAdminExample = new SysAdminExample();
        SysAdminExample.Criteria criteria = sysAdminExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);

        List<SysAdmin> list = sysAdminMapper.selectByExample(sysAdminExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
        return sysPermissionMapperCustom.findMenuListByUserId(userid);
    }
    @Override
    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
        return sysPermissionMapperCustom.findPermissionListByUserId(userid);
    }

}
