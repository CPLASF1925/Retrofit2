package www.mp5a5.com.retrofit2.nbamodule;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import www.mp5a5.com.retrofit2.net.BaseResponseEntity;

/**
 * 作者：王文彬 on 2018/2/3 18：01
 * 邮箱：wwb199055@126.com
 */

@Data
@Log
@EqualsAndHashCode(callSuper = false)
public class NBAInfo extends BaseResponseEntity {

  private String reason;
  private String error_code;
  private ResultInfo result;

  @Data
  public static class ResultInfo {
    private List<TeammatchInfo> teammatch;


    @Data
    public static class TeammatchInfo {
      private String name;
      private String url;
    }
  }

}
