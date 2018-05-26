package www.mp5a5.com.retrofit2.nbamodule.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import www.mp5a5.com.retrofit2.R;
import www.mp5a5.com.retrofit2.base.mvp.view.activity.BaseMvpActivity;
import www.mp5a5.com.retrofit2.customview.ActRecycleViewDivider;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;
import www.mp5a5.com.retrofit2.nbamodule.adapter.FirstAdapter;
import www.mp5a5.com.retrofit2.nbamodule.presenter.imp.NBAPresenterImp;
import www.mp5a5.com.retrofit2.nbamodule.view.view.NBAView;
import www.mp5a5.com.retrofit2.net.EventBusMessage;
import www.mp5a5.com.retrofit2.utils.AppContextUtils;
import www.mp5a5.com.retrofit2.utils.ToastUtils;

/**
 * Practice_Rxjava_Retrofit-master
 *
 * @author 王文彬
 * @date 2017/12/28
 */


public class FirstActivity extends BaseMvpActivity<NBAPresenterImp, NBAView> implements SwipeRefreshLayout
    .OnRefreshListener, BaseQuickAdapter
    .RequestLoadMoreListener, NBAView, BaseQuickAdapter.OnItemClickListener {


  @BindView(R.id.rv_recycler_view)
  RecyclerView recyclerViewRv;
  @BindView(R.id.srl_refresh_view)
  SwipeRefreshLayout refreshViewSrl;
  private FirstAdapter mAdapter;

  @Override
  protected int initLayout() {
    return R.layout.activity_main;
  }

  @Override
  protected boolean needHeader() {
    return super.needHeader();
  }

  @Override
  protected void initView() {
    super.initView();
    setTitle("首页");
    recyclerViewRv.setLayoutManager(new LinearLayoutManager(this));
    recyclerViewRv.addItemDecoration(new ActRecycleViewDivider(this, LinearLayoutManager.VERTICAL));
    refreshViewSrl.setOnRefreshListener(this);
  }

  @Override
  protected NBAPresenterImp getBasePresenter() {
    return new NBAPresenterImp();
  }

  @Override
  protected void initAdapter() {
    super.initAdapter();
    mAdapter = new FirstAdapter();
    recyclerViewRv.setAdapter(mAdapter);
    mAdapter.setOnLoadMoreListener(this, recyclerViewRv);
    mAdapter.setOnItemClickListener(this);
  }

  @Override
  protected void initNet() {
    super.initNet();
    presenter.requestNetworkData(AppContextUtils.getActivity(), true);
  }


  @Override
  public void onLoadMoreRequested() {
    presenter.requestNetworkData(AppContextUtils.getActivity(), false);
  }

  @Override
  public void showMessage(String msg) {
    ToastUtils.show(msg);
  }

  @Override
  public <E> void setNewData(List<E> list) {
    mAdapter.setNewData((List<NBAInfo.ResultInfo.TeammatchInfo>) list);
  }

  @Override
  public <E> void addNewData(List<E> list) {
    mAdapter.addData((List<NBAInfo.ResultInfo.TeammatchInfo>) list);
  }

  @Override
  public void loadMoreEnd(boolean isEnd) {
    mAdapter.loadMoreEnd(isEnd);
  }

  @Override
  public void loadMoreComplete() {
    mAdapter.loadMoreComplete();
  }

  @Override
  public void enableLoadMore() {
    mAdapter.setEnableLoadMore(true);
  }

  @Override
  public void refreshing() {
    refreshViewSrl.setRefreshing(true);
  }

  @Override
  public void unableRefreshing() {
    refreshViewSrl.setRefreshing(false);
  }

  @Override
  public void loadMoreFail() {
    mAdapter.loadMoreFail();
  }

  @Override
  public void subIndex() {

  }

  @Override
  public void addIndex() {

  }

  @Override
  public void resetIndex() {

  }


  @Override
  public void onRefresh() {
    presenter.requestNetworkData(AppContextUtils.getActivity(), true);
  }

  @Override
  public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
    EventBus.getDefault().postSticky(new EventBusMessage<>("refresh"));
    gotoActivity(SecondAct.class);
  }
}