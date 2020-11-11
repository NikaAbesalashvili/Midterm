package ge.edu.btu.currency.service.impl;

import ge.edu.btu.currency.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {

    double exchangeRate;

    @Override
    public double convert(int amount) {
        try {
            return amount / this.exchangeRate;
        }catch (ArithmeticException exception) {
            System.out.println("მოხდა ნულზე გაყოფა");
            return 0;
        }
    }

    @Override
    public double convert(double amount) {
        try {
            return amount / this.exchangeRate;

        }catch (ArithmeticException exception) {
            System.out.println("მოხდა ნულზე გაყოფა");
            return 0;
        }
    }

    @Override
    public void setExchangeRate(double value) {
        this.exchangeRate = value;
    }
}
