package com.tools.autoGeneratePOJO;


/*
 * 枚举类
 * 注:将int放在smallint和bigint之后，否则map中包含数据{big=int}或{small=int}
 */
public class AutoGenerateEnum {
	
	public static enum SQLSERVE_TYPE {
		NVARCHAR("nvarchar", "String"),
		VARCHAR("varchar", "String"),
		SMALLINT("smallint", "Integer"),
		BIGINT("bigint", "Long"),
		TINYINT("tinyint", "Integer"),
		INT("int", "Integer"),
		DATETIME("datetime", "String"),
		DATE("date", "String");
		private String sqlType;
        private String toJavaType;
        
        SQLSERVE_TYPE(String sqlType, String toJavaType) {
        	this.setSqlType(sqlType);
        	this.setToJavaType(toJavaType);
        }

		public String getSqlType() {
			return sqlType;
		}

		public void setSqlType(String sqlType) {
			this.sqlType = sqlType;
		}

		public String getToJavaType() {
			return toJavaType;
		}

		public void setToJavaType(String toJavaType) {
			this.toJavaType = toJavaType;
		}
		public static String getJavaTypeBySqlType (String sqlType) { 
			for (SQLSERVE_TYPE c : SQLSERVE_TYPE.values()) {
	            if (c.getSqlType().equals(sqlType)) {
	                return c.toJavaType;
	            }
	        }
			return null;
		}
	}
}
