package actors;

/**
 * Created by Lena on 29.10.2014.
 */
public class User {
    public String email;
    public String nickname;
    public String passwd;


    public User(){
        this.email = "asd"+ Long.toString(System.currentTimeMillis()) +"@i.ua";
        this.nickname = "asd";
        this.passwd = "qwerty";

     }




}
