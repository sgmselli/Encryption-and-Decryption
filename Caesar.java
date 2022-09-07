import java.util.Scanner;
import java.util.Arrays;

public class Caesar {
    public static char rotateChar(int shift, char message){
        int encrypted = (int)message;
        if(Character.isLowerCase(message)) {
            encrypted = message + shift;
            if(encrypted>122) {
                encrypted = encrypted - 26;
            }
        }

        if(Character.isUpperCase(message)) {
            encrypted = message + shift;
            if(encrypted>90) {
                encrypted = encrypted - 26;
            }
        }
        return (char)encrypted;
    }

    public static String rotateString(int shift, String str) {

        char[] array = str.toCharArray();


            for (int i = 0; i < array.length - 1; i++) {
                    if(Character.isLetterOrDigit(array[i])) {
                        array[i] = rotateChar(shift, array[i]);
                    }
            }
            return String.valueOf(Arrays.copyOfRange(array, 1, array.length));


    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int shift = scan.nextInt();
        String str = scan.nextLine();

        System.out.print(rotateString(shift, str));

    }
}
