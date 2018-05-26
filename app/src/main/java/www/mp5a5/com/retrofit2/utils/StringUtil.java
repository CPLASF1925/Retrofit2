package www.mp5a5.com.retrofit2.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import com.cdel.lib.utils.StringUtil;

/**
 * 操作字符串
 */
public class StringUtil {

  /**
   * 判断字符串是否为图片文件
   *
   * @return true：不为空， false：为空
   */
  public static boolean isPhoto(String str) {
    if ("JPG".equals(str) || "JPEG".equals(str) || "jpg".equals(str) || "jpeg".equals(str) || "png".equals(str)) {
      return true;
    }
    return false;
  }

  /**
   * float类型加减法，防止精度丢失
   */
  public static float floatSubtract(String num1, String num2) {
    BigDecimal temp1 = new BigDecimal(num1);
    BigDecimal temp2 = new BigDecimal(num2);
    return temp2.subtract(temp1).floatValue();
  }

  /**
   * float类型加减法，防止精度丢失
   */
  public static float floatAdd(String num1, String num2) {
    BigDecimal temp1 = new BigDecimal(num1);
    BigDecimal temp2 = new BigDecimal(num2);
    return temp2.add(temp1).floatValue();
  }

  /**
   * 判断字符串是否为空
   *
   * @return true：不为空， false：为空
   */
  public static boolean isNotNull(String str) {
    if (str != null && !"".equals(str) && !"null".equals(str)) {
      return true;
    }
    return false;
  }

  /**
   * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
   *
   * @return boolean 若输入字符串为null或空字符串，返回true
   */
  public static boolean isEmpty(String input) {

    if (input == null || "".equals(input)) {
      return true;
    }
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
        return false;
      }
    }
    return true;
  }

  /**
   * 转换输入流为字符串
   *
   * @param is 指定要转换的输入流
   * @return String 字符串
   */
  public static String getInputStreamToString(InputStream is) {
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    StringBuffer buffer = new StringBuffer();
    String line = "";
    try {
      while ((line = in.readLine()) != null) {
        buffer.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return buffer.toString();
  }

  /**
   * 获取IP地址，即用IP替换域名地址
   */
  public static String getIPUrlByDomain(String url, String ip) {
    URL urls = null;
    String domain = "";
    try {
      urls = new URL(url);
      domain = urls.getHost();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    urls = null;
    if (isEmpty(domain) || isEmpty(ip)) {
      return "";
    }
    return url.replaceFirst(domain, ip);
  }

  /**
   * 获取域名
   */
  public static String getDomainByUrl(String url) {
    URL urls = null;
    try {
      urls = new URL(url);
      return urls.getHost();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * 检查是否是邮箱
   */
  public static boolean isEmail(String email) {
    if (email == null || email.trim().length() == 0) {
      return false;
    }
    Pattern pattern =
        Pattern.compile(
            "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))" +
                "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    return pattern.matcher(email).matches();
  }

  public static String trimmy(String str) {
    String dest = "";
    if (str != null) {
      str = str.replaceAll("-", "");
      str = str.replaceAll("\\+", "");
      dest = str;
    }
    return dest;
  }

  /**
   * 用逗号拼接字符串集合
   */
  public static String getStr(List<String> list) {

    if (list == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    for (String string : list) {
      sb.append(string);
      sb.append(",");
    }
    String deleteIds = sb.toString();
    if (deleteIds.endsWith(",")) {
      deleteIds = deleteIds.substring(0, deleteIds.length() - 1);
    }
    return deleteIds;
  }

  /**
   * 字符串数组转字符串，并用逗号分隔
   */
  public static String arrayToString(String[] strArray) {
    if (strArray == null || strArray.length == 0) {
      return "";
    }
    StringBuffer s = new StringBuffer();
    int len = strArray.length;
    for (int i = 0; i < len; i++) {
      s.append(strArray[i]);
      if (i >= 0 && i < len - 1) {
        s.append(',');
      }
    }
    return s.toString();
  }

  /**
   * 分割字符串
   *
   * @param str    String 原始字符串
   * @param splits String 分隔符
   * @return String[] 分割后的字符串数组
   */
  public static String[] split(String str, String splits) {
    int index;
    if (str == null || splits == null) {
      return null;
    }
    ArrayList<String> al = new ArrayList<>();
    while ((index = str.indexOf(splits)) != -1) {
      al.add(str.substring(0, index));
      str = str.substring(index + splits.length());
    }
    al.add(str);
    return (String[]) al.toArray(new String[0]);
  }

  /**
   * 校验用户名是否合法，规则4-20个字符（可以为字母、数字或下划线'_'，不能包含空格）
   *
   * @param name 用户名
   * @return true为合法
   */
  public static boolean checkName(String name) {
    Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]{4,20}$");
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }

  /**
   * 校验用户姓名是否为汉字，规则2-5个汉字
   *
   * @param name 要校验的姓名
   * @return true为合法
   */
  public static boolean checkNameIsChinese(String name) {
    Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]{2,5}");
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }
}
