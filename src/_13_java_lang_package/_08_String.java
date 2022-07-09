package _13_java_lang_package;

/*

case 1:
String s = new String("durga");				||		StringBuffer sb = new StringBuffer("durga");
s.concat("software");						||		sb.append("software");
System.out.println(s);//durga				||		System.out.println(sb);//durgasoftware
											||
--> Once we create a string object we		||	--> Once we create StringBuffer object we can perform
cannot perform any changes in the existing	||		any change in the existing Object this changeable 
object, if we are trying to perform any		||		behaviour is nothing but mutability on stringbuffer object.
change with those changes a new object will	||
be created. This non-changeable behaviour is||
nothing but immutability of string.			||
==================================================================================================================
											||
case 2:										||
String s1 = new String("durga");			||		StringBuffer sb1 = new StringBuffer("durga");
String s2 = new String("durga");			||		StringBuffer sb2 = new StringBuffer("durga");
System.out.println(s1 == s2);//false		||		System.out.println(sb1 == sb2);//false
System.out.println(s1.equals(s2));//true	||		System.out.println(sb1.equals(sb2));//false
											||
--> In String class .equals() method is		||   --> In StringBuffer class .equals() method is not overriden   
overridden for content comparison and 		||		for content comparison, hence Object class .equals() 
hence even though objects are different		||		method got executed which is ment for reference comparison
if contents are same .equals() returns true	||		(address comparison). Due to this if objects are different
											||       .equals() method returns false even though content is same.
===================================================================================================================
											||
case 3:										||
a)											||
String s = new String("durga");				||		String s = "durga";
--> In this case two objects will be created||	--> In this case only one oject will be created in scp, and s
one in the heap area and the other in scp 	||		is pointing to that object.
and s is always pointing to heap object		||
											||
											||
	heap  		|  scp						||			heap  		|  scp
	area		|							||			area		|
	+------+	|	+------+				||						|		+------+
s-->|durga |	|	|durga |				||						|		|durga |<----s
	+------+	|	+------+				||						|		+------+

Note: 1) Object creation in scp is optional, first it will check is there any object already presentin scp with
 		required content. If object already present then existing object will be reused. If object not already
 		available then only a ne object will be created. But this rule is applicable only for scp but not for
 		heap memory.
 	
 	  2) Garbage collector is not allowed to access scp area hence even though object doestn't content reference
 	  	variable it is not eligible for gc if it is present in scp area. All scp objects will be destroyed automatically
 	  	at the time of jvm shutdown.
 	  	
 	  	
b)
String s1 = new String("durga"); 	  	
String s2 = new String("durga"); 	  	
String s3 = "durga";
String s4 = "durga";

 		
 		heap area    |    scp
 					 |
 		+------+     |	+------+
 s1---> |durga |     |  |durga |<--- s3
 		+------+     |  +------+
 					 |		/|\
 		+------+     |		 |	
 s2--->	|durga |     |       s4
 		+------+     |  
 
--> Whenever we are using new operator compulsory a new object will be created in the heap area, hence
there may be a chance of existing two objects with same content in the heap area but not in scp, ie duplicate
objects are possible in heap area but not in scp. 
 
c)
String s1 = new String("durga");
s1.concat("Software");
String s2 = s1.concat("Solutions");
s1= s1.concat("Soft");
System.out.println(s1);//durgaSoft
System.out.println(s2);//durgaSolutions
 
 		heap area    		|    scp
 					 		|	
 		+------+     		|	+------+
  		|durga |     		|  	|durga |
 		+------+     		|  	+------+
 					 		|		
 	+--------------+		|	+----------+	 	
 	|durgaSoftware |		|   | Software |    
 	+--------------+		|   +----------+
 					 		|		
 		+--------------+	|	+----------+	 	
 s2-->	|durgaSolutions|	|   | Solutions|    
 		+--------------+	|   +----------+
 					 		|		
 		+--------------+	|	+------+	 	
 s1-->	|durgaSoft	   |	|   | Soft |    
 		+--------------+	|   +------+
 
Note: 1) For every String constant one object will be placed in scp area.
	2) Because of some runtime operation if an object is required to create
		that object will be placed only in heap area but not in scp area.
 
String s1 = new String("Spring");
s1.concat("Summer");
String s2 = s1.concat("Winter");
s1= s1.concat("Fall");
System.out.println(s1);//SpringFall
System.out.println(s2);//SpringWinter
 
 		heap area    		|    scp
 					 		|	
 		+-------+     		|	+-------+
  		|Spring |     		|  	|Spring |
 		+-------+     		|  	+-------+
 					 		|		
 	+--------------+		|	+--------+	 	
 	|SpringSummer  |		|   | Summer |    
 	+--------------+		|   +--------+
 					 		|		
 		+--------------+	|	+--------+	 	
 s2-->	|SpringWinter  |	|   | Winter |    
 		+--------------+	|   +--------+
 					 		|		
 		+--------------+	|	+------+	 	
 s1-->	|SpringFall	   |	|   | Fall |    
 		+--------------+	|   +------+
 
 107, start
 */
public class _08_String {

}
