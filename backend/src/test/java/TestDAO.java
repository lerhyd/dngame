import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.model.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class TestDAO {

    @Autowired
    RuleDao ruleDao;

    @Test
    public void testDAORules(){
        List<Rule> list = ruleDao.findAll();
        for(Rule description : list){
            System.out.println(description.getDescription());
        }
    }

}
