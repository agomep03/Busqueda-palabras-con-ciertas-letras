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
	private JPanel codes;
	private JTextField letras;
	private JButton ejecutar;
	private JScrollPane scrolleable;
	private JTextArea etiqueta;
	
	public InterfazGrafica() {
		this.seleccionCodigo = 1;
		this.diccionario = new Dictionary();
	}
	
	public void crearVentana() {
		ventana= new JFrame("Busqueda de palabras");
		ventana.setLayout(new BorderLayout());
		principal = new JPanel(new GridLayout(4, 1));
		ventana.add(principal, BorderLayout.NORTH);
		
		code1 = new JButton("Emplear el código menos óptimo");
		code2 = new JButton("Emplear el código más óptimo");
		codes = new JPanel();
		codes.setLayout(new GridLayout(1,2));
		codes.add(code1);
		codes.add(code2);
		principal.add(codes);
		code1.setEnabled(false);
		code1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				seleccionCodigo=2;
				code1.setEnabled(false);
				code2.setEnabled(true);
			}
		});
		code2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				seleccionCodigo=1;
				code2.setEnabled(false);
				code1.setEnabled(true);
			}
		});
		
		letras = new JTextField();
		principal.add(letras);
		
		ejecutar = new JButton();
		principal.add(ejecutar);
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
					imprimirRes("Aqui llamaría a las pruebas...\n"+"Si tuvieramos pruebas");
				default:
					break;
				}
			}
		});
		scrolleable = new JScrollPane();
		scrolleable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		etiqueta = new JTextArea();
		scrolleable.add(etiqueta);
		etiqueta.setSize(600, 400);
		scrolleable.setBackground(Color.red);
		ventana.add(scrolleable, BorderLayout.CENTER);
		etiqueta.setText("\n\n\n\n");
		ventana.setSize(600, 450);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	public void imprimirRes(String sol) {
		etiqueta.setText(sol);
	}
	
	
	
}
