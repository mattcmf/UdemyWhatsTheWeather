package demos.udemywhatstheweather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Weather {

	private String rawFeed;
	private JSONObject jsonPart;
	private String feedError = null;

	public Weather(String rawFeed) throws JSONException {
		this.rawFeed = rawFeed;
		initFeed();
	}

	private void initFeed()  {
		if (null == rawFeed) {
			feedError = "Data feed is null";
			return;
		}

		try {
			JSONObject jsonObject = new JSONObject(rawFeed);
			String weatherinfo = jsonObject.getString("weather");
			JSONArray arr = new JSONArray(weatherinfo);
			jsonPart = arr.getJSONObject(0);
		} catch (JSONException e) {
		feedError = "Error converting JSON feed";
		}

	}

	public String get(WeatherProperties property) {
		if (null == feedError) {
			try {
				return jsonPart.getString(property.prop());
			} catch (JSONException e) {
				e.printStackTrace();
				return feedError = "Error getting property data from JSON feed. " + e.getMessage();
			}
		} else {
			return feedError;
		}
	}
}
