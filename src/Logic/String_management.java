package Logic;

public class String_management {

    private String inputString;
    private String searchString;
    private String strToSearch;
    private String stringVowels;
    private String hour;
    private String stringFill;
    private char charFill;
    private int amount;
    private boolean rightLeft;
    private String stringDelete;
    private char charDelete;
    private String charRepeat;
    private String interString1;
    private String interString2;
    private String stringRepeat;
    private String stringAmount;

    /**
     * Creación del objeto para llevar a cabo la realización de la clase manejo de cadenas a partir de la entrada de cadenas
     * y su manipulación partiendo de la cadena que quiera manipular el usuario con el menú dado en la interfaz de usuario.
     * @param inputString Cadena dada por el usuario a la cual cada que contenga se la convertirá en nombre propio
     * @param searchString Cadena que contiene varias palabras para buscar
     * @param strToSearch Cadena a buscar en el texto de la variable searchString
     * @param stringVowels Cadena en la que se contaran las vocales que contenga
     * @param hour Cadena en formato hora minuto 00:00
     * @param stringFill
     * @param charFill
     * @param amount
     * @param rightLeft
     * @param stringDelete
     * @param charDelete
     * @param charRepeat
     * @param interString1
     * @param interString2
     * @param stringRepeat
     * @param stringAmount
     */
    public String_management(String inputString, String searchString, String strToSearch, String stringVowels, String hour, String stringFill, char charFill, int amount, boolean rightLeft, String stringDelete, char charDelete, String charRepeat, String interString1, String interString2, String stringRepeat, String stringAmount) {
        this.inputString = inputString;
        this.searchString = searchString;
        this.strToSearch = strToSearch;
        this.stringVowels = stringVowels;
        this.hour = hour;
        this.stringFill = stringFill;
        this.charFill = charFill;
        this.amount = amount;
        this.rightLeft = rightLeft;
        this.stringDelete = stringDelete;
        this.charDelete = charDelete;
        this.charRepeat = charRepeat;
        this.interString1 = interString1;
        this.interString2 = interString2;
        this.stringRepeat = stringRepeat;
        this.stringAmount = stringAmount;
    }

    /**
     * Este método realiza la conversión del primer caracter de cada palabra en mayúscula, solo si la palabra
     * tiene más de un caracter
     * @param inputString Cadena de texto a ala cual se le pasara el primer caracter de cada palabra en mayúscula
     * @return Devuelve un arreglo de caracteres con los cambios hechos a la cadena
     */
    public static char[] convertToOwnName(String inputString){
        char[] characters = inputString.toCharArray();
        characters[0] = Character.toUpperCase(characters[0]);
        for (int i = 0; i < inputString.length() - 2; i++) {
            if (characters[i] == ' ' || characters[i] == '.' || characters[i] == ',' ) {
                characters[i + 1] = Character.toUpperCase(characters[i + 1]);
            }
            if(Character.isLetter(inputString.charAt(i)) && inputString.charAt(i+1) == ' ' && inputString.charAt(i-1) == ' ' ||
                    Character.isLetter(inputString.charAt(i)) && inputString.charAt(i+1) == ',' && inputString.charAt(i-1) == ' '){
                characters[i] = Character.toLowerCase(characters[i]);
            }
        }
        return characters;
    }

}

