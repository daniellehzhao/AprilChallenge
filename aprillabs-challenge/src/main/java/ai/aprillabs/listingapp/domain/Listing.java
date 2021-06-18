package ai.aprillabs.listingapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String address;
    private Integer beds;
    private Integer baths;
    private BigDecimal price;
    private String createdAt;

    public Listing() {
    }

    public Listing(Integer id, String address, Integer beds, Integer baths, BigDecimal price) {
        this.id = id;
        this.address = address;
        this.beds = beds;
        this.baths = baths;
        this.price = price;
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        this.createdAt = df.format(new Date());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        this.createdAt = df.format(new Date());
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Listing))
        return false;
        Listing listing = (Listing) o;
        return Objects.equals(this.id, listing.id) && Objects.equals(this.address, listing.address)
            && Objects.equals(this.beds, listing.beds) && Objects.equals(this.baths, listing.baths)
            && Objects.equals(this.price, listing.price);
    }

    @Override
    public String toString() {
        return "Listing{" + "id=" + this.id + ", address='" + this.address + '\'' + ", beds='" + this.beds 
        + '\'' + ", baths='" + this.baths + '\'' + ", price='" + this.price + '\'' + '}';
    }
}
