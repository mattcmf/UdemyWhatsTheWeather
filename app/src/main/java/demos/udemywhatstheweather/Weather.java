package demos.udemywhatstheweather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Weather {

	String rawFeed;
	JSONObject jsonPart;

	public Weather(String rawFeed) {
		this.rawFeed = rawFeed;
		initFeed();
	}

	private void initFeed() {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(rawFeed);
			String weatherinfo = jsonObject.getString("weather");
			JSONArray arr = new JSONArray(weatherinfo);
			jsonPart = arr.getJSONObject(0);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String get(WeatherProperties property) {
		try {
			return jsonPart.getString(property.prop());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
}
