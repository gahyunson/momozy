package memozy.momozy.repository;

import memozy.momozy.domain.Memo;
import memozy.momozy.repository.MemoryMemoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemoRepositoryTest {
    MemoryMemoRepository repository = new MemoryMemoRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Memo memo = new Memo();
        memo.setTitle("The Dog's Day");
        memo.setContent("Today was The Dog's Day");

        repository.save(memo);
    }

//    @Test
//    public void findByTitle(){
//        Memo memo = new Memo();
//
//    }
    @Test
    public void findAll(){
        Memo memo1 = new Memo();
        memo1.setTitle("I'm living with a cat");
        memo1.setContent("It's been about 6 months.");
        repository.save(memo1);

        Memo memo2 = new Memo();
        memo2.setTitle("My New Thing.");
        memo2.setContent("I got a new job!");
        repository.save(memo2);

    }
}
