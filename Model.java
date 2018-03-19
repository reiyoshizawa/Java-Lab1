package Lab1;

/**
 * @author Rei Yoshizawa on 2018-03-16
 */

public class Model {

    /**
     * instances
     */
    private String firstName;
    private String lastName;
    private int height;
    private int inches;
    private int feet;
    private double weight;
    private long kilograms;
    private double pounds;
    private boolean canTravel;
    private boolean smokes;
    private static String occupation = "modeling";

    public static final int INCHES_PER_FOOT = 12;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    /**
     * construtor
     */
    public Model(){
    }

    /**
     * constructor for calling setFirstName, setLastName, setHeight,
     * setHeight, setCanTravel, setSmokes
     *
     * @param firstName
     * @param lastName
     * @param inches
     * @param pounds
     * @param canTravel
     * @param smokes
     */
    public Model(String firstName,
                 String lastName,
                 int inches,
                 double pounds,
                 boolean canTravel,
                 boolean smokes
                 ){
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(inches);
        setWeight(pounds);
        setCanTravel(canTravel);
        setSmokes(smokes);
    }

    /**
     **
     * constructor for calling setCanTravel(true), setSmokes(false)
     *
     * @param firstName
     * @param lastName
     * @param inches
     * @param pounds
     */
    public Model(String firstName,
                 String lastName,
                 int inches,
                 double pounds){
        setCanTravel(true);
        setSmokes(false);
    }

    /**
     * method
     */

    /**
     *
     * @return firstName
     */
    public String getFirstName(){
        return  firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName(){
        return  lastName;
    }

    /**
     *
     * @return height
     */
    public int getHeightInches(){
        return  height;
    }

    /**
     *
     * @return weight
     */
    public double getWeightPounds(){
        return  weight;
    }

    /**
     *
     * @return If condition shows feet and inch properly (ex. feet, feet 1 inch, feet inches)
     */
    public String getHeightInFeetAndInches(){
        int feet = height / INCHES_PER_FOOT;
        int inch = height % INCHES_PER_FOOT;

        if (inch == 0){
            return height + " feet";
        } else if (inch == 1){
            return height + " feet 1 inch";
        } else {
            return feet + " feet " + inch + " inches";
        }
    }

    /**
     *
     * @return this method calculates pounds to kg
     */
    public long getWeightKg(){
       long kg = (Math.round(weight * 0.453592));
       return kg;
    }

    /**
     *
     * @return occupation
     *
     */
    public static String getOccupation(){
        return occupation;
    }

    /**
     * if firstName has more than 3 letters and also less than 20 letters
     * parameter firstName will show
     *
     * @param firstName
     */
    public final void setFirstName(String firstName) {
        if ((firstName != null) && (firstName.length() >= 3) && (firstName.length() <= 20)) {
            this.firstName = firstName;
        }
    }

    /**
     * set lastname
     *
     * @param lastName
     */
    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * if pounds is more than 80, less than 280
     * parameter pounds will show
     *
     * @param pounds
     */
    public final void setWeight(double pounds){
        if (pounds >= 80 && pounds <= 280) {
            this.weight = pounds;
        }
    }

    /**
     * set kilograms
     *
     * @param kilograms
     */
    public final void setWeight(long kilograms){
        this.weight = kilograms;
    }

    /**
     * set feet inches for height
     *
     * @param feet
     * @param inches
     */
    public final void setHeight(int feet, int inches){
        this.height = feet + inches;
    }

    /**
     * if height inches is taller than 24, shorter than 84
     * parameter inches will show
     *
     * @param inches
     */
    public final void setHeight(int inches){
        if (inches >= 24 && inches <= 84) {
            this.height = inches;
        }
    }

    /**
     * set canTravel
     *
     * @param canTravel
     */
    public final void setCanTravel(boolean canTravel){
        this.canTravel = canTravel;
    }

    /**
     * set smokes
     *
     * @param smokes
     */
    public final void setSmokes(boolean smokes){
        this.smokes = smokes;
    }

    /**
     * this method prints first name last name, height(inches), weight(pounds),
     * also travel and smoke information
     */
    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInches() + " inches");
                System.out.println("Weight: " + Math.round(getWeightPounds()) + " pounds");
        if(canTravel){
            System.out.println("Does travel ");
        }else{
            System.out.println("Does not travel ");
        }
        if(smokes){
            System.out.println("Does smoke ");
        }else{
            System.out.println("Does not smoke ");
        }
    }

    /**
     * this method shows base hours salary depends on height and weight
     *
     * @param height height in inches
     * @param weight
     * @return
     */
    public int calculatePayDollarsPerHour(int height, double weight){
        if (TALL_INCHES <= height && THIN_POUNDS > weight){
            return  BASE_RATE_DOLLARS_PER_HOUR +
                    TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        } else if (canTravel) {
            return BASE_RATE_DOLLARS_PER_HOUR +
                    TRAVEL_BONUS_DOLLARS_PER_HOUR;
        } else if (smokes) {
            return BASE_RATE_DOLLARS_PER_HOUR -
                    SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        } else {
            return BASE_RATE_DOLLARS_PER_HOUR;
        }
    }

    /**
     * this method prints first name last name, height(inches), weight(pounds),
     * also travel and smoke information plus hourly salary rate
     */
    public void displayModelDetails(){
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInFeetAndInches());
        System.out.println("Weight: " + getWeightPounds() + " pounds");
        if(canTravel){
            System.out.println("Travels: yep");
        }else{
            System.out.println("Travels: nope");
        }
        if(smokes){
            System.out.println("Smokes: yep");
        }else{
            System.out.println("Smokes: nope");
        }
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour(height, weight));
    }

    /**
     * this method prints first name last name, height(cm), weight(kg),
     * also travel and smoke information plus hourly salary rate
     *
     * @param metricUnits
     */
    public void displayModelDetails(boolean metricUnits) {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        int centimeter = (int) Math.round(height * 2.54);
        if (metricUnits) {
            System.out.println("Height: " + centimeter + " cm");
        } else {
            System.out.println("Height: " + getHeightInFeetAndInches());
        }

        if (metricUnits) {
            System.out.println("Weight: " + getWeightKg() + " kg");
        } else {
            System.out.println("Weight: " + getWeightPounds() + " pounds");
        }

        if (canTravel) {
            System.out.println("Travels: yep");
        } else {
            System.out.println("Travels: nope");
        }
        if (smokes) {
            System.out.println("Smokes: yep");
        } else {
            System.out.println("Smokes: nope");
        }
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour(height, weight));
    }


}
