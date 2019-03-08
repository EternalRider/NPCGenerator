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
		this.setTitle("NPC生成器");
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
		Font font = new Font("宋体",Font.PLAIN,20);
		jsp.setBackground(Color.BLUE);
		
		//左上角，阵营九宫格
		alignC = new JPanel();
		alignC.setSize(350, 200);
		alignC.setLayout(new GridLayout(3,3));
		//align.add(new JButton("善良"), BorderLayout.NORTH);
		//align.add(new JButton("邪恶"), BorderLayout.SOUTH);
		//align.add(new JButton("守序"), BorderLayout.WEST);
		//align.add(new JButton("混乱"), BorderLayout.EAST);
		aligngroup = new ButtonGroup();
		alignbutton[0] = new JRadioButton("守序善良");
		alignbutton[1] = new JRadioButton("中立善良");
		alignbutton[2] = new JRadioButton("混乱善良");
		alignbutton[3] = new JRadioButton("守序中立");
		alignbutton[4] = new JRadioButton("绝对中立");
		alignbutton[5] = new JRadioButton("混乱中立");
		alignbutton[6] = new JRadioButton("守序邪恶");
		alignbutton[7] = new JRadioButton("中立邪恶");
		alignbutton[8] = new JRadioButton("混乱邪恶");
		for(int i=0;i<9;i++) {
			alignC.add(alignbutton[i]);
			alignbutton[i].setFont(font);
			aligngroup.add(alignbutton[i]);
		}
		alignbutton[4].setSelected(true);
		face.add(alignC);
		alignC.setBackground(Color.BLUE);
		
		//右上角，名字+性别，年龄（下拉框+文本框）+背景（下拉框）
		base = new JPanel();//面板
		base.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		base.setSize(500,175);
		namelabel = new JLabel("姓名:");//姓名标签
		namelabel.setFont(font);
		base.add(namelabel);
		nametext = new JTextField(25);//姓名文本框
		nametext.setFont(font);
		//nametext.setSize(400, 22);
		base.add(nametext);
		nametext.setLocation(50, 0);
		sexlabel = new JLabel("性别:");//性别标签
		sexlabel.setFont(font);
		base.add(sexlabel);
		sexbox = new JComboBox();//性别下拉框
		sexbox.setFont(font);
		sexbox.addItem("男");
		sexbox.addItem("女");
		sexbox.addItem("无");
		base.add(sexbox);
		agelabel = new JLabel("年龄:");//年龄标签
		agelabel.setFont(font);
		base.add(agelabel);
		agebox = new JComboBox();//年龄下拉框
		agebox.setFont(font);
		agebox.addItem("少年");
		agebox.addItem("青年");
		agebox.addItem("中年");
		agebox.addItem("老年");
		base.add(agebox);
		agebox.setSelectedIndex(1);
		agetext = new JTextField(4);//年龄文本框
		agetext.setFont(font);
		base.add(agetext);
		backlabel = new JLabel("背景:");//背景标签
		backlabel.setFont(font);
		base.add(backlabel);
		backbox = new JComboBox();//背景下拉框
		backbox.setFont(font);
		backbox.addItem("无");
		backbox.addItem("侍僧");
		backbox.addItem("骗子");
		backbox.addItem("罪犯/密探");
		backbox.addItem("艺人/角斗士");
		backbox.addItem("平民英雄");
		backbox.addItem("行会工匠/商人");
		backbox.addItem("隐士");
		backbox.addItem("贵族/骑士");
		backbox.addItem("化外之民");
		backbox.addItem("智者");
		backbox.addItem("水手/海盗");
		backbox.addItem("士兵/守卫");
		backbox.addItem("流浪儿");
		backbox.addItem("远行者");
		base.add(backbox);
		racelabel = new JLabel("种族:");//种族标签
		racelabel.setFont(font);
		base.add(racelabel);
		racebox = new JComboBox();//种族下拉框
		racebox.setFont(font);
		racebox.addItem("人类");
		racebox.addItem("矮人");
		racebox.addItem("精灵");
		racebox.addItem("半身人");
		racebox.addItem("龙裔");
		racebox.addItem("侏儒");
		racebox.addItem("半精灵");
		racebox.addItem("半兽人");
		racebox.addItem("魔裔");
		racebox.addItem("神裔");
		racebox.addItem("兽人");
		racebox.addItem("地精");
		racebox.addItem("大地精");
		base.add(racebox);
		//racebox.setSelectedIndex(0);
		racetext = new JTextField(8);//种族文本框
		racetext.setFont(font);
		racetext.setText("人类");
		base.add(racetext);
		random = new JButton("生成");//生成按钮
		random.setFont(font);
		save = new JButton("存档");//存档按钮
		save.setFont(font);
		help = new JButton("?");//帮助按钮
		help.setFont(font);
		base.add(random);
		base.add(save);
		base.add(help);
		face.add(base);
		base.setLocation(350,0);
		//base.setBackground(Color.BLUE);
		
		//右下角，理想、羁绊、缺点
		soul = new JPanel();//面板
		soul.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		soul.setSize(530,410);
		ideallabel = new JLabel("理想:");//理想标签
		ideallabel.setFont(font);
		soul.add(ideallabel);
		idealtext = new JTextArea(3,49);//理想文本域
		idealtext.setLineWrap(true);
		soul.add(idealtext);
		idealtext.setFont(font);
		bondlabel = new JLabel("羁绊:");//羁绊标签
		bondlabel.setFont(font);
		soul.add(bondlabel);
		bondtext = new JTextArea(3,49);//羁绊文本域
		bondtext.setLineWrap(true);
		soul.add(bondtext);
		bondtext.setFont(font);
		flowlabel = new JLabel("缺点:");//缺点标签
		flowlabel.setFont(font);
		soul.add(flowlabel);
		flowtext = new JTextArea(3,49);//缺点文本域
		flowtext.setLineWrap(true);
		soul.add(flowtext);
		flowtext.setFont(font);
		soul.setLocation(350,165);
		//soul.setBackground(Color.BLUE);
		face.add(soul);
		
		//左下角，特点，工作和来历
		color = new JPanel();//面板
		color.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		color.setSize(350,450);
		traitlabel = new JLabel("特点:");//特点标签
		traitlabel.setFont(font);
		color.add(traitlabel);
		traittext = new JTextArea(3,35);//特点文本域
		traittext.setLineWrap(true);
		color.add(traittext);
		traittext.setFont(font);
		comelabel = new JLabel("工作和来历:");//来历标签
		comelabel.setFont(font);
		color.add(comelabel);
		cometext = new JTextArea(8,35);//来历文本域
		cometext.setLineWrap(true);
		color.add(cometext);
		cometext.setFont(font);
		color.setLocation(0,200);
		//soul.setBackground(Color.BLUE);
		face.add(color);
		
		//按钮
		//botton = new JPanel();
		//botton.setSize(530, 100);
		//botton.setLocation(350, 570);
		//random.setLocation(350, 500);
		//save.setLocation(450,500);
		//botton.add(random);
		//botton.add(save);
		//botton.setBackground(Color.BLUE);
		//face.add(botton);
		
		//事件监听
		racebox.addActionListener(new ActionListener() {//选中种族时，文本框显示当前种族
			public void actionPerformed(ActionEvent e) {
				racetext.setText((String) racebox.getSelectedItem());
				
			}
		}); 
		/*
		 * nametext名字
		 * agetext年龄
		 * racetext种族
		 * traittext特点
		 * cometext来历
		 * idealtext理想
		 * bondtext羁绊
		 * flowtext缺点
		 */
		random.addActionListener(new ActionListener() {//点击生成按钮
			public void actionPerformed(ActionEvent e) {
				String race = (String) racebox.getSelectedItem();
				String age = (String) agebox.getSelectedItem();
				String sex = (String) sexbox.getSelectedItem();
				String background = (String) backbox.getSelectedItem();
//				System.out.println("种族="+race+";年龄="+age+";性别="+sex+";背景="+background);
				nametext.setText(NPCRandom.RandomName(race,sex));
//				System.out.println("名字随机完成；");
				agetext.setText(NPCRandom.RandomAge(race, age));
//				System.out.println("年龄随机完成；");
				traittext.setText(NPCRandom.RandomTrait(background, 2));
//				System.out.println("特点随机完成；");
				idealtext.setText(NPCRandom.RandomSoul(background, "ideal"));
//				System.out.println("理想随机完成；");
				bondtext.setText(NPCRandom.RandomSoul(background, "bound"));
//				System.out.println("羁绊随机完成；");
				flowtext.setText(NPCRandom.RandomSoul(background, "flaworsecret"));
//				System.out.println("缺点随机完成；");
			}
		});
		save.addActionListener(new ActionListener() {//点击保存按钮
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
		help.addActionListener(new ActionListener() {//点击帮助按钮
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
