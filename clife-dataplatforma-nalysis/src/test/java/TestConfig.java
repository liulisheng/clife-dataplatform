import com.clife.dataplatform.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Bootstrap.class})// 指定启动类
public class TestConfig {
//    @Value("${hello.text}")
    private String text;

    @Test
    public void sayHello(){
        System.out.println("text==========="+text);
    }
}
