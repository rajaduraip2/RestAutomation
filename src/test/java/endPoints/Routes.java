package endPoints;

public class Routes {

    public static String base_Url="https://petstore.swagger.io/v2";

    //user Model
    public static String user_get_Url=base_Url+"/user/{username}";
    public static String user_post_Url=base_Url+"/user";
    public static String user_put_Url=base_Url+"/user/{username}";
    public static String user_delete_Url=base_Url+"/user/{username}";

    //Store Model
    public static String store_get_Inventory_Url=base_Url+"/store/inventory";
    public static String store_PlaceOrder_Url=base_Url+"/store/order";
    public static String store_get_Order_Url=base_Url+"/store/order/{orderId}";
    public static String store_delete_Url=base_Url+"/store/order/{orderId}";

    //Pet Model

    public static String pet_get_Url=base_Url+"/pet/{petId}";
    public static String pet_Post_Url=base_Url+"/pet";
    public static String pet_put_Url=base_Url+"/pet";
    public static String pet_delete_Url=base_Url+"/pet/{petId}";

}
