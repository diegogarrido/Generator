package generate;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Generadora: Genera Nombres y ruts de forma aleatoria
 *
 * @version 1.0.1
 * @author Diego Garrido
 */
public class Generate {

    public static void main(String[] args) {
        Generate g = new Generate();
        ArrayList l = g.ruts(500);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        l = g.nombres(500);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    /**
     * Nombres 
     * 
     * Creada para mayor comodidad, invoca al método
     * nombres con sexos en False.
     *
     * @param cant Cantidad a generar.
     * @return ArrayList conteniendo los nombres en formato "Apellido Nombre".
     * Sin repetidos ordenados alfabéticamente
     */
    public ArrayList<String> nombres(int cant) {
        return nombres(cant, false);
    }

    /**
     * Nombres
     *
     * @param cant Cantidad a generar.
     * @param sexos "True" si se quiere agregar sexo al final del nombre, False
     * por defecto.
     * @return ArrayList conteniendo los nombres en formato "Apellido Nombre".
     * Sin repetidos ordenados alfabéticamente, con el género correspondiente al
     * final delimitado por " - ".
     */
    public ArrayList<String> nombres(int cant, boolean sexos) {
        ArrayList<String> nomb = new ArrayList();
        //agregar mas nombres y apellidos para obtener mas variedad
        String[] nombres = new String[]{"Pedro", "Juan", "Diego", "Alberto", "Pablo", "Manuel", "Lorenzo", "Roberto", "Adrian", "Ana", "Martina", "Diana", "Carlos", "Daniel", "Arturo", "Alexis", "Belen", "Camila", "Daniela", "Valentina", "Sofia", "Florencia", "Francisca", "Francisco", "Isidora", "Catalina", "Agustina", "Agustin", "Gonzalo", "Paz", "Rocio", "Julieta", "Renata", "Matilda", "Benjamin", "Vicente", "Martin", "Joaquin", "Jose", "Paulina", "Lucas", "Mateo", "Javier", "Emilio", "Santiago", "Esteban", "David"};
        String[] generos = new String[]{"M", "M", "M", "M", "M", "M", "M", "M", "M", "F", "F", "F", "M", "M", "M", "M", "F", "F", "F", "F", "F", "F", "F", "M", "F", "F", "F", "M", "M", "F", "F", "F", "F", "F", "M", "M", "M", "M", "M", "F", "M", "M", "M", "M", "M", "M", "M"};
        String[] apellidos = new String[]{"Rodriguez", "Garrido", "Martines", "Rojas", "Plaza", "Toledo", "Ortiz", "Zapata", "Fierro", "Suazo", "Zuniga", "Ovalle", "Sanhueza", "Obreque", "Aguero", "Gonzales", "Munoz", "Diaz", "Vazques", "Perez", "Soto", "Contreras", "Lopez", "Mora", "Morales", "Fuentes", "Valenzuela", "Araya", "Sepulveda", "Espinoza", "Torres", "Castillo", "Castro", "Chavez", "Bravo", "Gomez", "Iturria", "Pereira", "Salinas", "Sanchez", "Ruiz", "Tapia", "Carrasco", "Cortes", "Vergara", "Oliveros", "Riquelme", "Salazar", "Parra", "Medina"};
        String exist = "";
        for (int i = 0; i < cant; i++) {
            int nom;
            int ape;
            do {
                nom = (int) (Math.random() * (nombres.length));
                ape = (int) (Math.random() * (apellidos.length));
            } while (exist.contains(nom + "," + ape));
            if (sexos) {
                nomb.add(apellidos[ape] + " " + nombres[nom]+"-"+generos[nom]);
            } else {
                nomb.add(apellidos[ape] + " " + nombres[nom]);
            }
            exist += nom + "," + ape + " ";
        }
        Collections.sort(nomb);
        return nomb;
    }

    /**
     * Ruts
     *
     * @param cant Cantidad a generar
     * @return ArrayList conteniendo los ruts con putnos y guión. Sin repetidos
     * ordenados alfabéticamente
     */
    public ArrayList<String> ruts(int cant) {
        ArrayList<String> ruts = new ArrayList();
        for (int i = 0; i < cant; i++) {
            String rut = "";
            int sum = 0;
            int rand1 = (int) (Math.random() * 4) + 13;
            String num1 = "" + rand1;
            rut += num1 + ".";
            int rand2 = (int) (Math.random() * 999);
            String num2 = "" + rand2;
            if (num2.length() == 2) {
                num2 = "0" + num2;
            } else if (num2.length() == 1) {
                num2 = "00" + num2;
            }
            rut += num2 + ".";
            int rand3 = (int) (Math.random() * 999);
            String num3 = "" + rand3;
            if (num3.length() == 2) {
                num3 = "0" + num3;
            } else if (num3.length() == 1) {
                num3 = "00" + num3;
            }
            sum += Integer.parseInt("" + num3.toCharArray()[2]) * 2;
            sum += Integer.parseInt("" + num3.toCharArray()[1]) * 3;
            sum += Integer.parseInt("" + num3.toCharArray()[0]) * 4;
            sum += Integer.parseInt("" + num2.toCharArray()[2]) * 5;
            sum += Integer.parseInt("" + num2.toCharArray()[1]) * 6;
            sum += Integer.parseInt("" + num2.toCharArray()[0]) * 7;
            sum += Integer.parseInt("" + num1.toCharArray()[1]) * 2;
            sum += Integer.parseInt("" + num1.toCharArray()[0]) * 3;
            int div = sum / 11;
            int resto = sum - (div * 11);
            String verificador;
            switch (resto) {
                case 11:
                    verificador = "0";
                    break;
                case 10:
                    verificador = "K";
                    break;
                default:
                    verificador = "" + resto;
                    break;
            }
            rut += num3 + "-" + verificador;

            if (!ruts.contains(rut)) {
                ruts.add(rut);
            } else {
                i--;
            }
        }
        return ruts;
    }

    /**
     * Fechas
     * Crear fechas aleatorias, con el formato AA-MM-DD validadas para que existan.
     * El año máximo debe ser mayor que el mínimo.
     * Ej. fechas (50,1938,1998) Creará fechas desde 1938 hasta 1998.
     * @param cant Cantidad a generar.
     * @param min Año mínimo del que crear las fechas
     * @param max Año máximo del que crear las fechas
     * @return
     */
    public ArrayList<String> fechas(int cant, int min, int max) {
        ArrayList<String> fechas = new ArrayList();
        for (int i = 0; i < cant; i++) {
            int a = (int) (max - (Math.random() * (max-min)) );
            int m = (int) (Math.random() * 12);
            int d;
            if (m % 2 == 0) {
                d = (int) (Math.random() * 30) + 1;
            } else {
                d = (int) (Math.random() * 31) + 1;
            }
            if (a % 4 == 0 && m == 2) {
                d = (int) (Math.random() * 29) + 1;
            }
            fechas.add(a + "-" + m + "-" + d);
        }
        return fechas;
    }
}
