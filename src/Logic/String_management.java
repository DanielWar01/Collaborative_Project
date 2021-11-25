package Logic;

import javax.swing.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_management {






    /**
     * Este método realiza la conversión del primer caracter de cada palabra en mayuscula, solo si la palabra
     * tiene mas de un caracter
     * @param inputString Cadena de texto a ala cual se le pasara el primer caracter de cada palabra en mayuscula
     * @return Devuelve una cadena de caracteres con los cambios hechos a la cadena
     */

    public static String convertToOwnName(String inputString){
        /*
         *Para cambiar la primera letra de cada palabra se necesita evaluar cada caracter para ello se convierte el string en un arreglo de caracteres
         */
        char[] characters = inputString.toCharArray();
        characters[0] = Character.toUpperCase(characters[0]);
        /*
         * El siguiente paso seria mediante un for y dos condicionales evaluar cada uno de los caracteres contenidos demtro del arreglo de caracteres
         */
        for (int i = 0; i < inputString.length() - 2; i++) {
            /*
             * Si el caracter del arreglo en la posicion "i" es un espacio, coma o punto en esa posición más uno se debe pasar a mayúscula
             */
            if (characters[i] == ' ' || characters[i] == '.' || characters[i] == ',' ) {
                characters[i + 1] = Character.toUpperCase(characters[i + 1]);
            }
            /*
             * En el caso de que hayan un espacio seguido de una letra seguido de un espacio, o un espacio seguido de una letra seguido de una coma; significa que la letra
             * esta sola por lo tanto se pasa a minuscula con toLowerCase
             */
            if(Character.isLetter(inputString.charAt(i)) && inputString.charAt(i+1) == ' ' && inputString.charAt(i-1) == ' ' ||
                    Character.isLetter(inputString.charAt(i)) && inputString.charAt(i+1) == ',' && inputString.charAt(i-1) == ' '){
                characters[i] = Character.toLowerCase(characters[i]);
            }
        }
        /*
         * Finalmente se pasa el arreglo de caracteres a un string mediante String.valueOf
         */
        return String.valueOf(characters);
    }

    /**Método cuyo procedimiento es buscar cuántas veces esta una cadena de caracteres en otra
     * @param searchString Cadena que contiene varias palabras para buscar
     * @param strToSearch Cadena a buscar en el texto de la variable searchString
     * @return Devuelve entero que indica el número de veces que existe la cadena
     */

    public static int searchWords(String searchString, String strToSearch) {
        int counter = 0;
        Pattern patron = Pattern.compile(Pattern.quote(strToSearch), Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(searchString);
        while (m.find()) {
            counter++;
        }
        return counter;

    }

    /**
     * Método cuyo procedimiento es el conteo de vocales de una cadena ignorando si son minúsculas o mayúsculas
     * @param stringVowels Cadena a la cual se le contaran las vocales que contiene
     * @return Devuelve un entero con la cantidad de vocales que tiene la cadena de caracteres
     */

    public static int countVowels(String stringVowels){
        /*
         * Se crea una variable contador que va a contar la veces en las que aparece una vocal controlada por un ciclo for y un condicional que hará aumentar
         * contador a medida que detecte una vocal en la cadena mediante una expresion regular tanto de vocales con acento como sin acento
         */
        int count = 0;
        for (int i = 0; i < stringVowels.length(); i++){
            String letter = String.valueOf(stringVowels.charAt(i));
            if (Pattern.matches("[aeiouAEIOU]", letter) || Pattern.matches("[áéíóúÁÉÍÓÚ]", letter)){
                count ++;
            }
        }
        /*
         * Finalmente se retorna el contador
         */
        return count;
    }

    /**
     * Este método realiza el proceso con una cadena de caracteres que dice una hora y calcula cuantos minutos faltan para año nuevo a partir de esta
     * @param hour String que da la hora base
     * @return Devuelve cuantos minutos faltan para año nuevo
     */
    public static int newYear(String hour){
        int hours, minutes, timeLeft = 0;
            if(Pattern.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", hour)) {
                hours = Integer.parseInt(hour.substring(0, 2));
                minutes = Integer.parseInt(hour.substring(3, 5));
                timeLeft = ((23 - hours) * 60) + (60 - minutes);
                System.out.println("Para año nuevo faltan "+timeLeft+" minutos");
            }else{
                System.out.println("La cadena no está formada en formato 00:00");
            }

        return timeLeft;

    }

    /**
     * Método el cual su acción es recibir una cadena de caracteres y un caracter ademas de un entero que diga cuantas veces se repetirá ese caracter además de un byte que especifique
     * donde se pondran esos caracteres en la cadena, si por izquierda o por derecha
     * @param stringFill Cadena inicial
     * @param charFill Caracter a unir a la cadena
     * @param rightLeft Boolean para saber si se concatena a derecha o izquierda
     * @param amount Cnatidad de veces que se reperita el caracter introducido
     * @return Devuelve una cadena concatenada con la catidad de veces el caracter introducido por el usuario
     */

    public static String fillCharString(String stringFill, char charFill, boolean rightLeft, int amount){
        /*
         * Para poder concatenar cierta cantidad de caracteres lo que se haría sería dentro de un arreglo de tipo char con la cantidad de caracteres que quiera el usuario
         * y mediante un for lenar con el caracter n veces
         */
        char[] characters = new char[amount];
        for (int i = 0; i < amount; i++){
            characters[i] = charFill;
        }
        /*
         * Después a partir de unos condicionales que evaluan si los caracteres se deben poner por izquierda o por derecha y se concatena en el string original
         */
        if(rightLeft){
            return stringFill = stringFill+String.valueOf(characters);
        }else if(rightLeft == false){
            return stringFill = String.valueOf(characters)+stringFill;
        }else{
            return "La opción no está disponible";
        }
    }

    /**
     * Este método realiza el proceso de borrar caracteres de una cadena de caracteres
     * @param stringDelete Cadena de caracteres donde se va a borrar un caracter;
     * @param charDelete Caracter que se va a borrar de la cadena de caracteres;
     */

    public static String deleteChar( String stringDelete, String charDelete) {

        stringDelete = stringDelete.replace(charDelete, "");

        return stringDelete;
    }


    /**
     * Este método realiza el proceso de recibir dos cadenas de texto e intercalar sus calacteres pero sin dejar caracteres repetidos
     * @param interString1  Primera cadena a intercalar sus caracteres
     * @param interString2  Segunda cadena a intercalar sus caracteres
     * @return Retorna una sola cadena pero con los caracteres intercalados de las dos cadenas de entrada y sin repetir
     */

    public static String intersectionStrings(String interString1, String interString2){
        /*
         * Bueno, como se necesita quitar los caracteres repetidos de las dos cadenas entonces para ello lo que se haría sería concatenar las dos cadenas
         * unidas por una coma (¿Para que la coma?, la coma sería para despues realizar arreglo String por medio del método split lo cual va a separar las dos cadenas)
         * Después lo que se haria es crear un StringBuilder para utilizar la función .append para construir el String letra por letra; entonces dentro de un for se crea
         * un String que tomara caracter por caracter y lo mediante un if se buscara en la cadena si el caracter ya se encuentra si es así con el método append lo añadimos
         * al StringBuilder en caso contrario se queda por fuera
         */
        String strConcat = interString1+","+interString2;
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < strConcat.length(); i++) {
            String si = strConcat.substring(i, (i+1));
            if (noDupes.indexOf(si) == -1 || " ".equals(si)) {
                noDupes.append(si);
            }
        }
        /*
         * Ahora el StringBuilder se pasa a String y se genera un split separado por la coma entonces cada cadena la pasamos a un arreglo de caracteres  y se crea un arreglo
         * adicional que contendrá las cadenas con la intersección con la longitud de ambas
         */
        String g = noDupes.toString();
        String parts[] = g.split(",");
        char[] chars1 = parts[0].toCharArray();
        char[] chars2 = parts[1].toCharArray();

        char[] completeString = new char[chars1.length+chars2.length];
        int j = 0;
        int i = 0;
        /*
         Mediante un ciclo mientras y dos condicionales (uno para chars1 y el otro chars2), si se cumplen se añade al arreglo que contiene la intersección, esto se
         hace para que no se sobrepase la cantidad de elementos del arreglo que almacena la intersección
         */
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
        /*
        Finalmente se pasa el arreglo a String y se retorna
         */

        return String.valueOf(completeString);
    }

    /**
     * Método que elimina los caracteres repetidos de una cadena y solo deja el primero
     * @param charRepeat Cadena a la cual se le eliminaran sus caracteres repetidos
     * @return Devuelve la cadena sin los caracteres repetidos
     */
    public static String deleteRepeat(String charRepeat){
        StringBuilder noRepeat = new StringBuilder();
        String str = charRepeat.substring(4,5);
        for (int i = 0; i < charRepeat.length(); i++) {
            String si = charRepeat.substring(i, (i+1));
            if (noRepeat.indexOf(si) == -1 || " ".equals(si)) {
                noRepeat.append(si);
            }
        }
        return noRepeat.toString();
    }

    /**
     * En este método lo que se realiza es el conteo de palabras que tiene una cadena de entrada
     * @param stringAmount Cadena a la que se contaran su cantidad de palabras
     * @return Entero que indica la cantidad de palabras de la cadena
     */

    public static int countWords(String stringAmount){
        /*
        Este es el más sencillo simplemente al pasar el string a tokens con la clase StringTokenizer, se coje el objeto y se llama al método que va a contar la cantidad
        de tokens(palabras) devolviendo un entero
         */
        StringTokenizer strToken = new StringTokenizer(stringAmount);
        return strToken.countTokens();
    }

    /**
     *  Método que comprueba si un correo electrónico es válido
     * @param email Correo electrónico ingresado por el usuario
     * @return Devuelve un valor lógico (true o false)
     */
    public static boolean validateEmail(String email){
        /*
        Para poder validar el correo electrónico se utiliza un patrón que mediante un regex o expresion regular comprueba la validez del correo ingresado la parte
        [\w-]+(\.[\w-]+ los caracteres iniciales a-z, A-Z y 0-9 y el punto son los demas signos, debspues debe estar forzadamente un arroba y después de este solo
        se aceptan caracateres entre a-z A-z 0-9 y finalmente con un punto se aceptan caractere alfabeticos pero solo dos elementos
         */
        if (Pattern.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]{0,3}+)*(\\.[A-Za-z]{0,2})$", email) || Pattern.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]{0,3})$", email)){
            return true;
        }
        return false;
    }

}

