import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    //Inventory constructor
    public Inventory(){
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){  //Method to add items in our inventory
        items.add(item);
    }
    public  void removeItem(Item item){  //Method to remove items in our inventory
        items.remove(item);
    }

    //Method to get the value of our inventory
    public double getInventoryValue (){
        double inventoryValue = 0.0;
        for (Item item:items) {
            inventoryValue += item.getBuyingPrice();
        }
        return inventoryValue;
    }
    public Item searchItemByID(int ID){
        for(Item item : items ){
            if (item.getItemID() == ID){
                return item;
            }
        }
        return null;
    }

}
