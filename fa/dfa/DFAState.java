package fa.dfa;

import java.util.HashMap;


import fa.State;

/**
 * DFAState class represents a state that is part of the DFA class
 * @author Rich Boundji & Ethan Raygor
 */
public class DFAState extends State {

    private HashMap<Character, String> transitions; // map of characters to strings representing states outgoing transitions
    private boolean startState; // boolean for if state is start state
    private boolean finalState; // boolean for if state is a final state

    /**
     * Constructor for DFAState
     * @param name String name of state
     * @param isStartState boolean determining if state is start state
     * @param isFinalState boolean determining if state is a final state
     */
    public DFAState(String name, boolean isStartState, boolean isFinalState) {
        this.name = name;
        this.startState = isStartState;
        this.finalState = isFinalState;
        transitions = new HashMap<>();
    }

    /**
     * returns name of state resulting from transition on a symbol
     * @param Character char transition symbol
     * @return String name of resulting state
     */
    public String getTransitions(char Character) {
        String nextState = transitions.get(Character);
        return nextState;
    }

    /**
     * Adds a transition to the state
     * @param onSymb char symbol for transition to be added
     * @param toState String name of state that transition ends on
     */
    public void addTransition(char onSymb, String toState){
        transitions.put(onSymb, toState);
    }

    /**
     * returns name of state 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns true if state is a start state
     * @return boolean
     */
    public boolean isStartState() {
        return startState;
    }

    /**
     * returns true if state is a final state
     * @return boolean
     */
    public boolean isFinalState() {
        return finalState;
    }

    /**
     * Set state to final state or not
     * @param b boolean
     */
    public void setFinalState(boolean b){
        this.finalState = b;
    }

    /**
     * Set state to start state or not
     * @param b boolean
     */
    public void setStartState(boolean b){
        this.startState = b;
    }
    
}
