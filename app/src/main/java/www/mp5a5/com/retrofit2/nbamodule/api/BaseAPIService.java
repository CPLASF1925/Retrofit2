package www.mp5a5.com.retrofit2.nbamodule.api;

import java.util.HashMap;
import java.util.Map;

import www.mp5a5.com.retrofit2.utils.StringUtil;

/**
 * @author ：king9999 on 2018/5/26 12：01
 * @describe：
 * @email：wwb199055@126.com
 */
public class BaseAPIService {
  /**
   * 公共参数初始化的地方
   */
  protected Map<String, Object> getPublicParams() {
    Map<String, Object> map = new HashMap<>();
/*    map.put("time", "");
    map.put("platformSource", "");
    map.put("time", "");
    map.put("version", "");*/
    return map;
  }

  /**
   * 累加参数的接口
   */
  protected Map<String, Object> putParams(Map<String, Object> map, String key, String value) {
    if (StringUtil.isNotNull(value)) {
      map.put(key, value);
    }
    return map;
  }
}
