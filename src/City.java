import java.util.List;
import java.util.Random;

public class City {
    private String cityName;
    List<Item> availableItems;

    //City Constructor
    public City(String cityName,int numItems){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }



    //Method to see if the smuggler gets caught
    public void catchSmuggler(Smuggler smuggler) {
        Random random = new Random();
        int numOfItems = smuggler.getInventory().getItems().size();
        double catchProbability = numOfItems * 10; // We can Adjust the multiplier to control the catch probability

        if (random.nextDouble() < catchProbability) {
            System.out.println("You have been caught by the authorities!");

            // Move the smuggler to a random city
            int randomIndex = random.nextInt(smuggler.getCities().size()); //Random index to determine new city
            List<City> allCities = smuggler.getCities();
            City randomCity = allCities.get(randomIndex);
            smuggler.setCurrentCity(randomCity);

            // Pay the fine and remove all items of a specific type
            smuggler.payFine();

        } else {
            System.out.println("You successfully arrived in " + smuggler.getCurrentCity().getCityName() + ".");
        }
    }

}
