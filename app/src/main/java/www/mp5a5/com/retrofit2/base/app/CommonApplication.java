package www.mp5a5.com.retrofit2.base.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import www.mp5a5.com.retrofit2.BuildConfig;
import www.mp5a5.com.retrofit2.net.ApiConfig;
import www.mp5a5.com.retrofit2.utils.AppContextUtils;


/**
 * @author ：王文彬 on 2018/5/22 14：35
 * @describe： CommonApplication，APP启动时候做的操作，AndroidManifest中的Application的类都应该以此类为父类
 * @email：wwb199055@126.com
 */
public abstract class CommonApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();
    AppContextUtils.init(this);
    //CrashHandler.getInstance().init(this);
    ApiConfig.getInstance().setServerUrl(setBaseUrl());

    if (BuildConfig.DEBUG) {
      if (LeakCanary.isInAnalyzerProcess(this)) {
        return;
      }
      LeakCanary.install(this);
    }
  }


  /**
   * 在子类初始化application的时候，必须重写该防范然后获取到BaseUrl
   *
   * @return 返回app的BaseUrl
   */
  public abstract String setBaseUrl();
}
