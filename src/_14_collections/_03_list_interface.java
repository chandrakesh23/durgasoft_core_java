package _14_collections;
/*
 
List(I)
--> List is child interface of Collection.
--> If we want to represent a group of individual objects as a
single enity were duplicates are alowed and insertion order must be
preserved then we should go for List.
--> We can preserve instertion order via index and we can differentiate duplicate
objects by using index, hence index will play very important role in List.
--> List interface defines the following specific methods:
i)   void add(Object o); 
ii)  void add(int index, Object o); 
iii) void addAll(int index, Collection c);
iv)  Object get(int index);
v)   Object remove(int index);
vi)  Object set(int index, Object newObject);
          // to replace the element present at specified index with provided
         // Object and returns old object.
vii) int indexOf(Object o);
          // returns index of first occurrence of 'o'
viii)int lastIndexOf(Object o);
ix)  ListIterator listIterator();

				Collection(I)
				/
			   /
		      /
		     List(I)-------+
		     / \           |
		    /   \          |
		   /    LinkedList | 
		  /	               |
		ArrayList		 Vector
		                   |
		                   |
		                  Stack
		                  

--> ArrayList
1. The undelying data structure is resizeable array or growable array.
2. Duplicates are allowed.
3. Insertion order is preserved.
4. Heterogeneous objects are allowed.(Except TreeSet and TreeMap everywhere
   heterogeneous objects are allowed).
5. Null insertion is allowed.

   Constructors:
   1. ArrayList l = new ArrayList();
 Creates an empty arraylist object with default initial capacity 10. Once
 arraylist reaches its default capacity then a new Arraylist object will
 be created with new capacity as following rule
   +-------------------------------------------------+
   |   new capacity = ( current capacity * 3/2) + 1  |
   +-------------------------------------------------+
                         
   2. ArrayList l = new ArrayList(int initial capacity);
   
   134 50:25
                           
                           
		                  
 */
public class _03_list_interface {
	public static void main(String[] args) {

	}
}
