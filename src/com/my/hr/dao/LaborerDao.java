package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerDao {
	List<Laborer> selectLaborers();	// 리스트 검색
	Laborer selectLaborer(int laborerId); // 단일 검색
	void insertLaborer(String laborerName, LocalDate hireDate);	// 저장 , 수정 삭제는 리턴값이 없음으로 void
	void updateLaborer(Laborer laborer);	// 사용해야할 데이터 (ID검색, 이름수정, 날짜수정)가 3개 이상임으로 Laborer을 이용하는게 좋다.
	void deleteLaborer(int laborerId);	// 특정 노동자 한명만 검색하면 되기떄문에 Id값만 넣는다
}
