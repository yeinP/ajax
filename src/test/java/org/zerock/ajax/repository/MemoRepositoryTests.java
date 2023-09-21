package org.zerock.ajax.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.ajax.entity.Memo;
import org.zerock.ajax.repository.MemoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1,100).forEach( i -> {
            Memo memo = Memo.builder().memoText("sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno= 100L;
        Optional<Memo> result = memoRepository.findById(mno);
        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("update Text").build();
        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void testDelete() {
        Long mno = 100L;
        memoRepository.deleteById(mno);

    }

    @Test
    public void testPageDefault() {
        Sort mno = Sort.by("mno").descending();
        Sort mno2 = Sort.by("mno").descending();
//        and 시키는 기능
        Sort sortall = mno.and(mno2); 
        Pageable pageable = PageRequest.of(0,10, mno);
        Page<Memo> result =
                memoRepository.findAll(pageable);
        System.out.println(result);
        System.out.println("------------------------");
        System.out.println("total page " + result.getTotalPages());
        System.out.println("total count: " + result
                .getTotalElements());
        System.out.println("page Number: " +result.getNumber());
        System.out.println("page Size " + result.getSize());
        System.out.println("has next page? "+ result.hasNext());
        System.out.println("frist page " +result.isFirst());
        System.out.println("aaaaaaaaaaaaaaaaaa");

    }




}
