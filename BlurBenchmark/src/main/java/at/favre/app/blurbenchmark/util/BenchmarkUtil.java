package at.favre.app.blurbenchmark.util;

import android.os.Build;
import android.os.SystemClock;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by PatrickF on 16.04.2014.
 */
public class BenchmarkUtil {
	private static final DecimalFormat format = new DecimalFormat("#.0");

	static {
		format.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		format.setRoundingMode(RoundingMode.HALF_UP);
	}

	public static long elapsedRealTimeNanos() {
		if (Build.VERSION.SDK_INT >= 17) {
			return SystemClock.elapsedRealtimeNanos();
		}
		return SystemClock.elapsedRealtime() * 1000000l;
	}

	public static String formatNum(double number) {
		return format.format(number);
	}

	public static String formatNum(double number, String formatString) {
		final DecimalFormat format = new DecimalFormat(formatString);
		format.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		format.setRoundingMode(RoundingMode.HALF_UP);
		return format.format(number);
	}
}