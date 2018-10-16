package com.qdtx.shop.pojo;

import java.util.Date;

public class SysAdminRole {
    private Long id;

    private Long adminid;

    private Long roleid;

    private Date createtime;

    private Boolean iseabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getIseabled() {
        return iseabled;
    }

    public void setIseabled(Boolean iseabled) {
        this.iseabled = iseabled;
    }
}