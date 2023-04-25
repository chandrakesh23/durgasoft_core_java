package _13_java_lang_package;

/*
--> The process of creating exactly duplicate object is called cloning.
--> the main purpose of cloning is to maintain backup copy, and to
 preserve state of an object.
--> We can perform cloning by using clone method of Object class.

 +-------------------------------------------------------------------+
 | protected native Object clone() throws CloneNotSupportedException | 
 +-------------------------------------------------------------------+

example:
 
class Test implements Cloneable{
	int i=10;
	int j=20;
	public static void main(String[] args) throws CloneNotSupportedException {
		Test t1= new Test();
//		
//		 CE 1:
//		Test t2= t1.clone();//CE:Type mismatch:
//		                   //cannot convert from Object to Test
//		 CE 2:                   
//		Test t2=(Test) t1.clone();//CE:Unhandled exception
//		                         // type CloneNotSupportedException
//		                         
//      	Test t2=(Test) t1.clone();//RE:Exception in thread "main" 
//         					     //java.lang.CloneNotSupportedException
//         					    // ie, we need to implement Cloneable interface in Test class
//
      	Test t2=(Test) t1.clone();
		t2.i=888;
		t2.j=999;
		System.out.println(t1.i+"..."+t1.j);
	}
}

--> we can perform cloning only for cloneable objects, an object is said to be cloneable
	if and only if the corresponding class implements cloneable interface.
--> cloneable interface present in java.lang package and it doesn't contain any methods, it
	is a markup interface.
--> If we are trying to perform cloning for non-cloneable objects then we will get RE saying
	CloneNotSupportedException.
----------------------------------------
lets assume,	
	
	class C{
		int j=20;
	}
	class Dog implements Clonable{
		int i=10;
		C c=new C();
	}
	 
	 shallow cloning                      vs        Deep cloning
										|
d1                        d2			|			d1                        d2
 +-------+	            +-----+			|			+-------+	            +-----+  
 |	 i=10|   +-----+    |i=10 | 		|			|   i=10|   +-----+     |i=10 |   +----+
 |   c---|-->| j=20|<---|---c |			|		    |   c---|-->| j=20|     |c----|-->|j=20|
 +-------+   +-----+    +-----+			|			+-------+   +-----+     +-----+   +----+ 
	 									|		
	 Dog d1= new Dog();					|			 Dog d1= new Dog();												                            
	 Dog d2= (Dog)d1.clone();			|		     Dog d2= (Dog)d1.clone();
	 
--> The process of creating bit-wise copy of an object is called shallow 
	cloning.
--> if the main object contain primitive variables then exaclty duplicate copies 
	will be created in the clonned objects.
--> if the main object contain any reference variable then corresponding
 	object won't be created just a duplicate reference variable will be created
	pointing to old content object.
--> Object class clone method meant for shallow cloning.  	

	 
example:

class Cat{
	int j;
	Cat(int j){
		this.j=j;
	}
}
class Dog implements Cloneable{
	int i;
	Cat c;
	Dog(Cat c, int i){
		this.c=c;
		this.i=i;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
class ShallowCloningDemo{
	public static void main(String[] args) throws CloneNotSupportedException {
		Cat c= new Cat(20);
		Dog d1= new Dog(c, 10);
		System.out.println(d1.i+"...."+d1.c.j);//10....20
		Dog d2= (Dog)d1.clone();
		d2.i= 888;
		d2.c.j= 999;
		System.out.println(d1.i+"...."+d1.c.j);//10....999
	}
}
--> In shallow cloning by using clonned object reference if we perform any
change to the contained object then those changes will be reflected to the main
object,
	To overcome this problem we should go for deep-cloning.
	

 #Deep Cloning
-->The process of creating exactly independent duplicate copy including the contained
 object is called deep cloning.
--> In deep cloning if the main object contains any primitive variables then in the 
clonned object duplicate copies will be created.
--> If the main object contains any reference variables then the corresponding contained
objects will also be created in the clonned copy.
--> By default Object class clonned method ment for shallow cloning but we can implement
deep-clonning explicitly be overriding clone method in our class.   

example:

class Cat{
	int j;
	Cat(int j){
		this.j=j;
	}
}
class Dog implements Cloneable{
	int i;
	Cat c;
	Dog(Cat c, int i){
		this.c=c;
		this.i=i;
	}
	public Object clone() throws CloneNotSupportedException{
		Dog d= new Dog(new Cat(this.c.j), this.i);
		return d;
	}
}
class DeepCloningDemo{
	public static void main(String[] args) throws CloneNotSupportedException {
		Cat c= new Cat(20);
		Dog d1= new Dog(c, 10);
		System.out.println(d1.i+"...."+d1.c.j);//10....20
		Dog d2= (Dog)d1.clone();
		d2.i= 888;
		d2.c.j= 999;
		System.out.println(d1.i+"...."+d1.c.j);//10....20
	}
}

--> By using clonned object reference if we perform any change to the contained
object then those changes won't be reflected to the main object.

Q. which cloning is best?
A) If object contains only primitive variable then shallow cloning is the best choice,but
if object contians reference varibles then deep-cloning is the best choice.

*/
public class _14_clone {
	public static void main(String[] args) {

	}
}