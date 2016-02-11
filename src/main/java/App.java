import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;
import spark.ModelAndView;
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
      String coinList = App.CoinCount(coinInputInt);


      model.put("result", coinList);
      model.put("template","templates/output.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String CoinCount(int changeBack) {
    int[] coins = {25, 10, 5, 1};

    int[] list = new int[coins.length];

    for (int i=0; i <coins.length; i++) {
      while (changeBack >= coins[i]) {
        list[i]++;
        changeBack -= coins[i];
      }
    }
    return "Quarters: " + list[0] + "<br>" + "Dimes: " + list[1] + "<br>" +  "Nickels: " + list[2] + "<br>" + "Pennies: " + list[3];
  }
}
