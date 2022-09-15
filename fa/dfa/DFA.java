package fa.dfa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    private Map<String, DFAState> states;
    private Set<Character> sigma;

    @Override
    public void addStartState(String name) {
        this.states.put(name, new DFAState(name, true, false));
    }

    @Override
    public void addState(String name) {
        this.states.put(name, new DFAState(name, false, false));
    }

    @Override
    public void addFinalState(String name) {
        this.states.put(name, new DFAState(name, false, true));
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        for(DFAState state : states.values()) {
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
        Set<DFAState> rtVal = new HashSet<DFAState>();
        for(String s : states.keySet()){
            rtVal.add(states.get(s));
        }
        return rtVal;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        Set<DFAState> rtVal = new HashSet<DFAState>(); //return value
        for(DFAState d : this.states.values()){ //check all states
            if(d.isFinalState()){
                rtVal.add(d); //add state to return value if final
            }
        }
        return rtVal;
    }

    @Override
    public DFAState getStartState() {
        for(DFAState d : this.states.values()){ // check all states
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
        DFAState curr = this.getStartState();
        for(int i=0; i<s.length(); i++){
            curr = (DFAState) this.getToState(curr, s.charAt(i));
        }
        if(curr.isFinalState()){
            return true;
        }
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        String nextName = from.getTransitions(onSymb);
        DFAState rtVal = this.states.get(nextName);
        return rtVal;
    }

}
