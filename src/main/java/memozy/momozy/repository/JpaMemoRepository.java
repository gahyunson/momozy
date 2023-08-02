package memozy.momozy.repository;

import memozy.momozy.domain.Memo;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemoRepository implements MemoRepository {
    private final EntityManager em;

    public JpaMemoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }
    @Override
    public Optional<Memo> findById(Long id) {
        Memo memo = em.find(Memo.class, id);
        return Optional.ofNullable(memo);
    }

    @Override
    public Optional<Memo> update(Optional<Memo> memo) {
        em.merge(memo);
        return memo;
    }

    @Override
    public void delete(Memo memo){
        em.remove(memo);
    }

    @Override
    public List<Memo> findAll() {
        return em.createQuery("select m from Memo m", Memo.class).getResultList();
    }
}

