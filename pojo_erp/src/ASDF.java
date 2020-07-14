import java.net.InetAddress;

public class ASDF {

	public static void main(String[] args) {
		
		try {
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		System.out.println(ip);
		}catch (Exception e) {
			e.printStackTrace();
		}

}

}
