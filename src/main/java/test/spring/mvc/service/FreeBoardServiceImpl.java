package test.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("freeService")
public class FreeBoardServiceImpl implements CrudService{

	@Override
	public List<Object> read() {
		return null;
	}

	@Override
	public void update(Object dto) {		
	}

	@Override
	public void delete(Object dto) {
	}

	@Override
	public int create(Object dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> readNo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*���ٽ�
	 * �߻� �޼��尡 �ϳ��� �������̽����� ��밡��
	 * �޼��� �̸��� ����
	 * �ڵ尡 ����������
	 * �������� ��������
	 * ���� ���α׷��ֿ� �����ϴ�
	 * ����(�Ű�����) : class A{
	  						Runnable run = (�Ű����������龲��) <<���� �������̽�(Runnable) ����
	  				}
	 * 
	*/

}
