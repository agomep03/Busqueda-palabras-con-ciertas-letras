package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazGrafica{
	private int seleccionCodigo;
	private Dictionary diccionario;
	
	private JFrame ventana;
	private JPanel principal;
	private JButton code1;
	private JButton code2;
	private JButton prueba;
	private JPanel codes;
	private JTextField letras;
	private JButton ejecutar;
	private JScrollPane scrolleable;
	private JTextArea etiqueta;
	private JPanel panelEjecutar;
	private JPanel opciones;
	private JPanel modos;
	
	public InterfazGrafica() {
		this.seleccionCodigo = 1;
		this.diccionario = new Dictionary();
	}
	
	public void crearVentana() {
		ventana= new JFrame("Busqueda de palabras");
		ventana.setLayout(new BorderLayout());
		principal = new JPanel(new GridLayout(2, 1,10,10));
		ventana.add(principal, BorderLayout.NORTH);
		
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
		code1.setEnabled(false);
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
		panelEjecutar.setLayout(new BorderLayout());
		
		letras = new JTextField();
		panelEjecutar.add(letras, BorderLayout.CENTER);
		
		ejecutar = new JButton("Ejecutar");
		panelEjecutar.add(ejecutar, BorderLayout.EAST);
		principal.add(panelEjecutar);
		ejecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
					imprimirRes("Aqui llamaría a las pruebas...\n"+"Pero aun no las he puesto :b");
				default:
					break;
				}
			}
		});
		scrolleable = new JScrollPane();
		scrolleable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		etiqueta = new JTextArea();
		scrolleable.add(etiqueta);
		etiqueta.setSize(700, 400);
		scrolleable.setBackground(Color.red);
		ventana.add(scrolleable, BorderLayout.CENTER);
		etiqueta.setText("\n\n\n\n");
		ventana.setSize(700, 450);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public void imprimirRes(String sol) {
		etiqueta.setText(sol);
	}
	
	
	
}
