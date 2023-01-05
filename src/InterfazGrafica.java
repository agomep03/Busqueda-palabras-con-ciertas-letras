package src;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazGrafica{
	private int seleccionCodigo;
	private int numPos;
	private Dictionary diccionario;
	
	private JFrame ventana;
	private JPanel principal;
	private JButton code1;
	private JButton code2;
	private JButton prueba;
	private JPanel codes;
	private JTextField letras;
	private JButton ejecutar;
	private JPanel panelEjecutar;
	private JPanel opciones;
	private JPanel modos;
	
	private JPanel panelEtiqueta;
	private JPanel soluciones;
	private JPanel flechas;
	private JButton subir;
	private JButton bajar;
	private JLabel etiquetas[];
	private int numEtiquetas;
	
	
	String[] listaSoluciones;
	
	public InterfazGrafica() {
		this.seleccionCodigo = 0;
		this.numPos = 0;
		this.diccionario = new Dictionary();
		this.numEtiquetas = 10;
	}
	
	public void crearVentana() {
		ventana= new JFrame("Busqueda de palabras");
		ventana.setLayout(new BorderLayout(10,10));
		principal = new JPanel(new GridLayout(2, 1,10,10));
		ventana.add(principal, BorderLayout.NORTH);
		principal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		opciones = new JPanel();
		opciones.setLayout(new BorderLayout());
		
		modos = new JPanel();
		modos.add(new JLabel("Selecciona un modo:"));
		opciones.add(modos, BorderLayout.WEST);
		
		
		code1 = new JButton("Emplear el código menos óptimo");
		code2 = new JButton("Emplear el código más óptimo");
		prueba = new JButton("Ejecutar una prueba");
		codes = new JPanel();
		codes.setLayout(new GridLayout(3,1));
		codes.add(code1);
		codes.add(code2);
		codes.add(prueba);
		opciones.add(codes, BorderLayout.CENTER);
		
		principal.add(opciones);
		code1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionCodigo=2;
				code1.setEnabled(false);
				code2.setEnabled(true);
				prueba.setEnabled(true);
			}
		});
		code2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionCodigo=1;
				code1.setEnabled(true);
				code2.setEnabled(false);
				prueba.setEnabled(true);
			}
		});
		prueba.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionCodigo=3;
				code1.setEnabled(true);
				code2.setEnabled(true);
				prueba.setEnabled(false);
			}
		});
		
		panelEjecutar = new JPanel();
		panelEjecutar.setLayout(new BorderLayout(10,10));
		
		letras = new JTextField();
		panelEjecutar.add(letras, BorderLayout.CENTER);
		
		ejecutar = new JButton("Ejecutar");
		panelEjecutar.add(ejecutar, BorderLayout.EAST);
		principal.add(panelEjecutar);
		ejecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (seleccionCodigo) {
					case 1:
						Code codigo = new Code(diccionario);
						String sol = codigo.DictionarySearch(letras.getText());
						imprimirRes(sol);
						break;
					case 2:
						String[] letrasDivididas = letras.getText().split("");
						Code2 codigo2 = new Code2(diccionario);
						String sol2 = codigo2.DictionarySearch(letrasDivididas);
						imprimirRes(sol2);
						break;
					case 3:
						imprimirRes("Aqui llamaría a las pruebas");
						break;
					default:
						imprimirRes("Da click a un botón para seleccionar su modo.");
						break;
				}
			}
		});
		
		soluciones = new JPanel();
		soluciones.setLayout(new BorderLayout());
		ventana.add(soluciones, BorderLayout.CENTER);
		
		flechas = new JPanel();
		flechas.setLayout(new GridLayout(2,1));
		subir = new JButton("↑");
		subir.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		subir.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numPos>0) {
					numPos--;
					colocarEtiquetas();
				}
			}
		});
		flechas.add(subir);
		bajar = new JButton("↓");
		bajar.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		bajar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numPos<listaSoluciones.length-1) {
					numPos++;
					colocarEtiquetas();
				}
			}
		});
		flechas.add(bajar);
		soluciones.add(flechas, BorderLayout.EAST);
		
		panelEtiqueta = new JPanel();
		panelEtiqueta.setLayout(new GridLayout(numEtiquetas, 1));
		etiquetas = new JLabel[numEtiquetas];
		for(int i=0; i<numEtiquetas; i++) {
			etiquetas[i] = new JLabel(" ");
			panelEtiqueta.add(etiquetas[i]);
		}
		soluciones.add(panelEtiqueta);
		soluciones.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		
		ventana.setSize(450, 450);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	
	public void imprimirRes(String sol) {
		listaSoluciones = sol.split("\n");
		numPos = 0;
		colocarEtiquetas();
	}
	
	public void colocarEtiquetas() {
		for(int i=0; i<numEtiquetas; i++) {
			if(numPos+i<listaSoluciones.length) {
				etiquetas[i].setText(listaSoluciones[numPos+i]);
			}else {
				etiquetas[i].setText(" ");
			}
		}
	}
	
	
	
}
