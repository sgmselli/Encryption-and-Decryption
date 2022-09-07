import java.util.Arrays;
import java.util.Scanner;

public class Brutus {

    public static final double[] english = {
            0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
            0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
            0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };
    public static int[] count(String str){
        int[] letterCounts = new int[26];

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)!=' ') {
                if(Character.isLowerCase(str.charAt(i))) {
                    letterCounts[str.charAt(i) - 97]++;
                }
                else if(Character.isUpperCase(str.charAt(i))){
                    letterCounts[str.charAt(i) - 65]++;
                }
            }
        }
        return letterCounts;
    }

    public static double[] frequency(String str){

        double[] counted = Arrays.stream(count(str)).asDoubleStream().toArray();
        double[] letterFrequencies = new double[26];

        for(int i=0; i<26;i++){
            letterFrequencies[i] = counted[i]/str.length();
        }
        return letterFrequencies;
    }

    public static double chiSquared(double[] frequencies1, double[] frequencies2){

        double sum=0;

        for(int i=0; i<26; i++){
            double chi = ((frequencies1[i] - frequencies2[i])*(frequencies1[i] - frequencies2[i])) / frequencies2[i];
            sum += chi;
        }


        return sum;
    }

    public static double minValue(double[] array){
        Arrays.sort(array);
        return array[0];
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        double[] arrayChi = new double[26];

        int i=0;
        while(i<26 && arrayChi[i]==minValue(arrayChi)){
            arrayChi[i] = chiSquared(frequency(Caesar.rotateString(i, str)), english);
            i++;
        }
        int shift = i-1;

        System.out.print(Caesar.rotateString(shift, str));



    }
}
