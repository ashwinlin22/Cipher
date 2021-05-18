import java.util.*;
import java.io.*;
import java.nio.file.*;


/** 
 * Allows the user to perform operations on a txt file and output them to another file
 * three operations are reverse, shift letters forward, and shift letters backwards
 * @author Ashwin Lingaraj
 */
public class Cipher {

    /** max shift amount */
    public static final int MAX_SHIFT_AMOUNT = 25;

    /** 
     * user enters input file and output file for operations
     * menu displays and asks user input for options
     * @param args command line arguments
     */
    public static void main (String[] args){
        if (args.length != 2){
            System.out.println("Usage: java -cp bin Cipher infile outfile");
            System.exit(1);
        }     
        Scanner scanner = new Scanner(System.in);        
        Scanner input = null;
        int numLines = 0;
        try {
            input = new Scanner(new FileInputStream(args[0]));
        }  
        catch (FileNotFoundException e) {
            System.out.println("Unable to access input file: " + args[0]);
            System.exit(1);
        }
        while (input.hasNextLine()){
            input.nextLine();
            numLines++;
        }
        String[] contents = new String[numLines];
        Path path = Path.of(args[1]);
        PrintWriter output = null;
        if (!Files.exists(path)){
            try {
                output = new PrintWriter(new FileOutputStream(args[1]));
            }     
            catch (IOException e) {
                System.out.println("Cannot create output file");
                System.exit(1);
            }
            try {
                Scanner input2 = new Scanner(new FileInputStream(args[0]));
                for (int i = 0; i < contents.length; i++){
                    contents[i] = input2.nextLine();
                }
            }  
            catch (FileNotFoundException e) {
                System.out.println("Unable to access input file: " + args[0]);
                System.exit(1);
            }
            String operation = "";
            while (!operation.equals("Q")){
                System.out.println();
                System.out.println("Cipher - Please enter an operation below.");
                System.out.println();
                System.out.println("R - Reverse all lines");
                System.out.println("F - Shift all letters forward");
                System.out.println("B - Shift all letters backward");
                System.out.println("Q - Quit");
                System.out.println();
                System.out.print("Operation: ");
                operation = scanner.next().toUpperCase();
            
                if (operation.equals("R")){
                    for (int i = 0; i < contents.length; i++){
                        contents[i] = reverseLine(contents[i]);
                    }
                    continue;    
                }
                else if (operation.equals("F")){
                    System.out.print("Shift amount(1-25): ");
                    int amount;
                    if (scanner.hasNextInt()){
                        amount = scanner.nextInt();
                        if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
                            System.out.println("Invalid amount");
                            continue;
                        }
                        else {
                            for (int i = 0; i < contents.length; i++){
                                contents[i] = shiftLineLettersForward(contents[i], amount);
                            }
                            continue;    
                        }
                    }
                    else {
                        System.out.println("Invalid amount");
                        scanner.next();
                        System.out.println();
                        continue;
                    }
                }
                else if (operation.equals("B")){
                    System.out.print("Shift amount(1-25): ");
                    int amount;
                    if (scanner.hasNextInt()){
                        amount = scanner.nextInt();
                        if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
                            System.out.println("Invalid amount");
                            continue;
                        }
                        else {
                            for (int i = 0; i < contents.length; i++){
                                contents[i] = shiftLineLettersBackward(contents[i],amount);
                            }
                            continue;
                        }
                    }
                    else {
                        System.out.println("invalid value");
                        scanner.next();
                        System.out.println();
                        continue;
                    }
                }
                else if (operation.equals("Q")){
                    for (int i = 0; i < contents.length; i++){
                        output.println(contents[i]);
                    }
                    output.close();
                    break;
                }
                else {
                    System.out.println("Invalid operation");
                    continue;
                }
            }
        }    
        else {
            System.out.print(args[1] + " exists - OK to overwrite (y,n)?: ");
            String response = scanner.next();
            if (response.startsWith("y") || response.startsWith("Y")){
                try {
                    output = new PrintWriter(new FileOutputStream(args[1]));
                }     
                catch (IOException e) {
                    System.out.println("Cannot create output file");
                    System.exit(1);
                } 
                try {
                    Scanner input3 = new Scanner(new FileInputStream(args[0]));
                    for (int i = 0; i < contents.length; i++){
                        contents[i] = input3.nextLine();
                    }
                }  
                catch (FileNotFoundException e) {
                    System.out.println("Unable to access input file: " + args[0]);
                    System.exit(1);
                }
                String operation = "";
                while (!operation.equals("Q")){
                    System.out.println();
                    System.out.println("Cipher - Please enter an operation below.");
                    System.out.println();
                    System.out.println("R - Reverse all lines");
                    System.out.println("F - Shift all letters forward");
                    System.out.println("B - Shift all letters backward");
                    System.out.println("Q - Quit");
                    System.out.println();
                    System.out.print("Operation: ");
                    operation = scanner.next().toUpperCase();
            
                    if (operation.equals("R")){
                        for (int i = 0; i < contents.length; i++){
                            contents[i] = reverseLine(contents[i]);
                        }
                        continue;    
                    }
                    else if (operation.equals("F")){
                        System.out.print("Shift amount(1-25): ");
                        int amount;
                        if (scanner.hasNextInt()){
                            amount = scanner.nextInt();
                            if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
                                System.out.println("Invalid amount");
                                continue;
                            }
                            else {
                                for (int i = 0; i < contents.length; i++){
                                    contents[i] = shiftLineLettersForward(contents[i], amount);
                                }
                                continue;    
                            }
                        }
                        else {
                            System.out.println("Invalid amount");
                            scanner.next();
                            System.out.println();
                            continue;
                        }
                    }
                    else if (operation.equals("B")){
                        System.out.print("Shift amount(1-25): ");
                        int amount;
                        if (scanner.hasNextInt()){
                            amount = scanner.nextInt();
                            if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
                                System.out.println("Invalid amount");
                                continue;
                            }
                            else {
                                for (int i = 0; i < contents.length; i++){
                                    contents[i] = shiftLineLettersBackward(contents[i],amount);
                                }
                                continue;
                            }
                        }
                        else {
                            System.out.println("invalid value");
                            scanner.next();
                            System.out.println();
                            continue;
                        }
                    }
                    else if (operation.equals("Q")){
                        for (int i = 0; i < contents.length; i++){
                            output.println(contents[i]);
                        }
                        output.close();                        
                        break;
                    }
                    else {
                        System.out.println("Invalid operation");
                        continue;
                    }
             
                } 
                
            }
            else {
                System.exit(1);
            }
        }
    }
    
    /** 
     * reverses the string order 
     * @param line that will be reverse 
     * @return reversed string 
     * @throws IllegalArgumentException if the line is null
     */ 
    public static String reverseLine(String line){
        if (line == null){
            throw new IllegalArgumentException("Invalid line");
        }    
        String reversed = "";
        for (int i = line.length() - 1; i >= 0; i--){
            reversed += line.charAt(i);
        }
        return reversed;
    }
    
    /** 
     * shifts the letters in the string line forward by the specified amount 
     * @param line that will be shifted forward
     * @param amount to shift the letters forward by
     * @return shifted forward line
     * @throws IllegalArgumentException if the line in null
     * @throws IllegalArgumentException if the amount is less than 1 or greater than 25
     */
    public static String shiftLineLettersForward(String line, int amount){
        if (line == null){
            throw new IllegalArgumentException("Invalid line");
        }    
        else if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
            throw new IllegalArgumentException("Invalid amount");
        }
        
                
        String shiftForward = "";
        for (int i = 0; i < line.length(); i++){
            if (Character.isLetter(line.charAt(i))){
                char c = line.charAt(i);
                if ((c >= 'A' && c <= 'Z') && 
                    (((char)(c + amount) >= 'A' && (char)(c + amount) <= 'Z'))){
                    shiftForward += (char)(c + amount);       
                }
                else if (c >= 'a' && c <= 'z' 
                         && ((char)(c + amount) >= 'a' &&  (char)(c + amount) <= 'z')){
                    shiftForward += (char)(c + amount);              
                }
                else {
                    if ((char)(c + amount) >= 'z'){
                        c = (char)((c + amount) % 'z' + 'a' - 1);  
                    } 
                    else {
                        c = (char)((c + amount) % 'Z' + 'A' - 1);  
                    }
                    shiftForward += c;
                }        
            }
            else {
                shiftForward += line.charAt(i);    
            }
        }
        return shiftForward;
    }
    
    
    /**
     * shifts the line backwards by the specified amount
     * @param line that will be shifted backwards
     * @param amount to shift the letters backward by
     * @return shifted backwards line
     * @throws IllegalArgumentException if the line is null
     * @throws IllegalArgumentException if the amount is less than 1 or greater than 25
     */ 
    public static String shiftLineLettersBackward(String line, int amount){
        if (line == null){
            throw new IllegalArgumentException("Invalid line");
        }    
        else if (amount < 1 || amount > MAX_SHIFT_AMOUNT){
            throw new IllegalArgumentException("Invalid amount");
        }
        
                
        String shiftBackward = "";
        for (int i = 0; i < line.length(); i++){
            if (Character.isLetter(line.charAt(i))){
                char c = line.charAt(i);
                if ((c >= 'A' && c <= 'Z') && 
                    (((char)(c - amount) >= 'A' && (char)(c - amount) <= 'Z'))){
                    shiftBackward += (char)(c - amount);       
                }
                else if (c >= 'a' && c <= 'z' 
                         && ((char)(c - amount) >= 'a' &&  (char)(c - amount) <= 'z')){
                    shiftBackward += (char)(c - amount);              
                }
                else {
                    if ((char)(c - amount) <= 'A'){
                        c = (char)('Z' - ('A' % (c - amount)) + 1); 
                    } 
                    else {
                        c = (char)('z' - ('a' % (c - amount)) + 1); 
                    }
                    shiftBackward += c;
                }        
            }
            else {
                shiftBackward += line.charAt(i);    
            }
        }
        return shiftBackward;
    }
    
}