package com.el.cmic.ws.service;

import com.el.cmic.ws.domain.PhE001OutHeader;
import com.el.cmic.ws.domain.PhE001OutsublineA;
import com.el.cmic.ws.domain.PhE001OutsublineB;
import com.el.cmic.ws.domain.PhE002OutMain;

/**
 * Created by king_ on 2016/9/30.
 */
public interface AddE02ToERPService {
    public String updateF4101(PhE001OutHeader phE001OutHeader, PhE002OutMain phE002OutMain,String no);
    public String updateFE84101(PhE001OutHeader phE001OutHeader,PhE002OutMain phE002OutMain,PhE001OutsublineB phE001OutsublineB,String no);
    public String updateFE84101Z(PhE002OutMain phE002OutMain, PhE001OutsublineB phE001OutsublineB, String no,String co);
    public String addE02ToERP(PhE001OutHeader phE001OutHeader,PhE002OutMain phE002OutMain,PhE001OutsublineB phE001OutsublineB,String no,String co);

   // public String updateF00165(PhE001OutsublineA phE001OutsublineA,PhE002OutMain phE002OutMain,PhE001OutsublineB phE001OutsublineB);
}
