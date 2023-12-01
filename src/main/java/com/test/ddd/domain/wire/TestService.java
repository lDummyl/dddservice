package com.test.ddd.domain.wire;

import com.test.ddd.repo.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepo testRepo;

    private int anInt = 10;

    @Transactional
    public void extracted1(UUID id) {
        TestEnt testEnt1 = testRepo.findById(id).get();
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("status = " + status);
        boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        int incr = testEnt1.getIncr();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int newVal = incr + anInt;
//        testEnt1.setIncr(newVal);
        testRepo.save(testEnt1);
    }


    public void call() {
        System.out.println("testRepo = " + testRepo);
    }
}
