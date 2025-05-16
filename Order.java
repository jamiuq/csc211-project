public class Order
{
  private ArrayList<Product> cart;

  

  public ArrayList<Product> getCart() 
  {
    return cart;
  }

  public void addToCart(Product product) 
  {
    cart.add(product);
  }

  public void removeFromCart(Product product) 
  {
    cart.remove(product);
  }

  public void removeFromCart(int index)
  {
    cart.remove(index);
  }
  
  // Lambda to calculate the total price of items in the cart
  public double calculateCartTotal(cartProcessor totalCalculator) 
  {
    return totalCalculator.apply(this.cart);
  }

  // Lambda to apply a discount to the cart total
  public double applyDiscount(double initialTotal, numProcessor discountApplicator) 
  {
    return discountApplicator.apply(initialTotal);
  }

  // Lambda to calculate tax on the cart total
  public double calculateTax(double subtotal, numProcessor taxCalculator) 
  {
    return taxCalculator.apply(subtotal);
  }

  // Lambda to calculate shipping fees
  public double calculateShipping(cartProcessor shippingCalculator) 
  {
    return shippingCalculator.apply(this.cart);
  }

  public double getTotalAmount()
  {
    double subtotal = this.calculateCartTotal(cart -> cart.stream().mapToDouble(Product::getPrice).sum());
  
    double discountedTotal = customer1.applyDiscount(subtotal, total -> total * 0.9); // 10% discount
  
    double tax = customer1.calculateTax(discountedTotal, amount -> amount * 0.08); // 8% tax
  
    double shippingFee = customer1.calculateShipping(cart -> cart.size() * 1.5); // $1.5 per item shipping
  
    double finalTotal = discountedTotal + tax + shippingFee;
    return finalTotal;
  }
  
  public String toString() 
  {
      return "Number of Cart Items: " + cart.size();
  }
}
