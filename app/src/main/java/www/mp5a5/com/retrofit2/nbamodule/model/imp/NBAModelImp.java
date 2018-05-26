package www.mp5a5.com.retrofit2.nbamodule.model.imp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import www.mp5a5.com.retrofit2.base.app.CommonActivity;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;
import www.mp5a5.com.retrofit2.nbamodule.api.NBAAPIService;
import www.mp5a5.com.retrofit2.nbamodule.model.NBAModel;
import www.mp5a5.com.retrofit2.net.BaseObserver;
import www.mp5a5.com.retrofit2.net.OnBaseResponseListener;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public class NBAModelImp implements NBAModel {

  @Override
  public void requestNetwork(CommonActivity activity, final OnBaseResponseListener listener) {


    NBAAPIService.getInstance()
        .getNbaTest()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(activity.bindToLifecycle())
        .subscribe(new BaseObserver<NBAInfo>(activity) {
          @Override
          public void onSuccess(NBAInfo response) {
            listener.onSuccess(response);
          }

          @Override
          public void onError(Throwable e) {
            super.onError(e);
            listener.onError();
          }

          @Override
          public void onFailing(NBAInfo response) {
            super.onFailing(response);
            listener.onFailing(response);
          }
        });

  }
}
