import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {}

  public static Integer CoinCount(Integer changeBack) {
    Integer quarterQuantity = 0;
    Integer dimeQuantity = 0;
    Integer nickelQuantity = 0;
    Integer pennyQuantity = 0;
    Integer remainingAmount = 0;

    int[] coinWorth = { 25 , 10 , 5 , 1 };

    for (int coin = 0; coin < coinWorth.length; coin++) {
      while (changeBack > 0 && changeBack > coinWorth[coin]) {
          quarterQuantity = changeBack / coinWorth[0];
          remainingAmount = changeBack % coinWorth[0];

          if (changeBack % coinWorth[0] == 0) {
            changeBack -= changeBack;
          } else {
            changeBack -= remainingAmount;
          }
        }
    }
    return quarterQuantity;
  }
}
