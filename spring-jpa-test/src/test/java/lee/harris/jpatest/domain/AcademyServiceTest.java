package lee.harris.jpatest.domain;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class AcademyServiceTest {
    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyService academyService;

    @AfterEach
    void tearDown() {
        academyRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        List<Academy> academies = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Academy academy = Academy.builder()
                    .name("강남스쿨" + i)
                    .build();
            academy.addSubject(Subject.builder().name("자바웹개발" + i).build());
            academies.add(academy);
        }
        academyRepository.saveAll(academies);
    }

    @Test
    public void Academy_여러개를_조회시_Subject가_N1_쿼리가발생한다() throws Exception {
        //given
        List<String> subjectNames = academyService.findAllSubjectNames();
        //then
        assertThat(subjectNames.size(), is(10));
    }
}