package Restaurant.Part_01.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.ReceiptOrder;
import Restaurant.Part_01.repository.ReceiptOrderRepository;

@Service
public class ReceiptOrderService  {

	@Autowired
	private ReceiptOrderRepository receiptOrderRepository;
	
	public List<ReceiptOrder> listReceiptOrders(){
		return receiptOrderRepository.findAll();
	}
	
	public Double getTotalSumByDate(Date date) {
		return receiptOrderRepository.sumTotalByDate(date);
	}
	
	public Double getTotalSum() {
		return receiptOrderRepository.sumTotal();
	}
}
