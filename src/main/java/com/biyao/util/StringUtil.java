package com.biyao.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 将一个字符串拆分成Integer集合
	 * 
	 * @param str
	 */
	public static List<Integer> getIntegerListByStr(String str) {
		List<Integer> result = new ArrayList<Integer>();
		String[] strs = str.split(",");
		for (String st : strs) {
			if (!st.equals("")) {
				result.add(Integer.parseInt(st));
			}
		}
		return result;
		
	}
	/**
	 * 将一个字符串拆分成long数组
	 * 
	 * @param str
	 */
	public static List<Long> getLongListByStr(String str) {
		List<Long> result = new ArrayList<Long>();
		String[] strs = str.split(",");
		for (String st : strs) {
			if (!st.equals("")) {
				result.add(Long.parseLong(st));
			}
		}
		return result;

	}
	
	/**
	 * 将一个字符串拆分成long数组
	 * 
	 * @param str
	 */
	public static List<String> getStringListByStr(String str) {
		List<String> result = new ArrayList<String>();
		String[] strs = str.split(",");
		for (String st : strs) {
			if (!st.equals("")) {
				result.add(st);
			}
		}
		return result;

	}
    /**
     * 将数字对象格式化为2位有效小数的BigDecimal对象
     */
	public static BigDecimal fomatBigDecimal( Object b) {
		if (b == null)
			return null;
		if (b.toString().equals(""))
			return null;
		return new BigDecimal(b.toString()).setScale(2,BigDecimal.ROUND_HALF_UP);

	}
	
	public static void main(String[] parm){
		BigDecimal bb=new BigDecimal("271623.255");
		float f=Float.parseFloat("271623.255");

	}

	/**
	 * 将一个字符串拆分成long数组
	 */
	public static Long[] getLongArrByStr(String str) {
		Long[] result = new Long[str.split(",").length];
		String[] strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			result[i] = Long.parseLong(strs[i]);
		}
		return result;

	}

	/**
	 * 将一个long数组合并为字符串
	 */
	public static String getStrByLongList(Long[] list) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			strb.append(list[i].toString());
			if (i < list.length - 1) {
				strb.append(",");
			}
		}
		return strb.toString();

	}

	/**
	 * 将一个long数组合并为字符串
	 */
	public static String getStrByLongArr(List<Long> list) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			strb.append(list.get(i).toString());
			if (i < list.size() - 1) {
				strb.append(",");
			}
		}
		return strb.toString();

	}

	/**
	 * 将一个long数组合并为字符串
	 */
	public static String getStrByStrArr(List<String> list) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			strb.append(list.get(i).toString());
			if (i < list.size() - 1) {
				strb.append(",");
			}
		}
		return strb.toString();

	}

	/**
	 * 将字符的首字母转换为大写
	 * 
	 * @param str
	 *            <a href="http://my.oschina.net/u/556800" class="referer"
	 *            target="_blank">@return</a>
	 */
	public static String firstLetterToUpper(String str) {
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}

	/**
	 * 清除字符串中的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 判断字符串是否为null或空字符串
	 * 
	 * @param str
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.trim().equals(""))
			return true;
		return false;

	}

	/**
	 * 删除字符串尾部某个字符
	 * 
	 * @param source
	 * @return
	 */
	public static String removeTail(String source, String tag) {
		// 如果字符串尾部不为0，返回字符串
		if (!source.substring(source.length() - 1).equals(tag)) {
			return source;
		} else {
			// 否则将字符串尾部删除一位再进行递归
			return removeTail(source.substring(0, source.length() - 1), tag);
		}
	}

	/**
	 * 数字金额大写转换，先写个完整的然后将如零拾替换成零
	 * 
	 * 要用到正则表达式
	 * 
	 * 
	 */

	public static String digitUppercase(double n) {		
		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };
		String head = n < 0 ? "负" : "";
		n = Math.abs(n);
		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i])
					.replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(n);
		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i]+ s;
		}
		return head+ s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");

	}

	/**
	 * list相减
	 * @param
	 * @return
	 */
	public static List<String> listCut(List<String> listD, List<String> listx) {
		for (String s : listx) {
			if (listD.contains(s))
				listD.remove(s);

		}
		return listD;

	}

}
