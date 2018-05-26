package www.mp5a5.com.retrofit2.base.app;

import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import www.mp5a5.com.retrofit2.utils.AppContextUtils;
import www.mp5a5.com.retrofit2.utils.StatusBarUtils;
import www.mp5a5.com.retrofit2.utils.ViewManagerUtils;


/**
 * @author king9999
 * @describe： CommonActivity，定义了常见方法如：创建文件、初始化配置信息等；所有子类应该尽量继承这个类；
 * @email：wwb199055@126.com
 */
public class CommonActivity extends RxAppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initStatusBar();
    AppContextUtils.init(this);
    ViewManagerUtils.getInstance().addActivity(this);
    EventBus.getDefault().register(this);
  }

  /**
   * 初始化状态栏
   */
  protected void initStatusBar() {
    StatusBarUtils.setLightMode(this);
  }

  @Subscribe
  public void onEvent(String event){
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
    EventBus.getDefault().removeAllStickyEvents();
  }
}
