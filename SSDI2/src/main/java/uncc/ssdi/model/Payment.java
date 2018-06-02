package uncc.ssdi.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


	@Entity
	@Table(name = "PAYMENT_DETAILS")
	
	public class Payment implements Serializable, IPayment {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column
	    private String userEmail;
	    
	    @Column
	    private String number;
	    
	    @Column
	    private String holder;
	    
	    @Column
	    private String date;
	    
	    @Column
	    private String cvv;
	    
	    @Column
	    private String address;
	   
	 
	    /**@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;**/

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

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getCvv() {
			return cvv;
		}

		public void setCvv(String cvv) {
			this.cvv = cvv;
		}
		
		

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Payment() {}

		public Payment(int id, String userEmail, String number, String holder, String date, String cvv, String address ) {
			super();
			this.id = id;
			this.userEmail = userEmail;
			this.number = number;
			this.holder = holder;
			this.date = date;
			this.cvv = cvv;
			this.address = address;
		}

		
		

	}
