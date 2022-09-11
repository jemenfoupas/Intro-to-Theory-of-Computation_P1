package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    private DFAState startState;
    private DFAState endState;
    private Set<DFAState> states;
    // neet to have a set of stattes and a set of end states

    @Override
    public void addStartState(String name) {
        this.startState = new DFAState(name);
        this.states.add(startState);
    }

    @Override
    public void addState(String name) {
        DFAState startState = new DFAState(name);
        this.states.add(startState);
    }

    @Override
    public void addFinalState(String name) {
        this.endState = new DFAState(name);
        this.states.add(endState);
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        // TODO Auto-generated method stub
        
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
