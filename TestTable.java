package A5.Q3;

import java.util.*;
import java.util.Scanner;

public class TestTable {
    public static SSNTable new_table = new SSNTable();
    
    public static int hash(String name){
        String values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int name_value = 0;
        for(int i = 0; i<name.length(); i++){
            for(int j = 0; j<values.length(); j++){
                if(name.charAt(i) == values.charAt(j)){
                    name_value += j+1;
                }
            }
        }
        return (name_value) % 31;
    }

    public static void StartProgram(){
        Scanner in = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter a name below: ");
        String name = in.nextLine();
        System.out.println("Please Enter a Social Security Number below: ");
        int number = s.nextInt();
        while(Integer.toString(number).length() != 9){
            System.out.println("Oops! Please enter a valid Social Security Number again - 9 Digits:");
            number = s.nextInt();
        }
        new_table.put(new Person(name, number));
        System.out.println("Continue? Y/N");
        String temp = in.nextLine();
        while(temp.equals("Y")){
            StartProgram();
        }
        System.out.println("The table info is shown below: ");
        new_table.display_Table(); 
        System.exit(0);
    }
    public static void main(String[] args) {
        StartProgram();
    }
}
