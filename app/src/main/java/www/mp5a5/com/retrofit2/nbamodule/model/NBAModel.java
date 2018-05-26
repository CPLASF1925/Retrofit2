package www.mp5a5.com.retrofit2.nbamodule.model;


import www.mp5a5.com.retrofit2.base.app.CommonActivity;
import www.mp5a5.com.retrofit2.base.mvp.model.BaseModel;
import www.mp5a5.com.retrofit2.net.OnBaseResponseListener;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public interface NBAModel extends BaseModel {
  void requestNetwork(CommonActivity activity, OnBaseResponseListener listener);

}
