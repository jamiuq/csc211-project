public class Clothing extends Product
{
  private int size;
  private String color;

  public Clothing(String itemName, double price, int size, String color)
  {
    this.size = size;
    this.color = color;
    super(itemName, price);
  }

  public int getSize() {return size;}
  public void setSize(int size) {this.size = size;}

  public String getColor() {return color;}
  public void setColor(String color) {this.color = color;}

  @Override
  public String toString()
  {
    return super.toString() + ", Size: " + size + ", Color: " + color;
  }
}
