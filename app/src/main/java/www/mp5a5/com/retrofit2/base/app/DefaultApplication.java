package www.mp5a5.com.retrofit2.base.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

import java.util.Map;

/**
 * @author ：王文彬 on 2018/5/26 11：15
 * @describe：
 * @email：wwb199055@126.com
 */
public class DefaultApplication extends CommonApplication{

  private static final String  HOST = "http://op.juhe.cn/";
  private static final String API_SERVER_URL = HOST + "onebox/basketball/";
  @Override
  public String setBaseUrl() {
    return API_SERVER_URL;
  }

  public static Map<String, String> headerMap;
  private static int mMainThreadId = -1;
  private static Thread mMainThread;
  private static Handler mMainThreadHandler;
  private static Looper mMainLooper;

  @Override
  public void onCreate() {
    super.onCreate();
    mMainThreadId = Process.myTid();
    mMainThread = Thread.currentThread();
    mMainThreadHandler = new Handler();
    mMainLooper = getMainLooper();
  }

  public static Map<String, String> getHeaderMap() {
    return headerMap;
  }

  public static int getMainThreadId() {
    return mMainThreadId;
  }

  public static Thread getMainThread() {
    return mMainThread;
  }

  public static Looper getMainThreadLooper() {
    return mMainLooper;
  }

  public static Handler getMainThreadHandler() {
    return mMainThreadHandler;
  }


  @Override
  public void onTerminate() {
    super.onTerminate();
  }

  @Override
  public void onTrimMemory(int level) {
    super.onTrimMemory(level);
  }
}
