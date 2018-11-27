import java.util.Scanner;

public class HalfACookie_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            double radius = sc.nextDouble();
            double xStrike = sc.nextDouble();
            double yStrike = sc.nextDouble();
            double distanceFromOrigin = Math.sqrt(xStrike*xStrike + yStrike*yStrike);
            /**
             * strike point is
             * outside the circle
             */
            if(distanceFromOrigin > radius) {
                System.out.println("miss");
                /**
                 * skip over the rest of the
                 * code for this iteration
                 */
                continue;
            }

            final double pi = Math.PI;
            double totalArea = pi * radius * radius;

            /**
             * the angle formed by the radius and
             * the chord at the boundary of the circle
             */
            double angleAtChord = Math.asin(distanceFromOrigin/radius);
            double angleAtCentre = pi - 2*angleAtChord;
            /**
             * chordLength = 2*(base of half-triangle)
             * base of half-triangle = sqrt(radius^2 - distanceFromOrigin^2)
             */
            double chordLength = 2*(Math.sqrt(Math.pow(radius, 2) - Math.pow(distanceFromOrigin, 2)));

            double areaOfSector = (angleAtCentre/(2*pi)) * totalArea;
            double areaOfTriangle = 0.5 * chordLength * distanceFromOrigin;

            double areaSmallerPiece = areaOfSector - areaOfTriangle;
            double areaBiggerPiece = totalArea - areaSmallerPiece;
            System.out.println(areaBiggerPiece + " " + areaSmallerPiece);
        }
        sc.close();
    }
}