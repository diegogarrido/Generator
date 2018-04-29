package generate;

import java.util.ArrayList;

public class BD {

    public static void main(String[] args) {
        Generate g = new Generate();
        ArrayList n = g.nombres(500, true);
        ArrayList r = g.ruts(500);
        ArrayList f = g.fechas(500, 1938, 1998);
        String[] deptos = new String[]{"ARQ", "CIE", "INF", "LEY", "MAT", "MED", "PED", "PSI"};
        System.out.println("insert into personal");
        System.out.println("(rut,nombre,fecha_nac,cod_sexo,e_civil,contratado,sueldo_bas,estatura,nro_hijos,cod_depto) values");
        for (int i = 0; i < n.size(); i++) {
            String rut = "" + r.get(i);
            rut = rut.replaceAll("\\.", "");
            rut = rut.replaceAll("-", "");

            String sexo;
            String nom = "" + n.get(i);
            sexo = nom.split("-")[1];
            n.set(i, nom.split("-")[0]);

            int e_civil = (int) ((Math.random() * 4) + 1);

            int c = (int) (Math.random() * 10);

            String contr = "S";
            if (c < 4) {
                contr = "N";
            }

            int est = (int) (50 + (Math.random() * 50));

            int sueldo = (int) (100000 + (Math.random() * 700000));
            sueldo = sueldo / 1000;
            sueldo = sueldo * 1000;

            int nhijos = (int) (Math.random() * 8);

            int depto = (int) (Math.random() * deptos.length);

            System.out.print("('" + rut + "','" + n.get(i) + "','" + f.get(i) + "','" + sexo + "'," + e_civil + ",'" + contr + "'," + sueldo + ",1." + est + "," + nhijos + ",'" + deptos[depto] + "')");
            if (i != n.size() - 1) {
                System.out.print(",\n");
            }
        }
        System.out.print(";\n");
    }

}
