/** P. 145 project #4: CircularList.java */
import java.util.*;

public class CircularList<E> {

   private static class Node<E> {

      private E data;
      private Node<E> next = null;

      public Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
      public Node(E data) {
         this(data, null);
      }
   }

   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;

   public void addFirst(E item) {
      head = new Node<E>(item, head);
      size++;
      tail = getNode(size-1);
      tail.next = head;
   }

   private void addAfter(Node<E> node, E item) {
      node.next = new Node<E>(item, node.next);
      size++;
      tail = getNode(size-1);
      tail.next = head;
   }

   public void add(int index, E item) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if (index == 0) {
         addFirst(item);
      } else {
         Node<E> node = getNode(index - 1);
         addAfter(node, item);
      }
   }

   public E removeFirst() {
      Node<E> temp = head;
      if (head != null) {
         head = head.next;
      }
      if (temp != null) {
         size--;
         tail = getNode(size-1);
         tail.next = head;
         return temp.data;
      } else {
         return null;
      }
   }

   private E removeAfter(Node<E> node) {
      Node<E> temp = node.next;
      if (temp != null) {
         node.next = temp.next;
         size--;
         tail = getNode(size-1);
         tail.next = head;
         return temp.data;
      } else {
         return null;
      }
   }
   public void remove(int index) {
      if (index < -1 || index >= size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if (index == -1) {
         removeFirst();
      } else {
         Node<E> node = getNode(index - 1);
         removeAfter(node);
      }
   }

   private Node<E> getNode(int index) {
      Node<E> node = head;
      for (int i = 0; i < index && node != null; i++) {
         node = node.next;
      }
      return node;
   }

   public E get(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      return node.data;
   }

   public E set(int index, E newValue) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      E result = node.data;
      node.data = newValue;
      return result;
   }

   public boolean add(E item) {
      add(size, item);
      return true;
   }

   int size() {
     return size;
   }

   public Iterator<E> iterator()
   {
      return new CircularListIterator();
   }

   private class CircularListIterator  implements Iterator<E>
   {
      private Node<E> nextNode;

      public CircularListIterator()
      {
         nextNode = head;
      }

      public boolean hasNext()
      {
         return nextNode != null;
      }

      public E next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         E item = nextNode.data;
         nextNode = nextNode.next;
         return item;
      }
      public void remove() { throw new UnsupportedOperationException();      }
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("[");
      Node p = head;
      if (p != null) {
         while (p.next != null) {
            sb.append(p.data.toString());
            sb.append("  ");
            p = p.next;
         }
         sb.append(p.data.toString());
      }
      sb.append("]");
      return sb.toString();
   }}
