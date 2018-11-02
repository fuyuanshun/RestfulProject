import com.alibaba.fastjson.JSON;
import com.fys.restful.model.User;
import com.fys.restful.util.ResultUtil;

public class Test {

    public static void main(String[] args) {
        String json = "{'code':'fys','msg':'fysfys'}";
        ResultUtil resultUtil = JSON.parseObject(json, ResultUtil.class);
        System.out.println(resultUtil);

        String json2 = JSON.toJSONString(resultUtil);
        System.out.println(json2);
    }
}
