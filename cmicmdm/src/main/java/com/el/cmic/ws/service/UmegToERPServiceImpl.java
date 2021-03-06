package com.el.cmic.ws.service;

import com.el.cfg.domain.F0101;
import com.el.cfg.domain.F4101;
import com.el.cfg.domain.Fe80101;
import com.el.cfg.domain.Fe84101;
import com.el.cmic.ws.domain.PhE001OutHeader;
import com.el.cmic.ws.domain.PhE001OutHeaderCode;
import com.el.cmic.ws.mapper.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by king_ on 2016/10/22.
 */
@Service
public class UmegToERPServiceImpl implements UmegToERPService{
    Logger logger = Logger.getLogger(UmegToERPServiceImpl.class);
    @Value("${schema}")
    private String schema;
    @Autowired
    F4101SelectBy f4101SelectBy;
    @Autowired
    FE84101SelectAitm fe84101SelectAitm;
   /* @Autowired
    F4101UpdateByLitmMapper f4101UpdateByLitmMapper;*/
    @Autowired
    FE84101UpdateByLitmMapper fe84101UpdateByLitmMapper;
   /* @Autowired
    F0101SelectBy f0101SelectBy;*/
    @Autowired
    FE80101UpdateByPKMapper fe80101UpdateByPKMapper;
    @Autowired
    FE80101SelectAlky fe80101SelectAlky;
    @Autowired
    F0101UpdateByPKMapper f0101UpdateByPKMapper;

    @Transactional
    @Override
    public String UmegToERP(PhE001OutHeader phE001OutHeader) {
        logger.info("开始还原");
      /*  try {*/
            if (phE001OutHeader.getDatatype().equals("E01")
                    || phE001OutHeader.getDatatype().equals("E02")
                    || phE001OutHeader.getDatatype().equals("E03")
                    || phE001OutHeader.getDatatype().equals("E04")) {
                String codeform11 = "";
                List<String> listlitm = new ArrayList<>();
                List<String> list12 = new ArrayList<>();
                for (PhE001OutHeaderCode tmp : phE001OutHeader.getCodeinfo().getPhE001OutHeaderCodeList()) {

                    if (tmp.getCodetype().equals("11")) {
                        codeform11 = tmp.getCodevalue();
                        listlitm = fe84101SelectAitm.FE84101SelectTym(schema, tmp.getCodevalue());
                    }
                    if (tmp.getCodetype().equals("12")) {
                        list12.add(tmp.getCodevalue());
                    }
                }
                for (String a : listlitm) {
                    String newaitm = fe84101SelectAitm.FE84101Select(schema, a);
                    String[] str1 = newaitm.split(";");
                    if (str1.length >= 2) {
                        for (String b : list12) {
                            if (str1[str1.length - 1].equals(b)) {
                                Fe84101 fe84101 = new Fe84101();
                                fe84101.setSpe8sptym(str1[str1.length - 1]);

                                String changeAitm = "";
                                for (int i = 1; i <= str1.length - 2; i++) {
                                    changeAitm = changeAitm + ";" + str1[i];
                                }
                                if (changeAitm.equals("")) {
                                    changeAitm = " ";
                                }
                                //fe84101.setSpaitm(changeAitm);
                                fe84101.setSpe8str200(changeAitm);
                                fe84101.setSplitm(a);
                                //fe84101.setSpe8sptym(newaitm);
                                fe84101UpdateByLitmMapper.updateByLitmSelective(schema, fe84101, "UMEGE");
                            }
                        }
                    }
                }


            }
            if (phE001OutHeader.getDatatype().equals("C01")) {
                String codeform11 = "";
                List<String> listan8 = new ArrayList<>();
                List<String> list12 = new ArrayList<>();

                for (PhE001OutHeaderCode tmp : phE001OutHeader.getCodeinfo().getPhE001OutHeaderCodeList()) {
                    if (tmp.getCodetype().equals("11")) {
                        codeform11 = tmp.getCodevalue();
                        listan8 = fe80101SelectAlky.FE80101SelectTym(schema, tmp.getCodevalue());
                    }
                    if (tmp.getCodetype().equals("12")) {
                        list12.add(tmp.getCodevalue());
                    }
                }
                for (String a : listan8) {
                    BigDecimal bd = new BigDecimal(a);
                    String newalky = fe80101SelectAlky.FE80101Select(schema, bd);


                    String[] str1 = newalky.split(";");
                    Fe80101 fe80101 = new Fe80101();
                    if (str1.length >= 2) {
                        for (String b : list12) {
                            if (str1[str1.length - 1].equals(b)) {
                                fe80101.setKse8kstym(str1[str1.length - 1]);

                                String changeAlky = "";
                                for (int i = 1; i <= str1.length - 2; i++) {
                                    changeAlky = changeAlky + ";" + str1[i];
                                }
                                if (changeAlky.equals("")) {
                                    changeAlky = " ";
                                }
                                //fe80101.setKsalky(changeAlky);
                                fe80101.setKse8str200(changeAlky);
                                fe80101.setKsan8(bd);
                                //fe80101.setKse8kstym(newalky);
                                fe80101UpdateByPKMapper.updateByPrimaryKeySelective(schema, fe80101, "UMEGC");
                            }
                        }

                    }


                }


            }


     /*   }catch (Exception e){
            logger.error("------------------------------------------------------------------------------------------");
            logger.error("还原失败"+e.getMessage());
            logger.error("------------------------------------------------------------------------------------------");
        }*/

        return null;
    }
}
