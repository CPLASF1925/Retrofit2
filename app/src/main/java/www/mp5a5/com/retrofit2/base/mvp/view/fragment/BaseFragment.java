package www.mp5a5.com.retrofit2.base.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.mp5a5.com.retrofit2.base.app.CommonFragment;
import www.mp5a5.com.retrofit2.utils.ToastUtils;


/**
 * 作者：王文彬 on 2017/12/3 13：44
 * 邮箱：wwb199055@126.com
 */

public abstract class BaseFragment extends CommonFragment {

  public View rootView;
  public LayoutInflater inflater;


  @Nullable
  @Override
  public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    this.inflater = inflater;
    if (rootView == null) {
      rootView = inflater.inflate(this.getLayoutId(), container, false);
      init(savedInstanceState);
    }
    ViewGroup parent = (ViewGroup) rootView.getParent();
    if (parent != null) {
      parent.removeView(rootView);
    }
    return rootView;
  }

  protected abstract int getLayoutId();

  protected abstract void init(Bundle savedInstanceState);

  protected void showToast(String msg) {
    ToastUtils.show(msg);
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
  }


  @Override
  public void onDestroyView() {
    super.onDestroyView();
  }

}
