package ecuaciondesegundogrado;

import javax.swing.JOptionPane;
import org.jfree.ui.RefineryUtilities;

public class Calcular {

    private double a;
    private double b;
    private double c;
    private double resultado1;
    private double resultado2;
    private double imaginario;
    double dentroRaiz;
    private boolean seGrafica;

    public Calcular() {
    }

    public void capturar() {
        // tomar los valores de los textfield de la clase "Ecuacion" y almacenarlos en variables globales
        a = Integer.parseInt(Ecuacion.textA.getText());
        b = Integer.parseInt(Ecuacion.textB.getText());
        c = Integer.parseInt(Ecuacion.textC.getText());
    }

    public void calcular() {

        seGrafica = false;
        double bCuadrado = Math.pow(b, 2);//elevar b al cuadrado
        double raiz = Math.sqrt(bCuadrado - 4 * a * c); //calcular raiz cuadrada
        dentroRaiz = bCuadrado - (4 * a * c);
        
        if ((a == 0) && (b == 0)) {
            editarLabels("", "", "No tiene solución Real");
        } else if ((a == 0) && (b != 0)) {//'a' debe ser distinto de cero para que la ecuación no sea una constante
            editarLabels("" + (-(c / b)), "", "La ecuación no es cuadrática");
        } else if (dentroRaiz < 0) {//discriminante negativo= 2 soluciiones complejas
            imaginario= Math.sqrt((-dentroRaiz))/(2*a);
            editarLabels("" + (-(b / (2 * a)))+" + i"+imaginario, "" + (-(b / (2 * a)))+" - i"+imaginario, " 2 soluciones complejas");
        } else if (dentroRaiz > 0) {//discriminante positivo
            //resolver ecuación de segundo grado
            resultado1 = ((-(b) + (raiz)) / (2 * a));//primera solución (x1)
            resultado2 = ((-(b) - (raiz)) / (2 * a));//segunda solución(x2)
            resultado1 = ((int) (resultado1 * 10) / 10.0);//reducción de decimales
            resultado2 = ((int) (resultado2 * 10) / 10.0);//reducción de decimales
            editarLabels("" + resultado1, "" + resultado2, "2 soluciones reales");
            seGrafica = true;
        } else if (dentroRaiz == 0) {//discriminante igual a cero
            editarLabels("" + (-(b / 2 * a)), "", "1 solución real");
        }
    }

    public void graficar() {
        if (seGrafica == true) {
//          se crea una instancia de la clase Grafico
            final Grafico demo = new Grafico("Ecuacion Cuadratica", this.a, this.b, this.c);
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
        } else {
            editarLabels("", "", "La solución no se puede graficar");
        }

    }

    public void editarLabels(String ms1, String ms2, String ms3) {
//      "Ecuacion" = nombre de la clase; "res1, 2 0 3" nombre Labels
//      método que edita los valores de los labels
        Ecuacion.res1.setText(ms1);
        Ecuacion.res2.setText(ms2);
        Ecuacion.res3.setText(ms3);
    }
}
