package com.employee.entity;

import java.io.Serializable;

/**
 * deliver
 * @author 
 */
public class Deliver implements Serializable {
    private Integer id;

    private Integer personalid;

    private Integer recruitmentid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonalid() {
        return personalid;
    }

    public void setPersonalid(Integer personalid) {
        this.personalid = personalid;
    }

    public Integer getRecruitmentid() {
        return recruitmentid;
    }

    public void setRecruitmentid(Integer recruitmentid) {
        this.recruitmentid = recruitmentid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Deliver other = (Deliver) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonalid() == null ? other.getPersonalid() == null : this.getPersonalid().equals(other.getPersonalid()))
            && (this.getRecruitmentid() == null ? other.getRecruitmentid() == null : this.getRecruitmentid().equals(other.getRecruitmentid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonalid() == null) ? 0 : getPersonalid().hashCode());
        result = prime * result + ((getRecruitmentid() == null) ? 0 : getRecruitmentid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personalid=").append(personalid);
        sb.append(", recruitmentid=").append(recruitmentid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}