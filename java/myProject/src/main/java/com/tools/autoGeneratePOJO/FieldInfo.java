package com.tools.autoGeneratePOJO;

/*
 * 字段信息类
 */
public class FieldInfo {
	/*
	 * 字段名称
	 */
	private String fieldName;
	/*
	 * 字段类型
	 */
	private String fieldType;
	/*
	 * 字段描述
	 */
	private String fieldDesc;
	/*
	 *字段对应的属性名称
	 */
	private String propertyName;
	/*
	 * 字段对应的属性类型
	 */
	private String propertyType;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldDesc() {
		return fieldDesc;
	}
	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public String toString() {
		return "‘"+"fieldName:" + this.getFieldName() + ",fieldType:"+ this.getFieldType() + 
				",fieldDesc:" + this.getFieldDesc() + ",propertyName:" + this.getPropertyName() + ",propertyType:" + this.getPropertyType()+"’";  
	}
}
