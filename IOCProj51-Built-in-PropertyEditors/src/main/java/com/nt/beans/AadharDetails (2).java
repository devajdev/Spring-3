package com.nt.beans;

import java.io.File;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class AadharDetails {
	private long uid;
	private String name;
	private Date  dob;
	private File photoPath;
	private String[] verifiers;
	private boolean maritalStatus;
	private char  gender;
	private float  height;
	private int pinCode;
	private Class clazz;
	private Currency  currencycode;
	private Locale  locale;
	private char[] nickNameChars;
	private  int[] pinNumbers;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public File getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(File photoPath) {
		this.photoPath = photoPath;
	}
	public String[] getVerifiers() {
		return verifiers;
	}
	public void setVerifiers(String[] verifiers) {
		this.verifiers = verifiers;
	}
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public Currency getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(Currency currencycode) {
		this.currencycode = currencycode;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public char[] getNickNameChars() {
		return nickNameChars;
	}
	public void setNickNameChars(char[] nickNameChars) {
		this.nickNameChars = nickNameChars;
	}
	public int[] getPinNumbers() {
		return pinNumbers;
	}
	public void setPinNumbers(int[] pinNumbers) {
		this.pinNumbers = pinNumbers;
	}
	
	@Override
	public String toString() {
		return "AadharDetails [uid=" + uid + ", name=" + name + ", dob=" + dob + ", photoPath=" + photoPath
				+ ", verifiers=" + Arrays.toString(verifiers) + ", maritalStatus=" + maritalStatus + ", gender="
				+ gender + ", height=" + height + ", pinCode=" + pinCode + ", clazz=" + clazz + ", currencycode="
				+ currencycode + ", locale=" + locale + ", nickNameChars=" + Arrays.toString(nickNameChars)
				+ ", pinNumbers=" + Arrays.toString(pinNumbers) + "]";
	}
	
	
	


}
