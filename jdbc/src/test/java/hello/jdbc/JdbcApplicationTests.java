package hello.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JdbcApplicationTests {

	@Test
	void contextLoads() {

		String a = "hihi";
		String b = "hihi";
		String c = new String("hihi");
		String d = c.intern();
		System.out.println(a==c);
		System.out.println("hihi" == a);
		System.out.println("hihi" == c);
		System.out.println("hihi" == d);
//		assertThat(a).isSameAs(c);
	}

	@Test
	void test(){
		String test = "hello";
		String test2 = "hello";
		String test3 = new String("hello");

		assertThat(test).isSameAs(test2);
		assertThat(test).isNotSameAs(test3);
		assertThat(test).isSameAs(test3.intern());
	}

}
