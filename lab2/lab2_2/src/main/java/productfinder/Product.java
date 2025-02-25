package productfinder;

public class Product 
{
    private int id;
    private String image;
    private String description;
    private double price;
    private String title;
    private String category;
    Product(int id, String image, String description, double price, String title, String category){
        this.id = id;
        this.image = image;
        this.description = description;
        this.price = price;
        this.title = title;
        this.category = category;
    }
    Product(){}
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public String getImage() {
        return image;
    }
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
