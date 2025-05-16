// Subclass for customers
class Customer extends User 
{
    private Order localOrder;

    public Customer(String username, String password) 
    {
      super(username, password);
      this.localOrder = new localOrder();
    }

    public Order getLocalOrder() {return localOrder;}
    public void setLocalOrder(Order setorder) {localOrder = setorder;}
  
    public String toString() 
    {
      return super.toString() + ", " + localOrder.toString();
    }
}
