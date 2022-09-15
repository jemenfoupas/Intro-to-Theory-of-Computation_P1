package fa.dfa;

import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    private Set<DFAState> states;

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
    }

    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        Set<DFAState> rtVal = new HashSet<DFAState>();
        for(DFAState d : this.states){
            if(d.isFinalState()){
                rtVal.add(d);
            }
        }
        return rtVal;
    }

    @Override
    public State getStartState() {
        for(DFAState d : this.states){
            if(d.isStartState()){
                return d;
            }
        }
        return null;
    }

    @Override
    public Set<Character> getABC() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        // TODO Auto-generated method stub
        return null;
    }

}
