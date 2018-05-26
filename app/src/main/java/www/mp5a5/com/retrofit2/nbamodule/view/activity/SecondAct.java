package www.mp5a5.com.retrofit2.nbamodule.view.activity;

import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import www.mp5a5.com.retrofit2.R;
import www.mp5a5.com.retrofit2.base.mvp.view.activity.BaseActivity;
import www.mp5a5.com.retrofit2.net.EventBusMessage;

/**
 * @author ：king9999 on 2018/5/26 14：19
 * @describe：
 * @email：wwb199055@126.com
 */
public class SecondAct extends BaseActivity {
  @BindView(R.id.tv_second)
  TextView tvSecond;

  @Override
  protected int initLayout() {
    return R.layout.activity_second;
  }

  @Subscribe(sticky = true, threadMode = ThreadMode.MAIN_ORDERED)
  public void getMsg(EventBusMessage msg) {
    if ("refresh".equals(msg.getTag())) {
      tvSecond.setText(msg.getTag());
    }
  }

}
