package Exception;

import java.util.Scanner;

public class EmailCheck {

	/*Ham kiem rea dia chi Email. Gia su quy tac kiem tra don gian nhu sau
	 * 1. Dia chi Email chi chua 1 ki tu @
	 * 2. Ki tu @ khong nam o vi tri dau tien  
	 */
	public static void check(String str) throws EmailAddressException{
		// Kiem tra chuoi co ki tu @
		int place = str.indexOf('@');
		// Neu khong chua ki tu @
		if(place ==-1) {
			// Nem ra 1 doi tuong EmailAdressException
			throw new EmailAddressException("Khong hop le vi khong chua '@' ");
		}
		if(place ==0) {
			throw new EmailAddressException("Khong hop le do '@' o vi tri dau tien ");
		}
		// Neu co chua @, tiep tuc kiem tra co chua @ khac khong
		place = str.indexOf('@',place+1);
		// Neu tim thay them @ trong chuoi
		if(place!=-1) {
			throw new EmailAddressException("Khong hop le do co hon 1 '@' ");
		}
		//Khong roi vao cac truong hop tren thi hop le
		System.out.println("Dia chi email hop le ");
		
	}
	public static void main(String[] args) {
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap dia chi email: ");
			String email = sc.nextLine();	
			check(email);
		} catch(EmailAddressException e) {
			System.out.println(e.getMessage());
		}
	}

}
