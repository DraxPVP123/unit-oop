public class Person implements Comparable<Person> {
    //instance attributes
    //These are values that describe an instance of this class
    //Attributes are private to control how the user of this class
    // can access the data stored in the attributes
    private String id;
    private String name;
    private String birthDay;
    public double salary;
    //private Date birthDay;

    // default constructor
    // This is the one way to declare an instance of the Person class/
    public Person(){
        id = "";
        name = "";
        birthDay = "";
    }
    // parameter constructor
    // This is another way to declare an instance of the Person class.
    // We can send values for the attributes using parameters.
    public Person(String i, String n, String bD){
        id = i;
        name = n;
        birthDay = bD;
    }
    // getters & setters
    //These are how we control the use of the data store in the attributes.
    // If you don't want the user of the class to be able to get a value
    // or set a value you would not have a getter or setter for it.
    // If you
    public String getId() {
        return id;
    }

    public void setId(String i) {
        id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String bD) {
        birthDay = bD;
    }
    // overridden methods
    // These methods override the toString and equals methods
    // in the Object class
    public String toString() {
        String ans = getClass().getName()+", id: " + id
                + ", name: " + name +", birthday: " + birthDay + "\n";
        return ans;
    }
    public boolean equals(Object o) {
        return id.equals(((Person) o).getId());
        //return (compareTo((Person) o) == 0);
    }
    // This implements the compareTo method in the Comparable interface
    public int compareTo(Person p){
        return (id.compareTo(p.getId()));
    }

    protected double getSalary() {
        return salary;
    }
}