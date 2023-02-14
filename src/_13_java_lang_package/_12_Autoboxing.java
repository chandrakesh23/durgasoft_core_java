package _13_java_lang_package;
/*

Autoboxing:
--> automatic conversion of primitive to wrapper object by compiler
	is class autoboxing.

example:
		Integer i = 10;
compiler converts int to Integer automatically by Autoboxing, After
compilation the above line will become:

		Integer i = Integer.valueOf(10);
ie, internally autoboxing concept is implemented by using valueOf()
methods.
----------------


Autounboxing:
--> automatic conversion of wrapper object to primitive by compiler
is called autounboxing.		

		Integer I = new Integer(10);
		int i = I;
compiler converts Integer to int automatically by autounboxing. After
compilation the above line will become:
		
		int i = I.intValue();
ie, internally autounboxing concept is implemented by using xxxValue()
method.

	
	+---------------+   Autoboxing[ valueOf()]   +-----------+ 
	|               |--------------------------->|           |       
	| primitive     |                            | wrapper   |
	|  value        |                            |   Object  |
	|               |<---------------------------|           |              
	+---------------+ Autounboxing [xxxValue()]  +-----------+
	
example 1:

class Test{
	static Integer I=10;//autoboxing
	public static void main(String[] args) {
		int i=I;//autounboxing
		m1(i);////autoboxing
	}
	public static void m1(Integer k) {
		int m=k;//autounboxing
		System.out.println(m);//10
	}
}	

Note:
a) the above code is valid in 1.5 version but invalid in 1.4 version.
b) Just because of autoboxing and autounboxing we can use primitives
	and wrapper objects interchangeably from 1.5 version onwards.
	
example 2:
case-1:
			class Test{
				static Integer I=0;
				public static void main(String[] args) {
					int i=I;
					System.out.println(i);//0
				}
			}
			
case-2:
			class Test{
				static Integer I;
				public static void main(String[] args) {
					int i=I;//RE: NullPointerException
					System.out.println(i);
				}
			}
			
Note: On null reference if we are trying to perform autounboxing then
we will get runtime exception saying NullPointerException.

Example 3:
	class Test{
		public static void main(String[] args) {
			Integer X=10;
			Integer Y=X;
			X++;
			System.out.println(X);//11
			System.out.println(Y);//10
			System.out.println(X==Y);//false
		}
	}
	
Note: All wrapper class Objects are immutable ie, once we create wrapper
class object we cannot perform any changes in that Object if we are trying
to perform any changes, with those changes a new object will be created.

Example 4:

case1)
		Integer X= new Integer(10);
		Integer Y= new Integer(10);
		System.out.println(X==Y);//false
		
case2)									
		Integer X= new Integer(10);
		Integer Y= 10;
		System.out.println(X==Y);//false
		
case3)		
		Integer X= 10;
		Integer Y= 10;
		System.out.println(X==Y);//true
		
case4)
		Integer X= 100;
		Integer Y= 100;
		System.out.println(X==Y);//true

case5)
		Integer X= 1000;
		Integer Y= 1000;
		System.out.println(X==Y);//false
		
conclusion:
a) Internally to provide support for autoboxing a buffer of wrapper Objects
will be created at the time of wrapper class loading, By autoboxing if an 
Objects is required to be created, first JVM will check whether this object
already present in buffer or not, if it is already present in the buffer then
existing buffer object will be used, if it is not already available in the
buffer then JVM will create a new Object.

 						class Integer{
 							static{
 							  +----+----+--+---+---+--+----+
 							  |-128|-127|..10..|100...| 127|
 							  +----+----+--+---+---+--+----+
 							}
 						}
 						
b) But buffer concept is available only in the following ranges
 	Byte  ---> always
 	Short ---> -128 to 127
 	Integer--> -128 to 127
 	Long  ---> -128 to 127
 	Character-> 0 to 127
 	Boolean---> always
 except this range in all remaining cases a new Object will be created.
 	
example:
		Integer X= 127;
		Integer Y= 127;
		System.out.println(X==Y);//true
		-----
		Integer X= 128;
		Integer Y= 128;
		System.out.println(X==Y);//false
		-----
		Boolean X= false;
		Boolean Y= false;
		System.out.println(X==Y);//true
		-----
		Double X= 10.0;
		Double Y= 10.0;
		System.out.println(X==Y);//false

c) Internally autoboxing concept is implemented by using valueOf()
method hence buffer concept is applicable for valueof() methods also.  	

example:
		Integer X= new Integer(10);
		Integer Y= new Integer(10);
		System.out.println(X==Y);//false
		------
		Integer X= 10;
		Integer Y= 10;
		System.out.println(X==Y);//true
		------
		Integer X= Integer.valueOf(10);
		Integer Y= Integer.valueOf(10);
		System.out.println(X==Y);//true
		------
		Integer X= 10;
		Integer Y= Integer.valueOf(10);
		System.out.println(X==Y);//true
		
-------------------------------

	Overloading with respect to Autoboxing, widening & var-arg methods
	
case-1
-->	Autoboxing vs widening

		class Test{
			public static void m1(Integer i) {
				System.out.println("Autoboxing");
			}
			public static void m1(long l) {
				System.out.println("widening");
			}
			public static void main(String[] args) {
				int x=10;
				m1(x);//widening
			}
		}
--> widening always dominates autoboxing, ie both m1(Integer i) and m1(long l)
were eligible for m1(x) but widening was intoroduced in 1.0 version and autoboxing
was intoduced in 1.5v so to provide backward compatibility widening has more
 preference over autoboxing.		
	
					
case-2
--> widening vs var-arg methods
		class Test{
			public static void m1(int ...i) {
				System.out.println("var-arg");
			}
			public static void m1(long l) {
				System.out.println("widening");
			}
			public static void main(String[] args) {
				int x=10;
				m1(x);//widening
			}
		}
--> widening always dominates var-arg methods, ie both m1(int... i) and m1(long l)
were eligible for m1(x) but widening was intoroduced in 1.0 version and var-arg
was intoduced in 1.5v so to provide backward compatibility widening has more
preference over autoboxing.		


case-3
---> autoboxing vs var-arg
		class Test{
			public static void m1(int... i) {
				System.out.println("var-arg");
			}
			public static void m1(Integer I) {
				System.out.println("autoboxing");
			}
			public static void main(String[] args) {
				int x=10;
				m1(x);//autoboxing
			}
		}
--> Autoboxing dominates var-arg methods, in general var-arg method will get
least priority ie, if no other method matched then only var-arg method will
get chance. It exaclty same as default case inside switch.

Note: while resolving overloaded method compiler will always give precedence
in order, widening--> autoboxing--> var-arg methods
		
case-4
		class Test{
			public static void m1(Long L) {
				System.out.println("autoboxing");
			}
			public static void main(String[] args) {
				int x=10;
				m1(x);//CE:The method m1(Long) in the type
				     //Test is not applicable for the arguments (int)
			}
		}

above possibility is:
	          A.B                       widening not possible
		int ------------->   Integer --------------> Long
		     widening                    A.B
		int ------------->   Integer --------------> Long 
---> widening followed by autoboxing is not allowed in java whereas 
autoboxing followed by widening is allowed.
example:
		Long l =10;//CE:Type mismatch: cannot convert from int to Long
		
		long l1= 10;//possible due to widening

case-5
		class Test{
			public static void m1(Object o) {
				System.out.println("Object version");
			}
			public static void main(String[] args) {
				int x=10;
				m1(x);//Object version
			}
		}											

		Object o=10;//valid int--> Integer--> Object(autoboxing --> widening)
		Number n=10;//valid int--> Integer--> Number(autoboxing --> widening)
		
Q. which of the following assignments are legal		
		int i1=10;//valid
		Integer I1=10;//valid(autoboxing)
		int i2=10L;//CE:Type mismatch: cannot convert from long to int
		Long l1=10L;//valid(autoboxing)
		Long l2=10;//CE:Type mismatch: cannot convert from int to Long
		long l3=10;//valid(widening)
		Object o1=10;//valid(int-->Integer-->Object)(autoboxing-->widening)
		double d1=10;//valid(widening)
		Double D2=10;//CE:Type mismatch: cannot convert from int to Double
		Number n=10;//valid(int-->Integer-->Number)(autoboxing-->widening)
		
 */
public class _12_Autoboxing {
	public static void main(String[] args) {	}	
}
