package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.NPCRandom;
import data.NPCBackground;
//import org.json.*;

public class Maininterface extends JFrame{
	public static String ver = "made by EteranlRider      version 0.1";
	private JPanel face;
	private JPanel alignC;
	private JPanel base;
	private JPanel color;
	private JPanel soul;
	private JPanel botton;
	
	public JRadioButton alignbutton[] = new JRadioButton[9];
	public ButtonGroup aligngroup;
	
	public JLabel namelabel;
	public JLabel sexlabel;
	public JLabel agelabel;
	public JLabel backlabel;
	public JLabel racelabel;
	public JTextField nametext;
	public JComboBox sexbox;
	public JComboBox agebox;
	public JComboBox racebox;
	public JTextField agetext;
	public JTextField racetext;
	public JComboBox backbox;
	
	public JLabel traitlabel;
	public JLabel comelabel;
	public JTextArea traittext;
	public JTextArea cometext;
	
	public JLabel ideallabel;
	public JLabel bondlabel;
	public JLabel flowlabel;
	public JTextArea idealtext;
	public JTextArea bondtext;
	public JTextArea flowtext;
	
	public JButton random;
	public JButton save;
	public JButton help;
	
	public Maininterface() {
		this.setTitle("NPC������");
		this.setSize(900, 700);
		this.setLocation(900, 200);
		
		//this.setLayout(null);
		this.add(new JLabel(ver),BorderLayout.SOUTH);
		
		
		face = new JPanel();
		JScrollPane jsp = new JScrollPane(face);
		face.setLayout(null);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize(850, 650);
		jsp.setLocation(20, 20);
		face.setSize(850,650);
		this.add(jsp, BorderLayout.CENTER);
		Font font = new Font("����",Font.PLAIN,20);
		jsp.setBackground(Color.BLUE);
		
		//���Ͻǣ���Ӫ�Ź���
		alignC = new JPanel();
		alignC.setSize(350, 200);
		alignC.setLayout(new GridLayout(3,3));
		//align.add(new JButton("����"), BorderLayout.NORTH);
		//align.add(new JButton("а��"), BorderLayout.SOUTH);
		//align.add(new JButton("����"), BorderLayout.WEST);
		//align.add(new JButton("����"), BorderLayout.EAST);
		aligngroup = new ButtonGroup();
		alignbutton[0] = new JRadioButton("��������");
		alignbutton[1] = new JRadioButton("��������");
		alignbutton[2] = new JRadioButton("��������");
		alignbutton[3] = new JRadioButton("��������");
		alignbutton[4] = new JRadioButton("��������");
		alignbutton[5] = new JRadioButton("��������");
		alignbutton[6] = new JRadioButton("����а��");
		alignbutton[7] = new JRadioButton("����а��");
		alignbutton[8] = new JRadioButton("����а��");
		for(int i=0;i<9;i++) {
			alignC.add(alignbutton[i]);
			alignbutton[i].setFont(font);
			aligngroup.add(alignbutton[i]);
		}
		alignbutton[4].setSelected(true);
		face.add(alignC);
		alignC.setBackground(Color.BLUE);
		
		//���Ͻǣ�����+�Ա����䣨������+�ı���+������������
		base = new JPanel();//���
		base.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		base.setSize(500,175);
		namelabel = new JLabel("����:");//������ǩ
		namelabel.setFont(font);
		base.add(namelabel);
		nametext = new JTextField(25);//�����ı���
		nametext.setFont(font);
		//nametext.setSize(400, 22);
		base.add(nametext);
		nametext.setLocation(50, 0);
		sexlabel = new JLabel("�Ա�:");//�Ա��ǩ
		sexlabel.setFont(font);
		base.add(sexlabel);
		sexbox = new JComboBox();//�Ա�������
		sexbox.setFont(font);
		sexbox.addItem("��");
		sexbox.addItem("Ů");
		sexbox.addItem("��");
		base.add(sexbox);
		agelabel = new JLabel("����:");//�����ǩ
		agelabel.setFont(font);
		base.add(agelabel);
		agebox = new JComboBox();//����������
		agebox.setFont(font);
		agebox.addItem("����");
		agebox.addItem("����");
		agebox.addItem("����");
		agebox.addItem("����");
		base.add(agebox);
		agebox.setSelectedIndex(1);
		agetext = new JTextField(4);//�����ı���
		agetext.setFont(font);
		base.add(agetext);
		backlabel = new JLabel("����:");//������ǩ
		backlabel.setFont(font);
		base.add(backlabel);
		backbox = new JComboBox();//����������
		backbox.setFont(font);
		backbox.addItem("��");
		backbox.addItem("��ɮ");
		backbox.addItem("ƭ��");
		backbox.addItem("�ﷸ/��̽");
		backbox.addItem("����/�Ƕ�ʿ");
		backbox.addItem("ƽ��Ӣ��");
		backbox.addItem("�лṤ��/����");
		backbox.addItem("��ʿ");
		backbox.addItem("����/��ʿ");
		backbox.addItem("����֮��");
		backbox.addItem("����");
		backbox.addItem("ˮ��/����");
		backbox.addItem("ʿ��/����");
		backbox.addItem("���˶�");
		backbox.addItem("Զ����");
		base.add(backbox);
		racelabel = new JLabel("����:");//�����ǩ
		racelabel.setFont(font);
		base.add(racelabel);
		racebox = new JComboBox();//����������
		racebox.setFont(font);
		racebox.addItem("����");
		racebox.addItem("����");
		racebox.addItem("����");
		racebox.addItem("������");
		racebox.addItem("����");
		racebox.addItem("٪��");
		racebox.addItem("�뾫��");
		racebox.addItem("������");
		racebox.addItem("ħ��");
		racebox.addItem("����");
		racebox.addItem("����");
		racebox.addItem("�ؾ�");
		racebox.addItem("��ؾ�");
		base.add(racebox);
		//racebox.setSelectedIndex(0);
		racetext = new JTextField(8);//�����ı���
		racetext.setFont(font);
		racetext.setText("����");
		base.add(racetext);
		random = new JButton("����");//���ɰ�ť
		random.setFont(font);
		save = new JButton("�浵");//�浵��ť
		save.setFont(font);
		help = new JButton("?");//������ť
		help.setFont(font);
		base.add(random);
		base.add(save);
		base.add(help);
		face.add(base);
		base.setLocation(350,0);
		//base.setBackground(Color.BLUE);
		
		//���½ǣ����롢�ȱ��
		soul = new JPanel();//���
		soul.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		soul.setSize(530,410);
		ideallabel = new JLabel("����:");//�����ǩ
		ideallabel.setFont(font);
		soul.add(ideallabel);
		idealtext = new JTextArea(3,49);//�����ı���
		idealtext.setLineWrap(true);
		soul.add(idealtext);
		idealtext.setFont(font);
		bondlabel = new JLabel("�:");//��ǩ
		bondlabel.setFont(font);
		soul.add(bondlabel);
		bondtext = new JTextArea(3,49);//��ı���
		bondtext.setLineWrap(true);
		soul.add(bondtext);
		bondtext.setFont(font);
		flowlabel = new JLabel("ȱ��:");//ȱ���ǩ
		flowlabel.setFont(font);
		soul.add(flowlabel);
		flowtext = new JTextArea(3,49);//ȱ���ı���
		flowtext.setLineWrap(true);
		soul.add(flowtext);
		flowtext.setFont(font);
		soul.setLocation(350,165);
		//soul.setBackground(Color.BLUE);
		face.add(soul);
		
		//���½ǣ��ص㣬����������
		color = new JPanel();//���
		color.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		color.setSize(350,450);
		traitlabel = new JLabel("�ص�:");//�ص��ǩ
		traitlabel.setFont(font);
		color.add(traitlabel);
		traittext = new JTextArea(3,35);//�ص��ı���
		traittext.setLineWrap(true);
		color.add(traittext);
		traittext.setFont(font);
		comelabel = new JLabel("����������:");//������ǩ
		comelabel.setFont(font);
		color.add(comelabel);
		cometext = new JTextArea(8,35);//�����ı���
		cometext.setLineWrap(true);
		color.add(cometext);
		cometext.setFont(font);
		color.setLocation(0,200);
		//soul.setBackground(Color.BLUE);
		face.add(color);
		
		//��ť
		//botton = new JPanel();
		//botton.setSize(530, 100);
		//botton.setLocation(350, 570);
		//random.setLocation(350, 500);
		//save.setLocation(450,500);
		//botton.add(random);
		//botton.add(save);
		//botton.setBackground(Color.BLUE);
		//face.add(botton);
		
		//�¼�����
		racebox.addActionListener(new ActionListener() {//ѡ������ʱ���ı�����ʾ��ǰ����
			public void actionPerformed(ActionEvent e) {
				racetext.setText((String) racebox.getSelectedItem());
				
			}
		}); 
		/*
		 * nametext����
		 * agetext����
		 * racetext����
		 * traittext�ص�
		 * cometext����
		 * idealtext����
		 * bondtext�
		 * flowtextȱ��
		 */
		random.addActionListener(new ActionListener() {//������ɰ�ť
			public void actionPerformed(ActionEvent e) {
				String race = (String) racebox.getSelectedItem();
				String age = (String) agebox.getSelectedItem();
				String sex = (String) sexbox.getSelectedItem();
				String background = (String) backbox.getSelectedItem();
//				System.out.println("����="+race+";����="+age+";�Ա�="+sex+";����="+background);
				nametext.setText(NPCRandom.RandomName(race,sex));
//				System.out.println("���������ɣ�");
				agetext.setText(NPCRandom.RandomAge(race, age));
//				System.out.println("���������ɣ�");
				traittext.setText(NPCRandom.RandomTrait(background, 2));
//				System.out.println("�ص������ɣ�");
				idealtext.setText(NPCRandom.RandomSoul(background, "ideal"));
//				System.out.println("���������ɣ�");
				bondtext.setText(NPCRandom.RandomSoul(background, "bound"));
//				System.out.println("������ɣ�");
				flowtext.setText(NPCRandom.RandomSoul(background, "flaworsecret"));
//				System.out.println("ȱ�������ɣ�");
			}
		});
		save.addActionListener(new ActionListener() {//������水ť
			public void actionPerformed(ActionEvent e) {
				String alignment = new String();
				for(int i=0;i<9;i++) {
					if(alignbutton[i].isSelected()) {
						alignment = alignbutton[i].getText();
						break;
					}
				}
				String race = racetext.getText();
				String age = agetext.getText();
				String sex = (String) sexbox.getSelectedItem();
				String background = (String) backbox.getSelectedItem();
				String name = nametext.getText();
				String trait = traittext.getText();
				String ideal = idealtext.getText();
				String bound = bondtext.getText();
				String flaworsecret = flowtext.getText();
				String workandfrom = cometext.getText();
				NPCBackground npc = new NPCBackground(name,race,sex,alignment,age,ideal,bound,flaworsecret,trait,background, workandfrom);
				File f = new File("NPCsave.txt");
				try {
					FileWriter fw = new FileWriter(f,true);
					fw.write(npc.toStringForShow());
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		help.addActionListener(new ActionListener() {//���������ť
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Maininterface m = new Maininterface();
	}

}
