import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CityGenerator {
    private static final List<String> cityNames = Arrays.asList(
            "Montreal","Toronto","Calgary","Manitoba","Edmonton","Ottawa",
            "Vancouver","Winnipeg","Halifax","Saint-John","Mississauga",
            "Hamilton","Quebec City","Waterloo","YellowKnife","Niagara",
            "Victoria","White Horse","Trois Rivieres","Windsor","Thunder Bay");

    //Method to randomly generate  cities
    public static List<City> generateCities (int numCities){
        List<City> cities = new ArrayList<>(); //Array t
        Random random = new Random();
        for(int i =0; i<numCities; i++){
            String cityName = getRandomCityName(random);
            City city = new City(cityName,generateRandomNumItems());
            cities.add(city);
        }

        return cities;
    }
    //Method to  generate random city names
    private static String getRandomCityName (Random random){
        //Generate a random number between 0 and the length of our city names list
        int index = random.nextInt(cityNames.size());
        return cityNames.get(index); //Returning a name at the random index in our list
    }

    //Method to generate a random number of items between each city
    private  static  int generateRandomNumItems(){
        Random random = new Random();
        return random.nextInt(11); //Generate between 0 and 10 items
    }

}
