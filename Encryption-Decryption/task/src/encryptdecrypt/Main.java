package encryptdecrypt;  
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mode = "enc";
        int key = 0;
        String data = ":)";
        char numButChar = 'a';

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                default:
                    System.err.println("unknown argument");
                    System.exit(1);

            }
        }
        char[] dt = data.toCharArray();
        int movage = key;

        switch (mode) {

            case "enc":
                for(int i = 0; i < dt.length; i++) {

                    key = dt[i] + movage; 
                    numButChar = (char) key;

                    System.out.print(numButChar);
                }
                break;

            case "dec":
                for(int i = 0; i < dt.length; i++) {

                    key = dt[i] - movage; //movage;
                    numButChar = (char) key;
                    System.out.print(numButChar);
                }
                break;

            default:
                System.err.println("unknown mod");
                System.exit(1);
        }
    }
}




