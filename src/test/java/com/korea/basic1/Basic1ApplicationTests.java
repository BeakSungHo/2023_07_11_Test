package com.korea.basic1;

import com.korea.basic1.Entity.Book;
import com.korea.basic1.Entity.BookStore;
import com.korea.basic1.Repository.BookRepository;
import com.korea.basic1.Repository.BookStoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Basic1ApplicationTests {
@Autowired
private BookRepository bookRepository;
@Autowired
private BookStoreRepository bookStoreRepository;


// 서점 두개를 만들어주세요.
// 서점은 각각 이름과 보유서적으로 구성됩니다.
// 각각 코리아서점, 아이티문고
	@Test
	void t2() {
		BookStore bs1 = new BookStore();
		bs1.setStore_Name("코리아서점");
		this.bookStoreRepository.save(bs1);
		BookStore bs2 = new BookStore();
		bs2.setStore_Name("아이티 문고");
		this.bookStoreRepository.save(bs2);

// 구현 및 테스트

	}



// 모든 서점 정보 조회

// 출력 : 코리아서점, 아이티문고

	@Test

	void t3() {
		List<BookStore> all = this.bookStoreRepository.findAll();
		assertEquals(2, all.size());
		System.out.print("출력 : ");
		for(int i = 0 ;i<all.size();i++){
			BookStore bs = all.get(i);
			System.out.print(bs.getStore_Name()+", ");
		}
		System.out.println();

// 구현 및 테스트

	}





// 아이티문고의 이름을 IT문고로 변경해주세요.

// 변경 후엔 t3() 메서드를 실행해 확인해주세요.

// 출력 : 코리아서점, IT문고

	@Test

	void t4() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
		Optional<BookStore> obs= this.bookStoreRepository.findById(2);
		assertTrue(obs.isPresent());
		BookStore bs = obs.get();
		bs.setStore_Name("IT문고");
		this.bookStoreRepository.save(bs);
//		아이티문고
// 구현 및 테스트

	}



// 책 5권을 만들어주세요.
// 책은 제목과 저자, 보유 서점으로 구성됩니다.
// 책은 각각
// 어린왕자, 생떽쥐페리, 코리아서점
// 해리포터, 조앤 롤링, 코리아서점
// 죄와벌, 도스토예프스키, 코리아서점
// 점프 투 스프링부트, 박응용, 아이티문고
// 수학의 정석, 홍성대, 아이티문고
// 로 만들어주세요.
	@Test
	void t5() {
		BookStore korea = this.bookStoreRepository.findById(1).get();
		BookStore it = this.bookStoreRepository.findById(2).get();

		// 어린왕자, 생떽쥐페리, 코리아서점
		Book b1 = new Book();
		b1.setAuthor("생떽쥐페리");
		b1.setBookName("어린왕자");
		b1.setBookStore(korea);
		this.bookRepository.save(b1);

		// 해리포터, 조앤 롤링, 코리아서점
		Book b2 = new Book();
		b2.setAuthor("조앤 롤링");
		b2.setBookName("해리포터");
		b2.setBookStore(korea);
		this.bookRepository.save(b2);

		// 죄와벌, 도스토예프스키, 코리아서점
		Book b3 = new Book();
		b3.setAuthor("도스토예프스키");
		b3.setBookName("죄와벌");
		b3.setBookStore(korea);
		this.bookRepository.save(b3);

		// 점프 투 스프링부트, 박응용, 아이티문고
		Book b4 = new Book();
		b4.setAuthor("박응용");
		b4.setBookName(" 점프 투 스프링부트");
		b4.setBookStore(it);
		this.bookRepository.save(b4);

		// 수학의 정석, 홍성대, 아이티문고
		Book b5 = new Book();
		b5.setAuthor("홍성대");
		b5.setBookName("수학의 정석");
		b5.setBookStore(it);
		this.bookRepository.save(b5);
// 구현 및 테스트

	}



// 모든 책의 제목을 출력해주세요.

	@Test

	void t6() {
		List<Book> all = this.bookRepository.findAll();
		System.out.println("모든 책의 제목 출력");
		for(int i = 0 ;i<all.size();i++) {
			Book b = all.get(i);
			System.out.println("제목  : " + b.getBookName());
			System.out.println("저자  : " + b.getAuthor());
			System.out.println("책  : " + b.getBookStore());
		}
// 구현 및 테스트

	}



// 코리아서점에서 판매하는 책의 제목을 출력해주세요.

	@Test

	void t7() {
		List<BookStore> all = this.bookStoreRepository.findAll();
		BookStore korea = all.get(0);

		System.out.println("코리아서점에서 판매중인 책들");
		for (Book b :korea.getBookList()){
			System.out.println("\t"+b.getBookName());

		}
// 구현 및 테스트

	}



// 박응용이 쓴 책을 삭제해주세요.

// 삭제 후 t5 메서드를 이용해 확인해주세요.

	@Test

	void t8() {
		Book b = this.bookRepository.findByAuthor("박응용");
		this.bookRepository.delete(b);
// 구현 및 테스트

	}
}
