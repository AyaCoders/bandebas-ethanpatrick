import java.util.Scanner;
import java.util.ArrayList;

class Order {
   private String item;
   private int quantity;
   private int totalPrice;
   
   Order(String item, int quantity){
      this.item = item;
      this.quantity = quantity;
   }
}  

public class RIP {

   static Scanner in = new Scanner(System.in);
   
   static void displayMenu(){
      System.out.print("======== Menu ========\n[1] C1 - Php 100.00\n[2] C2 - Php 150.00\n" +
                       "[3] C3 - Php 200.00\n\nAdd Ons:\n[4] R1 - Php 35.00\n[5] R2 - Php 50.00\n" +
                       "\n[6] Exit\nChoice: ");
      int choice = in.nextInt();
   }
   
   static void getOrder(int orderNumber){
      ArrayList <Order> userOrders = new ArrayList <>();
      do {
         displayMenu();
         
         Order userOrder;
         
         switch(orderNumber) {
            case 1:
               userOrder = new Order("C1", 100);
            break;
            case 2:
               userOrder = new Order("C2", 150);
            break;
            case 3:
               userOrder = new Order("C3", 200);
            break;
            default:
               System.out.println("\nPlease pick from the choices...");
            break;
         }
         userOrders.add(userOrder);
      } while(orderNumber != 6);
   }

   public static void main(String[] args) {
      displayMenu();
   }
}