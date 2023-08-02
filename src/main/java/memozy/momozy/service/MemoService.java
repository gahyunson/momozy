package memozy.momozy.service;

import memozy.momozy.controller.MemoForm;
import memozy.momozy.domain.Memo;
import memozy.momozy.repository.MemoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Long write(Memo memo) {
        memoRepository.save(memo);
        return memo.getId();
    }

    public Optional<Memo> findMemoId(Long id){
        Optional<Memo> memo = memoRepository.findById(id);
        return memo;
    }

    public void delete(Long id) {
        Optional<Memo> memo = findMemoId(id);
        memoRepository.delete(memo.get());
    }

    public List<Memo> findMemo() {
        return memoRepository.findAll();
    }
    }


