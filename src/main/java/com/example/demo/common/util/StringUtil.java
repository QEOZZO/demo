package com.example.demo.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description： 字符串处理工具类
**/
public class StringUtil {
	/**
	* <p>方法名称: IgnoreCaseReplace|描述: 忽略大小写替换</p>
	* @param str
	* @param oldString
	* @param newString
	* @return
	*/
	public static String IgnoreCaseReplace(String str, String oldString, String newString){
		Pattern p = Pattern.compile(oldString, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		String ret=m.replaceAll(newString);
		return ret; 
	}

	/**
	 * @Description: html转义
	 * @param s
	 * @return java.lang.String
	**/
	public static String escapeHtml(String s){
		s = IgnoreCaseReplace(s,"<","&lt;");
		s = IgnoreCaseReplace(s,">","&gt;");
		s = IgnoreCaseReplace(s,"\"","&#34;");
		return s;
	}

	/**
	 * @Description: 文本转化为html展示
	 * @param s
	 * @return java.lang.String
	**/
	public static String textToHtml(String s){
		if(s == null || s.isEmpty()){
			s = "";
		}else{
			s = s.replaceAll(" ","&nbsp;");
			s = s.replaceAll("\n","<br />");
		}
		return s;
	}

	/**
	 * @Description: 判断字符串是否为null或者空
	 * @param s
	 * @return boolean
	**/
	public static boolean isNullOrEmpty(String s){
		if(null == s || s.isEmpty())return true;
		return false;
	}

	/**
	 * @Description: 判断List是否为null或元素个数为0
	 * @param list
	 * @return boolean
	**/
	public static boolean isNullOrEmpty(List<?> list){
		if(null == list || list.size()==0)return true;
		return false;
	}
	/**
	* <p>方法名称: arrayToList|描述: 数组转化为list</p>
	* @param array
	* @return
	*/
	public static <T> List<T> arrayToList(T[] array){
		List<T> list=new ArrayList<T>();
		if(null != array){
			for(int i=0;i<array.length;i++){
				list.add(array[i]);
			}
		}
		return list;
	}
	
	/**
	 * @Description: 数组转化为以指定分隔符分隔的字符串
	 * @param array 数组
	 * @param separator 分隔符
	 * @return java.lang.String
	**/
	public static String arrayToString(String[] array, String separator){
		if(array != null){
			StringBuilder sb=new StringBuilder("");
			for (int i = 0; i < array.length; i++) {
				if(i !=0 )sb.append(separator);
				sb.append(array[i]);
			}
			return sb.toString();
		}else{
			return "";
		}
	}
	/**
	 * @Description: 指定分隔符分隔的字符串转化为数组</p>
	 * @param str  字符串
	 * @param separator 指定分隔符
	 * @return java.lang.String[]  返回的数组
	 */
	public static String[] stringToArray(String str,String separator){
		if(!StringUtil.isNullOrEmpty(str)){
			return str.split(separator);
		}else{
			return null;
		}
	}

	/**
	 * @Description: 将小数转化为百分数
	 * @param num 要转化的数字
	 * @param digits 保留小数位个数
	 * @return java.lang.String
	**/
	public static String numToPercent(Object num, int digits){
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setMinimumFractionDigits(digits);
		return nt.format(num);
	}
	
	/**
	 * @Description: 如果是null则转化为空
	 * @param s
	 * @return java.lang.String
	**/
	public static String nullToEmpty(String s) {
		if (s == null)	return "";
		else			return s;
	}

	/**
	 * @Description: 如果是null则转化为空
	 * @param o
	 * @return java.lang.String
	**/
	public static String nullToEmpty(Object o) {
		if (o == null)	return "";
		else			return o.toString();
	}

	/**日期转化为指定格式的字符串
	 * @param date 要转化的日期(应是一个有效的date)
	 * @param format 格式字符串，yyyy-MM-dd HH:mm:ss.SSS（详见SimpleDateFormat类）
	 * @return
	 */
	public static String dateToString(Object date, String format){
		if(date == null || date.equals("")) return "";
		else{
			try{
				return new SimpleDateFormat(format, Locale.CHINA).format((Date)date);
			}catch(Exception e){
				return date.toString();
			}
		}
	}
	
	/**
	* <p>方法名称: stringToDate|描述: 字符串转化为日期</p>
	* @param str 要转化的字符串
	* @param format 格式字符串，yyyy-MM-dd HH:mm:ss.SSS（详见SimpleDateFormat类）
	* @return 转化失败返回null
	*/
	public static Date stringToDate(String str, String format){
		if(str == null || str.equals("")) return null;
		else{
			try{
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.setLenient(false);
				return sdf.parse(str);
			}catch(Exception e){
				return null;
			}
		}
	}

	/**如超过指定长度则截取并返回指定长度的字符串
	 * @param str 要处理的源字符串
	 * @param maxLen 长度
	 * @param flag 超长后是否在截取末尾添加省略号
	 * @return
	 */
	public static String subStr(String str, int maxLen, boolean flag){
		if(str==null || str.trim().equals(""))return "";
		else{
			String s="";
			if(str.length()>maxLen){
				if(flag)
					s=str.substring(0,maxLen-1)+"...";
				else
					s=str.substring(0,maxLen);
			}
			else s=str;
			return s;
		}
	}
	/**
	* <p>方法名称: subKeyString|描述: 截取指定关键字部分</p>
	* @param str 源字符串
	* @param key 关键字
	* @param maxLen 长度
	* @param flag 超长后是否在截取末尾添加省略号
	* @return
	*/
	public static String subKeyString(String str, String key, int maxLen, boolean flag){
		if(str==null || str.trim().equals(""))return "";
		else{
			String s="";
			if(str.length() > maxLen){
				int k_index=str.indexOf(key);
				if(k_index>-1){//内容中存在key
					if(key.length()>maxLen){
						if(flag)
							s=key.substring(0,maxLen-1)+"...";
						else
							s=key.substring(0,maxLen);
					}else{
						int start=k_index-((maxLen-key.length())/2);
						if(start<0)start=0;
						if(flag)
							s=str.substring(start,maxLen-1)+"...";
						else
							s=str.substring(start,maxLen);
					}
				}else{
					if(flag)
						s=str.substring(0,maxLen-1)+"...";
					else
						s=str.substring(0,maxLen);
				}
			}else{
				s=str;
			}
			return s;
		}
	}

	/**
	 * @Description: 尝试将字符串转化为整型
	 * @param s 要转化的字符串
	 * @param defaultValue 转化失败的默认值
	 * @return int
	**/
	public static int tryToInt(String s, int defaultValue){
		int r=defaultValue;
		try{
			r= Integer.parseInt(s);
		}catch(Exception e){
			r=defaultValue;
		}
		return r;
	}
	/**
	 * @Description: 尝试将对象转化为整型
	 * @param obj 要转化的对象
	 * @param defaultValue 转化失败的默认值
	 * @return int
	**/
	public static int tryToInt(Object obj, int defaultValue){
		return tryToInt(nullToEmpty(obj), defaultValue);
	}

	/**
	 * @Description: 尝试将字符串转化为Long型
	 * @param s 要转化的字符串
	 * @param defaultValue 转化失败的默认值
	 * @return java.lang.Long
	**/
	public static Long tryToLong(String s, Long defaultValue){
		Long r = defaultValue;
		try{
			r = Long.parseLong(s);
		}catch(Exception e){
			r = defaultValue;
		}
		return r;
	}

	/**
	 * @Description: 尝试将字符串转化为double型
	 * @param s 要转化的字符串
	 * @param defaultValue 转化失败的默认值
	 * @return double
	**/
	public static double tryToDouble(String s, double defaultValue){
		double r = defaultValue;
		try{
			r = Double.parseDouble(s);
		}catch(Exception e){
			r = defaultValue;
		}
		return r;
	}

	/**
	 * @Description: ISO编码转化为GBK编码
	 * @param isoStr
	 * @return java.lang.String
	**/
	public static String isoToGbk(String isoStr) {
        return changeCharset(isoStr,"ISO-8859-1","GBK");
	}
	/**
	 * @Description: ISO编码转化为UTF-8编码
	 * @param isoStr
	 * @return java.lang.String
	**/
	public static String isoToUtf8(String isoStr) {
        return changeCharset(isoStr,"ISO-8859-1","UTF-8");
	}
	/**
	 * @Description: GB2312编码转化为UTF-8编码
	 * @param gb2312Str
	 * @return java.lang.String
	**/
	public static String gb2312ToUtf8(String gb2312Str) {
		return changeCharset(gb2312Str,"GB2312","UTF-8");
	}
	/**
	 * @Description: 转换字符串的编码
	 * @param str 要处理的字符串
	 * @param sourceCharset 原编码
	 * @param targetCharset 新编码
	 * @return java.lang.String
	**/
    public static String changeCharset(String str,String sourceCharset,String targetCharset) {
        String result = null;
        if (isNullOrEmpty(str)) {
            result = str;
        } else {
            try {
                result = new String(str.getBytes(sourceCharset), targetCharset);
            } catch (UnsupportedEncodingException e) {
                System.out.println("StringUtil.changeCharset exception:"+e.getMessage());
                result=str;
            }
        }
        return result;
    }

	/**
	 * @Description: MD5加密
	 * @param s 要加密的字符串
	 * @return java.lang.String 加密后的字符串（32位全大写模式）
	**/
	public static String encodeToMD5(String s){
		s = nullToEmpty(s);
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] bR=md.digest();
			for(int i=0;i<bR.length;i++){
				
			}
			return byte2hex(bR).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * @Description: 二进制数组转化为16进制字符串
	 * @param b
	 * @return java.lang.String
	**/
	public static String byte2hex(byte[] b){
		String hs="";
		String stmp="";
		for (int n=0; n<b.length; n++){
			stmp=(Integer.toHexString(b[n] & 0xFF));
			if (stmp.length()==1) hs=hs+"0"+stmp;
				else hs=hs+stmp;
		}
		return hs;
	}

	/**
	 * @Description: 生成指定位数的随机字符串（由小写字母、大写字母、数字组成）
	 * @param len 长度
	 * @return java.lang.String
	**/
	public static String getRandomString(int len){
		SecureRandom secureRandom = SecureRandomUtil.getSecureRandom();
		String s = "";
		for (int i=0;i<len;i++) {
			int rType = secureRandom.nextInt(3);
			int rChar=48;
			if(rType == 0){
				rChar = secureRandom.nextInt(10) + 48;
			}else if(rType == 1){
				rChar = secureRandom.nextInt(26) + 65;
			}else{//rType=2
				rChar = secureRandom.nextInt(26) + 97;
			}
			char ctmp = (char)rChar;
			s += String.valueOf(ctmp);
		}
		return s;
	}

	/**
	 * @Description: 生成指定位数的随机字符串（由小写字母、大写字母、数字组成）
	 * @param len 长度
	 * @param sExclude 要排除的字符（多个字符以字符串形式传入）
	 * @return java.lang.String
	**/
	public static String getRandomString(int len,String sExclude){
		String s = "";
		SecureRandom secureRandom = SecureRandomUtil.getSecureRandom();
		for (int i=0;i<len;i++) {
			int rChar=48;
			if(i > 1){
				rChar = secureRandom.nextInt(10) + 48;
			}else if(i==1){
				rChar = secureRandom.nextInt(26) + 97;
			}else if(i==0){
				rChar = secureRandom.nextInt(26) + 65;
			}
			char ctmp = (char)rChar;
			if(sExclude.indexOf(ctmp) > -1){
				i--;
			}else{
				s += String.valueOf(ctmp);
			}
		}
		return s;
	}
	/**
	 * @Description: 生成指定长度的由数字组成的随机字符串
	 * @param len 长度
	 * @return java.lang.String
	**/
	public static String getRandomNumberString(int len){
		String s = "";
		SecureRandom secureRandom = SecureRandomUtil.getSecureRandom();
		for (int i=0;i<len;i++) {
			s += String.valueOf(secureRandom.nextInt(10));
		}
		return s;
	}

	/**
	* <p>方法名称: getDiffDays|描述: 计算天数差</p>
	* @param d1 减数
	* @param d2 被减数
	* @return
	*/
	public static long getDiffDays(Date d1, Date d2){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 12);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 12);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MILLISECOND, 0);
		
		return (c1.getTimeInMillis() - c2.getTimeInMillis())/1000/60/60/24;
	}
	/**
	* <p>方法名称: getDiffSeconds|描述: 计算秒数差</p>
	* @param d1 减数
	* @param d2 被减数
	* @return
	*/
	public static long getDiffSeconds(Date d1, Date d2){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		
		return (c1.getTimeInMillis() - c2.getTimeInMillis())/1000;
	}
	

	/** 预定义sql注入字符*/
	private static String[] sqlFilter={" update "," delete "," insert "," drop "," create "," alter "};
	/**
	* <p>方法名称: sqlIsSafe|描述: sql语句是否包含危险关键字</p>
	* @param sql
	* @return
	*/
	public static boolean isSqlSafe(String sql){
		for (String s : sqlFilter) {
			if(sql.indexOf(s) != -1){
				return false;
			}
		}
		return true;
	}

	public static boolean contains(String[] array,String str){
	    if(null == array || array.length == 0){
	        return false;
        }
	    for(String s:array){
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }
}