package A5.Q3;

class Person {
    String name;
    int NSN;

    public Person(String name_new, int NSN){
        this.name = name_new;
        this.NSN = NSN;
    }

    String getName(){
        return this.name;
    }

    int getSSN(){
        return this.NSN;
    }
}