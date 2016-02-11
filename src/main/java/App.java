import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {



  }

  public static Object CoinCount(Integer changeBack) {
    ArrayList<Object> coinQuantity = new ArrayList<Object>();
    Integer quarter = 25;
    Integer dime = 10;
    Integer nickel = 5;
    Integer pennyQuantity = 0;

    Integer quarterQuantity = changeBack / quarter;
    Integer quarterTimes = quarterQuantity * quarter;
    Integer remainingAmount = changeBack - quarterTimes;
    coinQuantity.add("Quarters: " + quarterQuantity);

    Integer dimeQuantity = remainingAmount / dime;
    Integer dimeTimes = dimeQuantity * dime;
    Integer remainingAmountDimes = remainingAmount - dimeTimes;
    coinQuantity.add("Dimes: " + dimeQuantity);

    Integer nickelQuantity = remainingAmountDimes / nickel;
    Integer nickelTimes = nickelQuantity * nickel;
    Integer remainingAmountNickel = remainingAmountDimes - nickelTimes;
    coinQuantity.add("Nickels: " + nickelQuantity);
    coinQuantity.add("Pennies: " + remainingAmountNickel);
    return coinQuantity;
  }


}
