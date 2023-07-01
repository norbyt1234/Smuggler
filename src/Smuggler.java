import java.util.List;
import java.util.Random;

public class Smuggler {

    private Inventory inventory;
    private City currentCity;
    private List<City> cities = CityGenerator.generateCities(20); //List of cities where the  smuggler can travel
    private  double money;
    private static double ifCaughtFine = 100;
    private boolean isCaught;

    //Smuggler Constructor
    public Smuggler(){
        currentCity = cities.get(0);
        inventory = new Inventory();
        money = getStartingMoney();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<City> getCities() {
        return cities;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public double getMoney() {
        return money;
    }


    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        isCaught = caught;
    }

    //Method to get the starting money for the smuggler
    public double getStartingMoney(){
        Random random = new Random();
        double startingMoney = random.nextDouble(500,1200); // Smuggler starts with between 500 and 1200$
        return  startingMoney;
    }

    //Method to sell item
    public void sellItem(int itemID){
        Item item = inventory.searchItemByID(itemID);
        inventory.removeItem(item); //Removing the sold item from inventory
        money = money + item.getSellingPrice();
        System.out.println("You just sold the "+item.getItemName() +" at "+item.getSellingPrice()+"$");
        System.out.println("The money you have is now "+item.getBuyingPrice()+"$");
    }

    //Method to buy item
    public void buyItem(int itemID){
        Item item = inventory.searchItemByID(itemID);
        if(money >= item.getBuyingPrice()) {
            inventory.addItem(item); //Adding the sold item from inventory
            money = money - item.getBuyingPrice();
            System.out.println("You just bought the "+item.getItemName()+" at "+item.getBuyingPrice()+"$");
            System.out.println("The money you have is now "+item.getBuyingPrice()+"$");
        } else {
            System.out.println("You dont have enough fund to buy the item");
        }
    }
    //Method to allow the smuggler to travel
    public void travelToAnotherCity(int cityIndex){
        if(cityIndex >=0 && cityIndex < cities.size()){
            City newCity = cities.get(cityIndex);
            currentCity = newCity;
            System.out.println("You have travelled to "+ currentCity.getCityName());
        }
    }



    //Method to  display Inventory
    public  void lookAtInventory(){
        System.out.println("                      Here is your Inventory.");
        System.out.println("                      You have, "+ inventory.getItems().size() +" items in the inventory");
        System.out.println();
        System.out.println("Item ID          Item Name            Buying Price           Selling Price ");
        System.out.println("----------------------------------------------------------------------------------------------");
        for(Item item : inventory.getItems()){
            System.out.println(item.getItemID() + item.getItemName()+ item.getBuyingPrice() + item.getSellingPrice());
        }
    }

    //Method to look at money
    public void lookAtMoney(){
        System.out.println("You currently have "+ money+"$");
    }

    //


    //Method to pay the fine
    public void payFine() {
        if (money >= ifCaughtFine) {
            money -= ifCaughtFine;
            System.out.println("Paid a fine of $" + ifCaughtFine);
            ifCaughtFine += 50; // Increase the fine amount for subsequent times
        } else {
            System.out.println("Not enough money to pay the fine. You lose!");
            // Add logic to handle the loss condition
        }
    }
}
