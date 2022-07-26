package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public class LaborerDaoImpl implements LaborerDao {
	private List<Laborer> laborers;
	private int laborerIdSeq; // ID값	
		
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborers = laborers;
		this.laborerIdSeq = 1; // ID값은 1이상 자연수로 시작하기때문에 1을 준다.
	}

	@Override
	public List<Laborer> selectLaborers() {
		return laborers;
	}

	@Override
	public Laborer selectLaborer(int laborerId) {
		Laborer laborer = null;
		
		for(Laborer laborerTmp: laborers) {
			if(laborerTmp.getLaborerId() == laborerId) {
				laborer = laborerTmp;
				break;	// break를 쓰지않으면 foreach가 검색이 끝나도 계속돌기떄문에 빠져나온다.
			}
		}
		
		return laborer;
	}

	@Override
	public void insertLaborer(String laborerName, LocalDate hireDate) {
		laborers.add(new Laborer(laborerIdSeq++, laborerName, hireDate));
	}

	@Override
	public void updateLaborer(Laborer laborerTmp) {
		laborers.forEach(laborer -> {	// foreach API사용해봄(람다식). 그냥 foreach문도 가능
			if(laborer.getLaborerId() == laborerTmp.getLaborerId()) {
				laborer.setName(laborerTmp.getName());
				laborer.setHireDate(laborerTmp.getHireDate());
			}
		});
	}

	@Override
	public void deleteLaborer(int laborerId) {
		Laborer laborer = null;	// 검색해온 정보를 담을 laborer
		laborer = selectLaborer(laborerId);	//한명 검색은 위에 만들어 두었음으로 이용한다.
		if(laborer != null) laborers.remove(laborer);
	}
}
