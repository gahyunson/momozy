package memozy.momozy.service;

import memozy.momozy.domain.Memo;
import memozy.momozy.repository.MemoRepository;
import memozy.momozy.repository.MemoryMemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemoServiceIntegrationTest {
    @Autowired MemoService memoService;
    @Autowired MemoRepository memoRepository;

    @Test
    void write() {
        //given
        Memo memo = new Memo();
        memo.setTitle("It was so Good Travel");

        //when
        Long saveId = memoService.write(memo);

        //then
        Memo findMemo = memoRepository.findById(saveId).get();
        Assertions.assertEquals(memo.getTitle(), findMemo.getTitle());
    }
}