package data;
import org.json.*;

public class NPCBackground {
	/*
	 * 角色基础：名字、种族、性别、年龄、阵营
	 * 
	 * 角色填色：工作与来历、外貌、特点、背景
	 * 
	 * 角色灵魂：理想、牵绊、缺点
	 * 
	 * 角色配菜：有用知识、癖好、天赋
	 */
	public String name;//名字，随机生成，文本框
	public String race;//种族，决定名字表和年龄表，不随机
	public String sex;//性别，下拉框，男、女、无
	public String alignment;//阵营，九宫格，影响理想表
	public String age;//年龄，下拉框分少年、青年、中年、老年
	
	public String ideal;//理想，文本框，随机
	public String bound;//牵绊，文本框，随机
	public String flaworsecret;//缺点或秘密，文本框，随机
	
	public String trait;//特点，随机，文本框，包括：外貌、属性特点、互动特质、特点
	public String background;//背景，下拉框，影响理想、牵绊、缺点、特点表
	public String workandfrom;//工作与来历，文本框，不随机
	
//	public String talents;//天赋
//	public String mannerism;//癖好
//	public String usefulknowledge;//有用知识
	
	public NPCBackground(String name,String race,String sex,String alignment,String age,String ideal,String bound,String flaworsecret,String trait,String background,String workandfrom) {
		this.name = name;
		this.race = race;
		this.sex = sex;
		this.alignment = alignment;
		this.age = age;
		this.ideal = ideal;
		this.bound = bound;
		this.flaworsecret = flaworsecret;
		this.trait = trait;
		this.background = background;
		this.workandfrom = workandfrom;
	}
	
	public String toStringForShow() {
		String r = new String();
		String br = System.getProperty("line.separator");
		r = "{"+br+"名字："+name+br+"种族："+race+br+"性别："+sex+br+"阵营："+alignment+br+"年龄："+age+br+"理想："+ideal+br+"羁绊："+bound+br+"缺点："+flaworsecret+br+"特点："+trait+br+"背景："+background+br+"工作与来历："+workandfrom+br+"}"+br;
		return r;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject(this);
		return json;
	}

}
