package hamming

class Hamming {

    def distance(String strand1, String strand2) {
        validateStrands(strand1, strand2)
        return (0..<strand1.size()).count { index ->
            strand1[index] != strand2[index]
        }
    }

    private def validateStrands(String strand1, String strand2) {
        if (strand1.length() != strand2.length()) {
            throw new ArithmeticException()
        }
        if (strand1.isEmpty() && !strand2.isEmpty()) {
            throw new ArithmeticException()
        }
        if (!strand1.isEmpty() && strand2.isEmpty()) {
            throw new ArithmeticException()
        }
    }

}
