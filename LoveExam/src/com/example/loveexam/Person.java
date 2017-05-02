package com.example.loveexam;

public class Person {
	private int image;
	private String txtName,txtnumber;
	public Person(int image, String txtName, String txtnumber) {
		super();
		this.image = image;
		this.txtName = txtName;
		this.txtnumber = txtnumber;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getTxtName() {
		return txtName;
	}
	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
	public String getTxtnumber() {
		return txtnumber;
	}
	public void setTxtnumber(String txtnumber) {
		this.txtnumber = txtnumber;
	}

}
