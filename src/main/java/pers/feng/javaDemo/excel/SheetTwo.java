/**   
 * Copyright © 2018 重庆普天永惠大数据科技有限公司. All rights reserved.
 * 
 * @Package: pers.feng.javaDemo.excel 
 * @author: fengdezhi   
 * @date: 2018年8月20日 上午10:22:22 
 */
package pers.feng.javaDemo.excel;

import java.io.Serializable;

/** 
 * @ClassName: SheetTwo 
 * @Description: TODO
 * @author: fengdezhi
 * @date: 2018年8月20日 上午10:22:22  
 */
public class SheetTwo implements Serializable{
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										
	private static final long serialVersionUID = 6749541952141435160L;
	
	private String 病人号;
	private String 姓名;
	private String 性别;
	private String 年龄;
	private String 科室;
	private String 检验者;
	private String 病区;
	private String 样本类型;
	private String 临床诊断;
	private String 诊断源;
	private String 项目英文缩写;
	private String 项目值;
	/** 
	 * @Title:SheetTwo
	 * @Description:TODO 
	 */  
	public SheetTwo(String 病人号, String 姓名, String 性别, String 年龄, String 科室, String 检验者, String 病区, String 样本类型,
			String 临床诊断, String 诊断源, String 项目英文缩写, String 项目值) {
		super();
		this.病人号 = 病人号;
		this.姓名 = 姓名;
		this.性别 = 性别;
		this.年龄 = 年龄;
		this.科室 = 科室;
		this.检验者 = 检验者;
		this.病区 = 病区;
		this.样本类型 = 样本类型;
		this.临床诊断 = 临床诊断;
		this.诊断源 = 诊断源;
		this.项目英文缩写 = 项目英文缩写;
		this.项目值 = 项目值;
	}
	/** 
	 * @Title:SheetTwo
	 * @Description:TODO  
	 */  
	public SheetTwo() {
		super();
		// TODO Auto-generated constructor stub
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
	public String get诊断源() {
		return 诊断源;
	}
	public void set诊断源(String 诊断源) {
		this.诊断源 = 诊断源;
	}
	public String get项目英文缩写() {
		return 项目英文缩写;
	}
	public void set项目英文缩写(String 项目英文缩写) {
		this.项目英文缩写 = 项目英文缩写;
	}
	public String get项目值() {
		return 项目值;
	}
	public void set项目值(String 项目值) {
		this.项目值 = 项目值;
	}	
	
	
}
