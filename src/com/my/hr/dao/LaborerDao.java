package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerDao {
	List<Laborer> selectLaborers();	// ����Ʈ �˻�
	Laborer selectLaborer(int laborerId); // ���� �˻�
	void insertLaborer(String laborerName, LocalDate hireDate);	// ���� , ���� ������ ���ϰ��� �������� void
	void updateLaborer(Laborer laborer);	// ����ؾ��� ������ (ID�˻�, �̸�����, ��¥����)�� 3�� �̻������� Laborer�� �̿��ϴ°� ����.
	void deleteLaborer(int laborerId);	// Ư�� �뵿�� �Ѹ� �˻��ϸ� �Ǳ⋚���� Id���� �ִ´�
}
