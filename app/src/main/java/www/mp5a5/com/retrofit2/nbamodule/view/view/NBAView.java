package www.mp5a5.com.retrofit2.nbamodule.view.view;


import java.util.List;

import www.mp5a5.com.retrofit2.base.mvp.view.view.BaseView;

/**
 * studio
 *
 * @author 王文彬
 * @date 2017/10/18
 */
public interface NBAView extends BaseView {

  /**
   * 吐司
   *
   * @param msg 内容
   */
  void showMessage(String msg);

  <E> void setNewData(List<E> list);

  <E> void addNewData(List<E> list);

  void loadMoreEnd(boolean isEnd);

  void loadMoreComplete();


  void enableLoadMore();

  void refreshing();

  void unableRefreshing();

  void loadMoreFail();

  void subIndex();

  void addIndex();

  void resetIndex();
}
