package www.mp5a5.com.retrofit2.nbamodule.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import www.mp5a5.com.retrofit2.nbamodule.NBAInfo;

/**
 * @author ：king9999 on 2018/5/26 12：09
 * @describe：
 * @email：wwb199055@126.com
 */
public interface NBAApis {

  @POST("nba")
  Observable<NBAInfo> getNBAList(@QueryMap Map<String, Object> maps);
}
