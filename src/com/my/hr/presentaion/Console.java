package com.my.hr.presentaion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface Console {
	Scanner sc = new Scanner(System.in); //�������̽��� �����ڰ� �������� ������ �����Ѵ�.
	
	static void info(Object obj) {	//�Ķ���͸� objcect�� �����ϸ� �Ÿ���̵� ���θ�ǵǾ� ��밡���ϴ�.
		System.out.println(obj);
	}
	
	static void err(String msg) {
		System.out.println("ERROR] " + msg);
	}
	
	private static void in(String msg) { //�Է¾ȳ��޼���
		System.out.print(msg + "\n> ");
	}
	
	static String inStr(String msg, int len) {	//len : �ִ���ڼ�
		boolean isGood = false;
		String line = "";
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			int length = line.length();
			isGood = 0 < length && length <= len;
			if(!isGood) err("1�� �̻� " + len + "�� ���ϸ� �Է��ϼ���.");
		} while(!isGood);
		
		return line;
	}
	
	static int inNum(String msg) {
		boolean isGood = false;
		String line = "";
		int num = 0;
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			if(line.length() > 0 && line.matches("[0-9]*")) { //String.matches ������ ������ ���Ѵ�. 
				try {
					num = Integer.parseInt(line);
					isGood = true;
				} catch(NumberFormatException e) {}	
			}
			
			if(!isGood) err("0 �̻��� �Է��ϼ���.");
		} while(!isGood);
		
		return num;
	}
	
	static LocalDate inDate(String msg) {
		String line = "";
		LocalDate date = null;
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			if(line.length() > 0) {
				try {
					date = LocalDate.parse(line, DateTimeFormatter.ISO_DATE); 
					// LocalDate.parse(): �Է¹��� ���ڸ� ���ڷ� �ٲ��ִ� API, try catch�� ��� ����ؾ��Ѵ�.
				} catch(DateTimeException e) {}
			}
			
			if(date == null) err("���� ��¥�� YYYY-MM-DD �������� �Է��ϼ���.");
		} while(date == null);
		
		return date;
	}
}
