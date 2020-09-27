package Service.Input;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public final class InputArea {
    private static Scanner sc = GetterScanner.getSc();

    public static String getUsername() {
        String userStringInput = null;
        while (true) {
            userStringInput = sc.next();
            if (userStringInput.matches("\\d{0,3}")) {
                System.out.println("username must more than 3 character");
                continue;
            } else {
                break;
            }
        }
        return userStringInput;

    }

    public static String getPassword() {
        String userStringInput = sc.next();
        return userStringInput;
    }

    public static int getMenuNumber(int n) {
        int number;
        do {
            System.out.println("Please enter a in number range 0 to " + n);
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
        } while (number <= 0 && number >= n);
        return number;
    }

    public static String getNationalCode(){
        return sc.next();
    }

    public static Date getDate(){
        System.out.println("Choose your Date (in format yyyy-MM-dd) : ");
        String sDate = null;
        while (!(sDate = sc.next()).matches("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println("your format is not correct please try again :");
            sDate = sc.next();
            if(sDate.matches("\\d{4}-\\d{2}-\\d{2}")){
                break;
            }
        }
        LocalDate localDate = LocalDate.parse(sDate);
        return Date.valueOf(localDate);
    }

    public static String getText() {
        System.out.println("please when you want stop typing type \"/end\"");
        String text = "";
        while (sc.next() != "/end"){
            String newText = sc.next();
            text = text + newText;
        }
        return text;
    }

    public static Boolean getBool(){
        String ch;
        do{
        System.out.println("Please Enter Y/y or N/n (Y/y for Yes and N/n for No)");
        while(!sc.hasNext("\\w")){
            System.out.println("please enter Y/y or N/n");
        }
        ch = sc.next();
        }while (!(ch.equals("y") || ch.equals("Y") || ch.equals("n") || ch.equals("N")));
        if(ch.toUpperCase().equals("Y")){
            return true;
        }else{
            return false;
        }
    }
}
