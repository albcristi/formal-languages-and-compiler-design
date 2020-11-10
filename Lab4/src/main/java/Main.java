import model.FiniteAutomata;
import model.MyScanner;
import ui.CommandLineUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        System.out.println("1 - Run FA");
        System.out.println("2 - Run Scanner");
        System.out.println("Give command");
        try {
            command = reader.readLine();
        }
        catch (Exception e){
            System.exit(0);
        }
        if(command.equals("1")){
            lab4();
            System.exit(0);
        }
        try {
            System.out.println("Enter program location:");
            String filePath = reader.readLine();
            MyScanner scanner = new MyScanner(filePath);
            scanner.scan();
        }
        catch (Exception e){
            System.out.println("MAKE SURE FILE PATH IS GOOD");
            System.out.println("Other remarks");
            System.out.println(e.getMessage());
        }
    }

    private static void lab4(){
        FiniteAutomata fa = new FiniteAutomata("./fa.in");
        CommandLineUI ui = new CommandLineUI(fa);
        ui.run();
    }
}
