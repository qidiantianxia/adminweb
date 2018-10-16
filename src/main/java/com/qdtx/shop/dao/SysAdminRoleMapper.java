package com.qdtx.shop.dao;

import com.qdtx.shop.pojo.SysAdminRole;
import com.qdtx.shop.pojo.SysAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdminRoleMapper {
    int countByExample(SysAdminRoleExample example);

    int deleteByExample(SysAdminRoleExample example);

    int insert(SysAdminRole record);

    int insertSelective(SysAdminRole record);

    List<SysAdminRole> selectByExample(SysAdminRoleExample example);

    int updateByExampleSelective(@Param("record") SysAdminRole record, @Param("example") SysAdminRoleExample example);

    int updateByExample(@Param("record") SysAdminRole record, @Param("example") SysAdminRoleExample example);
}