package data;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
import java.io.File;
import java.io.IOException;
//import java.util.Collection;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
import java.util.Random;
import jxl.*;
import jxl.read.biff.BiffException;

public class NPCRandom {
	
	public static HashMap<String,String> FileReader(String filename, String sheetname) throws BiffException, IOException {
		String path = new String("resource/"+filename+".xls");
		File f = new File(path);
		Workbook workbook = Workbook.getWorkbook(f);
		Sheet sheet = workbook.getSheet(sheetname);
		HashMap<String,String> map = new HashMap<>();
		
		if (sheet != null){
	        // �������
	        int rows = sheet.getRows();
	        // �������
	        int cols = sheet.getColumns();
	        // ��ȡ����
	        for (int col = 0; col < cols; col=col+2){
	        	for (int row = 0; row < rows; row++){
	        		String key = sheet.getCell(col, row).getContents();
	        		String value = sheet.getCell(col+1, row).getContents();
//	        		System.out.printf("%10s", sheet.getCell(col, row).getContents());
//	        		System.out.printf("%10s", sheet.getCell(col+1, row).getContents());
	        		if((key != null)&&(value != null)&&(key != "")&&(value != "")) {
	        			map.put(key, value);
	        		}
//	        		System.out.println();
	            }
//	            System.out.println();
	        }
//	        System.out.println(map);
		}
		workbook.close();
		return map;
	}
	
	/*
	 * ������֣�������ο�DND����ֲ����������������������ﲻ�������ϣ�5e����ֲ���û�е���ο�pf�Ĵ�ȫchm
	 * ����������Ǵ�https://www.randomlists.com/random-names�����վ���ɵģ�������ÿ�����з���
	 * ������������Ա�
	 */
	public static String RandomName(String race,String sex) {
		String r = "erro";
		int k;
		Random random = new Random();
		HashMap<String, String> map;
		//һЩû���Լ��Ķ������ֱ������
		if(race == "������") race = "����";
		else if(race == "����") race = "����";
			else if(race == "�뾫��") {
				if(random.nextBoolean()) race = "����";
				else race = "����";
			}
		//���ޡ� = ��/Ů��50%
		if(sex == "��") {
			if(random.nextBoolean()) sex = "��";
			else sex = "Ů";
		}
		//��ȡ�ļ�
		try {
			map = FileReader("name", race);
			k = Integer.parseInt(map.get(race+sex+"��"));
			
			k = random.nextInt(k)+1;
			r = map.get(race+sex+k);
		} catch (BiffException | IOException e) {
			System.out.println("erro!");
			e.printStackTrace();
		}
		//
		
		return r;
	}
	
	/*
	 * �������
	 * ����������������
	 */
	public static String RandomAge(String race,String age) {
		String r = "erro";
		String ageNext;
		int k,l;
		Random random = new Random();
		HashMap<String, String> map;
		//��һ��������ֵ��Ϊ����
		switch(age) {
		case "����": ageNext = "����";break;
		case "����": ageNext = "����";break;
		case "����": ageNext = "����";break;
		case "����": ageNext = "����";break;
		default : ageNext = "����";break;
		}
		//��ȡ�ļ�
		try {
			map = FileReader("age", race);
			k = Integer.parseInt(map.get(ageNext));
			l = Integer.parseInt(map.get(age));
			k = random.nextInt(k-l)+l;
			r = Integer.toString(k);
		} catch (BiffException | IOException e) {
			System.out.println("erro!");
			e.printStackTrace();
		}
		//
		
		return r;
	}
	
