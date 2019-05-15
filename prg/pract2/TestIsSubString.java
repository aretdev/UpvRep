
/**
 * Write a description of class TestIsSubString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestIsSubString{
    public static void main(String[] args){
        String[] tests = {"","", "test","", "","test", "123456","test", "test","123456",
            "test","eltesteador", "cleido","esternocleidomastoideo", "cleido","cleido"};
             for (int i = 0; i < (tests.length) - 1; i += 2) {
                 testIsSubString(tests[i], tests[i + 1]);
             }
    }
    public static void testIsSubString(String a, String b) {
        System.out.println("----------------------------");
        System.out.println("SubCadena = " + a);
        System.out.println("Cadena = " + b);
        System.out.println("isSubstring = " + PRGString.isSubstring(a, b));
        System.out.println("Método String = " + b.contains(a));
    }

}
