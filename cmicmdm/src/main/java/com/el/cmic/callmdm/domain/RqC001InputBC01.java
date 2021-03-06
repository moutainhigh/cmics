package com.el.cmic.callmdm.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by king_ on 2016/9/23.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"pk_lictype", "licno", "licfw","licfwt","licfws", "lictodate", "islong","def3"})
public class RqC001InputBC01 {
    private String pk_lictype = "";
    private String licno = "";
    private String licfw = "";
    private String licfwt = "";
    private String licfws= "";

    private String lictodate = "";
    private String islong = "";
    private String def3="";

    public String getLicfwt() {
        return licfwt;
    }

    public void setLicfwt(String licfwt) {
        this.licfwt = licfwt;
    }

    public String getLicfws() {
        return licfws;
    }

    public void setLicfws(String licfws) {
        this.licfws = licfws;
    }

    public String getPk_lictype() {
        return pk_lictype;
    }

    public void setPk_lictype(String pk_lictype) {
        this.pk_lictype = pk_lictype;
    }

    public String getLicno() {
        return licno;
    }

    public void setLicno(String licno) {
        this.licno = licno;
    }

    public String getLicfw() {
        return licfw;
    }

    public void setLicfw(String licfw) {
        this.licfw = licfw;
    }

    public String getLictodate() {
        return lictodate;
    }

    public void setLictodate(String lictodate) {
        this.lictodate = lictodate;
    }

    public String getIslong() {
        return islong;
    }

    public void setIslong(String islong) {
        this.islong = islong;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    @Override
    public String toString() {
        return "RqC001InputBC01{" +
                "pk_lictype='" + pk_lictype + '\'' +
                ", licno='" + licno + '\'' +
                ", licfw='" + licfw + '\'' +
                ", licfwt='" + licfwt + '\'' +
                ", licfws='" + licfws + '\'' +
                ", lictodate='" + lictodate + '\'' +
                ", islong='" + islong + '\'' +
                ", def3='" + def3 + '\'' +
                '}';
    }
}
