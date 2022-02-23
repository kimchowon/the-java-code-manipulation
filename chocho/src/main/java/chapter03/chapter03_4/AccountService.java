package chapter03.chapter03_4;

public class AccountService {

    AccountRepository accountRepository;

    public void join() {
        System.out.println("AccountService.join");
        accountRepository.save();
    }
}
