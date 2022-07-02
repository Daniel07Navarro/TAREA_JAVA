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
        do {

            do {
                respuesta1 = JOptionPane.showInputDialog(null,
                        "SELECCIONE QUE TIPO DE FORMULAS USARÁ: " + "\n -MRUV" + "\n -ENERGIA", "MENU PRINCIPAL",
                        JOptionPane.QUESTION_MESSAGE); // (TIPO MENSAJE INFORMATIVO)
            } while ((!respuesta1.equalsIgnoreCase("MRUV") && (!respuesta1.equalsIgnoreCase("ENERGIA"))));

            if (respuesta1.equalsIgnoreCase("MRUV")) {
                principal.menu1(); //MENU DE MRUV
            } else if (respuesta1.equalsIgnoreCase("ENERGIA")) {
                principal.menu2(); //MENU DE ENERGIA
            }

            do {
                respuesta2 = JOptionPane.showInputDialog("DESEA VOLVER A MOSTRAR EL MENU PRINCIPAL (SI - NO)");
            } while ((!respuesta2.equalsIgnoreCase("SI") && (!respuesta2.equalsIgnoreCase("NO"))));

        } while (respuesta2.equalsIgnoreCase("SI"));

        if (respuesta2.equalsIgnoreCase("NO")) {
            JOptionPane.showMessageDialog(null, "GRACIAS, VUELVA PRONTO");
        }

    }

    // MENU PARA EL MRUV
    public void menu1() {
        int opcion = 0, opcion2 = 0;
        opcion2 = menúImagenMRUV();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION: " + "\n1. VOLVER A MOSTRAR LAS FORMULAS" + "\n2. CONTINUAR"));
            if (opcion != 1 && opcion != 2) {
                JOptionPane.showMessageDialog(null, "ERROR DEBE SELECCIONAR UNA DE LAS DOS OPCIONES", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (opcion == 1) {
                opcion2 = menúImagenMRUV();
            }
        } while (opcion != 2);

        switch (opcion2) {
            case 1:
                // CALCULO VELOCIDAD FINAL SIN DISTANCIA
                //JOptionPane.showMessageDialog(null, "SELECCIONO LA OPCION 1 (VELOCIDAD FINAL SIN DISTANCIA)");
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 1 - VELOCIDAD FINAL SIN DISTANCIA" + "\n\nINGRESE EL TIEMPO: ")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));
                objetoMRUV.setAceleracion(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA ACELERACION")));

                JOptionPane.showMessageDialog(null, "LA VELOCIDAD FINAL ES: "
                        + calcularVelocidadFinalSinDistancia(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial(), objetoMRUV.getAceleracion()));
                break;
            case 2:
                // CALCULAR LA DISTANCIA SIN ACELERACION
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 2 - DISTANCIA SIN ACELERACION" + "\n\nINGRESE EL TIEMPO:")));
                objetoMRUV.setVelocidadFinal(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD FINAL:")));
                objetoMRUV.setVelocidadInicial(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL:")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinAceleracion(objetoMRUV.getVelocidadInicial(), objetoMRUV.getVelocidadFinal(), objetoMRUV.getTiempo()));
                break;
            case 3:
                // CALCULO DE LA VELOCIDAD FINAL SIN TIEMPO
                objetoMRUV.setDistancia(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA DISTANCIA")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));
                objetoMRUV.setAceleracion(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA ACELERACION")));

                JOptionPane.showMessageDialog(null, "LA VELOCIDAD FINAL ES: "
                        + calcularVelocidadFinalSinTiempo(objetoMRUV.getDistancia(), objetoMRUV.getVelocidadInicial(), objetoMRUV.getAceleracion()));

                break;
            default: //CASO 4
                // CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL
                objetoMRUV.setTiempo(Double.parseDouble(JOptionPane.showInputDialog("SELECCIONO LA OPCION 3 - DISTANCIA SIN VELOCIDAD FINAL" + "\n\nINGRESE EL TIEMPO: ")));
                objetoMRUV.setVelocidadInicial(
                        Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA VELOCIDAD INICIAL")));
                objetoMRUV.setAceleracion(Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA ACELERACION")));

                JOptionPane.showMessageDialog(null, "LA DISTANCIA ES: "
                        + calcularDistanciaSinVelocidadFinal(objetoMRUV.getTiempo(), objetoMRUV.getVelocidadInicial(), objetoMRUV.getAceleracion()));

        }
    }

    // MENU PARA CALCULAR LA ENERGIA
    public void menu2() {
        int opcion, opcion2;
        opcion2 = menuImagenEnergia();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE SU OPCION: " + "\n1. VOLVER A MOSTRAR LAS FORMULAS" + "\n2. CONTINUAR"));
            if (opcion != 1 && opcion != 2) {
                JOptionPane.showMessageDialog(null, "ERROR DEBE SELECCIONAR UNA DE LAS DOS OPCIONES", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (opcion == 1) {
                opcion2 = menuImagenEnergia();
            }
        } while (opcion != 2);

        switch (opcion2) {
            case 1:
                //ENERGIA POTENCIAL ELASTICA
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
    // CALCULAR LA VELOCIDAD FINAL SIN DISTANCIA
    public static double calcularVelocidadFinalSinDistancia(double tiempo, double velocidadInicial, double aceleracion) {
        double velocidadFinal;
        velocidadFinal = velocidadInicial + aceleracion * tiempo;
        return velocidadFinal;
    }

    public static double calcularDistanciaSinAceleracion(double velocidadInicial, double velocidadFinal, double tiempo) {
        double distancia;
        distancia = ((velocidadFinal + velocidadInicial) / 2) * tiempo;
        return distancia;
    }

    // CALCULAR LA VELOCIDAD FINAL SIN TIEMPO
    public static double calcularVelocidadFinalSinTiempo(double distancia, double velocidadInicial, double aceleracion) {
        double velocidadFinal;
        velocidadFinal = Math.sqrt(Math.pow(velocidadInicial, 2) + 2 * aceleracion * distancia);
        return velocidadFinal;
    }

    // NECESITAMOS EL TIEMPO Y LA VELOCIDAD INICIAL
    public static double calcularDistanciaSinVelocidadFinal(double tiempo, double velocidadInicial, double aceleracion) {
        // double distancia;
        double distancia;
        distancia = velocidadInicial * tiempo - (aceleracion * Math.pow(tiempo, 2)) / 2;
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
            "2. CALCULAR LA DISTANCIA SIN ACELERACION",
            "3. CALCULAR LA VELOCIDAD FINAL SIN TIEMPO",
            "4. CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL"
        };
        String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion", "MRUV", JOptionPane.DEFAULT_OPTION, principal.icono("FORMULAS_MRUV 3.jpeg", 600, 500), MRUV, MRUV[0]);
        if (respuesta.equals("1. CALCULO VELOCIDAD FINAL SIN DISTANCIA")) {
            return 1;
        }
        if (respuesta.equals("2. CALCULAR LA DISTANCIA SIN ACELERACION")) {
            return 2;
        }
        if (respuesta.equals("3. CALCULAR LA VELOCIDAD FINAL SIN TIEMPO")) {
            return 3;
        }
        if (respuesta.equals("4. CALCULAR LA DISTANCIA SIN VELOCIDAD FINAL")) {
            return 4;
        }
        return 0;
    }

    public static int menuImagenEnergia() {
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

