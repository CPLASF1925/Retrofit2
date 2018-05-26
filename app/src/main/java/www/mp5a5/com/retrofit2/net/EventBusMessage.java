package www.mp5a5.com.retrofit2.net;

/**
 * @author ：王文彬 on 2018/5/23 12：33
 * @describe：EventBus传递内容的封装 <p>eg:EventBus.getDefault().post(new EventBusMsg<T>(tat,T));<p/>
 * @email：wwb199055@126.com
 */
public class EventBusMessage<T> {

  private T event;

  private String tag;

  /**
   * @param tag 传入的Tag值，可以根据tag区分不同EventBus传过来的值
   */
  public EventBusMessage(String tag) {
    this.tag = tag;
  }

  /**
   * @param event 传入的具体内容
   */
  public EventBusMessage(T event) {
    this.event = event;
  }

  public EventBusMessage(String tag, T event) {
    this.tag = tag;
    this.event = event;
  }


  public String getTag() {
    return tag;
  }

  public T getData() {
    return event;
  }


  @Override
  public String toString() {
    return "MessageEvent{" +
        "event=" + event +
        ", tag='" + tag + '\'' +
        '}';
  }
}
