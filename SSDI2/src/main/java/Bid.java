import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import uncc.ssdi.model.IBid;


@Entity
@Table(name = "BIDDETAILS")
public class Bid implements IBid{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String userEmail;
    
    @Column
    private Double bidValue;
    
    @Column
    private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Double getBidValue() {
		return bidValue;
	}

	public void setBidValue(Double bidValue) {
		this.bidValue = bidValue;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
    
    
	
}
