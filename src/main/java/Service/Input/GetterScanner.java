package Service.Input;

import java.util.Scanner;

public final class GetterScanner {
    private static Scanner sc = new Scanner(System.in);
    private static GetterScanner getterScanner = new GetterScanner();


    private GetterScanner(){}

    public static Scanner getSc() {
        return getterScanner.sc;
    }
}
