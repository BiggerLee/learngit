package com.tools.autoGeneratePOJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.util.StringUtils;

import com.tools.autoGeneratePOJO.AutoGenerateEnum.SQLSERVE_TYPE;

/**
 * Description: 根据建表语句自动生成POJO类
 */
public class AutoGeneratePOJO {
	
	//private final static List<String> SQLSERVE_TYPE = Arrays.asList("varchar","smallint","int","bigint","datetime");
	
	public static void main(String[] args) {
		if(args.length <= 0) {
			System.out.println("参数不能为null");
			return;
		}
		StringBuffer argsStrBuf = new StringBuffer();
		for(String arg : args){
			argsStrBuf.append(arg+" ");
		}
		
		String argsStr = argsStrBuf.toString();
		//1 解析POJO类名称
		String pojoClassName = getPOJOClassName(argsStr);
		//2 解析字段信息:字段名称,字段类型,属性名称,属性类型 
		// 2.1 获取第一个"("的位置
		int firstLeftBracket = argsStr.indexOf('(');
		// 2.2 获取和第一个"("匹配的")"的位置
		int firstRightBracket = getMarriedRightBracket(argsStr, firstLeftBracket);

		// 2.3 截取"("与")"之间的字符串,并根据","生成字符串数组
		if (firstRightBracket == -1 || firstRightBracket <= firstLeftBracket) {
			return;
		}
		
		String[] properties = argsStr.substring(firstLeftBracket+1, firstRightBracket).split(",");
		// 2.4 获取字段信息列表： 字段名称,字段类型,属性名称,属性类型 
		List<FieldInfo> fieldInfoList = getPOJOPropertyInfo(properties);
		//3 解析字段描述
		// 3.1只有“)”后有描述信息才解析
		if (firstRightBracket + 1 < argsStr.length()) {
			String[] fieldDesces = argsStr.substring(firstRightBracket + 1).split("go|GO");
			getFieldDesc(fieldDesces, fieldInfoList);
			//System.out.println(fieldInfoList);
		}
		
		//4 拼接POJO类
		StringBuffer autoPojo = new StringBuffer();
		// 4.1拼接类名
		autoPojo.append("public class " + pojoClassName + " {\r\n");
		// 4.2拼接属性
		concatProperties(fieldInfoList, autoPojo);
		// 4.3拼接方法
		concatSetGetMethods(fieldInfoList, autoPojo);
		autoPojo.append("\r\n}");
		System.out.println(autoPojo.toString());
	}

	/*
	 * 根据出现的第一个括号‘(’前的字符串，即表名，获取ClassName
	 */
	public static String getPOJOClassName(String argsStr) {
		String className = "";
		int nameEndIndex = argsStr.indexOf('(');
		String argsStrStart = argsStr.substring(0, nameEndIndex);//获取'('前的部分
		String[]  argsStrStartArray = argsStrStart.split(" ");
		//获取argsStrStartArray中最后一个不为empty的字符串即表名
		String tableName = getNotEmptyStr(argsStrStartArray);
		//将tableName中“_”分隔的字符串首字母大写
		String[] nameStrArray = tableName.split("_");
		for (String t : nameStrArray) {
			className += firstToUpperCase(t);
		}
		return className;
	}
	
