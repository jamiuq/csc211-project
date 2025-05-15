public class Product
{
  private String itemName;
  private double price;
  public Product(String itemName, double price) {this.itemName = itemName; this.price = price;}

  public String getItemName() {return itemName;}
  public void setItemName(String itemName) {this.itemName = itemName;}

  public double getPrice() {return price;}
  public void setPrice(double price) {this.price = price;}

  public String toString()
  {
    return "Name: " + itemName + ", Price: $" + String.format("%.2f", price);
  }
}
