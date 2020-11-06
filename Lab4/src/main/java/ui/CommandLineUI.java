package ui;

import model.AutomataTransition;
import model.FiniteAutomata;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineUI {
    private FiniteAutomata fa;

    public CommandLineUI(FiniteAutomata a){
        fa=a;
    }


    public void showCommands(){
        System.out.println("1 - Show states");
        System.out.println("2 - Show alphabet");
        System.out.println("3 - Show transitions");
        System.out.println("4 - Show final states");
        System.out.println("5 - Show initial state");
        System.out.println("6 - Read new FA");
        System.out.println("7 - Is DFA");
        System.out.println("8 - Sequence is accepted by FA");
        System.out.println("x - Exit");
    }

    private void comm1(){
        System.out.println("Existing states");
        for(String state: fa.getStates())
            System.out.println(state);
    }

    private void comm2(){
        System.out.println("Alphabet");
        for(String al: fa.getAlphabet())
            System.out.println(al);
    }

    private void comm3(){
        System.out.println("Transitions");
        for(AutomataTransition tr: fa.getTransitionFunction()){
            System.out.println("From"+tr.startState+" to "+tr.endState+" with value "+tr.transitionValue);
        }
    }

    private void comm4(){
        System.out.println("Final states:");
        for(String st: fa.getFinalStates())
            System.out.println(st);
    }

    private void comm5(){
        System.out.println("Initial state:");
        System.out.println(fa.getInitialState());
    }

    private void comm7(){
        String message = fa.isDFA() ? "is a DFA" : "is not a DFA";
        System.out.println("The introduced FA "+message);
    }

    private void comm8(){
        if(!fa.isDFA()){
            System.out.println("FA needs to be a DFA");
            return;
        }

        try{
            BufferedReader r =  new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter sequence");
            String sequence = r.readLine();
            String message  = fa.isAccepted(sequence) ? "Sequence is accepted" : "Sequence is not accepted";
            System.out.println(message);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void run(){
        while (true){
            try{
                showCommands();
                String command = "";
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter command: ");
                command = reader.readLine();
                switch(command)
                {
                    case "1":
                        comm1();
                        break;
                    case "2":
                        comm2();
                        break;
                    case "3":
                        comm3();
                        break;
                    case "4":
                        comm4();
                        break;
                    case "5":
                        comm5();
                        break;
                    case "6":
                        comm6();
                        break;
                    case "7":
                        comm7();
                        break;
                    case "8":
                        comm8();
                        break;
                    case "x":
                        System.exit(0);
                    default:
                        throw new Exception("Invalid command!");
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void comm6() {
        try{
            BufferedReader r =  new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new FA file location");
            String location = r.readLine();
            fa = new FiniteAutomata(location);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
