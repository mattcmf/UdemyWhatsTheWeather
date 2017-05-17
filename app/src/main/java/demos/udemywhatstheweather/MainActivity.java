package demos.udemywhatstheweather;

import static demos.udemywhatstheweather.WeatherProperties.DESCRIPTION;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

	private String country = "LONDON";
	JSONObject jsonObject = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		WeatherFeedDownloader weatherFeedDownloader = new WeatherFeedDownloader();
		MockFeedDownloader weatherFeedDownloader = new MockFeedDownloader();
		String rawFeed = weatherFeedDownloader.getFeed(country, getApplication().getApplicationContext());

		Weather weather = new Weather(rawFeed);
		Log.i("Weather_Data", weather.get(DESCRIPTION));

	}
}
