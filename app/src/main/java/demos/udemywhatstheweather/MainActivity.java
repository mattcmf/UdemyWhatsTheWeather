package demos.udemywhatstheweather;

import static demos.udemywhatstheweather.WeatherProperties.DESCRIPTION;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

	MockFeedDownloader weatherFeedDownloader;
	TextView weatherDescription = null;
	EditText cityInput = null;
	private String city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cityInput = (EditText) findViewById(R.id.cityInput);
		weatherDescription = (TextView) findViewById(R.id.weatherDescription);
//		WeatherFeedDownloader weatherFeedDownloader = new WeatherFeedDownloader();
		weatherFeedDownloader = new MockFeedDownloader();
		city = cityInput.getText().toString();

		getWeather();
	}

	public void clickWeather(View view) {
		getWeather();
	}

	public void getWeather() {
		Weather weather;
		city = cityInput.getText().toString();
		String rawFeed = null;
		try {
			rawFeed = weatherFeedDownloader.getFeed(city,
					getApplication().getApplicationContext());
		} catch (Exception e) {
			weatherDescription.setText(e.getMessage());
			return;
		}

		try {
			weather = new Weather(rawFeed);
			weatherDescription.setText(weather.get(DESCRIPTION));
		} catch (JSONException e) {
			weatherDescription.setText("Country not supported");
			e.printStackTrace();
		}
	}
}
