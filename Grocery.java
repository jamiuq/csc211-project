public class Grocery extends Product
{
  private boolean isGeneticallyModified;

  public Grocery(String itemName, double price, boolean isGeneticallyModified)
  {
    this.isGeneticallyModified = isGeneticallyModified;
    super(itemName, price);
  }

  public boolean getIsGeneticallyModified() {return isGeneticallyModified;}
  public void setIsGeneticallyModified(boolean isGeneticallyModified) {this.isGeneticallyModified = isGeneticallyModified;}

  @Override
  public String toString()
  {
    return super.toString() + ", Genetically Modified: " + (isGeneticallyModified ? "Yes" : "No");
  }
}
    
