package Back.model;

public class Product {
    private  int id ;
    private String name;
    private String price;
    private String Category;
    private String image;

    public Product() {
    }

    public Product(int id, String name, String price, String category, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        Category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", Category='" + Category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
