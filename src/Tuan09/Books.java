package Tuan09;

public class Books {
    private int Id;
    private String Title;
    private int Price;

    public Books(int id, String title, int price) {
        super();
        Id = id;
        Title = title;
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
