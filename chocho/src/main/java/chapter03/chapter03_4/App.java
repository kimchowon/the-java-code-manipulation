package chapter03.chapter03_4;

import org.example.ContainerService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = ContainerService.getObject(AccountService.class);
        accountService.join();
    }
}
