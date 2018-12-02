import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SoapRequestSender 
{
	private static String getSoapRequestXML( String path )
	{
		String xmlData = null;
		try 
		{
			File file = new File(path);
			byte[] buffer = new byte[(int)file.length()];
			InputStream inStream = new FileInputStream(file);
			inStream.read(buffer);
			xmlData = new String(buffer);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return xmlData;
	}


	public static String postRequest(String soapRequest,String soapURL) throws Exception
	{
		String responseXML = null;
		try
		{
			URL url = new URL(soapURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			byte[] requestXML = soapRequest.getBytes();

			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty( "Content-Length", String.valueOf( requestXML.length ) );
			httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction","post");
			httpConn.setRequestMethod( "POST" );
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);

			// Send the String that was read into postByte.
			OutputStream out = httpConn.getOutputStream();
			out.write(requestXML);
			out.close();

			// Read the response and write it to standard out.
			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String temp;
			String tempResponse = "";

			//Create a string using response from web services
			while ((temp = br.readLine()) != null)
				tempResponse = tempResponse + temp;
			responseXML = tempResponse;
			br.close();
			isr.close();
		}
		catch (java.net.MalformedURLException e)
		{
			e.printStackTrace();
			System.out.println("Error in postRequest(): Secure Service Required");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in postRequest(): " + e.getMessage());
		}
		return responseXML;
	}

	public static void main(String[] args) throws Exception
	{
		String filePath = "data/request1.xml";
		String webUrl = "http://localhost:8080/simplewebservice/services/simplewebservice?wsdl";
		String soapMessage = getSoapRequestXML(filePath);
		String response = postRequest(soapMessage, webUrl);
		System.out.println(response);
	}

}
