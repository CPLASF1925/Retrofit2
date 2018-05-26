package www.mp5a5.com.retrofit2.base.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import www.mp5a5.com.retrofit2.utils.AppContextUtils;


/**
 * @describe： CommonFragment定义了常见方法如：创建文件、初始化配置信息等；所有子类应该尽量继承这个类；
 * @email：wwb199055@126.com
 */
public class CommonFragment extends RxFragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    RxAppCompatActivity mContext = (RxAppCompatActivity) getActivity();
    AppContextUtils.init(mContext);
  }


}
