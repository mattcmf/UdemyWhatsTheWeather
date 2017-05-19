package demos.udemywhatstheweather;

import android.content.Context;

public class MockFeedDownloader {

	public String getFeed(String location, Context context) {
		if (location.equals("London")) {
			return context.getResources().getString(R.string.london_sample_data);
		} else if (location.equals("Tokyo")) {
			return context.getResources().getString(R.string.Toyko_sample_data);
		} else {
			return null;
		}
	}
}