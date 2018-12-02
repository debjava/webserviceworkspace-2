

import java.net.InetAddress;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
		InetAddress thisIp =InetAddress.getLocalHost();
		System.out.println("IP:"+thisIp.getHostAddress());

	}

}
