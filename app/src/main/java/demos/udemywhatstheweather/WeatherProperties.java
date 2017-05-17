package demos.udemywhatstheweather;

public enum WeatherProperties{

	DESCRIPTION("description");

	private String prop;

	WeatherProperties(String prop) {
		this.prop = prop;
	}

	public String prop(){
		return  prop;
	}

}
