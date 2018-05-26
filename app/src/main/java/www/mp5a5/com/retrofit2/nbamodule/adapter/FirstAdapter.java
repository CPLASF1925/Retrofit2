package www.mp5a5.com.retrofit2.nbamodule.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import www.mp5a5.com.retrofit2.R;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;


/**
 * 作者：王文彬 on 2018/2/3 11：25
 * 邮箱：wwb199055@126.com
 */

public class FirstAdapter extends BaseQuickAdapter<NBAInfo.ResultInfo.TeammatchInfo, BaseViewHolder> {

  public FirstAdapter() {
    super(R.layout.item_fist_test, null);
  }

  @Override
  protected void convert(BaseViewHolder helper, NBAInfo.ResultInfo.TeammatchInfo bean) {
    helper.setText(R.id.tv_who, bean.getName());
  }
}
