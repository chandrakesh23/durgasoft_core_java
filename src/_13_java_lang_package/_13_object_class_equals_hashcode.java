package _13_java_lang_package;
/*
 
---> Relation b/w == operator and .equals() method
 1. if two objects are equal by == operator then these objects are
always equal by .equals() method
	ie, if  r1 == r2 is true then r1.equals(r2) is always true
	
 2. if two objects are not equal by == operator then we cannot conclude
anything about .euqals() method, it may return true or false
	ie, if r1 == r2 is false then r1.equals(r2) may returns
    true or false and we cannot expect exaclty
    
 3. if two objects are equal by .equals() method then we cannot conclude
 anything about == operator, it may return true or false
     ie, if r1.equals(r2) is true then we cannot conclude anything
     about r1 == r2, it may return true or false.
     
 4. if two objects are not equal by .equals() method then these objects
 are always not equal by == operator.
 	ie, if r1.equals(r2) is false then r1 == r2 is always false
 	
 	 
---> Difference b/w == operator and  .equals() method
1. to use == operator compulsory there should be some relation
b/w argument types (either child to parent or parent to child or same type)
otherwise we will get compile time error saying incomparable types.
	if there is no relation b/w argument types then .equals() wont raise
	any CE or RE simply it returns false
 	
example:
		String s1= new String("durga");
		String s2= new String("durga");
		StringBuffer sb1= new StringBuffer("durga");
		StringBuffer sb2= new StringBuffer("durga");
		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(sb1==sb2);//false
		System.out.println(sb1.equals(sb2));//false
		System.out.println(s1==sb1);//CE: incomparable types
		System.out.println(s1.equals(sb1)); //false
		
+----------------------------------+----------------------------------+ 
| 		== operator                |  .equals() method                |
+----------------------------------+----------------------------------+ 		
|	1. it is an operator in java   | 1. it is a method applicable     |
| 	applicable for both primitives | only for object type but not     |
| 	and object types               | for primitves                    |
+----------------------------------+----------------------------------+ 		
|   2. In the case of object       | 2. by default .equals() present  |  
| references == operator ment for  | in Object class also ment for    |	
| reference(address) comparison    | reference comparison.            |
+----------------------------------+----------------------------------+ 		
|   3. we cannot override ==  	   | 3. we ca override .equals()method|
| operator for content comparison  | for content comparison.          |
+----------------------------------+----------------------------------+
|   4. to use == operator          | 4. If there is no relation b/w   |
| compulsory there should be some  | argument types then .equals() method		
| relation b/w argument types ie,  | wont raise any CE or RE and simply
|(either child to parent or parent | returns false.                   |
| to child or same type) otherwise |                                  |
|we will get CE saying incomparable|                                  |
| types.                           |                                  |
+----------------------------------+----------------------------------+


 a) In general we can use == operator for reference comparison and 
 	.equals() method for content comparison.

Note: 
	1)for any object reference r, 
				r == null
				r.equals(null)
	always returns false.
	example: 
			Thread t = new Thread();
			System.out.println(t==null);//false
			System.out.println(t.equals(null));//false
			
	2) Hashing related data structures follow the following fundamental rule:
	 two equivalent objects should be placed in same bucket but all objects
	 present in the same bucket need not be equal.
---------------------------------------------------------------	

Contract between .equals() and hashCode() method
-->if two objects are equal by .equals() method then their hashcodes() must be equal, ie
two eqivalent objects should have same hashcode
hence if r1.equals(r2) is true then r1.hashCode() == r2.hashCode() is always true.

--> Object class .equals() method and hashCode() method follws above contract hence
whenever we are overriding .equals() method compulsory we should override hashCode()
method to satisfy above contract(ie, two equivalent objects should have same hashcode).

--> if two objects are not .equals() method then there is no restriction on hashcodes
may be equal or not equal.

--> if hashcode of two object equal then we cannot conclude anything about .equals()
method.

--> if hashcode of two objects are not equal then these objects always not equal
by .equals() method

Note: to satisfy contract between hashCode() and equals() methods, whenever we are
overriding .equals() method compulsory we have to override hashCode() method otherwise
we wont get any compile time or runtime errors but it is not a good programming practice.

--> In string class .equals() method is overriden for content comparison and hence hashCode()
  method is also overriden to generate hashcode based on content
example:
		String s1= new String("durga");
		String s2= new String("durga");
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.hashCode());//95950491
		System.out.println(s2.hashCode());//95950491
		
--> In StringBuffer .equals() method is not overriden for content comparison, and hence
hashCode() method is not overriden.
example:
		StringBuffer s1= new StringBuffer("durga");
		StringBuffer s2= new StringBuffer("durga");
		System.out.println(s1.equals(s2));//false
		System.out.println(s1.hashCode());//942731712
		System.out.println(s2.hashCode());//971848845
		
Q. consider the following Person class					 				

	class Person{
		String name;
		int age;
		int sso;
		public boolean equals(Object obj) {
			if(obj instanceof Person) {
				Person p= (Person)obj;
				if(name.equals(p.name) && age==p.age)
					return true;
				else 
					return false;
			}
			return false;
		}
	}

which of the following hashCode() methods are appropriate for Person class?
a)
	public int hashCode() {
		return 100;
	}
	
b)
	public int hashCode() {
		return age+sso;
	}

c)
	public int hashCode() {
		return name.hashCode()+age;
	}
	
d) no restrictions

	answer: c
Note: 
1.Based on which parameters we override .equals() method,
it is highly recommended to use same parameters while overriding
hashCode() method also. 
2. In all collection classes, in all wrapper classes and in String class
.equals() method is overriden for content comparison hence it is highly
recommended to override .equals() method in our class also for content
comparison.
 */
public class _13_object_class_equals_hashcode {
	public static void main(String[] args) {}
}
