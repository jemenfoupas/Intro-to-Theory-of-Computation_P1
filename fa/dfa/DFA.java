package fa.dfa;

import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    private Set<DFAState> states;
    private Set<Character> sigma;

    /**
     * instance the instance variables
     */
    public DFA (){
        this.states = new HashSet<>();
        this.sigma = new HashSet<>();
    }

    @Override
    public void addStartState(String name) {
        this.states.add(new DFAState(name, true, false));
    }

    @Override
    public void addState(String name) {
        this.states.add(new DFAState(name, false, false));
    }

    @Override
    public void addFinalState(String name) {
        this.states.add(new DFAState(name, false, true));
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        for(DFAState state : states) {
            if(state.getName().equals(fromState)) {
                state.addTransition(onSymb, toState);
            }
        }
        if(!sigma.contains(onSymb)){
            sigma.add(onSymb); //adds symbol to sigma if not already added
        }
    }

    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        Set<DFAState> rtVal = new HashSet<DFAState>(); //return value
        for(DFAState d : this.states){ //check all states
            if(d.isFinalState()){
                rtVal.add(d); //add state to return value if final
            }
        }
        return rtVal;
    }

    @Override
    public DFAState getStartState() {
        for(DFAState d : this.states){ // check all states
            if(d.isStartState()){
                return d; //return when start state is found
            }
        }
        return null; //return null if there is no start state
    }

    @Override
    public Set<Character> getABC() {
        return sigma; //return sigma
    }

    @Override
    public boolean accepts(String s) {
        DFAState curr = this.getStartState(); //start at start state
        for(int i=0; i<s.length(); i++){ //for every character
            curr = (DFAState) this.getToState(curr, s.charAt(i)); //go to next transition
        }
        if(curr.isFinalState()){
            return true; //return true if last state is final state
        }
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        DFAState rtVal = null;
        String nextName = from.getTransitions(onSymb); //get name of next state
        for(DFAState d : states){
            if(d.getName().equals(nextName)){
                rtVal = d;
            }
        }
        return rtVal;
    }

}
