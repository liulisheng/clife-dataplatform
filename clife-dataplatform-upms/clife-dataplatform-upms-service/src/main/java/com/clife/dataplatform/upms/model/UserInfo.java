package com.clife.dataplatform.upms.model;

import java.util.List;

public class UserInfo {


    /**
     * id : 1
     * username : admin
     * password : 121212
     * chineseName : 管理员
     * idcardNo : 000000000000000000
     * policeCode : 000000
     * deptCode : 370200000000
     * gender : 1
     * email : abc@abc.com
     * phoneNo : 15100000005
     * duty : 超级管理员
     * address : address
     * remark : remarl
     * type : 0
     * status : 0
     * roles : [{"id":1,"roleName":"超级管理员","resources":[]}]
     * deptName : 杭州市
     * ticket : .2XxGlEuidOmAoYIdSo6pQIlGbQSh83U7p4eJsoTO-70
     * gxdwdm : 370200000000
     * deptLevel : 1
     * defaultDeptCode : 370200000000
     * defaultXzqhCode : 370200
     */

    private int id;
    private String username;
    private String password;
    private String chineseName;
    private String idcardNo;
    private String policeCode;
    private String deptCode;
    private int gender;
    private String email;
    private String phoneNo;
    private String duty;
    private String address;
    private String remark;
    private int type;
    private int status;
    private String deptName;
    private String ticket;
    private String gxdwdm;
    private String deptLevel;
    private String defaultDeptCode;
    private String defaultXzqhCode;
    private List<RolesBean> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getPoliceCode() {
        return policeCode;
    }

    public void setPoliceCode(String policeCode) {
        this.policeCode = policeCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getGxdwdm() {
        return gxdwdm;
    }

    public void setGxdwdm(String gxdwdm) {
        this.gxdwdm = gxdwdm;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDefaultDeptCode() {
        return defaultDeptCode;
    }

    public void setDefaultDeptCode(String defaultDeptCode) {
        this.defaultDeptCode = defaultDeptCode;
    }

    public String getDefaultXzqhCode() {
        return defaultXzqhCode;
    }

    public void setDefaultXzqhCode(String defaultXzqhCode) {
        this.defaultXzqhCode = defaultXzqhCode;
    }

    public List<RolesBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesBean> roles) {
        this.roles = roles;
    }

    public static class RolesBean {
        /**
         * id : 1
         * roleName : 超级管理员
         * resources : []
         */

        private int id;
        private String roleName;
        private List<?> resources;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public List<?> getResources() {
            return resources;
        }

        public void setResources(List<?> resources) {
            this.resources = resources;
        }
    }
}
