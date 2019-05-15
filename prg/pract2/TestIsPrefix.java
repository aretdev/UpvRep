
/**
 * Write a description of class TestIsPrefix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestIsPrefix {
        public static void main(String[] args){
            
            String[] tests = {"","", "","recursion", "recursion","", "recursion","rec", 
                              "recursion","recursion", "123456789","recursion", "rec","recursion",
                              "pecur","recursion", "recurso","recursion", "remursi","recursion"};
        for (int i = 0; i < (tests.length) - 1; i += 2) {
            testIsPrefix(tests[i], tests[i + 1]);
        }
        }
        public static void testIsPrefix(String a, String b) {
            System.out.println("A: " + "\"" + a+ "\"" + "   B: " + "\"" +b + "\"" +
                                "     isPrefix: " + PRGString.isPrefix(a, b) +
                                "     String class: " + b.startsWith(a));
            System.out.println("-----------------------------");
        
        }
    }

        
    

