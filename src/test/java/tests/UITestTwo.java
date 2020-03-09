package tests;

import framework.BaseTest;
import org.testng.annotations.Test;

public class UITestTwo extends BaseTest {

    //@Test(priority = 6)

    public static void main(String[] args) {
        compareProductDetails();
    }

    public static void compareProductDetails(){
        int x = (int) (1 + Math.random() * 50);
        double y = Math.random() * 50;
        int z = (int) y;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

}
