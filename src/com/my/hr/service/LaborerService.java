package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerService {
	List<Laborer> getLaborers();
	Laborer getLaborer(int laborerId);
	void addLaborer(String laborerName, LocalDate hireDate);	
	void fixLaborer(Laborer laborer);	
	void delLaborer(int laborerId);
	// select = get , insert = add , update = fix , delete = del
	// 현장마다 규칙명이 있음으로 서비스메소드 이름을 규칙대로 만든다.
}
