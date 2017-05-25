package demos.udemywhatstheweather;


import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class WeatherFeedDownloader {

	private String feedBase ="http://api.openweathermap.org/data/2.5/weather?q=";
	private String feedToken ="&APPID=7b62957d67e69c6eddbce621517d7487";
	private String TestFeed = feedBase + "London" + feedToken;



	public String getFeed(String city) {
		try {
			return new FullPageSourceDownloader().execute(feedBase + city + feedToken).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "InterruptedException";
		} catch (ExecutionException e) {
			e.printStackTrace();
			return "ExecutionException";
		}
	}

	private class FullPageSourceDownloader extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {

			Log.i("MATT", urls[0]);

			String result = "";

			URL url;

			//Think of this as a browswe and it fetches the content of a URL
			HttpURLConnection urlConnection = null;

			try{
				url = new URL(urls[0]);
				//Think opening browser window
				urlConnection = (HttpURLConnection)url.openConnection();
				//stream to hold the input of data as it comes in
				InputStream in = urlConnection.getInputStream();

				InputStreamReader reader = new InputStreamReader(in);

				int data = reader.read();

				//Data will keep going whilst its reading CHARACTERS from the value of the
				//URL reader.
				while (data != -1){
					char current = (char)data;
					result += current;
					//Move onto next character
					data = reader.read();
				}
				return result;
			}
			catch(Exception e){
				e.printStackTrace();
				return e.getMessage();
			}
		}
	}
}
