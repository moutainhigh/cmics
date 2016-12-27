package com.el.cmic.mapper.revert;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.el.cmic.domain.revert.RevertDataDetail;

public interface RevertDataDetailMapper {
	
	
	@Insert("insert  into ${tableSchema}.FE8SPD15(QMUKID,QMRLLN,QMEV01,QMLNID,QME8YYQGD,QME8KSQGD,QME8YYYCD,QMLITM,QME8YYYCN,QME8SPDGG,"
			+ "QME8SCCS,QME8SPDCD,QME8SPDDW,QMLOT1,QMLOT2,QME8KCLX,QME8YXQ,QME8SCRQ,QME8SPDBZ,QMUORG,QME8RKLX) "
			+ "values (#{revertDataDetail.qmukid ,jdbcType=DECIMAL},#{revertDataDetail.qmrlln ,jdbcType=DECIMAL}*1000,"
			+ "NVL(#{revertDataDetail.qmev01 ,jdbcType=NCHAR}, 'N'),#{revertDataDetail.qmlnid ,jdbcType=NCHAR}*1000,"
			+ "#{revertDataDetail.qme8yyqgd ,jdbcType=NCHAR},#{revertDataDetail.qme8ksqgd ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qme8yyycd ,jdbcType=NCHAR},#{revertDataDetail.qmlitm ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qme8yyycn ,jdbcType=NCHAR},#{revertDataDetail.qme8spdgg ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qme8sccs ,jdbcType=NCHAR},#{revertDataDetail.qme8spdcd ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qme8spddw ,jdbcType=NCHAR},#{revertDataDetail.qmlot1 ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qmlot2 ,jdbcType=NCHAR},#{revertDataDetail.qme8kclx ,jdbcType=NCHAR},"
			+ "#{revertDataDetail.qme8yxq ,jdbcType=INTEGER},#{revertDataDetail.qme8scrq ,jdbcType=INTEGER},"
			+ "#{revertDataDetail.qme8spdbz ,jdbcType=DECIMAL},#{revertDataDetail.qmuorg ,jdbcType=DECIMAL}*10000,"
			+ "#{revertDataDetail.qme8rklx ,jdbcType=DECIMAL})")
	public Integer insertRevertDataDetail(@Param("revertDataDetail") RevertDataDetail revertDataDetail);

}
