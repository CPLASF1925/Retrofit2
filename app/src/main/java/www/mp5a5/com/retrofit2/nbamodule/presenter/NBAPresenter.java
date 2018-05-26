package www.mp5a5.com.retrofit2.nbamodule.presenter;


import www.mp5a5.com.retrofit2.base.app.CommonActivity;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public interface NBAPresenter {

  void requestNetworkData(CommonActivity activity, boolean isRefresh);
}
