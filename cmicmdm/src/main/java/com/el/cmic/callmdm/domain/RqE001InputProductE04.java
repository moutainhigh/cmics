package com.el.cmic.callmdm.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by king_ on 2016/9/22.
 */
@XmlRootElement(name = "main")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"doco","ev01","litm","productcode", "servicename","modcause"})
public class RqE001InputProductE04 {
    private String doco;
    private String ev01;
    private String litm;
    private String productcode = "";
    private String servicename = "";

    private String modcause = "";//变更原因 1025

    public String getModcause() {
        return modcause;
    }

    public void setModcause(String modcause) {
        this.modcause = modcause;
    }

    public String getLitm() {
        return litm;
    }

    public void setLitm(String litm) {
        this.litm = litm;
    }

    public String getDoco() {
        return doco;
    }

    public void setDoco(String doco) {
        this.doco = doco;
    }

    public String getEv01() {
        return ev01;
    }

    public void setEv01(String ev01) {
        this.ev01 = ev01;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @Override
    public String toString() {
        return "RqE001InputProductE04{" +
                "doco='" + doco + '\'' +
                ", ev01='" + ev01 + '\'' +
                ", litm='" + litm + '\'' +
                ", productcode='" + productcode + '\'' +
                ", servicename='" + servicename + '\'' +
                ", modcause='" + modcause + '\'' +
                '}';
    }
}
