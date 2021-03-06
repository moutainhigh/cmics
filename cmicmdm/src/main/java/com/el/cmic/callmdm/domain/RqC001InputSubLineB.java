package com.el.cmic.callmdm.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by king_ on 2016/9/23.
 */
@XmlRootElement(name = "subline")
@XmlType(propOrder ={"subname","rqC001InputBC01List"})
public class RqC001InputSubLineB {
    private String subname;
    private List<RqC001InputBC01> rqC001InputBC01List;

    @XmlElement(name = "subname")
    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @XmlElement(name = "subcontent")
    public List<RqC001InputBC01> getRqC001InputBC01List() {
        return rqC001InputBC01List;
    }

    public void setRqC001InputBC01List(List<RqC001InputBC01> rqC001InputBC01List) {
        this.rqC001InputBC01List = rqC001InputBC01List;
    }

    @Override
    public String toString() {
        return "RqC001InputSubLineB{" +
                "subname='" + subname + '\'' +
                ", rqC001InputBC01List=" + rqC001InputBC01List +
                '}';
    }
}
