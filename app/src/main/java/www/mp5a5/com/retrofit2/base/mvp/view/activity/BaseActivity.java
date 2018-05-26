package www.mp5a5.com.retrofit2.base.mvp.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import www.mp5a5.com.retrofit2.R;
import www.mp5a5.com.retrofit2.base.app.CommonActivity;

/**
 * 继承自CommonActivity，定义了常见方法如：创建文件、初始化数据库、初始化配置信息等；
 */
public abstract class BaseActivity extends CommonActivity {

  private BaseActivity thisActivity = null;

  private TextView rightBtnTv;
  private TextView midTitleTv;
  private TextView leftBtnTv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = View.inflate(this, initLayout(), null);
    setContentView(needHeader() ? getMergerView(view) : view);
    ButterKnife.bind(this);
    thisActivity = this;
    initParams();
    initView();
    initAdapter();
    initNet();
  }

  /**
   * @return 初始化布局
   */
  protected abstract @LayoutRes
  int initLayout();

  protected boolean needHeader() {
    return true;
  }

  protected void initParams() {
  }

  protected void initView() {
  }

  protected void initNet() {
  }

  protected void initAdapter() {
  }

  private View getMergerView(@NonNull View view) {
    View rootView = View.inflate(this, R.layout.title_bar, null);
    leftBtnTv = rootView.findViewById(R.id.tv_left_btn);
    rightBtnTv = rootView.findViewById(R.id.tv_right_btn);
    midTitleTv = rootView.findViewById(R.id.tv_mid_title);
    RelativeLayout baseContainerRl = rootView.findViewById(R.id.rl_base_container);
    leftBtnClickListener();
    baseContainerRl.addView(view);
    return rootView;
  }

  /**
   * 左边按钮点击事件
   */
  private void leftBtnClickListener() {
    leftBtnTv.setOnClickListener(v -> finish());
  }

  @Override
  public void setTitle(CharSequence title) {
    if (midTitleTv != null) {
      midTitleTv.setText(title);
    }
  }

  /**
   * 左边按钮是否显示
   */
  @Override
  public void setVisible(boolean visible) {
    if (null != leftBtnTv) {
      if (visible) {
        leftBtnTv.setVisibility(View.VISIBLE);
      } else {
        leftBtnTv.setVisibility(View.GONE);
      }
    }
  }

  /**
   * 右侧按钮是否显示
   */
  public void setRightTextViewVisible(boolean visible, String txt) {
    if (null != rightBtnTv) {
      if (visible) {
        rightBtnTv.setVisibility(View.VISIBLE);
        rightBtnTv.setText(txt);
      } else {
        rightBtnTv.setVisibility(View.GONE);
      }
    }
  }

  /**
   * 得到右边的按钮
   */
  public TextView getRightBtn() {
    if (null != rightBtnTv) {
      return rightBtnTv;
    }
    return null;
  }

  public TextView getLeftBtn() {
    if (null != leftBtnTv) {
      return leftBtnTv;
    }
    return null;
  }


  public BaseActivity getThisActivity() {
    return thisActivity;
  }

  public String getThisActivityName() {
    return thisActivity.getClass().getName();
  }

  public void gotoActivity(Class<?> clazz) {
    thisActivity.startActivity(new Intent(thisActivity, clazz));
  }

  public void gotoActivity(
      @NonNull Class<?> clazz, @NonNull Bundle bundle, boolean isFinish) {
    Intent intent = new Intent();
    intent.putExtras(bundle);
    thisActivity.startActivity(intent);
    if (isFinish) {
      thisActivity.finish();
    }
  }

  @Override
  public void onTrimMemory(int level) {
    super.onTrimMemory(level);
  }

  @Override
  public boolean isFinishing() {
    return super.isFinishing();
  }

  @SuppressLint("NewApi")
  @Override
  public boolean isDestroyed() {
    return super.isDestroyed();
  }

}
