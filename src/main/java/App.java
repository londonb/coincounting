import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request,reponse)-> {
      HashMap model = new HashMap();
      model.put("template","templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request,reponse)-> {
      HashMap model = new HashMap();


      String coinInput = request.queryParams("coinInput");
      Integer coinInputInt = Integer.parseInt(coinInput);
      ArrayList<Object> coinList = new ArrayList<Object>();
      coinList = App.CoinCount(coinInputInt);
      String prettyResult = App.CoinPrintout(coinList);

      model.put("result", prettyResult);
      model.put("template","templates/output.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static ArrayList<Object> CoinCount(Integer changeBack) {
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
  public static String CoinPrintout(ArrayList<Object> coinQuantity) {
    String prettyResult = "";
    for (Integer i = 0 ; i < coinQuantity.size() ; i++) {
      prettyResult += "<li>" + coinQuantity.get(i) + "</li>";
    }
    return prettyResult;
  }

}
