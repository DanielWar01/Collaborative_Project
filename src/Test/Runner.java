package Test;

import Logic.String_management;

public class Runner {
    public static void main(String[] args) {
        String email = "guerra.daniel@uptc.com.co";
        if(String_management.validateEmail(email)) {
            System.out.println("El correo es válido");
        }else{
            System.out.println("El correo es invalido");
        }
    }
}
