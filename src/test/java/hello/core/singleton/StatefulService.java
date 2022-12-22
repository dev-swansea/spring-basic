package hello.core.singleton;

public class StatefulService {

  //! 이 공유필드를 유지시킬 필요가 없다.
  // private int price; 상태 유지 필드

  /* public void order(String name, int price) {
    System.out.println("name = " + name + " / price = " + price);
    this.price = price; // 이게 문제
  } */

  // return price를 여기서 해줌
  // price가 지역변수가 된다.
  public int order(String name, int price) {
    System.out.println("name = " + name + " / price = " + price);
    return price; // 이게 문제
  }
  // public int getPrice() {
  //   return price;
  // }
}
