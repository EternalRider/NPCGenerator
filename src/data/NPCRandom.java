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
	        // 获得行数
	        int rows = sheet.getRows();
	        // 获得列数
	        int cols = sheet.getColumns();
	        // 读取数据
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
	 * 随机名字，各种族参考DND玩家手册里各种族的姓名，但是这里不生成姓氏，5e玩家手册中没有的则参考pf的大全chm
	 * 人类的名字是从https://www.randomlists.com/random-names这个网站生成的，我懒得每个进行翻译
	 * 参数是种族和性别
	 */
	public static String RandomName(String race,String sex) {
		String r = "erro";
		int k;
		Random random = new Random();
		HashMap<String, String> map;
		//一些没有自己的独立名字表的种族
		if(race == "半兽人") race = "兽人";
		else if(race == "神裔") race = "人类";
			else if(race == "半精灵") {
				if(random.nextBoolean()) race = "人类";
				else race = "精灵";
			}
		//“无” = 男/女各50%
		if(sex == "无") {
			if(random.nextBoolean()) sex = "男";
			else sex = "女";
		}
		//读取文件
		try {
			map = FileReader("name", race);
			k = Integer.parseInt(map.get(race+sex+"总"));
			
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
	 * 随机年龄
	 * 参数是种族和年龄层
	 */
	public static String RandomAge(String race,String age) {
		String r = "erro";
		String ageNext;
		int k,l;
		Random random = new Random();
		HashMap<String, String> map;
		//下一个年龄层的值作为上限
		switch(age) {
		case "少年": ageNext = "青年";break;
		case "青年": ageNext = "中年";break;
		case "中年": ageNext = "老年";break;
		case "老年": ageNext = "寿命";break;
		default : ageNext = "寿命";break;
		}
		//读取文件
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
	 * 随机理想、牵绊和缺点秘密三核心之一，
	 * 参数background为背景，things为理想、牵绊和缺点秘密三者其一
	 * background的有效值为Maininterface，在经过if结构修正后为xls文件中的名字
	 * things的有效值为xls的sheet名，即ideal、bound、flaworsecret
	 */
	public static String RandomSoul(String background,String things) {
		String r = "erro";
		int k;
		Random random = new Random();
		HashMap<String, String> map;
		//一些背景统一名字
		if(background == "罪犯/密探") background = "罪犯";
			else if(background == "艺人/角斗士") background = "艺人";
				else if(background == "行会工匠/商人") background = "行会工匠";
					else if(background == "贵族/骑士") background = "贵族";
						else if(background == "水手/海盗") background = "水手";
							else if(background == "士兵/守卫") background = "士兵";
		//无背景即随机背景
		if(background == "无") {
			switch (random.nextInt(14)) {
				case 0:background = "侍僧";break;
				case 1:background = "骗子";break;
				case 2:background = "罪犯";break;
				case 3:background = "艺人";break;
				case 4:background = "平民英雄";break;
				case 5:background = "行会工匠";break;
				case 6:background = "隐士";break;
				case 7:background = "贵族";break;
				case 8:background = "化外之民";break;
				case 9:background = "智者";break;
				case 10:background = "水手";break;
				case 11:background = "士兵";break;
				case 12:background = "流浪儿";break;
				case 13:background = "远行者";break;
				default:background = "流浪儿";break;
			}
		}
		//读取文件
		try {
			map = FileReader("soul", things);
			k = Integer.parseInt(map.get(background+"总"));
			
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
	 * 随机特点，参数为背景和随机特点条数
	 * 特点分为背景特点、外貌、互动特质、癖好和天赋，只有背景特点和背景有关
	 */
	public static String RandomTrait(String background,int n) {
		String r = "";
		int k,i;
		String key[] = new String[n];
		String things[] = new String[n];
		Random random = new Random();
		HashMap<String, String> map;
		//一些背景统一名字
		if(background == "罪犯/密探") background = "罪犯";
			else if(background == "艺人/角斗士") background = "艺人";
				else if(background == "行会工匠/商人") background = "行会工匠";
					else if(background == "贵族/骑士") background = "贵族";
						else if(background == "水手/海盗") background = "水手";
							else if(background == "士兵/守卫") background = "士兵";
		//无背景即随机背景
		if(background == "无") {
			switch (random.nextInt(14)) {
			case 0:background = "侍僧";break;
			case 1:background = "骗子";break;
			case 2:background = "罪犯";break;
			case 3:background = "艺人";break;
			case 4:background = "平民英雄";break;
			case 5:background = "行会工匠";break;
			case 6:background = "隐士";break;
			case 7:background = "贵族";break;
			case 8:background = "化外之民";break;
			case 9:background = "智者";break;
			case 10:background = "水手";break;
			case 11:background = "士兵";break;
			case 12:background = "流浪儿";break;
			case 13:background = "远行者";break;
			default:background = "流浪儿";break;
			}
		}
		for(i=0;i<n;i++) {
			switch(random.nextInt(5)) {
			case 0:things[i] = background; key[i] = "trait";break;
			case 1:things[i] = "外貌"; key[i] = "appearance";break;
			case 2:things[i] = "互动特质"; key[i] = "interaction";break;
			case 3:things[i] = "癖好"; key[i] = "mannerism";break;
			case 4:things[i] = "天赋"; key[i] = "talent";break;
			default:things[i] = "天赋"; key[i] = "talent";break;
			}
		}
		
		//读取文件
		for(i=0;i<n;i++) {
			try {
				map = FileReader("trait", key[i]);
				k = Integer.parseInt(map.get(things[i]+"总"));
				
				k = random.nextInt(k)+1;
				r = r + "·" + map.get(things[i]+k) + "\n";
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
//				System.out.println(map.get("矮人"+"男"+i));
//			}
//			for(i =1;i<24;i++) {
//				System.out.println(map.get("矮人"+"女"+i));
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
