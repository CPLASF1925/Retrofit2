package www.mp5a5.com.retrofit2.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 作者：王文彬 on 2017/12/3 12：00
 * 邮箱：wwb199055@126.com
 *
 * 关闭相关工具类
 */
public class CloseUtils {

  private CloseUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * 关闭IO
   *
   * @param closeables closeable
   */
  public static void closeIO(Closeable... closeables) {
    if (closeables == null) return;
    for (Closeable closeable : closeables) {
      if (closeable != null) {
        try {
          closeable.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 安静关闭IO
   *
   * @param closeables closeable
   */
  public static void closeIOQuietly(Closeable... closeables) {
    if (closeables == null) return;
    for (Closeable closeable : closeables) {
      if (closeable != null) {
        try {
          closeable.close();
        } catch (IOException ignored) {
        }
      }
    }
  }
}
