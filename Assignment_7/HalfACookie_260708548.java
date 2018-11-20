import java.util.Scanner;

public class HalfACookie_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            double radius = sc.nextDouble();
            double xStrike = sc.nextDouble();
            double yStrike = sc.nextDouble();
            double distanceFromOrigin = Math.sqrt(xStrike*xStrike + yStrike*yStrike);
            if(distanceFromOrigin > radius) {
                System.out.println("miss");
                continue;
            }

            final double pi = Math.PI;
            double totalArea = pi * radius * radius;

            double angleAtChord = Math.asin(distanceFromOrigin/radius);
            // System.out.println(angleAtChord);
            double angleAtCentre = pi - 2*angleAtChord;
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