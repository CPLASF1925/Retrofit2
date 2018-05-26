package www.mp5a5.com.retrofit2.base.mvp.presenter;

import java.lang.ref.WeakReference;

import www.mp5a5.com.retrofit2.base.mvp.model.BaseModel;
import www.mp5a5.com.retrofit2.base.mvp.view.view.BaseView;


/**
 * @author 王文彬
 * @date 2017/10/18
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

  protected M model;
  protected V v;
  protected WeakReference<V> weakReference;

  public BasePresenter() {
    model = createModel();
  }

  public void bind(V view) {
    this.v = view;
    weakReference = new WeakReference<V>(v);
  }

  public void unBind() {
    if (weakReference != null) {
      weakReference.clear();
      weakReference = null;
    }
  }

  public boolean isUnbind() {
    return weakReference != null && weakReference.get() != null;
  }

  public V getView() {
    if (weakReference != null) {
      return weakReference.get();
    }
    return null;
  }

  protected abstract M createModel();
}
