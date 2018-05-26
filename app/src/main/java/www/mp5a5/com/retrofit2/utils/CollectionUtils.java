package www.mp5a5.com.retrofit2.utils;

import java.util.List;

/**
 * 作者：王文彬 on 2018/2/3 12：23
 * 邮箱：wwb199055@126.com
 */

public class CollectionUtils {

  public static boolean isEmpty(List<?> list) {
    return list != null && list.size() == 0;
  }

  public static boolean isNull(List<?> list) {
    return list == null;
  }

  public static boolean isNotEmpty(List<?> list) {
    return list != null && list.size() > 0;
  }

}
