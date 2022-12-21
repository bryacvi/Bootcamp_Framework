package pageObjects;

import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants extends BasePage {

    public Constants(WebDriver webDriver) {
        super(webDriver);
    }

    //Place Order Form Information
    public static String NameInfo = new String("Juan");
    public static String CountryInfo = new String("Mexico");
    public static String CityInfo = new String("Mexico");
    public static String CardInfo = new String("23481623949789");
    public static String YearInfo = new String("2000");
    public static String MonthInfo = new String("04");

    //Date Form Information
    public static Date date = new Date();
    public static SimpleDateFormat day = new SimpleDateFormat("dd");
    public static String formattedDay = day.format(date);
    public static String DayFormat = new String(formattedDay);
    public static SimpleDateFormat month = new SimpleDateFormat("MM");
    public static String formattedMonth = month.format(date);
    public static Integer MonthNumber = Integer.valueOf(formattedMonth)-1;
    public static String MonthFormat = new String((MonthNumber.toString()));
    public static SimpleDateFormat year = new SimpleDateFormat("yyyy");
    public static String formattedYear = year.format(date);
    public static String YearFormat = new String(formattedYear);
    public static String DateInfoAux = new String(DayFormat+"/"+MonthFormat+"/"+YearFormat);
}
