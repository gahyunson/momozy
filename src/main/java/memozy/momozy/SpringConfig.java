package memozy.momozy;

import memozy.momozy.repository.JpaMemoRepository;
import memozy.momozy.repository.MemoRepository;
import memozy.momozy.service.MemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }



    @Bean
    public MemoService memoService(){
        return new MemoService(memoRepository());
    }
    @Bean
    public MemoRepository memoRepository(){
        return new JpaMemoRepository(em);
    }


//    @Bean
//    public MemoService memoService(){
//        return new MemoService(memoRepository());
//    }
//
//    @Bean
//    public MemoRepository memoRepository() {
//        return new MemoryMemoRepository();
//    }
}
