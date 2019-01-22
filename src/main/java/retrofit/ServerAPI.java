package retrofit;

public interface ServerAPI {

    @Get("https://www.baidu.com/")
    public String getBaiduHome(@Query("type") String type);

    @Post("https://www.baidu.com/update")
    public String getBaiduUser(@Field("name") String name, @Field("age") String age);

}
