package Restaurant.Part_01.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.Receipt;
import Restaurant.Part_01.repository.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;

	public Integer findMaxCustomerId() {
		return receiptRepository.findMaxCustomerId();
	}

	public void addReceipt(Receipt receipt) {
		receiptRepository.save(receipt);
	}

	public Receipt getReceiptByCustomerId(Integer customerID) {
		return receiptRepository.findReceiptByCustomerId(customerID);
	}

	public List<Receipt> findAllReceipts() {
		return receiptRepository.findAll();
	}

	public long getReceiptCount() {
		return receiptRepository.countReceipts();
	}

	public Double getTotalSumByDate(Date date) {
		return receiptRepository.sumTotalByDate(date);
	}

	public Double getTotalSum() {
		return receiptRepository.sumTotal();
	}

	public List<Object[]> getTotalSumByDateGroupByDateOrderByDate() {
		return receiptRepository.sumTotalByDateGroupByDateOrderByDate();
	}
	
	public List<Object[]> getCountByIdGroupByDateOrderByDate() {
	    return receiptRepository.countByIdGroupByDateOrderByDate();
	}
}
