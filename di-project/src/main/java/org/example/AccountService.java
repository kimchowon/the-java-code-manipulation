package org.example;

import chapter03.chapter03_4.Inject;

public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public void join() {
        System.out.println("AccountService.join");
        accountRepository.save();
    }
}
