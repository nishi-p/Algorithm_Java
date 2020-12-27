import java.lang.Math;
import java.math.BigInteger;

/**
 * Karatsuba Multiplication (Divide and Conquer)
 * 3T(n/2) = O(n^2)
 *
 * @author Nishi Parameshwara
 */

public class KaratsubaMultiplication {

    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");//1234
        BigInteger num2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");//4321
        BigInteger result = karat(num1, num2);
        System.out.println(result);
    }

        public static BigInteger karat(BigInteger x, BigInteger y) {
        if (x.compareTo(BigInteger.valueOf(10)) == -1) {
            if (y.compareTo(BigInteger.valueOf(10)) == -1) {
                return x.multiply(y); //1*4, 2*3, 3*7, 3*2, 4*1, 7*3, 4*6, 6*4, 1*1, 0*0, 2*0
            }
        }

        //divide each n-bit numbers into half
        //count number of digits in a number
        BigInteger num1 = x; //1234, 12, 34, 46, 10
        BigInteger num2 = y; //4321, 43, 21, 64, 10

        int count = 0; //4, 2, 2, 2, 2
        while (!num1.equals(BigInteger.valueOf(0))) {
            num1 = num1.divide(BigInteger.valueOf(10));
            /*
            int i = 1;
            int x = i++; //x is 1, i is 2 --> gets the element and then increments it, i = 1, i++ = 2
            int y = ++i; //y is 3, i is 3 --> increments the element and then returns it, ++i = 3, i = 3
            */
            ++count; //increment and then assign
        }

        int count1 = 0; //4, 2, 2, 2, 2
        while (!num2.equals(BigInteger.valueOf(0))) {
            num2 = num2.divide(BigInteger.valueOf(10));
            /*
            int i = 1;
            int x = i++; //x is 1, i is 2 --> gets the element and then increments it, i = 1, i++ = 2
            int y = ++i; //y is 3, i is 3 --> increments the element and then returns it, ++i = 3, i = 3
            */
            ++count1; //increment and then assign
        }

        int count2 = Math.max(count1, count); //4, 2, 2, 2, 2

        int m = (int) Math.ceil(count2 / 2); //2, 1, 1, 1, 1

        BigInteger xH = x.divide(BigInteger.valueOf((long)Math.pow(10,m))); //12, 1, 3, 4, 1
        BigInteger xL = x.mod(BigInteger.valueOf((long)Math.pow(10,m))); //34, 2, 4, 6, 0

        BigInteger yH = y.divide(BigInteger.valueOf((long)Math.pow(10,m))); //43, 4, 2, 6, 1
        BigInteger yL = y.mod(BigInteger.valueOf((long)Math.pow(10,m)));; //21, 3, 1, 4, 0

        BigInteger a = karat(xH, yH); //(12,43)=516, (1,4)=4, (3,2)=6, (4,6)=24, (1,1)=2
        BigInteger b = karat(xL, yL); //(2,3)=6, (34,21)=714, (4,1)=4, (6,4)=24, (0,0)=0
        BigInteger c = karat(xH.add(xL), yH.add(yL)).subtract(a).subtract(b);//(1+2,4+3)-4-6=11, (3+4,2+1)-6-4=11, (12+34,43+21)-a-b=(46,64)-516-714=1714, (4+6,6+4)-24-24=52, (1+1,0+0)-2-0=0

        BigInteger aresult = a.multiply(BigInteger.valueOf((long)Math.pow(10,count2)));
        BigInteger cresult = c.multiply(BigInteger.valueOf((long)Math.pow(10,m)));

        return  aresult.add(cresult).add(b); //516, 714, 100, 1714, 5332114
    }
}//KaratsubaMultiplication
