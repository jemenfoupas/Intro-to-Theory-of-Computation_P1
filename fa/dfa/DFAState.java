package fa.dfa;

import java.util.HashMap;

import javax.print.attribute.HashDocAttributeSet;

import fa.State;

public class DFAState extends State {

    private HashMap<Character, String> transitions;

    public DFAState(String name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    public String getTransitions(char Character) {
        String nextState = transitions.get(Character);
        return nextState;
    }

    public void addTransitions(){

    }

    
}
