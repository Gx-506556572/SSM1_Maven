import com.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:DispatcherServlet.xml"})
public class MvcTest {
    //传入Mvc的IOC
    @Autowired
    WebApplicationContext context;
    //虚拟Mvc请求，获取处理结果
    MockMvc mockMvc;
    @Before
    public void initMockMvc(){
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    //模拟请求拿到返回值
    @Test
    public void testPage() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();
        //请求成功后，可以通过请求域中pageInfo验证
        MockHttpServletRequest request=mvcResult.getRequest();
        PageInfo<Employee> li= (PageInfo<Employee>) request.getAttribute("pageInfo");
        System.out.println("当前页码："+li.getPageNum());
        System.out.println("总页码："+li.getPages());
        System.out.println("总条数："+li.getTotal());
        System.out.println("页面连续展示的页码");
        int nums[]= li.getNavigatepageNums();
        for(int i:nums){
            System.out.print(" "+i);
        }
        List<Employee> list=li.getList();
        for(Employee employee:list){
            System.out.println("ID"+employee.getEmpId()+"===>Name"+employee.getEmpName());
        }
    }
}
