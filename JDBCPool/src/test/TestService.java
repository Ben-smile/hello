package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import domain.Student;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestService {

    public static void main(String[] args) {
        StudentService service = new StudentService();
        //service.insert(new Student(6,"小六","男",6));
//        Student student = service.selectOne(1);
//        System.out.println(student);
        List<Student> list = service.studentList();
        System.out.println(list);














//        Student student = service.selectOne(5);
//        String sname = service.selectOne(1);
//        System.out.println(sname);








        //注册账号
        //页面上  逐个填写的数据
        //  填写sid  填写sname  填写ssex  填写sage
        //  点击注册按钮
        //  发送请求---> 4个散值
        //  控制层---->接收到了4个散的值  组合成一个Student对象
        //  业务层---->完整的Student
        //  持久层---->完整的Student
        //      JDBC操作+SQL
        //      SQL+对象拆开一个一个的属性值




//        Map<String,Object> map = new HashMap();//这个map是为了代替刚才那个domain
//        map.put("sid",7);
//        map.put("sname","小7");
//        map.put("ssex","女");
//        map.put("sage",7);
//        service.insert(map);
        //service.insert(new Student(6,"Ella","女",18));
        //service.delete(6);
        //service.update(new Student(2,"小2","女",13));
    }
}
