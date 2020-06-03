package jdbc.quiz.dao;

import java.util.List;
import java.util.Map;

import jdbc.quiz.vo.BookVO;

public interface IBookDAO {

	List<BookVO> getBooks();
	
	public void Bsearch();

	public void Csearch();
	
	public void ELogin();
	
	public void RendInfo();
	
	public int LateFee();
	
}
