package finalsection;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        hello("Sudip",null, value ->{
            System.out.println("no lastname provided for "+value);
        });

        hello2("Sudip",null, () ->{
            System.out.println("no lastname provided");
        });
    }

    static void hello(String fName, String lName, Consumer<String> callBack) {

        System.out.println(fName);
        if(lName!=null){
            System.out.println(lName);
        }else {
            callBack.accept(fName);
        }
    }

    static void hello2(String fName, String lName, Runnable callBack) {

        System.out.println(fName);
        if(lName!=null){
            System.out.println(lName);
        }else {
            callBack.run();
        }
    }

    /*function hello(firstName, lastName, callback){
        console.log(firstName);
        if(lastName) {
            console.log(lastName);
        }else{
            callback();
        }
    }*/
}
