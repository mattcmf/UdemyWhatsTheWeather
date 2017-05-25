package demos.udemywhatstheweather;

import android.content.Context;

public class MockFeedDownloader {

	public String getFeed(String location, Context context) throws Exception {
		if (location.equals("London")) {
			return context.getResources().getString(R.string.london_sample_data);
		} else if (location.equals("Tokyo")) {
			return context.getResources().getString(R.string.Toyko_sample_data);
		} else if (location.equals("Spain")) {
			return context.getResources().getString(R.string.Spain_sample_data);
		} else {
			throw new Exception("Country not supported");
		}
	}
}