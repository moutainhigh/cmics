package com.el.cmic.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by king_ on 2016/9/21.
 */
@XmlRootElement(name = "main")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhC001OutMain {
    private String custcode;
    private String custname;
    private String pk_country;
    private String pk_szq;
    private String pk_cities;
    private String pk_counties;
    private String address;
    private String gycode;
    private String isscs;
    private String isjxs;
    private String isjks;
    private String isyy;
    private String isjcyljg;
    private String isgr;
    private String isqt;

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getPk_country() {
        return pk_country;
    }

    public void setPk_country(String pk_country) {
        this.pk_country = pk_country;
    }

    public String getPk_szq() {
        return pk_szq;
    }

    public void setPk_szq(String pk_szq) {
        this.pk_szq = pk_szq;
    }

    public String getPk_cities() {
        return pk_cities;
    }

    public void setPk_cities(String pk_cities) {
        this.pk_cities = pk_cities;
    }

    public String getPk_counties() {
        return pk_counties;
    }

    public void setPk_counties(String pk_counties) {
        this.pk_counties = pk_counties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGycode() {
        return gycode;
    }

    public void setGycode(String gycode) {
        this.gycode = gycode;
    }

    public String getIsscs() {
        return isscs;
    }

    public void setIsscs(String isscs) {
        this.isscs = isscs;
    }

    public String getIsjxs() {
        return isjxs;
    }

    public void setIsjxs(String isjxs) {
        this.isjxs = isjxs;
    }

    public String getIsjks() {
        return isjks;
    }

    public void setIsjks(String isjks) {
        this.isjks = isjks;
    }

    public String getIsyy() {
        return isyy;
    }

    public void setIsyy(String isyy) {
        this.isyy = isyy;
    }

    public String getIsjcyljg() {
        return isjcyljg;
    }

    public void setIsjcyljg(String isjcyljg) {
        this.isjcyljg = isjcyljg;
    }

    public String getIsgr() {
        return isgr;
    }

    public void setIsgr(String isgr) {
        this.isgr = isgr;
    }

    public String getIsqt() {
        return isqt;
    }

    public void setIsqt(String isqt) {
        this.isqt = isqt;
    }

    @Override
    public String toString() {
        return "PhC001OutMain{" +
                "custcode='" + custcode + '\'' +
                ", custname='" + custname + '\'' +
                ", pk_country='" + pk_country + '\'' +
                ", pk_szq='" + pk_szq + '\'' +
                ", pk_cities='" + pk_cities + '\'' +
                ", pk_counties='" + pk_counties + '\'' +
                ", address='" + address + '\'' +
                ", gycode='" + gycode + '\'' +
                ", isscs='" + isscs + '\'' +
                ", isjxs='" + isjxs + '\'' +
                ", isjks='" + isjks + '\'' +
                ", isyy='" + isyy + '\'' +
                ", isjcyljg='" + isjcyljg + '\'' +
                ", isgr='" + isgr + '\'' +
                ", isqt='" + isqt + '\'' +
                '}';
    }
}
