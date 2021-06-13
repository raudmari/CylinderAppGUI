/**
 * klass Circle on ringi objek, mis tehakse raadiuse või diameetri baasil. isRadius parameetrist (true on raadius ja false on diameeter).
 */
public class Circle {

    private final double radius;

    /**
     * @param radius   objekti tegemisel kaasa andtud ringi raadius
     * @param isRadius true on raadius ja false on diameeter
     */

    public Circle(double radius, boolean isRadius) {
        if (!isRadius) {
            this.radius = radius / 2;  // Diameeter jagastud 2
        } else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Tagastab diameetri
     *
     * @return diameter double type
     */

    public double getDiameter() {
        return 2 * radius;
    }

    /**
     * @return tagastab pindala
     */

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * @return tagastab perimeetri ehk ümbermõõdu
     */

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Sisseehitatud meetodi toSting() enda jaoks sobivaks kohandamine.
     *
     * @return kirjutame kõik meetodid ühte stringi(tagstab kogu info raadius, diameeter, pindala ja ümbermõõt).
     */
    @Override
    public String toString() {
        return "r = " + radius + " d = " + getDiameter() + " S = " + getArea() + " P = " + getPerimeter();
    }
}
