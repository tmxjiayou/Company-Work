package pack202;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Text1 extends JFrame {
	
	public static void main(String args[]) {
		try {
			Text1 frame = new Text1();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Text1() {
		super();
		setTitle("�ṩ�б������ı��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vector columnNameV = new Vector();
		columnNameV.add("����");
		for (int i = 1; i < 21; i++) {
			columnNameV.add("��Ʒ" + i);
		}
		Vector tableValueV = new Vector();
		for (int row = 1; row < 31; row++) {
			Vector rowV = new Vector();
			rowV.add(row);
			for (int col = 0; col < 20; col++) {
				rowV.add((int) (Math.random() * 1000));
			}
			tableValueV.add(rowV);
		}
		final Text2 panel = new Text2(columnNameV,
				tableValueV, 1);
		getContentPane().add(panel, BorderLayout.CENTER);
		//
	}
	
}
