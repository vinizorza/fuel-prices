package pt.vinizorza.fuelprices.util;

import java.math.BigDecimal;

public class CurrencyFormatter {

    public static BigDecimal toBigDecimal(String value){
        value = value.replace(",", ".").replace(" €", "");
        return new BigDecimal(value);
    }

}
