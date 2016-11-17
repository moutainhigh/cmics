package com.el.cmic.callmdm.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2016/9/20.
 */
@XmlRootElement(name = "subline")
@XmlType(propOrder ={"subname","rqE001InputBE01List"})
public class RqE001InputSublineB {
    private String subname;
    private List<RqE001InputBE01> rqE001InputBE01List=new ArrayList<RqE001InputBE01>();

    @XmlElement(name = "subname")
    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @XmlElement(name = "subcontent")
    public List<RqE001InputBE01> getRqE001InputBE01List() {
        return rqE001InputBE01List;
    }

    public void setRqE001InputBE01List(List<RqE001InputBE01> rqE001InputBE01List) {
        this.rqE001InputBE01List = rqE001InputBE01List;
    }

    @Override
    public String toString() {
        return "RqE001InputSublineB{" +
                "subname='" + subname + '\'' +
                ", rqE001InputBE01List=" + rqE001InputBE01List +
                '}';
    }
}
