
package determinante.gauss.y.rango;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ventana extends JFrame implements ActionListener {
    
    JFrame v;
    JPanel p1,p2,p3;
    JLabel lTexto,ltitulo,ldeterminante,lrango,lcontador;
    JButton bDibujar,bCalcular, batras;
    JTextField tftamaño;
    ArrayList<JTextField> matriz;
    ArrayList<JLabel> matrixresul;
    Calculo c;
    double max[][];
    
    Ventana(){
        initcompents();
        AgregarComponentes();
    }

    private void AgregarComponentes() {
        v = new JFrame();
        v.setTitle("Determinate Gauss");
        v.setSize(300, 180);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.add(p1);
        v.setVisible(true);
    }

    private void initcompents() {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);
        c = new Calculo();
        lTexto = new JLabel("Ingrese el tamaño de la matriz:");
        ltitulo = new JLabel("Determinate y Rango");
        tftamaño =  new JTextField();
        matriz = new ArrayList();
        matrixresul = new ArrayList();
        bDibujar = new JButton("Dibujar Matriz");
        bDibujar.addActionListener(this);
        bCalcular= new JButton("Calcular");
        bCalcular.addActionListener(this);
        batras= new JButton("Volver");
        batras.addActionListener(this);
        ltitulo.setBounds(20, 10, 280, 40);
        ltitulo.setFont(new Font("Times New Roman", 3, 30));
        lTexto.setBounds(20, 60, 180, 20);
        tftamaño.setBounds(200, 60, 20, 20);
        bDibujar.setBounds(20, 90, 120, 20);
        p1.add(ltitulo);
        p1.add(lTexto);
        p1.add(tftamaño);
        p1.add(bDibujar);
    }
    
    public void CambioPaneles(JPanel viejo, JPanel nuevo,int x, int y){
        v.setVisible(false);
        v.remove(viejo);
        v.add(nuevo);
        v.setSize(x, y);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int tamaño = Integer.parseInt(tftamaño.getText());
        if(ae.getSource().equals(bDibujar)){    
            Dibujarmatriz(tamaño);
            CambioPaneles(p1, p2, 50 +(tamaño*55), 100 + (tamaño*25));
        }
        if(ae.getSource().equals(bCalcular)){
            pintarresultado(tamaño);
            CambioPaneles(p2, p3, 100 +(tamaño*55), 140 + (tamaño*25));
            
        }
        if(ae.getSource().equals(batras)){
            remover();
            CambioPaneles(p3, p1, 300, 180);
        }
    }

    private void Dibujarmatriz(int tamaño) {
        int index =0;
        for(int i=0; i<tamaño;i++){
            for(int j=0;j<tamaño;j++){
                matriz.add(new JTextField());
                matriz.get(index).setBounds(20 +(j*55),20+(i*25), 50, 20);
                matriz.get(index).setText("");
                p2.add(matriz.get(index));
                index++;
            }
        }
        
        bCalcular.setBounds(20, 50 + ((tamaño-1)*25), 100, 20);
        p2.add(bCalcular);
    }

    private void pintarresultado(int tamaño) {
        max = c.Calcular(tamaño,matriz);
        int index =0;
        for(int i = 0;i<tamaño;i++){
            for(int j = 0; j<tamaño;j++){
                matrixresul.add(new JLabel(Double.toString(max[i][j])));
                matrixresul.get(index).setBounds(20 +(j*60),20+(i*25), 50, 20);
                p3.add(matrixresul.get(index));
                index++;
            }
        }
        ldeterminante = new JLabel("El determinante es: " + c.Determinante());
        ldeterminante.setBounds(20, 50 + (tamaño-1)*25, 150, 20);
        lrango = new JLabel("El rango es: " + tamaño);
        lrango.setBounds(20, 40 + (tamaño)*25, 150, 20);
        batras.setBounds(20, 58 + ((tamaño+1)*25), 100, 20);
        lcontador = new JLabel("OE: " + c.contador());
        lcontador.setBounds(20, 54 + (tamaño)*25, 150, 20);
        lformula = new JLabel("OE: " + c.formula());
        lformula.setBounds(20, 54 + (tamaño)*25, 150, 20);
        p3.add(ldeterminante);
        p3.add(lrango);
        p3.add(lcontador);
        p3.add(batras);
        
       
    }

    private void remover() {
        p1.removeAll();
        p2.removeAll();
        p3.removeAll();
        tftamaño.setText("");
        p1.add(ltitulo);
        p1.add(lTexto);
        p1.add(tftamaño);
        p1.add(bDibujar);
    }
  
}
