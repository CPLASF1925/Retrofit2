package www.mp5a5.com.retrofit2.nbamodule.presenter.imp;


import www.mp5a5.com.retrofit2.base.app.CommonActivity;
import www.mp5a5.com.retrofit2.base.mvp.presenter.BasePresenter;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;
import www.mp5a5.com.retrofit2.nbamodule.model.NBAModel;
import www.mp5a5.com.retrofit2.nbamodule.model.imp.NBAModelImp;
import www.mp5a5.com.retrofit2.nbamodule.presenter.NBAPresenter;
import www.mp5a5.com.retrofit2.nbamodule.view.view.NBAView;
import www.mp5a5.com.retrofit2.net.BaseResponseEntity;
import www.mp5a5.com.retrofit2.net.OnBaseResponseListener;
import www.mp5a5.com.retrofit2.utils.CollectionUtils;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public class NBAPresenterImp extends BasePresenter<NBAView, NBAModel> implements NBAPresenter {

  @Override
  public void requestNetworkData(CommonActivity activity, boolean flag) {

    if (flag) {
      v.resetIndex();
    } else {
      v.addIndex();
    }
    model.requestNetwork(activity, new OnBaseResponseListener() {
      @Override
      public void onSuccess(BaseResponseEntity response) {
        NBAInfo info = (NBAInfo) response;
        if (CollectionUtils.isNotEmpty(info.getResult().getTeammatch())) {

          if (flag) {
            v.setNewData(info.getResult().getTeammatch());
          } else {
            if (info.getResult().getTeammatch().size() > 0) {
              v.addNewData(info.getResult().getTeammatch());
            }
          }

          if (info.getResult().getTeammatch().size() <= 15) {
            //第一页如果不够一页就不显示没有更多数据布局
            v.loadMoreEnd(flag);
          } else {
            v.loadMoreComplete();
          }
        }
        if (flag) {
          v.enableLoadMore();
          v.unableRefreshing();
        }
      }
      @Override
      public void onError() {
        if (flag) {
          v.enableLoadMore();
          v.unableRefreshing();
        } else {
          v.loadMoreFail();
          v.subIndex();
        }
      }


      @Override
      public void onFailing(BaseResponseEntity response) {
        if (flag) {
          v.enableLoadMore();
          v.unableRefreshing();
        } else {
          v.loadMoreFail();
          v.subIndex();
        }
      }

    });
  }

  @Override
  protected NBAModel createModel() {
    return new NBAModelImp();
  }
}
