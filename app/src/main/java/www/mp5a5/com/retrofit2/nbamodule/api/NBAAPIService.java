package www.mp5a5.com.retrofit2.nbamodule.api;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import www.mp5a5.com.retrofit2.net.RetrofitFactory;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;

/**
 * @author ：king9999 on 2018/5/26 12：00
 * @describe：
 * @email：wwb199055@126.com
 */
public class NBAAPIService extends BaseAPIService {

  private final NBAApis mBaseApis;

  private NBAAPIService() {
    mBaseApis = RetrofitFactory.getInstance().create(NBAApis.class);
  }

  private static class APIServiceHolder {
    private static final NBAAPIService INSTANCE = new NBAAPIService();
  }

  public static final NBAAPIService getInstance() {
    return APIServiceHolder.INSTANCE;
  }


  public Observable<NBAInfo> getNbaTest() {

    Map<String, Object> params = new HashMap<>();
    putParams(params, "dtype", "");
    putParams(params, "key", "6949e822e6844ae6453fca0cf83379d3");
    return mBaseApis.getNBAList(params);
  }
}
