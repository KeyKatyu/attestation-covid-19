package com.github.afelipez.util;

public class FieldValidator {

    // Validation de champs
    public static String checkIsAllLetter(String str) {
        if (!str.chars().allMatch(Character::isLetter))
            throw new IllegalArgumentException("La chaine de caracteres (" + str + ") ne doit contenir que des lettres");
        return str;
    }

    /*public static void checkCodePostal(String codePostal){
        Objects.requireNonNull(codePostal);
        if(!codePostal.matches("^\\d{5}$"))
            throw new IllegalArgumentException("Le code postal ("+codePostal+") doit contenir 5 chiffres");
    }

    public static void checkDate(String date){
        Objects.requireNonNull(date);
        if(!date.matches("^\\d{2}/\\d{2}/\\d{4}$"))
            throw new IllegalArgumentException("La date ("+date+") doit etre au format dd/MM/yyyy (ex : 01/01/1970)");
    }

    public static void checkHour(String hour){
        Objects.requireNonNull(hour);
        if(!hour.matches("^\\d{2}:\\d{2}$"))
            throw new IllegalArgumentException("L'heure ("+hour+") doit etre au format HH:mm (ex : 12:00)");
    }*/

    // Longeur du champs ville
    /*public static int getFontSizeForVille(String text) throws IOException {
        var fontSize = getIdealFontSize(PDType1Font.HELVETICA, text, 83, 7, 11);
        if(fontSize.isEmpty()){
            LOG.warn("Le nom de la ville risque de ne pas être affiché correctement en raison de sa longueur." +
                    "Essayez d'utiliser des abréviations (\"Saint\" en \"St.\" par exemple) quand cela est possible.");
            return 7;
        }
        return fontSize.getAsInt();
    }

    private static OptionalInt getIdealFontSize(PDFont font, String text, int maxWidth, int minSize, int defaultSize) throws IOException {
        int currentSize = defaultSize;
        int textWidth = (int) font.getStringWidth(text) / 1000 * currentSize;
        System.out.println("WIDTH : "+textWidth);

        while (textWidth > maxWidth && currentSize > minSize) {
            textWidth = (int) font.getStringWidth(text) / 1000 * currentSize;
            System.out.println(textWidth);
            currentSize--;
        }

        return textWidth > maxWidth
                ? OptionalInt.empty()
                : OptionalInt.of(currentSize);
    }*/
}
