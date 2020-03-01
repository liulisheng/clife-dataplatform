import com.clife.dataplatform.Bootstrap;
import com.clife.dataplatform.dao.ItemRepository;
import com.clife.dataplatform.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Bootstrap.class})// 指定启动类
public class TestConfig {

    @Resource
    ElasticsearchTemplate esTemplate;
    @Autowired
    private ItemRepository itemRepository;
//    @Test
//    public void createIndex() {
//        if (!ElasticsearchUtil.isIndexExist("indexName")) {
//            ElasticsearchUtil.createIndex("indexName");
//            System.out.println("索引创建成功");
//        } else {
//            System.out.println("索引已经存在");
//        }
//
//    }

    @Test
    public void index() {
        Item item = new Item(2L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.baidu.com/13123.jpg");
        itemRepository.save(item);
    }


    @Test
    public void createIndex() {

        // 创建索引，会根据Item类的@Document注解信息来创建
        esTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        esTemplate.putMapping(Item.class);
    }

    @Test
    public void testFindAll(){
        //1 查找所有
        Iterable<Item> item = itemRepository.findAll();
        Iterator<Item> it = item.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //2 分页查找
//        Page<Item> page = itemRepository.findAll(PageRequest.of(1, 5));
//
//        for(Item item:page){
//            System.out.println(item);
//        }

        //3 排序
//        Iterable<Item> iterable = itemRepository.findAll(Sort.by("price").descending());
//        Iterator<Item> it = iterable.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }


    }

    @Test
    public void deleteById(){
        itemRepository.deleteById(1L);
    }


}
