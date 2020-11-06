package model;

import com.sun.tools.javac.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FiniteAutomata {


    private List<String> states;
    private List<String> alphabet;
    private String initialState;
    private List<String> finalStates;
    private List<AutomataTransition> transitionFunction;

   public FiniteAutomata(String pathToAutomata){
        readFA(pathToAutomata);
   }

   private void readFA(String filePath){
       try{
           // first line
           BufferedReader reader = new BufferedReader(new FileReader(filePath));
           // first line = set of states  separated by ,
           String line = reader.readLine();
           states = Arrays.asList(line.split(","));
           line = reader.readLine();
           // second line: alphabet
           alphabet = Arrays.asList(line.split(","));
           // third line: init state
           initialState = reader.readLine();
           // fourth line: final states
           line = reader.readLine();
           finalStates = Arrays.asList(line.split(","));
           //next lines:
           // transitions of form: state,state,alphabet value
           transitionFunction = new ArrayList<>();
           while (true){
               line = reader.readLine();
               if(line==null || line.equals(""))
                   break;
               List<String> transition = Arrays.asList(line.split(","));
               AutomataTransition  automataTransition = new AutomataTransition();
               automataTransition.startState = transition.get(0);
               automataTransition.endState = transition.get(1);
               automataTransition.transitionValue = transition.get(2);
               transitionFunction.add(automataTransition);
           }
           reader.close();
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }

   }


    @Override
    public String toString() {
        return "FiniteAutomata{" +
                "states=" + states +
                ", alphabet=" + alphabet +
                ", initialState='" + initialState + '\'' +
                ", finalStates=" + finalStates +
                ", transitionFunction=" + transitionFunction +
                '}';
    }


    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public List<String> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(List<String> finalStates) {
        this.finalStates = finalStates;
    }

    public List<AutomataTransition> getTransitionFunction() {
        return transitionFunction;
    }

    public void setTransitionFunction(List<AutomataTransition> transitionFunction) {
        this.transitionFunction = transitionFunction;
    }


    public Boolean isDFA(){
        HashMap<Pair<String, String>, Integer> map = new HashMap<>();
        for(AutomataTransition transition: transitionFunction)
            map.put(new Pair<>(transition.startState, transition.transitionValue),0);
        for(AutomataTransition transition: transitionFunction) {
            if (map.get(new Pair<>(transition.startState, transition.transitionValue))==1)
                return false;
            map.put(new Pair<>(transition.startState, transition.transitionValue),1);
        }
        return true;
    }

    private List<AutomataTransition> transitionsOf(String startState){
       List<AutomataTransition> tr = new ArrayList<>();
       for(AutomataTransition t: transitionFunction)
           if(t.startState.equals(startState))
               tr.add(t);
       return tr;
    }

    private String nextState(String startState, String value){
       for(AutomataTransition tr: transitionsOf(startState))
           if(tr.transitionValue.equals(value))
               return tr.endState;
       return "invalid-state";
    }


    public boolean isAccepted(String seq){
       String currentState = initialState;
       Integer index = 0;
       while (index < seq.length()) {
           String chValue = seq.charAt(index) + "";
           String nextState = nextState(currentState, chValue);
           if(nextState.equals("invalid-state"))
               return false;
           currentState = nextState;
           index++;
       }
        return finalStates.toString().contains(currentState);
    }

}
