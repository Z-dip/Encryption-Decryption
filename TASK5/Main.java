package encryptdecrypt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        String data = ":)";
        char numButChar = 'a';
        String out = "";
        StringBuilder sb = new StringBuilder();

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
                case "-in":
                    String fileName = args[i + 1];
                    File file = new File(fileName);
                    try (Scanner sc = new Scanner(file)) {
                        data = sc.nextLine();
                        System.out.println(data);
                    }  catch (FileNotFoundException e) {
                        System.out.println("Error");
                        System.exit(1);
                    }
                    break;
                case "-out":
                     out = args[i + 1];
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
                for (int i = 0; i < dt.length; i++) {

                    key = dt[i] + movage; //movage;
                    numButChar = (char) key;
                    sb.append(numButChar);
                    }

                if (out.equals("")) {
                    System.out.print(numButChar);
                } else {
                    File file = new File(out);

                    try(FileWriter writer = new FileWriter(file)) {
                        writer.write(sb.toString());
                        System.out.print(data);
                    } catch (IOException e) {
                        System.out.println("Error");
                        System.exit(1);
                    }
                }
                    break;
                case "dec":
                for(int i = 0; i < dt.length; i++) {
                    key = dt[i] - movage; //movage;
                    numButChar = (char) key;
                    sb.append(numButChar);
                    if (out.equals("")) {
                        System.out.print(numButChar);
                    } else {
                        File file = new File(out);

                        try (FileWriter writer = new FileWriter(file)) {
                            writer.write(sb.toString());
                            System.out.print(data);
                        } catch (IOException e) {
                            System.out.println("Error");
                            System.exit(1);
                        }
                    }
                }
                    break;
                default:
                System.err.println("unknown mod");
                System.exit(1);
        }
    }
}
