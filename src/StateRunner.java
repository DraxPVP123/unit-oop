import java.util.ArrayList;

public class StateRunner{
    public static void main(String[] args)
    {
        ArrayList<State> states = new ArrayList<State>();

        State s1 = new State("Maryland","Annapolis","Black-eyed Susan","Cardinal",1000000);
        State s2 = new State();
        //State s3 = new State("Maryland","Annapolis","Black-eyed Susan","Cardinal",-1);

        //Testing the Constructors
        System.out.println("Testing the Parameter Constructor: " + s1);
        System.out.println("Testing the Default Constructor: " + s2);
        //System.out.println("Testing the Negative Constructor: " + s3);

        //Testing Setters
        s2.setStateName("Alaska");
        s2.setStateCapital("Juneau");
        s2.setStateFlower("Forget-me-not");
        s2.setStateBird("Willow Ptarmigan");
        s2.setStatePopulation(600000);
        System.out.println("Testing the Setters: " + s2);

        //Testing Getters
        System.out.println("Testing getStateName(): " + s1.getStateName());
        System.out.println("Testing getStateCapital(): " + s1.getStateCapital());
        System.out.println("Testing getStateFlower(): " + s1.getStateFlower());
        System.out.println("Testing getStateBird(): " + s1.getStateFlower());
        System.out.println("Testing getStatePopulation(): " + s1.getStatePopulation());

        //Testing compareTo()
        System.out.println("Testing compareTo(), it should be 12: " + s1.compareTo(s2));
        System.out.println("Testing compareTo(), it should be -12: " + s2.compareTo(s1));
        System.out.println("Testing compare To(), it should be 0: " + s1.compareTo(s1));


        //Testing equals()
        System.out.println("Testing equals(), it should be false: " + s1.equals(s2));
        System.out.println("Testing equals(), it should be true: " + s1.equals(s1));
    }
}

