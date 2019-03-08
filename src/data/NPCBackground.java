package data;
import org.json.*;

public class NPCBackground {
	/*
	 * ��ɫ���������֡����塢�Ա����䡢��Ӫ
	 * 
	 * ��ɫ��ɫ����������������ò���ص㡢����
	 * 
	 * ��ɫ��꣺���롢ǣ��ȱ��
	 * 
	 * ��ɫ��ˣ�����֪ʶ���á��츳
	 */
	public String name;//���֣�������ɣ��ı���
	public String race;//���壬�������ֱ������������
	public String sex;//�Ա��������С�Ů����
	public String alignment;//��Ӫ���Ź���Ӱ�������
	public String age;//���䣬����������ꡢ���ꡢ���ꡢ����
	
	public String ideal;//���룬�ı������
	public String bound;//ǣ���ı������
	public String flaworsecret;//ȱ������ܣ��ı������
	
	public String trait;//�ص㣬������ı��򣬰�������ò�������ص㡢�������ʡ��ص�
	public String background;//������������Ӱ�����롢ǣ��ȱ�㡢�ص��
	public String workandfrom;//�������������ı��򣬲����
	
//	public String talents;//�츳
//	public String mannerism;//��
//	public String usefulknowledge;//����֪ʶ
	
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
		r = "{"+br+"���֣�"+name+br+"���壺"+race+br+"�Ա�"+sex+br+"��Ӫ��"+alignment+br+"���䣺"+age+br+"���룺"+ideal+br+"�"+bound+br+"ȱ�㣺"+flaworsecret+br+"�ص㣺"+trait+br+"������"+background+br+"������������"+workandfrom+br+"}"+br;
		return r;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject(this);
		return json;
	}

}
