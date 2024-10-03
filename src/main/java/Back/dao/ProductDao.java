package Back.dao;

import Back.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDao(Connection con){
        this.con=con;
    }

    public List<Product> getAllProduct(){

        List<Product> Products = new ArrayList<Product>();

        try {
            query="select * from products";
            pst=this.con.prepareStatement(query);
            rs= pst.executeQuery();
            while (rs.next()){
                Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getString("price"));
                row.setImage(rs.getString("image"));

                Products.add(row);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Products;
    }


}
