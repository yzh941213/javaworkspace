
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JunitTest {

    int num = 0;
    @Test
    public void junitTest(){
        Integer integer = new Integer(2);
        System.out.println(integer == 2);

        //System.out.println(getNum());
    }


    private int getNum(){
        while (true){
         if (num<10) {
            this.getNum();
         } else {
             return num;
         }
         num++;
        }
    }



}
