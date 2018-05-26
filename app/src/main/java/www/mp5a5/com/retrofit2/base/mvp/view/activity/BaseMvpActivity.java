package www.mp5a5.com.retrofit2.base.mvp.view.activity;


import www.mp5a5.com.retrofit2.base.mvp.presenter.BasePresenter;
import www.mp5a5.com.retrofit2.base.mvp.view.view.BaseView;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public abstract class BaseMvpActivity<P extends BasePresenter, V extends BaseView>
    extends BaseActivity {

  protected P presenter;

  @Override
  protected void initView() {
    super.initView();
    presenter = getBasePresenter();
    presenter.bind((V) this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.bind((V) this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.unBind();
  }

  protected abstract P getBasePresenter();
}
