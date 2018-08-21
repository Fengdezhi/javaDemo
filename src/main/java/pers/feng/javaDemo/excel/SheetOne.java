/**   
 * Copyright © 2018 重庆普天永惠大数据科技有限公司. All rights reserved.
 * 
 * @Package: pers.feng.javaDemo.excel 
 * @author: fengdezhi   
 * @date: 2018年8月20日 上午10:15:44 
 */
package pers.feng.javaDemo.excel;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/** 
 * @ClassName: SheetOne 
 * @Description: TODO
 * @author: fengdezhi
 * @date: 2018年8月20日 上午10:15:44  
 */
public class SheetOne implements Serializable{
	private static final long serialVersionUID = -2424895163938081944L;
	
	private String 病人号;
	private String 姓名;
	private String 性别;
	private String 年龄;
	private String 科室;
	private String 检验者;
	private String 病区;
	private String 样本类型;
	private String 临床诊断;
	private String 培养_TX_TX1;
	private String xpert阴阳性;
	private String xpert_RIF;
	private String 快速药敏RIF;
	private String 快速药敏INH;
	
	/**
	 * 暂未使用
	 */
	private String 罗氏药敏RIF;
	
	/**
	 * 暂未使用
	 */
	private String 罗氏药敏INH;
	
	/**
	 * 判断数据是否有效 
	 * @return boolean
	 * @author fengdezhi
	 * @date 2018年8月20日下午12:20:01
	 */
	public boolean isEffective() {
		if (StringUtils.isNotEmpty(培养_TX_TX1)
				&& StringUtils.isNotEmpty(xpert阴阳性)
				&& StringUtils.isNotEmpty(xpert_RIF)
				&& StringUtils.isNotEmpty(快速药敏RIF)
				&& StringUtils.isNotEmpty(快速药敏INH)
				) {
			return true;
		}
		return false;
	}
	
	public String get病人号() {
		return 病人号;
	}
	public void set病人号(String 病人号) {
		this.病人号 = 病人号;
	}
	public String get姓名() {
		return 姓名;
	}
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	public String get性别() {
		return 性别;
	}
	public void set性别(String 性别) {
		this.性别 = 性别;
	}
	public String get年龄() {
		return 年龄;
	}
	public void set年龄(String 年龄) {
		this.年龄 = 年龄;
	}
	public String get科室() {
		return 科室;
	}
	public void set科室(String 科室) {
		this.科室 = 科室;
	}
	public String get检验者() {
		return 检验者;
	}
	public void set检验者(String 检验者) {
		this.检验者 = 检验者;
	}
	public String get病区() {
		return 病区;
	}
	public void set病区(String 病区) {
		this.病区 = 病区;
	}
	public String get样本类型() {
		return 样本类型;
	}
	public void set样本类型(String 样本类型) {
		this.样本类型 = 样本类型;
	}
	public String get临床诊断() {
		return 临床诊断;
	}
	public void set临床诊断(String 临床诊断) {
		this.临床诊断 = 临床诊断;
	}
	public String get培养_TX_TX1() {
		return 培养_TX_TX1;
	}
	public void set培养_TX_TX1(String 培养_TX_TX1) {
		this.培养_TX_TX1 = 培养_TX_TX1;
	}
	public String getXpert阴阳性() {
		return xpert阴阳性;
	}
	public void setXpert阴阳性(String xpert阴阳性) {
		this.xpert阴阳性 = xpert阴阳性;
	}
	public String getXpert_RIF() {
		return xpert_RIF;
	}
	public void setXpert_RIF(String xpert_RIF) {
		this.xpert_RIF = xpert_RIF;
	}
	public String get快速药敏RIF() {
		return 快速药敏RIF;
	}
	public void set快速药敏RIF(String 快速药敏rif) {
		快速药敏RIF = 快速药敏rif;
	}
	public String get快速药敏INH() {
		return 快速药敏INH;
	}
	public void set快速药敏INH(String 快速药敏inh) {
		快速药敏INH = 快速药敏inh;
	}
	public String get罗氏药敏RIF() {
		return 罗氏药敏RIF;
	}
	public void set罗氏药敏RIF(String 罗氏药敏rif) {
		罗氏药敏RIF = 罗氏药敏rif;
	}
	public String get罗氏药敏INH() {
		return 罗氏药敏INH;
	}
	public void set罗氏药敏INH(String 罗氏药敏inh) {
		罗氏药敏INH = 罗氏药敏inh;
	}
	
	
}
