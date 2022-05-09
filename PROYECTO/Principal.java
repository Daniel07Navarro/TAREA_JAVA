package PROYECTO;

import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {

    private static final double ACELERACION_GRAVEDAD = 9.81;

    public static Scanner trabajo = new Scanner(System.in);

    public static MRUVBean objetoMRUV = new MRUVBean(); // UN ATRIBUTO PUBLICO QUE SOLO SE PUEDE ACCEDER DESDE LA CLASE
    // PRINCIPAL

    public static EnergiaBean objetoEnergia = new EnergiaBean(); // UN ATRIBUTO PUBLICO QUE SOLO SE PUEDE ACCEDER DESDE
    // LA CLASE PRINCIPAL

    public static void main(String[] args) {
        String respuesta1, respuesta2;

        // CREAMOS ESTE OBJETO PARA PODER ACCEDER AL METODO MENU1() DEBIDO A QUE NO ES
        // ESTATICO
        Principal principal = new Principal();
        do {

            do {
                respuesta1 = JOptionPane.showInputDialog(null,
                        "SELECCIONE QUE TIPO DE FORMULAS USARÁ: " + "\n -MRUV" + "\n -ENERGIA", "MENU PRINCIPAL",
                        JOptionPane.INFORMATION_MESSAGE); // (TIPO MENSAJE PLANO)
            } while ((!respuesta1.equals("MRUV") && (!respuesta1.equals("ENERGIA"))));

            if (respuesta1.equals("MRUV")) {
                principal.menu1();
            } else if (respuesta1.equals("ENERGIA")) {
                principal.menu2();
            }

            do {
                respuesta2 = JOptionPane.showInputDialog("DESEA VOLVER A MOSTRAR EL MENÚ ");
            } while ((!respuesta2.equals("SI") && (!respuesta2.equals("NO"))));

        } while (respuesta2.equals("SI"));

        if (respuesta2.equals("NO")) {
            JOptionPane.showMessageDialog(null, "GRACIAS, VUELVA PRONTO");
        }

    }

    // MENU PARA EL MRUV
    public void menu1() {
        int opcion;
        Icon imagen = new ImageIcon(getClass().getResource("FORMULAS_MRUV 3.png"));
        do {
            JOptionPane.showMessageDialog(null, null, "MENÚ DE OPCIONES", JOptionPane.INFORMATION_MESSAGE, imagen);
            opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION"));
        } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

        switch (opcion) {
            case 1:
                // CALCULO VELOCIDAD FINAL SIN DISTANCIA
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL TIEMPO")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));

                JOptionPane.showMessageDialog(null, "LA VELOCIDAD FINAL ES: "
                        + calcularVelocidadFinalSinDistancia(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial()));
                break;
            case 2:
                // CALCULAR LA DISTANCIA SIN VELOCIDAD INICIAL
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL TIEMPO")));
                objetoMRUV.setVelocidadFinal(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD FINAL")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinVelocidadInicial(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadFinal()));
                break;
            case 3:
                // CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL TIEMPO")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinVelocidadFinal(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial()));
                break;
            default:
                // CALCULO DE LA VELOCIDAD FINAL SIN TIEMPO
                objetoMRUV.setDistancia(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA DISTANCIA")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));

                JOptionPane.showMessageDialog(null, "LA VELOCIDAD FINAL ES: "
                        + calcularVelocidadFinalSinTiempo(objetoMRUV.getDistancia(), objetoMRUV.getVelocidadInicial()));

        }
    }

    // MENU PARA CALCULAR LA ENERGIA
    public void menu2() {
        int opcion;
        Icon imagenEnergia = new ImageIcon(getClass().getResource("FORMULAS_ENERGIA.png"));
        do {
            JOptionPane.showMessageDialog(null, null, "MENU DE OPCIONES", JOptionPane.INFORMATION_MESSAGE, imagenEnergia);
            opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION"));
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        switch (opcion) {
            case 1:
                objetoEnergia.setConstanteElasticidad(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE LA CONSTANTE DE ELASTICIDAD")));
                objetoEnergia.setDeformacion(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE LA DEFORMACION")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA POTENCIA ELASTICA ES: " + calcularEnergiaPotencialElastica(
                        objetoEnergia.getConstanteElasticidad(), objetoEnergia.getDeformacion()));
                break;
            case 2:
                objetoEnergia.setMasa(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA MASA")));
                objetoEnergia.setVelocidad(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA CINETICA ES: "
                        + calcularEnergiaCinetica(objetoEnergia.getMasa(), objetoEnergia.getVelocidad()));

                break;
            default:
                objetoEnergia.setMasa(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA MASA")));
                objetoEnergia.setAltura(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA ALTURA")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA POTENCIA GRAVITATORIA ES: "
                        + calcularEnergiaPotencialGrativatoria(objetoEnergia.getMasa(), objetoEnergia.getAltura()));

        }
    }

    // CALCULAR LA VELOCIDAD INICIAL SIN TIEMPO
    public static double calcularVelocidadFinalSinTiempo(double distancia, double velocidadInicial) {
        double velocidadFinal;
        velocidadFinal = Math.sqrt(Math.pow(velocidadInicial, 2) + 2 * ACELERACION_GRAVEDAD * distancia);
        return velocidadFinal;
    }

    // CALCULAR LA VELOCIDAD FINAL SIN DISTANCIA
    public static double calcularVelocidadFinalSinDistancia(double tiempo, double velocidadInicial) {
        double velocidadFinal;
        velocidadFinal = velocidadInicial + ACELERACION_GRAVEDAD * tiempo;
        return velocidadFinal;
    }

    // NECESITAMOS EL TIEMPO Y LA VELOCIDAD INICIAL
    public static double calcularDistanciaSinVelocidadFinal(double tiempo, double velocidadInicial) {
        // double distancia;
        double distancia;
        distancia = velocidadInicial * tiempo - (ACELERACION_GRAVEDAD * Math.pow(tiempo, 2)) / 2;
        return distancia;
    }

    // NECESITAMOS EL TIEMPO Y LA VELOCIDAD INICIAL
    public static double calcularDistanciaSinVelocidadInicial(double tiempo, double velocidadFinal) {
        // double distancia;
        double distancia;
        distancia = velocidadFinal * tiempo + (ACELERACION_GRAVEDAD * Math.pow(tiempo, 2)) / 2;
        return distancia;
    }

    
    
    
    
    // FORMULAS DE ENERGIA
    public static double calcularEnergiaPotencialElastica(double constanteElasticidad, double deformacion) {
        double energiaElastica;
        energiaElastica = (constanteElasticidad * Math.pow(deformacion, 2)) / 2;
        return energiaElastica;
    }

    public static double calcularEnergiaCinetica(double masa, double velocidad) {
        double energiaCinetica;
        energiaCinetica = (masa * Math.pow(velocidad, 2)) / 2;
        return energiaCinetica;
    }

    public static double calcularEnergiaPotencialGrativatoria(double masa, double altura) {
        double energiaPotencialGravitatoria;
        energiaPotencialGravitatoria = masa * ACELERACION_GRAVEDAD * altura;
        return energiaPotencialGravitatoria;
    }

}
