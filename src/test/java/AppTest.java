import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Change");
  }
  @Test
  public void CoinCount_returnQuantityOfCoins_25() {
    App testCoin = new App();
    int[] list = new int[] {1, 0, 0, 0};
    assertEquals(list, testCoin.CoinCount(25));
  }

  @Test
  public void CoinCount_returnNumberOfEachCoinFromUser_35() {
    App testCoin = new App();
    int[] list = new int[] {1, 1, 0, 0};
    assertEquals(list, testCoin.CoinCount(35));
  }

  @Test
  public void CoinCount_returnNumberFromUser_99() {
    App testCoin = new App();
    int[] list = new int[] {3, 2, 0, 4};
    assertEquals(list, testCoin.CoinCount(99));
  }

}
