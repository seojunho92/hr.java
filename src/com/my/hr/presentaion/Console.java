package com.my.hr.presentaion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface Console {
	Scanner sc = new Scanner(System.in); //인터페이스는 생성자가 없음으로 위에서 선언한다.
	
	static void info(Object obj) {	//파라미터를 objcect로 선언하면 어떤타입이든 프로모션되어 사용가능하다.
		System.out.println(obj);
	}
	
	static void err(String msg) {
		System.out.println("ERROR] " + msg);
	}
	
	private static void in(String msg) { //입력안내메세지
		System.out.print(msg + "\n> ");
	}
	
	static String inStr(String msg, int len) {	//len : 최대글자수
		boolean isGood = false;
		String line = "";
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			int length = line.length();
			isGood = 0 < length && length <= len;
			if(!isGood) err("1자 이상 " + len + "자 이하를 입력하세요.");
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
			
			if(line.length() > 0 && line.matches("[0-9]*")) { //String.matches 문자의 패턴을 정한다. 
				try {
					num = Integer.parseInt(line);
					isGood = true;
				} catch(NumberFormatException e) {}	
			}
			
			if(!isGood) err("0 이상을 입력하세요.");
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
					// LocalDate.parse(): 입력받은 문자를 날자로 바꿔주는 API, try catch로 묶어서 사용해야한다.
				} catch(DateTimeException e) {}
			}
			
			if(date == null) err("실제 날짜를 YYYY-MM-DD 형식으로 입력하세요.");
		} while(date == null);
		
		return date;
	}
}
