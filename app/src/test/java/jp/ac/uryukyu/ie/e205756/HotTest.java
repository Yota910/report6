package jp.ac.uryukyu.ie.e205756;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotTest {
    @Test 
    void inputTest() {
        Hot hotTest = new Hot(0,"カフェオレ",140);
        hotTest.input();
    }
}