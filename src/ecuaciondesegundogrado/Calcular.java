package ecuaciondesegundogrado;

import javax.swing.JOptionPane;
import org.jfree.ui.RefineryUtilities;

public class Calcular {

    private double a;
    private double b;
    private double c;
    private double resultado1;
    private double resultado2;
    private double raizCuadrada;
    double dentroRaiz;

    public Calcular() {
    }

    public void capturar() {
        // tomar los valores de los textfield de la clase "Ecuacion" y almacenarlos en variables globales
        a = Integer.parseInt(Ecuacion.textA.getText());
        b = Integer.parseInt(Ecuacion.textB.getText());
        c = Integer.parseInt(Ecuacion.textC.getText());
    }

    public void calcular() {

        if (a != 0) { //'a' debe ser distinto de cero para que la ecuación no sea una constante 
            double bCuadrado = Math.pow(b, 2);//elevar b al cuadrado
            double raiz = Math.sqrt(bCuadrado - 4 * a * c); //raiz cuadrada
             dentroRaiz= bCuadrado - (4 * a * c);

//             se calculan los valores de x (x1 y x2) solo si la raiz es positiva
//             de lo contrario cambia el valor de un Label advirtiendo que la solución
//             es imaginaria
            if (dentroRaiz >= 0) {

                //resolver ecuación de segundo grado
                resultado1 = ((-(b) + (raiz)) / (2 * a));//primera solución (x1)
                resultado1 = ((int) (resultado1 * 10) / 10.0);//reducción de decimales
                resultado2 = ((-(b) - (raiz)) / (2 * a));//segunda solución(x2)
                resultado2 = ((int) (resultado2 * 10) / 10.0);//reducción de decimales

                editarLabels("" + resultado1, "" + resultado2, "");

            } else {
//              Raiz negativa solución pertenece a los imaginarios
                editarLabels("", "", "Imaginario");
            }
        } else {
            editarLabels("", "", "'A' no puede ser cero.");
        }
    }

    public void graficar() {

        if (dentroRaiz<0) {

            JOptionPane.showMessageDialog(null, "La solución no pertenece a los números REALES");
        } else {
//          se crea una instancia de la clase Grafico
            final Grafico demo = new Grafico("Ecuacion Cuadratica", this.a, this.b, this.c);
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
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
