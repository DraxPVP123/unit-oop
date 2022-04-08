public class State implements Comparable<State>
{
    private String stateName;
    private String stateCapital;
    private String stateFlower;
    private String stateBird;
    private int statePopulation;

    public State() {
        stateName = "";
        stateCapital = "";
        stateFlower = "";
        stateBird = "";
        statePopulation = 0;
    }
    public State(String sn, String sc, String sf, String sb, int sp)
    {
        setStateName(sn);
        setStateBird(sb);
        setStateCapital(sc);
        setStateFlower(sf);
        setStatePopulation(sp);
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String sn) {
        stateName = sn;
    }
    public String getStateCapital() {
        return stateCapital;
    }
    public void setStateCapital(String sc) {
        stateCapital = sc;
    }
    public String getStateFlower() {
        return stateFlower;
    }
    public void setStateFlower(String sf) {
        stateFlower = sf;
    }
    public String getStateBird() {
        return stateBird;
    }
    public void setStateBird(String sb) {
        stateBird = sb;
    }
    public int getStatePopulation() {
        return statePopulation;
    }
    public void setStatePopulation(int sp) {
        if (sp < 0) {
            throw new IllegalArgumentException("Invalid population. It cannot be negative silly!");
        } else
        this.statePopulation = sp;
    }
    public String toString() {
        String ans = "State Name: " + stateName + "\n" + "State's Capital: " + stateCapital + "\n" + "State Flower: " +
                stateFlower + "\n" + "State Bird: " + stateBird + "\n" + "State Population: " + statePopulation + "\n";
        return ans;
    }
    public boolean equals(Object s) {
        return this.compareTo((State)s) == 0;
    }
    public int compareTo(State s){
        return stateName.compareToIgnoreCase(s.getStateName());
    }
}