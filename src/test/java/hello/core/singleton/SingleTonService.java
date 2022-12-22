package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * SingleTonService
 */
public class SingleTonService {

  // 너는 private일 이유가 있나??
  private static final SingleTonService singleton = new SingleTonService();

  public static SingleTonService getInstance() {
    return singleton;
  }

  // 이것땜시 new로의 객체생성이 막아짐
  private SingleTonService() {}

  public void print() {
    System.out.println("singleton");
  }
}
