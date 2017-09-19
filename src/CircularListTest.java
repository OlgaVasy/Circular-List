/** CircularListTest.java */
import java.util.Iterator;

public class CircularListTest {

   public static void main(String[] args) {

      CircularList<String> colors = new CircularList<String>();

      colors.add("blue");
      colors.add("red");
      colors.add("green");
      colors.add("pink");
      colors.addFirst("yellow");

      System.out.println("The elements of the list are:");
      Iterator itr = colors.iterator();
      for (int i=0; i<colors.size();i++)
         System.out.print(itr.next() + " ");
      System.out.println();

      System.out.println("\nThe fifth element '" + colors.get(4) + "' has been replaced by 'white'. Now the elements of the list are:");
      colors.set(4, "white");
      Iterator itr1 = colors.iterator();
      for (int i=0; i<colors.size();i++)
         System.out.print(itr1.next() + " ");
      System.out.println();

      System.out.println("\nThe first element '" + colors.get(0) + "' has been removed. Now the elements of the list are:");
      colors.removeFirst();
      Iterator itr2 = colors.iterator();
      for (int i=0; i<colors.size();i++)
         System.out.print(itr2.next() + " ");
      System.out.println();

      System.out.println("\nThe second element '"+ colors.get(1) + "' has been removed. Now the elements of the list are:");
      colors.remove(0);
      Iterator itr3 = colors.iterator();
      for (int i=0; i<colors.size();i++)
         System.out.print(itr3.next() + " ");
      System.out.println();

      System.out.println("\nThe list is circular, and traverse in the forward can be infinite. For example, going through the list 3 times:");
      for (int i=0; i<colors.size()*3;i++){
         if(itr.hasNext())
            System.out.println(itr3.next());}

      System.out.println("\nThe tail of the list is:");
      itr3.next();
      itr3.next();
      System.out.print(itr3.next());
      System.out.println("\nThe next element from the tail is:");
      System.out.print(itr3.next());
      System.out.println();
            }
  }
