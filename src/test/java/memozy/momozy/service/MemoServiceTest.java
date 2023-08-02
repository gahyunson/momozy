package memozy.momozy.service;

import memozy.momozy.domain.Memo;
import memozy.momozy.repository.MemoryMemoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoServiceTest {
    MemoService memoService;
    MemoryMemoRepository memoryMemoRepository;

    @Test
    void write() {
        Memo memo = new Memo();
        memo.setTitle("It was so Good Travel");

//        String saveTitle = memoService.write(memo);


    }
}