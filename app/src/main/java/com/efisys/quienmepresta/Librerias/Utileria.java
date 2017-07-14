package com.efisys.quienmepresta.Librerias;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utileria {

    public static String mascaraAstericos(String cadena, int numerosDesenmascarados) {
        if (numerosDesenmascarados < cadena.length()) {
            String valorFormateado = "";
            valorFormateado = cadena.substring((cadena.length() - numerosDesenmascarados), cadena.length());
            valorFormateado = "**" + valorFormateado;
            return valorFormateado;
        } else {
            return cadena;
        }
    }

    public static String convierteFormatoMonedaEntero(String valorMonto) {
        DecimalFormat formato = new DecimalFormat("###,###.##");

        int parteEntera = (int) convierteDoble(valorMonto);
        String valorFormateado = formato.format(parteEntera);

        return valorFormateado;
    }

    public static String obtenerDecimales(String valorMonto) {
        String[] arr = divideString(valorMonto, "\\.");
        String decimales;
        if (arr[1].length() < 2) {
            decimales = "" + arr[1].charAt(0) + "0";
        } else {
            decimales = "" + arr[1].charAt(0) + arr[1].charAt(1);
        }

        return decimales;
    }

    public static String eliminaCeros(String cadena) {
        String aux = cadena;
        int t = cadena.length();
        for (int c = 0; c < t; c++) {
            if (cadena.charAt(c) != '0') {
                aux = cadena.substring(c);
                break;
            }
        }

        return aux;
    }

    public static String convierteFormatoMoneda(String valorMonto) {
        DecimalFormat formato = new DecimalFormat("#,###.##");
        String valorFormateado = formato.format(convierteDoble(valorMonto));
        boolean bandera = false;
        for (int i = 0; i < valorFormateado.length(); i++) {
            if (("" + valorFormateado.charAt(i)).equals(".")) {
                bandera = true;
            }
        }
        if (!bandera) {
            valorFormateado = valorFormateado + ".00";
        }

        valorFormateado = "$" + valorFormateado;
        return valorFormateado;
    }

    public static double convierteDoble(String valorStr) {
        double valorDoble = 0.0;

        try {
            if (!valorStr.equalsIgnoreCase("")) {
                valorDoble = Double.parseDouble(valorStr);
            }
        } catch (Exception error) {
            valorDoble = 0.0;
        }

        return valorDoble;

    }

    public static int convierteEntero(String valorStr) {
        int valorInt = 0;

        try {
            if (!valorStr.equalsIgnoreCase("")) {
                valorInt = Integer.parseInt(valorStr);
            }
        } catch (Exception error) {
            valorInt = 0;
        }
        return valorInt;
    }

    public static String[] divideString(String cadena, String caracterDivision) {
        return cadena.split(caracterDivision);
    }

    public static String[] separaFechaHora(String f) {
        String arre[] = new String[2];
        arre[0] = f.substring(0, 10);
        arre[1] = (f.substring(10)).substring(0, 9);

        return arre;
    }

    public static String obtenerFechaActual() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = s.format(new Date());
        return fecha;
    }

}

