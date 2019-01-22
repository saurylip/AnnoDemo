import org.junit.Test;
import retrofit.APICreater;
import retrofit.ServerAPI;

public class TestRetrofitDemo {

    @Test
    public void testRetrofit(){

        ServerAPI serverAPI = APICreater.create(ServerAPI.class);
        String homeeeeee = serverAPI.getBaiduHome("Homeeeeee");
        System.out.println("-----" + homeeeeee);

    }
}
