package org.zerock.ajax;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ajax.entity.Memo;
import org.zerock.ajax.repository.MemoRepository;

import java.util.List;

@SpringBootTest
class AjaxApplicationTests {
    @Autowired
    MemoRepository memoRepository;

    @Test
    void contextLoads() {
        System.out.println("테스트공간");
    }

    @Test
    public void testQueryMethods(){
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
        for (Memo memo: list) {
            System.out.println(memo);
        }
    }

    @Test
    public void testQueryMethodWithPageable() {
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(memo -> System.out.println(memo));
//        for(Memo memo:result.getContent()) {
//            System.out.println(memo);
//        }
    }

//    @Test
//    public void testShotCut() {
//        Memo memo = new Memo();//ctrl-shift-enter(세미콜론)
//        //ctrl-alt-v(변수선언)
//        if(memo == null) {
//
//        }
//    }
    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods() {
        memoRepository.deleteMemoByMnoLessThan(200L);

    }

    @Test
    public void testJQPL1() {
        List<Memo> list = memoRepository.getListDesc();
        list.stream().forEach(m -> System.out.println(m));
    }


    @Test
    public void testJPQL2() {
        memoRepository.updateMenoText(204L, "업데이트된 자료");


    }


}
