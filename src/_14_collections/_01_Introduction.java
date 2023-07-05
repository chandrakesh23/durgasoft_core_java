package _14_collections;
/*
An array is a indexed collection of, fixed number of homogeneous data
elements, the main advantage of array is we can represent multiple values
by using single variable so that the readability of the code will 
improved.

Limitations of arrays:
1. Arrays are fixed in size, ie once we create an array there is no
chance of increasing or decreasing the size based on our requirement,
due to this to use arrays concept compulsory we should know size in 
advance, which may not possible always.

2. Array can hold only homogeneous data type elements.

	Student[] s =new Student[1000];
	s[0]=new Student();//valid
	s[1]=new Customer();//CE: incompatible types 
					   // found:Customer
					  //  required:Student
 we can solve this problem by using object type arrays,
		Object[] o =new Object[1000];
		o[0]=new Student();
		o[1]=new Customer(); 					 
					 
3. Arrays concept is not implemented based on some standard data
 structure and hence readmade method support is not available, for
 every requirement we have to write the code explicitily which increases
 the complexity of programming.
 
--> To overcome above problems of array we should for Collections concept
1. Collections are growable in nature, ie based on our requirement we 
can increase or decrease the size.
2. Collections can hold both homogeneous and heterogeneous objects.
3. Every Collection class is implemented based on some standard
 data-structure and hence for every requirement redymade support is
 available, being a programmer we are responsible to use those methods
 and we are not responsible to implement those methods.
  		
  					 
------------------------------------------------+------------------------------------------------
  	Arrays                                      |       Collections
------------------------------------------------+------------------------------------------------
 1. arrays are fixed in size, once we create    | 1. collections are growable in nature ie, 	
an array we cannot increase/decrease the size   |    based on our requirement we can increase/
based on our requirement.   	                |    decrease this size.
------------------------------------------------+------------------------------------------------
2. with respect to memory array are not         | 2. with respect to memory Collections are 
recommended to use.                             |    recommended to use.  
------------------------------------------------+------------------------------------------------
3. with respect to performance arrays are       | 3. with respect to performance Collections are 
	recommended to use.                         |    not recommended to use.  
------------------------------------------------+------------------------------------------------
4. arrays can hold only homogeneous data-type   | 4. collections can hold both homogeneous and
	elements.                                   |    heterogeneous elements.
------------------------------------------------+------------------------------------------------
5. there is no underlying data-structure for    | 5. every collection class is implemented based 
  arrays and hence readymade method is not      | on some standard data-structure and hence for
  available. For every requirement we have to   | every requirement ready-made method support is
  write the code explicitily which increases    | available. Being a programmer we can use these 
  complexity of programming. 	                | methods direclty and we are not responsible to 
                                                | implement those methods.
------------------------------------------------+------------------------------------------------
6. arrays can hold both primitives and objects  | 6. collections can hold only objects types 
 												|   but not primitives. 					
------------------------------------------------+------------------------------------------------


Collections:
---> If we want to represent a group of individual objects as a single entity then we should
go for Collections.

Collection Framework:
---> It contains several classes and interface which can be used to represent a group of 
individual objects as a single entity.  


---> 9 key interfaces of collection Framework:
1. Collection    2. List            3. Set
4. SortedSet     5. NavigableSet    6. Queue
7. Map           8. SortedMap       9. NavigableMap


1. Collection(I)
--> If we want to represent a group of individual object as 
a single entity then we should go for Collection.
--> Collection interface defines the most common methods which are
applicable for any Collection object.
--> In general Collection Interface is considered as root Interface
of Collection Framework.
--> There is no concrete class which implements Collection interface
directly.

 Difference b/w Collection and Collections
--> Collection is an interface, if we want to represent a group of
 individual object as a single entity then we should go for Collection.
--> Whereas Collections is an utility class present in java.util package
to define several utility methods for Collection Objects(like sorting,
searching etc).

2. List(I)
--> It the child interface of Collection(I).
--> If we want to represent a group of individual objects as a single
entity were duplicates are allowed and insertion order must be preserved
then we should go for List.

        Collection(I)  1.2v
            |
            |
            |   
    (1.2v)List(I)--------------------+ 
           |   |        1.2v         |
           |   +--->LinkedList(C)    |
          \|/                       \|/   ---------+    
        ArrayList(C)                Vector(C)      |           
			1.2v                      |            |
			                          |    1.0v    +----> these two are legacy classes
			                         \|/           |
			                         Stack(C)      |
			                              ---------+
 
--> In 1.2 version Vector and Stack classes are Re-engineered to implement List interface.


3. Set(I)
--> It is the child interface of Collection(I).
--> If we want to represent a group of individual objects as single entity were duplicates
are not allowed and insertion order not required then we should go for Set interface. 
 
                Collection(I)
                   |    1.2v
                   |
                   |
                  \|/
                  Set(I)
                   |  1.2v
                   |
                  \|/
                  HashSet(C)
                   |  1.2v
                   |
                  \|/
                  LinkedHashSet(C)   
 						1.4v
 						
4. SortedSet(I)
--> It is the child interface of Set(I)
--> If we want to represent we want to represent a group
of individual objects as a single entity where duplicates are not
allowed and all objects should be inserted according to some sorting
order then we should go for SortedSet.

5. NavigableSet(I)
--> It is the child interface of SortedSet(I).
--> It contains several methods for navigation purposes.
 
                Collection(I)
                   |    1.2v
                   |
                   |
                  \|/
                  Set(I)
                   |  1.2v
                   |
                  \|/
                  SortedSet(I)
                   |  1.2v
                   |
                  \|/
                  NavigableSet(I)   
 				   |  1.6v
                   |
                  \|/
 				  TreeSet(C)
 				  	  1.2v
 				  	  
--> Difference b/w List and Set
-----------------------------------+---------------------------------------  
            List                   |             Set
-----------------------------------+---------------------------------------  
1. Duplicates allowed              |      1. Duplicates not allowed
2. Insertion order preserved       |      2. Inserion order not preserved            
-----------------------------------+---------------------------------------  
            

6. Queue(I)
--> It is the child interface of Collection(I).
--> If we want to represent a group of individual objects 
"prior to processing" then we should go for Queue(I)
--> Usually Queue follows first in first out order but based 
on our requirement we can implement our own priority order also.
eg: before sending a mail we have to store all mail id's in some
    datasturcture, in which order we added mail id's, in the same order
    mail should be delivered. For this requirement Queue is best choice.
            

 				  	  Collection(I)
 				  	       |
 				  	       |
 				  	      \|/
 				  	  Queue(I) 1.5v
 				  	     |
 		  -+-------------+--------------
 		   |             |   
 		PriorityQueue    | ........
 		                 |
 		              BlockingQueue
 		                 +--->PriorityBlockingQueue
 		                 |
 		                 +--->LinkedBlockingQueue       		  	       
 				  	       
 				  	       
Note:
--> All the above interfaces(Collection, List, Set, SortedSet, NavigableSet, Queue)
    ment for representing a group of individual objects.
--> If e want to represent a gruop of objects as key-value pair then we
    should go for Map interface.
    
7. Map(I)
--> Map is not the child interface of Collection(I).
--> If we want to represent a group of Objects as key-value pairs
then we should go for Map.
eg:     
            key        value
		+-----------+---------+ 
 		|Serial No. |  Name   |
        +-----------+---------+ 
 		|  101      |  durga  |
        +-----------+---------+ 
 		|  102      |  ravi   |
        +-----------+---------+ 
 		|  103      |  shiva  |
        +-----------+---------+ 
--> Both key and value are objects only.
--> Duplicate key not allowed but value can be duplicate       				  	       
 	
 				  	  
 				Map(I)                 Dictionary(Abstract Class)
 				 |                       |  1.0v
   +--------+----+------+-------------+  | 
   |        |           |             |  |                      1.0v are all
   |      WeakHashMap   |             |  |                    legacy clases   
   |         1.2v       |             |  |
  \|/                   |            Hashtable
   HashMap             \|/              |1.0v
   |1.2v          IdentityHashMap      \|/
   |                  1.4v             Properties               
  \|/                                     1.0v
  LinkedHashMap   
   1.4v
 				
 	
8. SortedMap(I)
--> It is the child interface of Map.
--> If we want to represent a group of key-value pairs according
	to some sorting order of key's, then we should go for sortedMap.
--> In sorted Map the sorting should be based on key but not based on value.

	
9. NavigableMap(I)
--> It is the child interface of SortedMap
-->	It defines several methods for navigation purposes.

			Map(I)
			| 1.2v
			|
		   \|/
		   SortedMap(I)
		    | 1.2v
		    |
		   \|/
		   NavigableMap(I)
		    | 1.6v
		    |
		   \|/
		   TreeMap(C)
			1.2v
			
Note: the following are legacy Classes/Interfaces in collection
1. Enumeration(I)
2. Dictionary(AC)
3. Vector(C)
4. Stack(C)
5. Hashtable(C)
6. Properties(C)

refer ./_01_image.png
			
 */
public class _01_Introduction {
	public static void main(String[] args) {

	}
}
