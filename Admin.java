class Admin extends User {
  public Admin(int id, String username) 
  {
      super(id, username);
  }

  public void addProduct(Order someonesOrder, Product product) 
  {
      someonesOrder.addToCart(product);
  }

  public void removeProduct(Order someonesOrder, Product product) 
  {
      someonesOrder.removeFromCart(product);
  }
}
