package uncc.ssdi.service;

import java.util.List;

import uncc.ssdi.model.Payment;
import uncc.ssdi.model.QuoteAndId;

public interface IPaymentService {
	
	void sendEmailWithLink(String email);

	void addPaymentDetails(Payment payment);

	void saveQuoteAndId(QuoteAndId quotedId);

	List<QuoteAndId> getAllQuotes();

	void deleteQuotes(int productId);

}
