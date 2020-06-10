package bean;

import java.sql.Timestamp;

public class User {
	private int id;
	private String name;
	private String text;
	private Timestamp datenow;
	private Timestamp dateedit;

	public User(String name, String text, Timestamp datenow, Timestamp dateedit) {
		this.name = name;
		this.text = text;
		this.datenow = dateedit;
		this.dateedit = dateedit;
	}

	public User(int id2, String name2, String text2, Timestamp datenow2, Timestamp dateedit2) {
		this.id = id2;
		this.name = name2;
		this.text = text2;
		this.datenow = dateedit2;
		this.dateedit = dateedit2;
	}

	public User(String text2, Timestamp dateedit2) {
		this.text = text2;
		this.dateedit = dateedit2;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public  int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}

	public Timestamp getdatenow(){
		return datenow;
	}

	public void setdatenow(Timestamp datenow){
		this.datenow = datenow;
	}

	public Timestamp getdateedit(){
		return dateedit;
	}

	public void setdateedit(Timestamp dateedit){
		this.dateedit = dateedit;
	}




}
