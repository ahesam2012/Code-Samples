package A5.Q3;

import java.util.*;

public class SSNTable {
    private final int INITIAL_SIZE = 31;
    int actual_size;
    LinkedList<Person> TABLE[];
    
    
    public SSNTable(){
        TABLE = new LinkedList[INITIAL_SIZE];
        for(int i = 0; i<TABLE.length; i++){
            TABLE[i] = new LinkedList<Person>();
        }
        actual_size = 0;
    }

    public int hash(String name){
        String values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int name_value = 0;
        for(int i = 0; i<name.length(); i++){
            for(int j = 0; j<values.length(); j++){
                if(name.charAt(i) == values.charAt(j)){
                    name_value += j+1;
                }
            }
        }
        return (name_value) % TABLE.length;
    }

    void expand_table(){
        LinkedList<Person> table2[] = new LinkedList[TABLE.length * 2];
        for(int i = 0; i<TABLE.length; i++){
            if(TABLE[i] != null){
                table2[i] = TABLE[i];
            }
        }
        TABLE = table2;
    }

    void put(Person p){
        if(actual_size >= TABLE.length){
            expand_table();
        }
        TABLE[hash(p.getName())].add(p);
        actual_size++;
    }

    Person find_in_LinkedList(String name, LinkedList<Person> list){
        for(int i = 0; i<list.size(); i++){
            if(name.equals(list.get(i).getName()) == true){
                return list.get(i);
            }
        }
        return null;
    }

    Person findByName(String name){
        return find_in_LinkedList(name, TABLE[hash(name)]);
    }

    void show_people(LinkedList<Person> list){
        for(int i = 0; i<list.size(); i++){
            System.out.print((i+1) + ") Name: '" + list.get(i).getName() + "' SSN: '" + list.get(i).getSSN() + "', ");
        }
        System.out.println();
    }

    void display_Table(){
        int k = 1;
        for(int i = 0; i<TABLE.length; i++){
            if(TABLE[i] != null){
                System.out.print(k + ".   ");
                show_people(TABLE[i]);
                k++;
            }
            else {
                System.out.print(k + ".    ---");
                k++;
            }
        }
    }
}
