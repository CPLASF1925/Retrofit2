package www.mp5a5.com.retrofit2.net.interceptor;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.logging.HttpLoggingInterceptor;
import www.mp5a5.com.retrofit2.utils.LogUtils;

/**
 * @author ：王文彬 on 2018/5/23 13：24
 * @describe：
 * @email：wwb199055@126.com
 */
public class LoggingInterceptor {

  public static HttpLoggingInterceptor getLoggingInterceptor() {
    //日志拦截器
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
      try {
        String text = URLDecoder.decode(message, "utf-8");
        LogUtils.e("OKHttp-----", text);
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        LogUtils.e("OKHttp-----", message);
      }
    });

    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    return interceptor;
  }

}
