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
	
	/*람다식
	 * 추상 메서드가 하나인 인터페이스에만 사용가능
	 * 메서드 이름이 없다
	 * 코드가 간결해진다
	 * 가독성이 높아진다
	 * 병렬 프로그래밍에 용이하다
	 * 문법(매개변수) : class A{
	  						Runnable run = (매개변수있으면쓰기) <<냅다 인터페이스(Runnable) 선언
	  				}
	 * 
	*/

}
