package chapter02.chapter02_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
class MoimTest {

    @Test
    public void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        Assertions.assertFalse(moim.isEnrollmentFull());
    }
}