	/*
	 * 获取字符串数组中，倒数第一个不为empty的字符串
	 */
	private static String getNotEmptyStr(String[] strArray) {
		if(strArray.length <= 0) {
			return "";
		}
		for (int i = strArray.length - 1; i > 0; i--) {
			if (!StringUtils.isEmpty(strArray[i])) {
				return strArray[i];
			}
		}
		return "";
	} 
	/*
	 * 首字母大写
	 */
	private static String firstToUpperCase(String str) {
		char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
	}
	/*
	 * 返回字段信息列表, 
	 * 根据"()"内的各“,”分隔
	 */
	public static List<FieldInfo> getPOJOPropertyInfo(String[] properties) {
		List<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>(); 
		// 循环处理每个声明的属性行,如果在属性行中找到了SQLServer类型则放入Map中
		for (int i = 0;i < properties.length; i++) {
			String property = properties[i];
			for (SQLSERVE_TYPE s: SQLSERVE_TYPE.values()) {
				//(1)属性行字符串是否包含SQLServer类型,并且不是以类型开头（只有类型声明，没有字段名称）
				if (property.indexOf(s.getSqlType()) > 0) {
					//(2)属性声明行中包含了SQLServer类型字符串，则获取此类型前的字段名称
					String[] sqlTypeStrArray = property.substring(0, property.indexOf(s.getSqlType())).split(" "); 
					String sqlTypeStr = getNotEmptyStr(sqlTypeStrArray);
					if(!StringUtils.isEmpty(sqlTypeStr)) {
						FieldInfo fieldInfo = new FieldInfo();
						
						//(3)将以“_”分隔的字段名称首字母大写（字段名称的首字母除外）
						String[] nameStrArray = sqlTypeStr.split("_");
						String sqlTypeStrUpCase = nameStrArray[0];
						for (int j = 1; j < nameStrArray.length; j++) {
							sqlTypeStrUpCase += firstToUpperCase(nameStrArray[j]);
						}
						//(4)将得到字段名称，字段类型，属性名称和对应的Java类型放入fieldInfo 
						fieldInfo.setFieldName(sqlTypeStr);
						fieldInfo.setFieldType(s.getSqlType());
						fieldInfo.setPropertyName(sqlTypeStrUpCase);
						fieldInfo.setPropertyType(s.getToJavaType());
						fieldInfoList.add(fieldInfo);
						break;
					}
				}
			}
		}
		
		return fieldInfoList;
	}
	/*
	 * 获取str中，和"("位置匹配的第一个“)”
	 */
	private static int getMarriedRightBracket(String str, int leftBracket) {
		int rightBrackerIndex= -1;
				 
		if('(' != str.charAt(leftBracket)) {//leftBracket的位置不是“(”
			return -1;
		}
		//存储"("")"的栈
		Stack<Character> bracketStack = new Stack<Character>();

		// 1 将第一个"("推入栈中
		bracketStack.push(str.charAt(leftBracket));
		char[] strChar = str.toCharArray();
		// 2 循环判断strChar,如果是"("则入栈，如果是")"则出栈，当栈空时，证明已找到匹配的")"
		for(int i = leftBracket + 1; i < strChar.length; i++) {
			if('(' == str.charAt(i)) {
				bracketStack.push(str.charAt(i));
			}
			if(')' == str.charAt(i)) {
				bracketStack.pop();
				if (bracketStack.isEmpty()) {
					rightBrackerIndex = i;
					break;
				}
			}
		}
		// 3 栈空，则说明找到与"("配对的")",否则未找到
		if (bracketStack.isEmpty()) {
			return rightBrackerIndex;
		} else {
			return -1;
		}
		
	}
	/*
	 * 返回字段描述信息,组装到fieldInfoList中
	 * go
execute sp_addextendedproperty 'MS_Description',   '主键id',   'SCHEMA', 'dbo', 'table', 't_ic_casebill_damage_types', 'column', 'id'
GO
execute sp_addextendedproperty 'MS_Description',   '受损名称',   'SCHEMA', 'dbo', 'table', 't_ic_casebill_damage_types', 'column', 'dm_type_name'

	 */
	public static void getFieldDesc(String[] fieldDesces, List<FieldInfo> fieldInfoList) {
		//循环处理每个GO语句
		for(int i = 0; i < fieldDesces.length; i++) {
			//按“,”分隔字段串
			String[] fieldDescSplit = fieldDesces[i].split(",");
			//判断GO语句的字段是否存在fieldInfoList中，如果存在，则将对应的字段描述存入fieldInfoList
			for(int j = 0; j < fieldInfoList.size(); j++) {
				//获取字段信息的字段名称,两边加''
				String fieldName = "'"+fieldInfoList.get(j).getFieldName() + "'";
				//判断当前字段名称与字段描述中的字段名称是否相同,（字段描述中的字段名称去除空格）
				String fieldNameInDesc = fieldDescSplit[fieldDescSplit.length-1].trim();
				if(fieldName.equals(fieldNameInDesc)) {
					//相同则，取字段描述存入fieldInfoList.get(j)中.下标为1的字符串为字段描述
					fieldInfoList.get(j).setFieldDesc(fieldDescSplit[1].replaceAll("'", ""));
					break;
				}
			}
		}
	}
	/*
	 * 拼接属性，类型及其描述
	 */
	public static void concatProperties(List<FieldInfo> fieldInfoList, StringBuffer autoPojo) {
		autoPojo.append("\r\n");
		for(int i = 0; i < fieldInfoList.size(); i++) {
			String fieldDesc = "";
			if(!StringUtils.isEmpty(fieldInfoList.get(i).getFieldDesc())) {
				fieldDesc = fieldInfoList.get(i).getFieldDesc();
			}
			autoPojo.append("	/**\r\n");
			autoPojo.append("	 *" + fieldDesc +"\r\n");
			autoPojo.append("	 */\r\n");
			autoPojo.append("	private " + fieldInfoList.get(i).getPropertyType()
							+ " "+ fieldInfoList.get(i).getPropertyName());
			autoPojo.append(";\r\n");
		}
	}
	/*
	 * 拼接get,set方法
	 */
	public static void concatSetGetMethods(List<FieldInfo> fieldInfoList, StringBuffer autoPojo) {
		autoPojo.append("\r\n");
		for(int i = 0; i < fieldInfoList.size(); i++) { 
			autoPojo.append("	public " + fieldInfoList.get(i).getPropertyType() + 
					" get" + firstToUpperCase(fieldInfoList.get(i).getPropertyName()) + "() {\r\n");
			autoPojo.append("		return " + fieldInfoList.get(i).getPropertyName()+";\r\n");
			autoPojo.append("	}\r\n");
			autoPojo.append("	public void set" + firstToUpperCase(fieldInfoList.get(i).getPropertyName())
					+ "(" + fieldInfoList.get(i).getPropertyType() + " " + fieldInfoList.get(i).getPropertyName() + ") {\r\n");
			autoPojo.append("		this." + fieldInfoList.get(i).getPropertyName() + " = "
					+ fieldInfoList.get(i).getPropertyName() + ";\r\n");
			autoPojo.append("	}\r\n");
		}
	}
}
