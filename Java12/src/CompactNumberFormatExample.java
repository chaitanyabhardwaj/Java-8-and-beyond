import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExample {

    public static void main(String[] args) throws Exception {
        //Short compact number format
        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

        System.out.println(shortFormat.format(1000)); //1K
        System.out.println(shortFormat.format(1000000)); //1M
        System.out.println(shortFormat.format(1500)); //2K -> Rounded up
        shortFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println(shortFormat.format(1500)); //1K -> Rounded down
        shortFormat.setMaximumFractionDigits(2);
        System.out.println(shortFormat.format(1500)); //1.5K -> Fraction digits set to 2

        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.LONG);

        System.out.println(longFormat.format(1000)); //1 thousand
        System.out.println(longFormat.format(1000000)); //1 million
        System.out.println(longFormat.format(1500)); //2 thousand -> Rounded up
        longFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println(longFormat.format(1500)); //1 thousand -> Rounded down
        longFormat.setMaximumFractionDigits(2);
        System.out.println(longFormat.format(1500)); //1.5 thousand -> Fraction digits set to 2
    }

}
