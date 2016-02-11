import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  // @ClassRule
  // public static ServerRule server = new ServerRule();
  //
  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("");
  // }
  @Test
  public void CoinCount_returnQuantityOfCoins_25() {
    App testCoin = new App();
    ArrayList<Object> coinQuantity = new ArrayList<Object>();
    coinQuantity.add(1);
    coinQuantity.add(0);
    assertEquals(coinQuantity, testCoin.CoinCount(25));
  }

  @Test
  public void CoinCount_returnNumberFromUser_99() {
    App testCoin = new App();
    ArrayList<Object> coinQuantity = new ArrayList<Object>();
    coinQuantity.add(3);
    coinQuantity.add(2);
    assertEquals(coinQuantity, testCoin.CoinCount(99));
  }

  @Test
  public void CoinCount_returnNumberOfEachCoinFromUser_35() {
    App testCoin = new App();
    ArrayList<Object> coinQuantity = new ArrayList<Object>();
    coinQuantity.add(1);
    coinQuantity.add(1);
    assertEquals(coinQuantity, testCoin.CoinCount(35));
  }

}
