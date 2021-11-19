package Interface;

import Logic.String_management;

import javax.swing.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        boolean confirmar = true;
        String str;
        while (option < 11 || option > 11){
            confirmar = true;
            do {
                try {

                    option = Integer.parseInt(JOptionPane.showInputDialog("Menú \nIngresa la opcion de manejo de cadenas que quieras" +
                            "\n1)Convertir cadena en nombre propio" +
                            "\n2)Buscar una palabra en un texto" +
                            "\n3)Contar las vocales de una cadena" +
                            "\n4)Saber los minutos que faltan para año nuevo" +
                            "\n5)Concatenar n caracteres en una cadena por izquierda o derecha" +
                            "\n6)Borrar caracter de una cadena" +
                            "\n7)Realizar intersección entre dos cadenas" +
                            "\n8)Borrar caracter repetido" +
                            "\n9)Cantidad de palabras en una cadena" +
                            "\n10)Validar correo electronico" +
                            "\n11)Salir del programa"));
                    switch (option){
                        case 1 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena a convertir a nombre propio");
                            JOptionPane.showMessageDialog(null, String_management.convertToOwnName(str));
                            break;
                        case 2 :
                            str = JOptionPane.showInputDialog("Ingresa el texto en el que buscaras la palabra");
                            String strSearch = JOptionPane.showInputDialog("Ahora ingresa la palabra que quieres buscar en el texto");
                            if(String_management.searchWords(str, strSearch) == 0){
                                JOptionPane.showMessageDialog(null,"La palabra que estabas buscando no se ha encontrado");
                            }else{
                                JOptionPane.showMessageDialog(null, "La palabra que bucabas '"+strSearch+"' se encontro en el texto "+String_management.searchWords(str, strSearch)+" veces");
                            }
                            break;
                        case 3 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena a la que quieras contar las vocales");
                            JOptionPane.showMessageDialog(null, "Se encontraron en la cadena "+String_management.countVowels(str)+" vocales");
                            break;
                        case 4 :
                            str = JOptionPane.showInputDialog("Ingresa la hora en formato 00:00");
                            if(Pattern.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", str)){
                                JOptionPane.showMessageDialog(null, "Para año nuevo faltan "+String_management.newYear(str)+" minutos");
                            }else{
                                JOptionPane.showMessageDialog(null,"La cadena no está formada en formato 00:00");
                            }
                            break;
                        case 5 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena que quieres concatenar con los caracteres");
                            char fillChar = JOptionPane.showInputDialog("Ingresa el caracter a concatenar" +
                                    "\n'Solo se tomara el primer caracter'").charAt(0);
                            try {
                                int amount = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de caracteres a concatenar"));
                                boolean rigthLeft = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Dónde quieres concatenar?" +
                                        "\nfalse para izquierda" +
                                        "\ntrue para derecha"));
                                JOptionPane.showMessageDialog(null, "La cadena resultante es: '" + String_management.fillCharString(str, fillChar, rigthLeft, amount)+"' ");
                            }catch(NumberFormatException exception){
                                JOptionPane.showMessageDialog(null, "La cantidad debe ser solo un número entero");
                            }
                            break;
                        case 6 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena a la que borraras el caracter");
                            char charDelete = JOptionPane.showInputDialog("Ingresa el caracter a borrar").charAt(0);
                            String strChar = String.valueOf(charDelete);
                            JOptionPane.showMessageDialog(null, String_management.deleteChar(str, strChar));
                            break;
                        case 7 :
                            str = JOptionPane.showInputDialog("Ingresa la primer a cadena");
                            String str2 = JOptionPane.showInputDialog("Ingresa la segunda cadena");
                            JOptionPane.showMessageDialog(null, "La cadena resultante es: "+String_management.intersectionStrings(str, str2));
                            break;
                        case 8 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena a eliminar sus caracteres repetidos");
                            JOptionPane.showMessageDialog(null, "La cadena resultante es: '"+String_management.deleteRepeat(str)+"' ");
                            break;
                        case 9 :
                            str = JOptionPane.showInputDialog("Ingresa la cadena a la cual quieras contar" +
                                    "\nsus palabras");
                            JOptionPane.showMessageDialog(null, "La cantidad de palabras de texto son: "+String_management.countWords(str));
                            break;
                        case 10 :
                            str = JOptionPane.showInputDialog("Ingresa el correo electrónico a validar ");
                            if (String_management.validateEmail(str)) {
                                JOptionPane.showMessageDialog(null, "El correo electronico es válido");
                            }else{
                                    JOptionPane.showMessageDialog(null, "El correo electronico ingresado es inválido");
                                }
                            break;
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "En la opción debes ingresar solo números enteros");
                    confirmar = false;
                }
            }while(!confirmar);
        }
    }
}
