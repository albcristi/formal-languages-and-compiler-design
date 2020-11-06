package model;

public class AutomataTransition {
    public String startState;
    public String endState;
    public String transitionValue;


    @Override
    public String toString() {
        return "[startState='" + startState + '\'' +
                ", endState='" + endState + '\'' +
                ", transitionValue='" + transitionValue + '\''+"]";
    }
}
