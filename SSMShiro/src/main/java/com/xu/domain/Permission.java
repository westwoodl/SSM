package com.xu.domain;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.perid
     *
     * @mbggenerated
     */
    private Integer perid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.pername
     *
     * @mbggenerated
     */
    private String pername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.percode
     *
     * @mbggenerated
     */
    private String percode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.perid
     *
     * @return the value of permission.perid
     *
     * @mbggenerated
     */
    public Integer getPerid() {
        return perid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.perid
     *
     * @param perid the value for permission.perid
     *
     * @mbggenerated
     */
    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.pername
     *
     * @return the value of permission.pername
     *
     * @mbggenerated
     */
    public String getPername() {
        return pername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.pername
     *
     * @param pername the value for permission.pername
     *
     * @mbggenerated
     */
    public void setPername(String pername) {
        this.pername = pername == null ? null : pername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.percode
     *
     * @return the value of permission.percode
     *
     * @mbggenerated
     */
    public String getPercode() {
        return percode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.percode
     *
     * @param percode the value for permission.percode
     *
     * @mbggenerated
     */
    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
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
        Permission other = (Permission) that;
        return (this.getPerid() == null ? other.getPerid() == null : this.getPerid().equals(other.getPerid()))
            && (this.getPername() == null ? other.getPername() == null : this.getPername().equals(other.getPername()))
            && (this.getPercode() == null ? other.getPercode() == null : this.getPercode().equals(other.getPercode()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPerid() == null) ? 0 : getPerid().hashCode());
        result = prime * result + ((getPername() == null) ? 0 : getPername().hashCode());
        result = prime * result + ((getPercode() == null) ? 0 : getPercode().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", perid=").append(perid);
        sb.append(", pername=").append(pername);
        sb.append(", percode=").append(percode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}