package acronym

class Acronym {

    static String abbreviate(String phrase) {
        def listOfWordsWithLetters = phrase.split(/[\s-]+/).findAll { it ->
            it =~ /[a-zA-Z]/
        }
        StringBuilder sb = new StringBuilder()
        listOfWordsWithLetters.each { String word ->
            def firstAlpha  = word.find(/[a-zA-Z]/)
            sb.append(firstAlpha)
        }
        return sb.toString().toUpperCase()
    }

}
