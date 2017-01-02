package com.el.cmic.ws.service;

import com.el.cfg.domain.*;
import com.el.cmic.ws.domain.*;
import com.el.cmic.ws.mapper.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by king_ on 2016/10/8.
 */
@Service
public class AddE03ToERPServiceImpl implements AddE03ToERPService {
    Logger logger = Logger.getLogger(AddE03ToERPServiceImpl.class);
    @Autowired
    F4101UpdateByLitmMapper f4101UpdateByLitmMapper;
    @Autowired
    FE84101UpdateByLitmMapper fe84101UpdateByLitmMapper;
    @Autowired
    F4104UpdateByLitmMapper f4104UpdateByLitmMapper;
    @Autowired
    F0005Mapper f0005Mapper;
    @Autowired
    F0005DMapper f0005DMapper;
    @Autowired
    FE80101SelectAn8ByNameMapper fe80101SelectAn8ByNameMapper;
    @Autowired
    FE84101ZSelectByE8ZZBM fe84101ZSelectByE8ZZBM;
    @Autowired
    FE84101ZUpdateByPKMapper fe84101ZUpdateByPKMapper;
    @Autowired
    FE841001UpdateByDocoMapper fe841001UpdateByDocoMapper;

    @Value("${schema}")
    private String schema;
    @Value("${ctlSchema}")
    private String dbtype;
    @Transactional
    public String addE03ToERP(PhE001OutHeader phE001OutHeader, PhE003OutMain phE003OutMain, PhE001OutsublineB phE001OutsublineB, String no,String co) {
    //    try {
            updateF4101(phE001OutHeader, phE003OutMain, no);
            updateF4104(phE001OutHeader, phE003OutMain, no);
            updateFE84101(phE001OutHeader, phE003OutMain, phE001OutsublineB, no);
            updateFE84101Z(phE003OutMain, phE001OutsublineB, no, co);
            if(phE001OutHeader.getFunctype().equals("ADD")){
                updateFE84101YON(no);
                updateFe841001flag(no);

            }
    //    if(phE001OutHeader.getFunctype().equals("MOD")){
            updateFE84101bgbs(no);
     //   }
     /*   }catch (Exception e){
            logger.error("----------------------------------------------------------------------------------------------------");
            logger.error("E03更新失败"+e.getMessage());
            logger.error("----------------------------------------------------------------------------------------------------");
        }*/
        return null;
    }

    @Transactional
    public String updateFE84101Z(PhE003OutMain phE003OutMain, PhE001OutsublineB phE001OutsublineB, String no,String co) {
        logger.info("E03开始更新FE84101Z");
        Fe84101z fe84101Z = new Fe84101z();
        if(phE001OutsublineB.getPhE001OutBE01List()!=null) {
            for (PhE001OutBE01 tmp : phE001OutsublineB.getPhE001OutBE01List()) {
                //     fe84101Z.setZze8zzlxa(tmp.getPk_licensetype());
                fe84101Z.setZze8zzlxa(f0005Mapper.selectF0005(dbtype, "E8", "28", tmp.getPk_licensetype()));
                fe84101Z.setZze8zzbm(tmp.getLicenseno());
                fe84101Z.setZzlitm(no);
                fe84101Z.setZzco(co);

                String dj = tmp.getTodate();

                if (fe84101ZSelectByE8ZZBM.Fe84101zselect(schema,fe84101Z) >= 1) {
                    //fe84101ZUpdateByPKMapper.updateByPrimaryKeySelective(schema, fe84101Z, "E01", dj);
                }
                if (fe84101ZSelectByE8ZZBM.Fe84101zselect(schema,fe84101Z)== 0) {
                    fe84101ZUpdateByPKMapper.insertSelective(schema, fe84101Z, dj);
                }
            }
        }
        logger.info("成功");
        return null;
    }

