package com.techelevator;

public class Weather {

	private int fiveDayForecast;
	private int low;
	private int high;
	private String forecast;

	public int getFiveDayForecast() {
		return fiveDayForecast;
	}
	public void setFiveDayForecast(int fiveDayForecast) {
		this.fiveDayForecast = fiveDayForecast;
	}
	public int getLow() {
		return low;
	}
	
	public int getLowC() {
		int celciusTemp = (int) ((low - 32) / 1.8);
		return celciusTemp;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	
	public int getHighC() {
		int celciusTemp = (int) ((high - 32) / 1.8);
		return celciusTemp;
	}
	
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}	
	
	public String getCamelCaseWords(String input) {
		String[] words = input.split(" ");
		String outputString = words[0];
		for (int i=1; i < words.length; i++) {
			outputString += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
		}
		return outputString;
	}
	
	public String getFlavorText(String forecast, int high, int low) {
		String flavorText = "";
		if (forecast.equals("snow")) {
			flavorText = "Pack snow shoes!";
		} 
		else if (forecast.equals("rain")){
			flavorText = "Pack rain gear and wear water-proof shoes!";
		}
		else if (forecast.equals("thunderstorms")){
			flavorText = "Seek shelter and avoid hiking on exposed ridges!";
		}
		else if (forecast.equals("sun")){
			flavorText = "Pack sunblock!";
		}
		else {
			flavorText = "Have fun!";
		}
		if (high > 75) {
			flavorText += " Bring extra water!";
		}
		else if (high - low > 20) {
			flavorText += " Wear breathable clothes!";
		}
		else if (low < 20) {
			flavorText += " Be careful of dangers of exposure to fridged temperatures!";
		}
		return flavorText;
	}
	
}
