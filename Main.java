public class Main
{
  public static void main(String[] args) {
    // Initialize products
    List<Product> products = new ArrayList<>();
    products.add(new Electronics("Laptop", 1200.00, "Dell"));
    products.add(new Electronics("Smartphone", 800.00, "Samsung"));
    products.add(new Clothing("T-Shirt", 25.00, "M", "Blue"));
    products.add(new Clothing("Jeans", 75.00, "32", "Denim"));
    products.add(new Grocery("Apples", 2.00, true));
    products.add(new Grocery("Milk", 3.50, false));
  
    // Initialize users
    Customer customer1 = new Customer("john.doe", "password12");
    Admin admin1 = new Admin("jane.admin", "knicksrule104");
  
    // Customer adds items to the cart
    customer1.addToCart(products.get(0)); // Laptop
    customer1.addToCart(products.get(2)); // T-Shirt
    customer1.addToCart(products.get(4)); // Apples
    
    System.out.println(customer1);
    Order customerOrder = customer1.getLocalOrder();
    
    // Admin adds and removes a product
    admin1.addProduct(customerOrder, new Electronics("Headphones", 150.00, "Sony"));
    System.out.println("\Customer profile after admin added a new product:\n" + customer1);
  
    // Using lambdas for cart calculations
    double subtotal = customer1.calculateCartTotal(cart -> cart.stream().mapToDouble(Product::getPrice).sum());
    System.out.println("Cart Subtotal: $" + String.format("%.2f", subtotal));
  
    double discountedTotal = customer1.applyDiscount(subtotal, total -> total * 0.9); // 10% discount
    System.out.println("Cart Total after 10% discount: $" + String.format("%.2f", discountedTotal));
  
    double tax = customer1.calculateTax(discountedTotal, amount -> amount * 0.08); // 8% tax
    System.out.println("Cart Total after tax: $" + String.format("%.2f", discountedTotal + tax));
  
    double shippingFee = customer1.calculateShipping(cart -> cart.size() * 1.5); // $1.5 per item shipping
    System.out.println("Shipping Fee: $" + String.format("%.2f", shippingFee));
  
    double finalTotal = discountedTotal + tax + shippingFee;
    System.out.println("Final Cart Total: $" + String.format("%.2f", finalTotal));
  
    // Using streams for search and sorting
    String searchTerm = "Laptop";
    List<Product> searchResults = customerOrder.getCart().stream()
            .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
            .collect(Collectors.toList());
    System.out.println("\nSearch results for '" + searchTerm + "':");
    searchResults.forEach(System.out::println);
  
    ArrayList<Product> sortedProductsByPrice = customerOrder.getCart().stream()
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .collect(Collectors.toList());
    System.out.println("\nCustomer cart sorted by price:");
    sortedProductsByPrice.forEach(System.out::println);
  
    // Assume we have a list of orders
    List<Order> orders = new ArrayList<>();
    orders.add(order1);
  
    String searchItem = "laptop";
    List<Order> customerOrders = orders.stream()
            .filter(order -> order.getCart().stream().filter(product -> product.getName().toLowerCase().containts(searchTerm.toLowerCase())))
            .collect(Collectors.toList());
    System.out.println("\nOrders that contain '" + searchCustomer + "':");
    customerOrders.forEach(System.out::println);
  
    List<Order> sortedOrdersByTotal = orders.stream()
            .sorted(Comparator.comparingDouble(Order::getTotalAmount).reversed())
            .collect(Collectors.toList());
    System.out.println("\nOrders sorted by total amount (descending):");
    sortedOrdersByTotal.forEach(System.out::println);
  }
}
