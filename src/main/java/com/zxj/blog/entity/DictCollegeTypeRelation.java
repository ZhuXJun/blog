package com.zxj.blog.entity;

public class DictCollegeTypeRelation {
    /**
     * 
     */
    private Integer id;

    /**
     * dict_college_type.id
     */
    private Integer typeid;

    /**
     * dict_college_new.id
     */
    private Integer collegeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}