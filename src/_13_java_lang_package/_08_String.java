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

case 2:
String s1 = new String("durga");					StringBuffer sb1 = new StringBuffer("durga");
String s2 = new String("durga");					StringBuffer sb2 = new StringBuffer("durga");
System.out.println(s1 == s2);//false				System.out.println(sb1 == sb2);//false
System.out.println(s1.equals(s2));//true			System.out.println(sb1.equals(sb2));//false

 lec 106, 24:39
 */
public class _08_String {

}
