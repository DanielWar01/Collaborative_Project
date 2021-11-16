package Logic;

import java.util.StringTokenizer;

public class String_management {

    private String inputString;
    private String searchString;
    private String strToSearch;
    private String stringVowels;
    private String hour;
    private String stringFill;
    private char charFill;
    private int amount;
    private byte rightLeft;
    private String stringDelete;
    private char charDelete;
    private String charRepeat;
    private String interString1;
    private String interString2;
    private String stringRepeat;
    private String stringAmount;
    private String email;

    /**
     * Creación del objeto para llevar a cabo la realización de la clase manejo de cadenas a partir de la entrada de cadenas
     * y su manipulación partiendo de la cadena que quiera manipular el usuario con el menú dado en la interfaz de usuario.
     * @param inputString Cadena dada por el usuario a la cual cada que contenga se la convertirá en nombre propio
     * @param searchString Cadena que contiene varias palabras para buscar
     * @param strToSearch Cadena a buscar en el texto de la variable searchString
     * @param stringVowels Cadena en la que se contaran las vocales que contenga
     * @param hour Cadena en formato hora minuto 00:00
     * @param stringFill Cadena de texto a la cual se concatenara un carecter por izquierda o por derecha
     * @param charFill Caracter a concatenar en la cadena stringFill
     * @param amount Cantidad de veces a concatenar en stringFill
     * @param rightLeft Lugar a concatenar izquieda o derecha (byte)
     * @param stringDelete Cadena a la cual se le eliminaran los caracteres repetidos
     * @param charDelete Caracter a eliminar en stringDelete
     * @param charRepeat Cadena a la cual se le eliminaran los caracteres repetidos
     * @param interString1 Cadena de caracteres que se intercalarán con los caracteres de interString2
     * @param interString2 Cadena de caracteres que se intercalarán con los caracteres de interString1
     * @param stringRepeat Texto al cual se le quitaran los caracteres repetidos
     * @param stringAmount Cadena que se le contarán la cantidad de palabras que contiene
     * @param email Cadena a la cual se le valida si lo que ingresa el usuario es un correo electronico o no
     */

    public String_management(String inputString, String searchString, String strToSearch, String stringVowels, String hour, String stringFill, char charFill, int amount, byte rightLeft, String stringDelete, char charDelete, String charRepeat, String interString1, String interString2, String stringRepeat, String stringAmount, String email) {
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
        this.email = email;
    }

    /**
     * Este método realiza la conversión del primer caracter de cada palabra en mayúscula, solo si la palabra
     * tiene más de un caracter
     * @param inputString Cadena de texto a ala cual se le pasara el primer caracter de cada palabra en mayúscula
     * @return Devuelve una cadena de caracteres con los cambios hechos a la cadena
     */

    public static String convertToOwnName(String inputString){
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
        String outputString = String.valueOf(characters);
        return outputString;
    }

    /**
     * Método cuyo procedimiento es el conteo de vocales de una cadena ignorando si son minúsculas o mayúsculas
     * @param stringVowels Cadena a la cual se le contaran las vocales que contiene
     * @return Devuelve un entero con la cantidad de vocales que tiene la cadena de caracteres
     */

    public static int countVowels(String stringVowels){
        int count = 0;
        for (int i = 0; i < stringVowels.length(); i++){
            if (stringVowels.charAt(i) == 'a' || stringVowels.charAt(i) == 'e' || stringVowels.charAt(i) == 'i' || stringVowels.charAt(i) == 'o' || stringVowels.charAt(i) == 'u'
                    || stringVowels.charAt(i) == 'A' || stringVowels.charAt(i) == 'E' || stringVowels.charAt(i) == 'I' || stringVowels.charAt(i) == 'O' || stringVowels.charAt(i) == 'U'){
                count ++;
            }
        }
        return count;
    }

    /**
     * Método el cual su acción es recibir una cadena de caracteres y un caracter ademas de un entero que diga cuantas veces se repetirá ese caracter además de un byte que especifique
     * donde se pondrán esos caracteres en la cadena, si por izquierda o por derecha
     * @param stringFill Cadena inicial
     * @param charFill Caracter a unir a la cadena
     * @param rightLeft Byte para saber si se concatena a derecha o izquierda
     * @param amount Cnatidad de veces que se reperita el caracter introducido
     * @return Devuelve una cadena concatenada con la catidad de veces el caracter introducido por el usuario
     */

    public static String fillCharString(String stringFill, char charFill, byte rightLeft, int amount){
        char[] characters = new char[amount];
        for (int i = 0; i < amount; i++){
            characters[i] = charFill;
        }
        if(rightLeft == 1){
            return stringFill = stringFill+String.valueOf(characters);
        }else if(rightLeft ==2){
            return stringFill = String.valueOf(characters)+stringFill;
        }else{
            return "La opción no está disponible";
        }
    }

    /**
     * Este método realiza el proceso de recibir dos cadenas de texto e intercalar sus calacteres pero sin dejar caracteres repetidos
     * @param interString1  Primera cadena a intercalar sus caracteres
     * @param interString2  Segunda cadena a intercalar sus caracteres
     * @return Retorna una sola cadena pero con los caracteres intercalados de las dos cadenas de entrada y sin repetir
     */

    public static String intersectionStrings(String interString1, String interString2){
        String strConcat = interString1+","+interString2;
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < strConcat.length(); i++) {
            String si = strConcat.substring(i, (i+1));
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        String g = noDupes.toString();
        String parts[] = g.split(",");
        String interString_1 = parts[0];
        String interString_2 = parts[1];
        char[] chars1 = interString_1.toCharArray();
        char[] chars2 = interString_2.toCharArray();
        char[] completeString = new char[chars1.length+chars2.length];
        int j = 0;
        int i = 0;

        while (j < chars1.length+chars2.length) {
            if (i < chars1.length) {
                completeString[j] = chars1[i];
                j++;
            }
            if (i < chars2.length) {
                completeString[j] = chars2[i];
                j++;
            }
            i++;
        }
        String interleavedString = completeString.toString();
        return interleavedString;
    }

    /**
     * En este método lo que se realiza es el conteo de palabras que tiene una cadena de entrada
     * @param stringAmount Cadena a la que se contaran su cantidad de palabras
     * @return Entero que indica la cantidad de palabras de la cadena
     */

    public static int countWords(String stringAmount){
        StringTokenizer strToken = new StringTokenizer(stringAmount);
        return strToken.countTokens();
    }

}

