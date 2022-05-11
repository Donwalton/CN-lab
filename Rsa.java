import java.util.*;
import java.math.*;

class Rsa
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int p,q,n,z,d=0,e,i;
        System.out.print("Enter the number to be decrypted and encrypted:");
        int msg=input.nextInt();
        double c;

        BigInteger msgback;
        System.out.print("Enter 1st prime number:");
        p=input.nextInt();
        System.out.print("Enter 2nd prime number:");
        q=input.nextInt();

        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("The value of z= "+z);
        for(e=2;e<z;e++){
            if(gcd(e,z)==1){
                break;
            }
        }
        System.out.println("the value of e= "+e);
        for(i=0;i<=9;i++){
            int x=1+(i*z);
            if(x%e==0)
            {
                d=x/e;
                break;
            }
       }
       System.out.println("the value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);
 
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
 
        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "+ msgback);
        
    }
 
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }

        
    }
