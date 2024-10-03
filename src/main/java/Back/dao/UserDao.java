package Back.dao;

import Back.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserDao(Connection con){
        this.con=con;
    }
    public UserModel userlogin(String email,String password){
        UserModel user =null;

        try {
            query="select * from user where email=? and password=?";
            pst=this.con.prepareStatement(query);
            pst.setString(1,email);
            pst.setString(2,password);
            rs=pst.executeQuery();

            if (rs.next()){
                user= new UserModel();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  user;
    }
}
