package com.GUI;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Rectangle;


@SuppressWarnings("serial")
public class Menu extends JFrame {
	
	int offsetX, offsetY;
	Color base = new Color(32, 178, 170);
	Color hover = new Color(32, 200, 170);
	Color hover_border = new Color(32, 160, 170);
	Color transparent = new Color(0, 0, 0, 0);
	
	public Menu() {
		getContentPane().setBounds(new Rectangle(0, 0, 1080, 720));
		setBounds(new Rectangle(500, 200, 1080, 720));
		setLocationByPlatform(false);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setFont(new Font("Lato", Font.PLAIN, 11));
		getContentPane().setLayout(null);
		
		JPanel background = new JPanel();
		background.setBounds(0, 0, 1080, 720);
		background.setBackground(Color.WHITE);
		getContentPane().add(background);
		background.setLayout(null);
		
		JPanel generarVisitas__btn = new JPanel();
		generarVisitas__btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generarVisitas__btn.setBackground(new Color(32, 178, 170));
		generarVisitas__btn.setBounds(78, 242, 235, 50);
		background.add(generarVisitas__btn);
		generarVisitas__btn.setLayout(null);
		
		JLabel generarVisitas_btn_label = new JLabel("GENERAR VISITAS");
		generarVisitas_btn_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				generarVisitas_btn_label.setBackground(Color.white);
				generarVisitas_btn_label.setOpaque(true);
				generarVisitas_btn_label.setForeground(base);
				generarVisitas_btn_label.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 3, 3, hover_border));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				generarVisitas_btn_label.setOpaque(false);
				generarVisitas_btn_label.setBackground(base);
				generarVisitas_btn_label.setForeground(Color.white);
				generarVisitas_btn_label.setBorder(null);
			}
		});
		generarVisitas_btn_label.setBounds(0, 0, 235, 50);
		generarVisitas__btn.add(generarVisitas_btn_label);
		generarVisitas_btn_label.setHorizontalTextPosition(SwingConstants.CENTER);
		generarVisitas_btn_label.setHorizontalAlignment(SwingConstants.CENTER);
		generarVisitas_btn_label.setForeground(Color.WHITE);
		generarVisitas_btn_label.setFont(new Font("Lato Black", Font.BOLD, 14));
		
		JPanel consultarDatos__btn = new JPanel();
		consultarDatos__btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		consultarDatos__btn.setLayout(null);
		consultarDatos__btn.setBackground(new Color(32, 178, 170));
		consultarDatos__btn.setBounds(78, 303, 235, 50);
		background.add(consultarDatos__btn);
		
		JLabel consultarDatos_btn_label = new JLabel("CONSULTAR DATOS");
		consultarDatos_btn_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				consultarDatos_btn_label.setBackground(Color.white);
				consultarDatos_btn_label.setOpaque(true);
				consultarDatos_btn_label.setForeground(base);
				consultarDatos_btn_label.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 3, 3, hover_border));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				consultarDatos_btn_label.setOpaque(false);
				consultarDatos_btn_label.setBackground(base);
				consultarDatos_btn_label.setForeground(Color.white);
				consultarDatos_btn_label.setBorder(null);
			}
		});
		consultarDatos_btn_label.setHorizontalTextPosition(SwingConstants.CENTER);
		consultarDatos_btn_label.setHorizontalAlignment(SwingConstants.CENTER);
		consultarDatos_btn_label.setForeground(Color.WHITE);
		consultarDatos_btn_label.setFont(new Font("Lato Black", Font.BOLD, 14));
		consultarDatos_btn_label.setBounds(0, 0, 235, 50);
		consultarDatos__btn.add(consultarDatos_btn_label);
		
		JPanel imprimirFacturacion__btn = new JPanel();
		imprimirFacturacion__btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imprimirFacturacion__btn.setLayout(null);
		imprimirFacturacion__btn.setBackground(new Color(32, 178, 170));
		imprimirFacturacion__btn.setBounds(78, 364, 235, 50);
		background.add(imprimirFacturacion__btn);
		
		JLabel imprimirFacturacion_btn_label = new JLabel("IMPRIMIR FACTURACIÓN");
		imprimirFacturacion_btn_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				imprimirFacturacion_btn_label.setBackground(Color.white);
				imprimirFacturacion_btn_label.setOpaque(true);
				imprimirFacturacion_btn_label.setForeground(base);
				imprimirFacturacion_btn_label.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 3, 3, hover_border));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				imprimirFacturacion_btn_label.setOpaque(false);
				imprimirFacturacion_btn_label.setBackground(base);
				imprimirFacturacion_btn_label.setForeground(Color.white);
				imprimirFacturacion_btn_label.setBorder(null);
			}
		});
		imprimirFacturacion_btn_label.setHorizontalTextPosition(SwingConstants.CENTER);
		imprimirFacturacion_btn_label.setHorizontalAlignment(SwingConstants.CENTER);
		imprimirFacturacion_btn_label.setForeground(Color.WHITE);
		imprimirFacturacion_btn_label.setFont(new Font("Lato Black", Font.BOLD, 14));
		imprimirFacturacion_btn_label.setBounds(0, 0, 235, 50);
		imprimirFacturacion__btn.add(imprimirFacturacion_btn_label);
		
		JPanel imprimirConsultas__btn = new JPanel();
		imprimirConsultas__btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imprimirConsultas__btn.setLayout(null);
		imprimirConsultas__btn.setBackground(new Color(32, 178, 170));
		imprimirConsultas__btn.setBounds(78, 425, 235, 50);
		background.add(imprimirConsultas__btn);
		
		JLabel ImprimirConsultas_btn_label = new JLabel("CONSULTAS DEMOGRÁFICAS");
		ImprimirConsultas_btn_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImprimirConsultas_btn_label.setBackground(Color.white);
				ImprimirConsultas_btn_label.setOpaque(true);
				ImprimirConsultas_btn_label.setForeground(base);
				ImprimirConsultas_btn_label.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 3, 3, hover_border));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImprimirConsultas_btn_label.setOpaque(false);
				ImprimirConsultas_btn_label.setBackground(base);
				ImprimirConsultas_btn_label.setForeground(Color.white);
				ImprimirConsultas_btn_label.setBorder(null);
			}
		});
		ImprimirConsultas_btn_label.setHorizontalTextPosition(SwingConstants.CENTER);
		ImprimirConsultas_btn_label.setHorizontalAlignment(SwingConstants.CENTER);
		ImprimirConsultas_btn_label.setForeground(Color.WHITE);
		ImprimirConsultas_btn_label.setFont(new Font("Lato Black", Font.BOLD, 14));
		ImprimirConsultas_btn_label.setBounds(0, 0, 235, 50);
		imprimirConsultas__btn.add(ImprimirConsultas_btn_label);
		
		JLabel title = new JLabel("Consultas");
		title.setForeground(new Color(32, 178, 170));
		title.setIcon(null);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 62));
		title.setBounds(62, 136, 401, 61);
		background.add(title);
		
		JLabel footer = new JLabel("Hecho por Fernando Pérez y Pablo Dominguez");
		footer.setHorizontalAlignment(SwingConstants.LEFT);
		footer.setForeground(new Color(32, 178, 170));
		footer.setFont(new Font("Lato", Font.PLAIN, 14));
		footer.setBounds(28, 669, 314, 40);
		background.add(footer);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			    setLocation(e.getXOnScreen() - offsetX, e.getYOnScreen()- offsetY);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				offsetX = e.getX();
				offsetY = e.getY();
			}
		});
		header.setOpaque(false);
		header.setBounds(0, 0, 1080, 45);
		background.add(header);
		header.setLayout(null);
		
		JPanel exit_btn = new JPanel();
		exit_btn.setBounds(0, 0, 45, 45);
		exit_btn.setOpaque(false);
		header.add(exit_btn);
		exit_btn.setLayout(null);
		
		JLabel exit_btn_label = new JLabel("x");
		exit_btn_label.setHorizontalAlignment(SwingConstants.CENTER);
		exit_btn_label.setVerticalAlignment(SwingConstants.TOP);
		exit_btn_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exit_btn_label.setBackground(base);
				exit_btn_label.setOpaque(true);
				exit_btn_label.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit_btn_label.setOpaque(false);
				exit_btn_label.setBackground(transparent);
				exit_btn_label.setForeground(base);
			}
		});
		exit_btn_label.setBounds(0, 0, 45, 45);
		exit_btn_label.setHorizontalTextPosition(SwingConstants.CENTER);
		exit_btn_label.setForeground(base);
		exit_btn_label.setFont(new Font("Roboto", Font.PLAIN, 36));
		exit_btn.add(exit_btn_label);
		
		JLabel background_image = new JLabel("");
		background_image.setIcon(new ImageIcon("C:\\Users\\Maydo\\Desktop\\DEVELOP\\TOOLS\\IDE\\Eclipse\\WORKSPACES\\DAW\\CONSULTA\\resources\\background_image.png"));
		background_image.setBounds(0, 0, 1080, 720);
		background.add(background_image);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maydo\\Desktop\\DEVELOP\\TOOLS\\IDE\\Eclipse\\WORKSPACES\\DAW\\CONSULTA\\resources\\icon_image.png"));
		setFont(new Font("Lato Black", Font.BOLD, 12));
		setTitle("Consulta 2.0");
	}
}