    @Transactional
    public String updateF4101(PhE001OutHeader phE001OutHeader, PhE003OutMain phE003OutMain,String no) {
        logger.info("E03开始更新F4101");
        F4101 f4101 = new F4101();
       /* String TemporaryCode="";
        String  FormalCode="";*/
        List<PhE001OutHeaderCode> phE001OutHeaderCodes = phE001OutHeader.getCodeinfo().getPhE001OutHeaderCodeList();
        /*for(PhE001OutHeaderCode tmp :phE001OutHeaderCodes){
            if(tmp.getCodetype().equals("0")){
                TemporaryCode = tmp.getCodevalue();
            }
            if(tmp.getCodetype().equals("1")){
                FormalCode = tmp.getCodevalue();
            }
        }*/

        //f4101.setImaitm(FormalCode);
        f4101.setImlitm(no);
        //------------------------------------f4101.setImdsc2(phE003OutMain.getProducttype());
        //f4101.setImOrig();
        f4101.setImdsc1(phE003OutMain.getSync());
   //     f4101.setImsrp3(phE003OutMain.getPk_productclass());
    //    f4101.setImsrp3(f0005Mapper.selectF0005(dbtype,"E8","14",phE003OutMain.getPk_productclass()));
   //     f4101.setImsrp4(phE003OutMain.getPk_yltsfl());
  //      f4101.setImsrp4(f0005Mapper.selectF0005(dbtype,"E8","15",phE003OutMain.getPk_yltsfl()));

        f4101UpdateByLitmMapper.updateByLitmSelective(schema,f4101,"E03");
        logger.info("成功");
        return null;
    }
    @Transactional
    public String updateFE84101(PhE001OutHeader phE001OutHeader, PhE003OutMain phE003OutMain,PhE001OutsublineB phE001OutsublineB,String no) {
        logger.info("E03开始更新FE84101");
        Fe84101 fe84101 = new Fe84101();
        String TemporaryCode="";
        String  FormalCode="";
        List<PhE001OutHeaderCode> phE001OutHeaderCodes = phE001OutHeader.getCodeinfo().getPhE001OutHeaderCodeList();
        for(PhE001OutHeaderCode tmp :phE001OutHeaderCodes){
            if(tmp.getCodetype().equals("1")){
                fe84101.setSpev01("Y");
            }
        }
        if(fe84101.getSpev01().equals(null)){
            fe84101.setSpev01("N");
        }
        for(PhE001OutHeaderCode tmp :phE001OutHeaderCodes){
            if(tmp.getCodetype().equals("0")){
                TemporaryCode = tmp.getCodevalue();
            }
            if(tmp.getCodetype().equals("1")){
                FormalCode = tmp.getCodevalue();
            }
        }
        fe84101.setSpe8sptym(FormalCode);
        fe84101.setSplitm(no);
        fe84101.setSpe8name(phE003OutMain.getProductname());
//        BigDecimal bd = new BigDecimal(phE003OutMain.getMfname());
        BigDecimal bigDecimal = new BigDecimal(fe80101SelectAn8ByNameMapper.FE80101Select(schema,phE003OutMain.getMfname()));
        fe84101.setSpan8(bigDecimal);
        fe84101.setSpe8cpdl(f0005Mapper.selectF0005(dbtype,"E8","14",phE003OutMain.getPk_productclass()));
        fe84101.setSpe8tsfl(f0005Mapper.selectF0005(dbtype,"E8","15",phE003OutMain.getPk_yltsfl()));
    //    fe84101.setSpe8jhg(phE003OutMain.getPk_jhg());
        fe84101.setSpe8jhg(f0005Mapper.selectF0005(dbtype,"E8","21",phE003OutMain.getPk_jhg()));
    //    fe84101.setSpe8ztw(phE003OutMain.getPk_ztw());
        fe84101.setSpe8ztw(f0005Mapper.selectF0005(dbtype,"E8","32",phE003OutMain.getPk_ztw()));
        fe84101.setSpe8dsc2(phE003OutMain.getProducttype());
        fe84101.setSporig(phE003OutMain.getPk_mfcountry());
     //   fe84101.setSporig(f0005Mapper.selectF0005(dbtype,"E8","17",phE003OutMain.getPk_mfcountry()));


        if(phE001OutsublineB.getPhE001OutBE01List()!=null) {
            for (PhE001OutBE01 tmp : phE001OutsublineB.getPhE001OutBE01List()) {
                //fe84101.setSpe8fxdj(tmp.getFxdj());
                //  String a = f0005Mapper.selectF0005(dbtype,"E8","19",tmp.getFxdj());
                fe84101.setSpe8fxdj(f0005Mapper.selectF0005(dbtype, "E8", "18", tmp.getFxdj()));
                //  fe84101.setSpe8cctj(tmp.getCctj());
                fe84101.setSpe8cctj(f0005Mapper.selectF0005(dbtype, "E8", "19", tmp.getCctj()));
                fe84101.setSpe8qtcc(tmp.getQtcctj());

                fe84101.setSpe8cpfl(tmp.getPk_productclass());
                //  fe84101.setSpe8jgg(tmp.getPk_jgg());
                fe84101.setSpe8jgg(f0005Mapper.selectF0005(dbtype, "E8", "35", tmp.getPk_jgg()));

            }
        }
        fe84101UpdateByLitmMapper.updateByLitmSelective(schema,fe84101,"E03");

        logger.info("成功");

        return null;
    }
    @Transactional
    public String updateF4104(PhE001OutHeader phE001OutHeader, PhE003OutMain phE003OutMain,String no) {
        logger.info("E03开始更新F4104");
        F4104 f4104 =new F4104();
        f4104.setIvcitm(phE003OutMain.getInterbarcode());
        f4104.setIvxrt("IC");
        f4104.setIvlitm(no);
        f4104UpdateByLitmMapper.updateByPrimaryKeySelective(schema,f4104);
        logger.info("成功");
        return null;
    }
    @Transactional
    public String updateFE84101YON(String no){
        Fe84101 fe84101 = new Fe84101();
        fe84101.setSplitm(no);
        fe84101.setSpflag("S");
        fe84101UpdateByLitmMapper.updateByLitmSelective(schema,fe84101,"S");
        return null;
    }

    @Transactional
    public String updateFE84101bgbs(String no){
        Fe84101 fe84101 = new Fe84101();
        fe84101.setSplitm(no);
        //fe84101.setSpev02("N");
        fe84101.setSpe8bgbs("N");
        fe84101UpdateByLitmMapper.updateByLitmSelective(schema,fe84101,"N");
        return null;
    }

    @Transactional
    public String updateFe841001flag(String no){
        Fe841001 fe841001 = new Fe841001();
        fe841001.setSqlitm(no);
        fe841001.setSqflag("S");
        fe841001UpdateByDocoMapper.updatebylitm(schema,fe841001);
        return null;
    }
}

