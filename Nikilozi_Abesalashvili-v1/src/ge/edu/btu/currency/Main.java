package ge.edu.btu.currency;

import ge.edu.btu.currency.service.CurrencyService;
import ge.edu.btu.currency.service.impl.CurrencyServiceImpl;
import org.apache.log4j.Logger;
import java.util.Scanner;

public class Main {

    final static Logger logger=Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userMoney;
        System.out.println("შემოიტანეთ თანხის რაოდენობა: ");
        userMoney = input.nextInt();

        CurrencyService currencyService = new CurrencyServiceImpl();
        currencyService.setExchangeRate(3);

        System.out.println(currencyService.convert(12));
        System.out.println(currencyService.convert(122.3));

        logger.info("მომხმარებლის მიერ შემოტანილი თანხა: "
                + userMoney
                + "\n\tგადაგონვერტირებული თანხა: " + currencyService.convert(userMoney));

    }
}
