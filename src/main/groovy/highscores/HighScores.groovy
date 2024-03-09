package highscores

class HighScores {

    List scores

    HighScores(def scores) {
        this.scores = scores
    }

    def latest() {
        return scores[scores.size() - 1]
    }

    def personalBest() {
        return scores.max()
    }

    def personalTopThree() {
        List temp = scores.collect { it }
        List personalTopThree = temp.sort().reverse()
        return personalTopThree.size() <= 3 ? personalTopThree : personalTopThree.subList(0, 3)
    }

}
