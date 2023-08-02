package memozy.momozy.repository;

import memozy.momozy.domain.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    Optional<Memo> update(Optional<Memo> memo);
    void delete(Memo memo);
    List<Memo> findAll();
}
