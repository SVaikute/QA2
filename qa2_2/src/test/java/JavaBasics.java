import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBasics {

    @Test
    public void javaBasic() {
        int a = 13;
        int b = 10;

        int c = sumDigits(a, b);
        int d = sumDigits(10, 13);
        System.out.println("Sum is " + c);
        System.out.println("Sum is " + d);

        Assertions.assertEquals(25, c, "Sum is not correct!");
    }

    private Integer sumDigits(int a, int b) {
        return a + b;
    }
}
