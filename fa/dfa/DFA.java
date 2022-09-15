package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    private DFAState startState;
    private Set<DFAState> states;

    @Override
    public void addStartState(String name) {
        this.startState = new DFAState(name, true, false);
        this.states.add(startState);
    }

    @Override
    public void addState(String name) {
        DFAState state = new DFAState(name, false, false);
        this.states.add(state);
    }

    @Override
    public void addFinalState(String name) {
        DFAState finalState = new DFAState(name, false, true);
        this.states.add(finalState);
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public State getStartState() {
        // TODO Auto-generated method stub
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
