package _13_java_lang_package;
/*
	Wrapper Classes:
--> The main objectives of wrapper classes are:
	a) To wrap primitive into object form, so that we can handle primitives also just like
		objects.
	b) To define several utility methods which are required for primitives.
	
--> Almost all wrapper classes contains two constructors one can take corresponding primitive
	as argument and another can take string as argument
example:
	1) Integer I = new Integer(10);
	   Integer I = new Integer("10");
	   
	2) Double D = new Double(10.5);
	   Double D = new Double("10.5");
	   
--> If string argument not representing a number then we will get runtime exception
	 saying NumberFormatException.
	eg: Integer i = new Integer("ten");//java.lang.NumberFormatException
	
--> Float class contains three constructors with float, double, string type of arguments.
example:
		Float f1 = new Float(10.5f);
		Float f2 = new Float("10.5f");
		Float f3 = new Float(10.5);
		Float f4 = new Float("10.5");
		
--> Character class contains only one constructor which can take char argument
example:
		Character c1 = new Character('a');
		Character c2 = new Character("a");//CE:The constructor Character(String) is undefined
		
--> Boolean class contains twi constructors one can take primitive as argument and other can
	take string as argument.
	i) if we pass boolean primitive as argument the only allowed values are true or false
	 were case and content both are important.
example:
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean(false);
		Boolean b3 = new Boolean(True);//True cannot be resolved to a variable
		Boolean b4 = new Boolean(durga);//durga cannot be resolved to a variable

--> If we are passing string type as argument then case and content both are not important.
--> If the content is case insensitive String of "true" then it is treated as true otherwise
	it is treated as false.
example:
	Boolean b1 = new Boolean("true");//true
	Boolean b2 = new Boolean("Ture");//true
	Boolean b3 = new Boolean("TRUE");//true
	Boolean b4 = new Boolean("malaika");//false
	Boolean b5 = new Boolean("kareena");//false
	
	code:-
		public static void main(String ... arg) {
			Boolean X = new Boolean("yes");
			Boolean Y = new Boolean("no");
			System.out.println(X);//false
			System.out.println(Y);//false
			System.out.println(X.equals(Y));//true
		}
		
  +-------------------+--------------------------------------+
  | wrapper class     |   Correponding constructor arguments |
  +-------------------+--------------------------------------+
  | Byte              | byte or String                       |
  +-------------------+--------------------------------------+  
  | Short             | short or String                      |
  +-------------------+--------------------------------------+  
  | Integer           | int or String                        |
  +-------------------+--------------------------------------+  
  | Long              | long or String                       |
  +-------------------+--------------------------------------+  
  | Float             | float or String or double            |
  +-------------------+--------------------------------------+  
  | Double            | double or String                     |
  +-------------------+--------------------------------------+  
  | Character         | char                                 |
  +-------------------+--------------------------------------+  
  | Boolean           | boolean or String                    |
  +-------------------+--------------------------------------+  
	
	
Note: In all wrapper classes toStrin() method is overridden to return content
		directly.
	  In all wrapper classes .equals() method is overridden for content comparison.
====================

	  Utility methods:
	  1) valueOf()
	  2) xxxValue()
	  3) parseXxx()
	  4) toString()
	  
1. valueOf() 
--> we can use valueOf() methods to create wrapper object for given primitive or String.
--> every wrapper class except Character class contains a static valueOf() method to create
	wrapper object for the given String.
	
Form-1:	
	+------------------------------------+
    | public static T valueOf(String s)  |
	+------------------------------------+
example:	
	Integer i = Integer.valueOf("10");//10
	Double d = Double.valueOf("10.5");//10.5
	Boolean b = Boolean.valueOf("durga");//false
	  
Form-2
--> Every integral type wrapper class(Byte,Short,Integer,Long) contains
the following valueOf() method to create wrapper object for the given radix string
	+-----------------------------------------------------+
    | public static wrapper valueOf(String s, int radix); |
	+-----------------------------------------------------+
	the allowed range of radix is: 2 to 36

example:
		Integer i= Integer.valueOf("100",2);
		System.out.println(i);//4

		Integer i2= Integer.valueOf("101",4);
		System.out.println(i2);//17
		

Form-3
---> every wrapper class including Character class contains a static valueOf() method
to create wrapper object for the given primitive.
	+---------------------------------------------+
    | public static wrapper valueOf(primitive p); |
	+---------------------------------------------+
	
example:
		Integer i= Integer.valueOf(10);
		Character c= Character.valueOf('c');
		Boolean b= Boolean.valueOf(true);
		
summary:

		+------------+            	+---------+
		| primitive/ |   valueOf()  | Wrapper | 
		| String     |------------->|  Object |
		+------------+            	+---------+
--------------------------------------

		
	  2. xxxValue()
--> we can use xxxValue() methods to get primitive for the given wrapper object.
--> every number type wrapper class(Byte,Short,Integer,Long,Float,Double) contains 
the following six methods to get primitive for the given wrapper objects:
	public byte byteValue()
	public short shortValue()
	public int intValue()
	public long longValue()
	public float floatValue()
	public dlouble dloubleValue()
	
example:
		Integer i= Integer.valueOf(130);
		System.out.println(i.byteValue());//-126
		System.out.println(i.shortValue());//130
		System.out.println(i.intValue());//130
		System.out.println(i.longValue());//130
		System.out.println(i.floatValue());//130.0
		System.out.println(i.doubleValue());//130.0	
	
---> charValue()
Character class contains charValue() method to get char primitive for the given character
object. 	

example:
		Character ch= new Character('a');
		char c= ch.charValue();
		System.out.println(c);//a	

---> booleanValue()
Boolean class contains booleanValue() method to get boolean primitive for the given boolean
object. 	  

exapmle:
		Boolean B = new Boolean(true);
		boolean b = B.booleanValue();
		System.out.println(b);//true

Note: in total 38(= 6x6 +1 +1) xxxValue() methods posible
		
summary:

		+----------+              +-----------+
		| wrapper  |   xxxValue() | primitive | 
		|  object  |------------->|           |
		+----------+              +-----------+
-------------------------------------------------


	  3. parseXxx()
---> we can use parseXxx() to convert string to primitive

Form-1
--->every wrapper class except Character class contains the following parseXxx() method to
find primitive for thr given String object.

	+---------------------------------------------+
    | public static primitive parseXxx(String s); |
	+---------------------------------------------+

example:
	int i = Integer.parseInt("10");//10
	double d = Double.parseDouble("10.5");//10.5
	boolean b = Boolean.parseBoolean("ck");//false


Form-2
---> every integral type wrapper class(Byte,Short,Integer,Long) contains the following
parseXxx() methods to convert specified radix String to primitive. 	  

	+--------------------------------------------------------+
    | public static primitive parseXxx(String s, int radix); |
	+--------------------------------------------------------+
    --> the allowed range of radix is 2 to 36

example:
	int i = Integer.parseInt("1111",2);
	System.out.println(i);//15

summary:

		+----------+              +-----------+
		| String   |   parseXxx() | primitive | 
		|          |------------->|           |
		+----------+              +-----------+
-------------------------------------------------

    	  4. toString()
---> we can use toString() to convert wrapper object or primitive to String.

Form-1
---> Every wrapper class contains the following toString() method to convert wrapper object
to String type.

      	  +--------------------------+
      	  | public String toString() |
      	  +--------------------------+
--> it the overrriding version of Object class toString() method.
--> whenever we are trying to print wrapper class reference internally
toString() method will be called.      	  

example:
		Integer i = new Integer(10);
		String s = i.toString();
		System.out.println(s);//10
		System.out.println(i);//==>System.out.println(i.toString())==> 10
		
Form-2
--> every wrapper class including Character wrapper class contains the following
static toString() method to convert primitive to String.
		
      	  +--------------------------------------------+
      	  | public static String toString(primitive p) |
      	  +--------------------------------------------+
      	  
example:      	  
		String s1= Integer.toString(10);
		String s2= Boolean.toString(true);
		String s3= Character.toString('a');
		

Form-3
---> Integer and Long classes contains the following toString() methods to convert
primitive to specified radix String.		
		
      	  +-------------------------------------------------------+
      	  | public static String toString(primitive p, int radix);|
      	  +-------------------------------------------------------+
      	  --> allowed range of radix is 2 to 36

example:
		String s1= Integer.toString(15,2);
		System.out.println(s1);//1111
		

Form-4: toXxxString()
---> Integer and Long classes contains the following toXxxString() methods:

	+-------------------------------------------------+
	| public static String toBinaryString(primitive p)|
	| public static String toOctalString(primitive p) |
	| public static String toHexString(primitive p)   |
	+-------------------------------------------------+

example:
		String b= Integer.toBinaryString(10);
		System.out.println(b);//1010
		
		String o= Integer.toOctalString(10);
		System.out.println(o);//12
		
		String h= Integer.toHexString(10);
		System.out.println(h);//a

summary:

		+------------------+              +-----------+
		| wrapper object   |   toString() |           | 
		|       or         |------------->|  String   |
		|    primitive     |              |           | 
		+------------------+              +-----------+
-------------------------------------------------

---> dancing b/w String, wrapper object and primitive

                          +----------------------------------------+
                          |                                        |
                     +------------+                                |  
           +-------->| String     |<------------+                  |
 toString()|         +------------+             |                  | 
           |            |                       |                  | 
           |            |valueOf()              |                  |
           |            |                       |                  |
           |            |                       |toString()        |parseXxx() 
         +----------+   |                     +------------+       | 
         |wrapper   |<--+       xxxValue()    |primitive   |<------+
         |object    |------------------------>|value       |
         +----------+                         +------------+
            /|\                                    |
             |           valueOf()                 |
             +-------------------------------------+
             
---------------------------------------------------------------------------

---> Partial Hierarchy of java.lang package

                                       Object
                                         |
 +---------+--------+-------------+---+--+--------+------------+-----------------
 |         |        |             |   |           |            |        ........
String     |       StringBuilder  |  Character    |           Void
         StringBuffer             |              Boolean
                               Number
                                 |
                +-----+----+-----+-+---+-------+
                |     |    |       |   |       |
               Byte   |   Integer  |   Float   |
                     Short        Long       Double  
  
  
Conclusions:
1. the wrapper classes which are not the child class of
 	number are Boolean,Character
2. the wrapper classes which are not the direct child
   class of Object are Byte,Short,Integer,Float,Double.
3. String, StringBuffer and StringBuilder and all wrapper classes
	are final classes.
4. In addition to String objects all wrapper class objects are also
	immutable.
5. sometimes Void class is also considered as wrapper class.


--> Void class
1. it is a final class and it is the direct child class of Object, it
	doesn't contains any methods and it contains only one variable "Void.TYPE".
2. in general we can use Void class in Reflections to check whether the return type
	is void or not.
	
	if(getMethod("m1").getReturntype()== Void.TYPE){
	
	}

3. Void is the class representation of void keyword in java
 */
public class _11_Wrapper_classes {
	public static void main(String ... arg) {
	}
}
