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
  
    Order customerOrder = customer1.getLocalOrder();
    customerOrder.addToCart(products.get(0)); // Laptop
    customerOrder.addToCart(products.get(2)); // T-Shirt
    customerOrder.addToCart(products.get(4)); // Apples
    
    System.out.println(customer1);
    
    // Admin adds and removes a product
    admin1.addProduct(customerOrder, new Electronics("Headphones", 150.00, "Sony"));
    System.out.println("Customer profile after admin added a new product:\n" + customer1);

    
    double finalTotal = customerOrder.getTotalAmount(); // function that uses lambdas to calculate total
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
    orders.add(customerOrder);
  
    String searchItem = "laptop";
    List<Order> customerOrders = orders.stream()
            .filter(order -> order.getCart().stream().filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase())))
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
