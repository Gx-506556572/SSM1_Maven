import com.bean.Dept;
import com.bean.Employee;
import com.dao.DeptMapper;
import com.dao.EmployeeMapper;
import javafx.application.Application;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*
* 使用Spring test 模块
* ContextConfiguration 指定Spring配置文件位置
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void testcrud(){
        //插入部门
        /*deptMapper.insertSelective(new Dept(null,"开发部"));
        deptMapper.insertSelective(new Dept(null,"测试部"));*/
        //插入员工
//employeeMapper.insertSelective(new Employee(null,"张三","M","Jeccy@qq.com",15));
    //批量操作
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0;i<100;i++){
            String uid=UUID.randomUUID().toString().substring(0,3)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",15));
        }
        System.out.println("批量完成");
    }
}
