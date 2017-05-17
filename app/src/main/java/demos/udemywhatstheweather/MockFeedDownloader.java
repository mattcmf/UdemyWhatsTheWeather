package demos.udemywhatstheweather;

import android.content.Context;

public class MockFeedDownloader {

	public String getFeed(String location, Context context) {
//		if (location == "LONDON") {
			return context.getResources().getString(R.string.london_sample_data);
//		} else {
////			return context.getResources().getString(R.string.spain_sample_data);
//		}
	}
}