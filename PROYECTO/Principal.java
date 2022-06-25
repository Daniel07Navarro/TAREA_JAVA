package PROYECTO;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {

    private static final double ACELERACION_GRAVEDAD = 9.81; //EL VALOR DE LA ACELERACION DE LA GRAVEDAD ES CONSTANTE

    public MRUVBean objetoMRUV = new MRUVBean(); // CREAMOS UN OBJETO DE LA CLASE MRUVBean

    public EnergiaBean objetoEnergia = new EnergiaBean(); // CREAMOS UN OBJETO DE LA CLASE EnergiaBean

    public static Principal principal = new Principal(); //PARA PODER ACCEDER AL MENÚ1 Y MENÚ2

    public static void main(String[] args) {
        String respuesta1, respuesta2;
        // CREAMOS ESTE OBJETO PARA PODER ACCEDER AL METODO DE LOS MENUS DEBIDO A QUE NO ES ESTATICO

        do {

            do {
                respuesta1 = JOptionPane.showInputDialog(null,
                        "SELECCIONE QUE TIPO DE FORMULAS USARÁ: " + "\n -MRUV" + "\n -ENERGIA", "MENU PRINCIPAL",
                        JOptionPane.INFORMATION_MESSAGE); // (TIPO MENSAJE PLANO)
            } while ((!respuesta1.equalsIgnoreCase("MRUV") && (!respuesta1.equalsIgnoreCase("ENERGIA"))));

            if (respuesta1.equalsIgnoreCase("MRUV")) {
                principal.menu1();
            } else if (respuesta1.equalsIgnoreCase("ENERGIA")) {
                principal.menu2();
            }

            do {
                respuesta2 = JOptionPane.showInputDialog("DESEA VOLVER A MOSTRAR EL MENÚ ");
            } while ((!respuesta2.equalsIgnoreCase("SI") && (!respuesta2.equalsIgnoreCase("NO"))));

        } while (respuesta2.equalsIgnoreCase("SI"));

        if (respuesta2.equalsIgnoreCase("NO")) {
            JOptionPane.showMessageDialog(null, "GRACIAS, VUELVA PRONTO");
        }

    }

    // MENU PARA EL MRUV
    public void menu1() {
        int opcion = 0, opcion2 = 0;
        Icon imagenMruv = new ImageIcon(getClass().getResource("FORMULAS_MRUV 3.jpeg"));
        do {
            opcion2 = menúImagenMRUV();
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION: " + "\n1. VOLVER A MOSTRAR LAS FORMULAS" + "\n2. CONTINUAR"));
                if (opcion != 1 && opcion != 2) {
                    JOptionPane.showMessageDialog(null, "ERROR DEBE SELECCIONAR UNA DE LAS DOS OPCIONES");
                }
                if (opcion == 1) {
                    opcion2 = menúImagenMRUV();
                }
            } while (opcion != 2);
        } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4);

        switch (opcion2) {
            case 1:
                // CALCULO VELOCIDAD FINAL SIN DISTANCIA
                //JOptionPane.showMessageDialog(null, "SELECCIONO LA OPCION 1 (VELOCIDAD FINAL SIN DISTANCIA)");
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 1 - VELOCIDAD FINAL SIN DISTANCIA" + "\n\nINGRESE EL TIEMPO: ")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));

                JOptionPane.showMessageDialog(null, "LA VELOCIDAD FINAL ES: "
                        + calcularVelocidadFinalSinDistancia(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial()));
                break;
            case 2:
                // CALCULAR LA DISTANCIA SIN VELOCIDAD INICIAL
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 2 - DISTANCIA SIN VELOCIDAD INICIAL" + "\n\nINGRESE EL TIEMPO:")));
                objetoMRUV.setVelocidadFinal(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD FINAL")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinVelocidadInicial(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadFinal()));
                break;
            case 3:
                // CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 3 - DISTANCIA SIN VELOCIDAD FINAL" + "\n\nINGRESE EL TIEMPO: ")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinVelocidadFinal(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial()));
                break;
            default: //CASO 4
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
        int opcion, opcion2;
        Icon imagenEnergia = new ImageIcon(getClass().getResource("FORMULAS_ENERGIA.png"));
        do {
            opcion2 = menuImageneEnergia();
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION: " + "\n1. VOLVER A MOSTRAR LAS FORMULAS" + "\n2. CONTINUAR"));
                if (opcion != 1 && opcion != 2) {
                    JOptionPane.showMessageDialog(null, "ERROR DEBE SELECCIONAR UNA DE LAS DOS OPCIONES");
                }
                if (opcion == 1) {
                    opcion2 = menuImageneEnergia();
                }
            } while (opcion != 2);
        } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4);

        switch (opcion2) {
            case 1:
                //ENERGIA ELASTICA
                objetoEnergia.setConstanteElasticidad(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE LA CONSTANTE DE ELASTICIDAD")));
                objetoEnergia.setDeformacion(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE LA DEFORMACION")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA POTENCIAL ELASTICA ES: " + calcularEnergiaPotencialElastica(
                        objetoEnergia.getConstanteElasticidad(), objetoEnergia.getDeformacion()));
                break;
            case 2:
                //ENERGIA CINETICA
                objetoEnergia.setMasa(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA MASA")));
                objetoEnergia.setVelocidad(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA CINETICA ES: "
                        + calcularEnergiaCinetica(objetoEnergia.getMasa(), objetoEnergia.getVelocidad()));

                break;
            default: //CASE3
                //ENERGIA POTENCIA GRAVITATORIA
                objetoEnergia.setMasa(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA MASA")));
                objetoEnergia.setAltura(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA ALTURA")));

                JOptionPane.showMessageDialog(null, "LA ENERGIA POTENCIA GRAVITATORIA ES: "
                        + calcularEnergiaPotencialGrativatoria(objetoEnergia.getMasa(), objetoEnergia.getAltura()));

        }
    }

    //FORMULAS DE MRUV
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
        distancia = velocidadFinal * tiempo + (ACELERACION_GRAVEDAD * tiempo) / 2;
        return distancia;
    }

    // FORMULAS DE ENERGIA
    //ENERGIA PONTENCIAL ELASTICA
    public static double calcularEnergiaPotencialElastica(double constanteElasticidad, double deformacion) {
        double energiaElastica;
        energiaElastica = (constanteElasticidad * Math.pow(deformacion, 2)) / 2;
        return energiaElastica;
    }

    //ENERGIA CINETICA
    public static double calcularEnergiaCinetica(double masa, double velocidad) {
        double energiaCinetica;
        energiaCinetica = (masa * Math.pow(velocidad, 2)) / 2;
        return energiaCinetica;
    }

    //ENERGIA POTENCIAL GRATIVATORIA
    public static double calcularEnergiaPotencialGrativatoria(double masa, double altura) {
        double energiaPotencialGravitatoria;
        energiaPotencialGravitatoria = masa * ACELERACION_GRAVEDAD * altura;
        return energiaPotencialGravitatoria;
    }

    public Icon icono(String ubicacion, int ancho, int altura) {
        Icon img;
        img = new ImageIcon(new ImageIcon(getClass().getResource(ubicacion)).getImage().getScaledInstance(ancho, altura, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public static int menúImagenMRUV() {
        String MRUV[] = {
            "1. CALCULO VELOCIDAD FINAL SIN DISTANCIA",
            "2. CALCULAR LA DISTANCIA SIN VELOCIDAD INICIAL",
            "3. CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL",
            "4. CALCULAR LA SIN VELOCIDAD INICIAL"
        };
        String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion", "MRUV", JOptionPane.DEFAULT_OPTION, principal.icono("FORMULAS_MRUV 3.jpeg", 600, 500), MRUV, MRUV[0]);
        if (respuesta.equals("1. CALCULO VELOCIDAD FINAL SIN DISTANCIA")) {
            return 1;
        }
        if (respuesta.equals("2. CALCULAR LA DISTANCIA SIN VELOCIDAD INICIAL")) {
            return 2;
        }
        if (respuesta.equals("3. CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL")) {
            return 3;
        }
        if (respuesta.equals("4. CALCULAR LA SIN VELOCIDAD INICIAL")) {
            return 4;
        }
        return 0;
    }

    public static int menuImageneEnergia() {
        String Energia[] = {
            "1. ENERGIA POTENCIAL ELASTICA",
            "2. ENERGIA CINETICA",
            "3. ENERGIA PONTENCIAL GRAVITATORIA"
        };
        String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion: ", "ENERGIA", JOptionPane.DEFAULT_OPTION, principal.icono("FORMULAS_ENERGIA.png", 600, 500), Energia, Energia[0]);
        if (respuesta.equals("1. ENERGIA POTENCIAL ELASTICA")) {
            return 1;
        }
        if (respuesta.equals("2. ENERGIA CINETICA")) {
            return 2;
        }
        if (respuesta.equals("3. ENERGIA PONTENCIAL GRAVITATORIA")) {
            return 3;
        }
        return 0;
    }

}
