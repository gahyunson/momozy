package memozy.momozy.repository;

import memozy.momozy.domain.Memo;

import java.util.*;

public class MemoryMemoRepository implements MemoRepository {
    private static Map<Long, Memo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Memo save(Memo memo) {
        memo.setId(++sequence);
        store.put(memo.getId(), memo);
        return memo;
    }

    @Override
    public Optional<Memo> update(Optional<Memo> memo) {
        return Optional.empty();
    }

    @Override
    public void delete(Memo memo) {

    }


    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Memo> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
