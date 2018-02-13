package com.biyao.system.model;

public class SysDictionary {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 参数类型
     */
    private String cfgType;

    /**
     * 参数值
     */
    private String cfgValue;

    /**
     * 参数值编码
     */
    private String cfgValueId;

    /**
     * 父类型编号
     */
    private Integer parent;

    /**
     * 是否启用
     */
    private Integer enable;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 是否允许编辑
     */
    private Integer isEdit;

    /**
     * 所属系统
     */
    private String systemId;

    /**
     * 获取 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置   主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 参数类型
     */
    public String getCfgType() {
        return cfgType;
    }

    /**
     * 设置   参数类型
     */
    public void setCfgType(String cfgType) {
        this.cfgType = cfgType;
    }

    /**
     * 获取 参数值
     */
    public String getCfgValue() {
        return cfgValue;
    }

    /**
     * 设置   参数值
     */
    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue;
    }

    /**
     * 获取 参数值编码
     */
    public String getCfgValueId() {
        return cfgValueId;
    }

    /**
     * 设置   参数值编码
     */
    public void setCfgValueId(String cfgValueId) {
        this.cfgValueId = cfgValueId;
    }

    /**
     * 获取 父类型编号
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * 设置   父类型编号
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * 获取 是否启用
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置   是否启用
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * 获取 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置   优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取 是否允许编辑
     */
    public Integer getIsEdit() {
        return isEdit;
    }

    /**
     * 设置   是否允许编辑
     */
    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    /**
     * 获取 所属系统
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 设置   所属系统
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}