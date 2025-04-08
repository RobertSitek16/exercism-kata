package squeakyclean;

public class SqueakyClean {

    public static String clean(String text) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') {
                sb.append('_');
                continue;
            }

            if (c == '-') {
                capitalizeNext = true;
                continue;
            }

            c = switch (c) {
                case '4' -> 'a';
                case '3' -> 'e';
                case '0' -> 'o';
                case '1' -> 'l';
                case '7' -> 't';
                default -> c;
            };

            if (!Character.isLetter(c)) {
                continue;
            }

            if (capitalizeNext) {
                c = Character.toUpperCase(c);
                capitalizeNext = false;
            }

            sb.append(c);
        }

        return sb.toString();
    }

}
