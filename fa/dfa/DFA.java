package fa.dfa;

import java.util.HashSet;
import java.util.Set;

import fa.State;

/**
 * DFA class that represents a deterministic finite automata
 * @author Rich Boundji & Ethan Raygor
 */
public class DFA implements DFAInterface {

    private Set<DFAState> states; // set of states in dfa
    private Set<Character> sigma; // set of symbols in language of dfa
    private DFAState qerror; //qerror state for if a bad transition is attempted


    /**
     * Constructor
     * instance the instance variables
     */
    public DFA (){
        this.states = new HashSet<>();
        this.sigma = new HashSet<>();

        qerror = new DFAState("qerror", false, false);
    }

    @Override
    public void addStartState(String name) {
        boolean alreadyExist = false;
        for(DFAState state : states) {
            if(state.getName().equals(name)){
                alreadyExist = true;
                state.setStartState(true);
            }
        }
        if(!alreadyExist) this.states.add(new DFAState(name, true, false));
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
            qerror.addTransition(onSymb, "qerror");
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
        if(s.equals("e")){ //check for empty string
            for(DFAState d : this.states){
                if(d.isStartState()){ //find start state
                    if(d.isFinalState()){
                        return true; //return true if also final state
                    }
                }
            }
            return false;
        }else{
            DFAState curr = this.getStartState(); //start at start state
            for(int i=0; i<s.length(); i++){ //for every character
                curr = (DFAState) this.getToState(curr, s.charAt(i)); //go to next transition
            }
            if(curr != null && curr.isFinalState()){
                return true; //return true if last state is final state
            }
            return false;
        }
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        DFAState rtVal = null;
        String nextName = from.getTransitions(onSymb); //get name of next state

        for(DFAState d : states){ 
            if(d.getName().equals(nextName)){ //find state with same name
                rtVal = d;
            }
        }
        if(rtVal == null) return qerror;
        return rtVal;
    }

    @Override
    public String toString(){
        String rtVal = ""; 
        rtVal += "Q = { "; //add set of states
        for(DFAState q : this.states){
            rtVal += q.getName()+" ";
        }
        rtVal += "}\n";
        rtVal += "Sigma = { "; //add set of accepted characters
        for(char c : sigma){
            rtVal += c+" ";
        }
        rtVal += "}\n";
        rtVal += "delta =\n\t\t"; //add transition table
        for(char c : sigma){
            rtVal += c+"\t";
        }
        rtVal += "\n";
        for(DFAState q : this.states){
            rtVal += "\t"+q.getName()+"\t";
            for(char c : sigma){
                rtVal += q.getTransitions(c)+"\t";
            }
            rtVal += "\n";
        }
        rtVal += "q0 = "; //add start state
        for(DFAState q : this.states){
            if(q.isStartState()){
                rtVal += q.getName()+"\n";
            }
        }
        rtVal += "F = { "; //add set of final states
        for(DFAState q : this.states){
            if(q.isFinalState()){
                rtVal += q.getName()+" ";
            }
        }
        rtVal += "}\n";
        return rtVal; //return
    }
}
