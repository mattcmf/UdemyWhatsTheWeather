package demos.udemywhatstheweather;

import static demos.udemywhatstheweather.WeatherProperties.DESCRIPTION;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

	MockFeedDownloader weatherFeedDownloader;
	TextView weatherDescription = null;
	EditText cityInput = null;
	private String city;
	JSONObject jsonObject = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cityInput = (EditText) findViewById(R.id.cityInput);
		weatherDescription = (TextView) findViewById(R.id.weatherDescription);
//		WeatherFeedDownloader weatherFeedDownloader = new WeatherFeedDownloader();
		weatherFeedDownloader = new MockFeedDownloader();
		city = cityInput.getText().toString();
		String rawFeed = weatherFeedDownloader.getFeed(city, getApplication().getApplicationContext());
		Weather weather = null;
		getWeather();
	}

	public void clickWeather(View view){
		getWeather();
	}

	public void getWeather(){
		Weather weather;
		city = cityInput.getText().toString();
		String rawFeed = weatherFeedDownloader.getFeed(city, getApplication().getApplicationContext());

		try {
			weather = new Weather(rawFeed);
			weatherDescription.setText(weather.get(DESCRIPTION));
		} catch (JSONException e) {
			//TODO: Should be smart enough to know between an error and an unsupported country
			weatherDescription.setText("Country not supported");
			e.printStackTrace();
		} catch (Exception e){
			weatherDescription.setText("An error has occured.");
		}

	}
}
