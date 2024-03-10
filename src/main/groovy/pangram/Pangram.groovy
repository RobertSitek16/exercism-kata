package pangram

class Pangram {

    static boolean isPangram(String sentence) {
        return sentence.toLowerCase().collect { it as Character }.containsAll(getAllChars())
    }

    static def getAllChars() {
        List<Character> allChars = (97..<123).collect { it as Character }
        return allChars
    }

}
