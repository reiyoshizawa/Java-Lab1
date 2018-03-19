package Lab1;

/**
 * @author Rei Yoshizawa on 2018-03-16
 */

/**
 * this main method call new property and several methods set in Medel.java
 * (printDetails, displayModelDetails, displayModelDetails etc)
 */
public class Driver {
    public static void main(String[] args) {
        Model rei = new Model("Rei", "Yoshizawa",
                50,80,true,true);
        rei.printDetails();
        rei.displayModelDetails();
        rei.displayModelDetails(true);

        Model ichiro = new Model("Ichiro", "Suzuki",
                70,120);
        ichiro.setSmokes(true);
        ichiro.setCanTravel(true);
    }
}
