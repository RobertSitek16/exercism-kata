package darts

class Darts {

    static int score(double x, double y) {
        double sumOfSquares = x**2 + y**2
        switch (sumOfSquares) {
            case { sumOfSquares <= 1**2 }: return 10
            case { sumOfSquares <= 5**2 }: return 5
            case { sumOfSquares <= 10**2 }: return 1
            default: return 0
        }
    }

}
