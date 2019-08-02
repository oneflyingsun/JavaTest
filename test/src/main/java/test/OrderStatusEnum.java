package test;

/**
 * ━━━━━神兽 出没━━━━━
 *
 * @author zhaocong
 * @ - -┏━┓     ┏━┓
 * @ -┏━┛ ┻━━━━━┛ ┻━┓
 * @ -┃             ┃ ㊣NO BUG㊣
 * @ -┃     ━━━     ┃
 * @ -██████━━██████┫
 * @ -┃             ┃
 * @ -┃     ━┻━     ┃
 * @ -┃             ┃
 * @ -┗━━┓       ┏━━┛
 * @ - - ┃       ┃ Code is far away from bug with the animal protecting
 * @ - - ┃       ┃                神兽庇护,码无BUG
 * @ - - ┃       ┗━━━━━━┓
 * @ - - ┃              ┣━┓
 * @ - - ┃              ┏━┛
 * @ - - ┗━┓ ┓ ┏━━┳━┓ ┏━┛
 * @ - - - ┃━┫━┫  ┃━┫━┫
 * @ - - - ┗━┻━┛  ┗━┻━┛
 * @date 2019-04-16
 * @description:
 */
public enum OrderStatusEnum {
  WaitLogin("待登录"), Done("已完成"), WaitCharge("待充值");
  private String value;

  OrderStatusEnum(String value) {
    this.value = value;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