	/*
	 * ������롢ǣ���ȱ������������֮һ��
	 * ����backgroundΪ������thingsΪ���롢ǣ���ȱ������������һ
	 * background����ЧֵΪMaininterface���ھ���if�ṹ������Ϊxls�ļ��е�����
	 * things����ЧֵΪxls��sheet������ideal��bound��flaworsecret
	 */
	public static String RandomSoul(String background,String things) {
		String r = "erro";
		int k;
		Random random = new Random();
		HashMap<String, String> map;
		//һЩ����ͳһ����
		if(background == "�ﷸ/��̽") background = "�ﷸ";
			else if(background == "����/�Ƕ�ʿ") background = "����";
				else if(background == "�лṤ��/����") background = "�лṤ��";
					else if(background == "����/��ʿ") background = "����";
						else if(background == "ˮ��/����") background = "ˮ��";
							else if(background == "ʿ��/����") background = "ʿ��";
		//�ޱ������������
		if(background == "��") {
			switch (random.nextInt(14)) {
				case 0:background = "��ɮ";break;
				case 1:background = "ƭ��";break;
				case 2:background = "�ﷸ";break;
				case 3:background = "����";break;
				case 4:background = "ƽ��Ӣ��";break;
				case 5:background = "�лṤ��";break;
				case 6:background = "��ʿ";break;
				case 7:background = "����";break;
				case 8:background = "����֮��";break;
				case 9:background = "����";break;
				case 10:background = "ˮ��";break;
				case 11:background = "ʿ��";break;
				case 12:background = "���˶�";break;
				case 13:background = "Զ����";break;
				default:background = "���˶�";break;
			}
		}
		//��ȡ�ļ�
		try {
			map = FileReader("soul", things);
			k = Integer.parseInt(map.get(background+"��"));
			
			k = random.nextInt(k)+1;
			r = map.get(background+k);
		} catch (BiffException | IOException e) {
			System.out.println("erro!");
			e.printStackTrace();
		}
		//
		
		return r;
	}
	
	/*
	 * ����ص㣬����Ϊ����������ص�����
	 * �ص��Ϊ�����ص㡢��ò���������ʡ��ú��츳��ֻ�б����ص�ͱ����й�
	 */
	public static String RandomTrait(String background,int n) {
		String r = "";
		int k,i;
		String key[] = new String[n];
		String things[] = new String[n];
		Random random = new Random();
		HashMap<String, String> map;
		//һЩ����ͳһ����
		if(background == "�ﷸ/��̽") background = "�ﷸ";
			else if(background == "����/�Ƕ�ʿ") background = "����";
				else if(background == "�лṤ��/����") background = "�лṤ��";
					else if(background == "����/��ʿ") background = "����";
						else if(background == "ˮ��/����") background = "ˮ��";
							else if(background == "ʿ��/����") background = "ʿ��";
		//�ޱ������������
		if(background == "��") {
			switch (random.nextInt(14)) {
			case 0:background = "��ɮ";break;
			case 1:background = "ƭ��";break;
			case 2:background = "�ﷸ";break;
			case 3:background = "����";break;
			case 4:background = "ƽ��Ӣ��";break;
			case 5:background = "�лṤ��";break;
			case 6:background = "��ʿ";break;
			case 7:background = "����";break;
			case 8:background = "����֮��";break;
			case 9:background = "����";break;
			case 10:background = "ˮ��";break;
			case 11:background = "ʿ��";break;
			case 12:background = "���˶�";break;
			case 13:background = "Զ����";break;
			default:background = "���˶�";break;
			}
		}
		for(i=0;i<n;i++) {
			switch(random.nextInt(5)) {
			case 0:things[i] = background; key[i] = "trait";break;
			case 1:things[i] = "��ò"; key[i] = "appearance";break;
			case 2:things[i] = "��������"; key[i] = "interaction";break;
			case 3:things[i] = "��"; key[i] = "mannerism";break;
			case 4:things[i] = "�츳"; key[i] = "talent";break;
			default:things[i] = "�츳"; key[i] = "talent";break;
			}
		}
		
		//��ȡ�ļ�
		for(i=0;i<n;i++) {
			try {
				map = FileReader("trait", key[i]);
				k = Integer.parseInt(map.get(things[i]+"��"));
				
				k = random.nextInt(k)+1;
				r = r + "��" + map.get(things[i]+k) + "\n";
			} catch (BiffException | IOException e) {
				System.out.println("erro!");
				e.printStackTrace();
			}
		}
		//
		
		return r;
	}
	
	
//	public static void main(String algs[]) {
//		try {
//			Map<String,String> map = FileReader("name");
//			int i = map.size();
//			System.out.println(i);
//			for(i =1;i<31;i++) {
//				System.out.println(map.get("����"+"��"+i));
//			}
//			for(i =1;i<24;i++) {
//				System.out.println(map.get("����"+"Ů"+i));
//			}
////			String value = null;
////			Collection c = map.values();
////			Iterator iter= c.iterator();
////			while (iter.hasNext()) {
////			    value = iter.next().toString();
////			    System.out.println(value);
////			}
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
