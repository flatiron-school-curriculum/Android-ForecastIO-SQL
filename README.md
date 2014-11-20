Android-ForecastIO-SQL
======================

You'll find attached a simple project that connects to the the Forecast.io API to get weather reports using Retrofit, Maps those reports onto Java Pojos, and Presents that data to a ListView.  Your task will be to Build out the functionality to persist data, delete data, and update stale data.  You should have 2 buttons on your options menu "Refresh" and "Delete".  Refresh will hit the API, if the database is empty it will insert the forecast into the database, otherwise it will update the existing data with the fresh data, then  present the data to ListView.  Delete will delete all rows from the database and update the ListView.  

##Instructions

* [Register for a ForecastIO APIKey](https://developer.forecast.io/) 
* Setup your Java POJO Forecast. See below for code snippet.  
* Configure your Database in `ForecastOpenHelper.java`.  
	* Define Table Name
	* All of Table's Column names as constant strings 
	* The Database Name and Version 
	* The DB_CREATE String 
* Implement the Constructor, onCreate and onUpgrade methods in `ForecastOpenHelper.java`
* Configure your ForecastDataSource with methods to insert a Forecast, select all Forecast's temperatures, update a Forecast's temperature, and delete a Forecast with a given id. 
* Create a ForecastAdapter CursorAdapter Subclass which displays each day in the Forecast's temperature 
* Configure your Activity to appropriately update it's ListView 

##Classes 

###Forecast 

POJO for a ForecastIO Forecast

```java

public class Forecast {
    public HourlyForecast hourly;

    public class HourlyForecast {
        public List<HourData> data;
    }

    public class HourData {
        public double temperature;
        public double precipProbability;
        public double humidity;
        public double windSpeed;
        public double visibility;
        public double pressure;
        public double ozone;
        public double time;
        public String icon;
        public String summary;
    }

}

``` 

###ForecastService

Retrofit Wrapper for loading forecast data 

###ForecastDataSource

DAO for Forecast Database CRUD Methods. 

###ForecastOpenHelper 

SQLiteOpenHelper subclass to create table and handle migrations 


###WeatherActivity

Root Activity Displays List of temperatures

