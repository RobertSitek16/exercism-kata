package proteintranslation

class ProteinTranslation {

    private final static List STOP = ["UAA", "UAG", "UGA"]
    private final static Map<String, String> CODONS = [
            "AUG": "Methionine",
            "UUU": "Phenylalanine",
            "UUC": "Phenylalanine",
            "UUA": "Leucine",
            "UUG": "Leucine",
            "UCU": "Serine",
            "UCC": "Serine",
            "UCA": "Serine",
            "UCG": "Serine",
            "UAU": "Tyrosine",
            "UAC": "Tyrosine",
            "UGU": "Cysteine",
            "UGC": "Cysteine",
            "UGG": "Tryptophan"
    ]

    static proteins(String strand) {
        def splitStrand = strand.split("(?<=\\G.{3})").toList()
        def protein = []
        for (String s : splitStrand) {
            if (STOP.contains(s)) {
                break
            } else if (CODONS.containsKey(s)) {
                protein.add(CODONS.get(s))
            }
        }
        protein
    }

}
