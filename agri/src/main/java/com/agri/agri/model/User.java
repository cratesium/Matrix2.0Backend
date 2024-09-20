

public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;
    private String mobileNo;
    private String otp;


    public void setUsername(String username){
        this.username= username;
    }
    public  void setId( String d){
        this.id=id;
    }
    public  void setPassword(String password){
        this.password=password;

    }

    public  void setOtp(String otp){
        this.otp=otp;
    }

}