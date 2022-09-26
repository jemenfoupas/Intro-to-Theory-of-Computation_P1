package fa.dfa;

import java.util.HashMap;


import fa.State;

public class DFAState extends State {

    private HashMap<Character, String> transitions;
    private boolean startState;
    private boolean finalState;

    // should add a variable in the dfastate class that 
    // tell if the state is an final state
    public DFAState(String name, boolean isStartState, boolean isFinalState) {
        this.name = name;
        this.startState = isStartState;
        this.finalState = isFinalState;
        transitions = new HashMap<>();
    }

    public String getTransitions(char Character) {
        String nextState = transitions.get(Character);
        return nextState;
    }

    public void addTransition(char onSymb, String toState){
        transitions.put(onSymb, toState);
    }

    public String getName() {
        return this.name;
    }

    public boolean isStartState() {
        return startState;
    }

    public boolean isFinalState() {
        return finalState;
    }

    public void setFinalState(boolean b){
        this.finalState = b;
    }
    
}
