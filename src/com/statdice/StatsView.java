package com.statdice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatsView implements ActionListener{
	//선언부
	String  array[]                = {"stat dice"};
	String  data[][]               = new String[0][0];
	JFrame  jf_statRoll            = null;
	JTable  jtb_statRoll           = null;
	DefaultTableModel dtm_statRoll = null;
	JScrollPane jsp_statRoll       = null;
	JButton jbtns[]                = null;
	JButton jbtn 		           = null;
	String  jbtns_label[]          = {"굴리기" , "종료"};
	JPanel  jp_south               = null;
	//생성자
	public StatsView() {
		dtm_statRoll   = new DefaultTableModel(data, array);
		jtb_statRoll   = new JTable(dtm_statRoll);
		jf_statRoll    = new JFrame();
		jp_south       = new JPanel();
		jsp_statRoll   = new JScrollPane(jtb_statRoll);
		jp_south.setLayout(new GridLayout(1,2,3,3));
		jbtns          = new JButton[jbtns_label.length];
		for (int i = 0; i< jbtns_label.length; i++) {
			jbtn = new JButton(jbtns_label[i]);
			jbtns[i] = jbtn;
			jp_south.add(jbtn);
			jbtns[i].addActionListener(this);
		}
		Display();
	}
	//화면처리부
	public void Display() {
		System.out.println("display 성공");
		jf_statRoll.add("South", jp_south);
		jf_statRoll.add("Center",jsp_statRoll);
		jf_statRoll.setTitle("스탯 주사위굴리기");
		jf_statRoll.setSize(600, 300);
		jf_statRoll.setVisible(true);
	}
	public static void main(String[] args) {
		new StatsView();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		StatsRun SR = new StatsRun();
		Object obj = ae.getSource();
		String command = ae.getActionCommand();
		if ("굴리기".equals(command)) {
			System.out.println("스탯 굴리기 실행");
			Vector oneRow = new Vector();
			oneRow.addElement(SR.runs());
			dtm_statRoll.addRow(oneRow);
		}
		else if ("종료".equals(command)) {
			System.exit(0);
			System.gc();
		}
		
		
	}
}
