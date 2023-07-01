public class Item {
    private String itemName;
    private int itemID;
    private static int nextID = 0;
    private double buyingPrice;
    private double sellingPrice;


    public Item(String itemName) {
        nextID++;
        this.itemName = itemName;
        this.itemID = nextID;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }


    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
