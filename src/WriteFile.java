
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

	public static void main(String[] args) {

		List<Customer> customers = new ArrayList<>();
		Customer c1 = new Customer("cus1");
		Customer c2 = new Customer("cus2");
		Customer c3 = new Customer("cus3");

		customers.add(c1);
		customers.add(c2);
		customers.add(c3);

		DataOutputStream dos;
		// Write file
		try {
			dos = new DataOutputStream(new FileOutputStream("output.txt"));
		} catch (Exception e) {
			System.out.println("Can't open file.");
			return;
		}

		try {
			for (Customer customer : customers) {
				dos.writeUTF(stringToHex(customer.getName()));
				String newLine = System.getProperty("line.separator");
				dos.writeBytes(newLine);
			}

			System.out.println("Lưu danh sách khách hàng thành công!");
			dos.close();
		} catch (Exception e) {
			System.out.println("Write error!");
		}
	}

	private static String stringToHex(String string) {
		StringBuilder buf = new StringBuilder(200);
		for (char ch : string.toCharArray()) {
			if (buf.length() > 0)
				buf.append(' ');
			buf.append(String.format("%04x", (int) ch));
		}
		return buf.toString();
	}

}
