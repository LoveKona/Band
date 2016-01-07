package test;
import java.awt.Dimension;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;
public class test {
	private static String UserID = "konachan@nate.com";
	
	public static String Cookie ="";
	public static void main(String[]args)
	{
		try
		{
		Cookie = JOptionPane.showInputDialog("C# 프로그램에서 발행된 값을 입력하여주십시오: ");
		}
		catch (Exception e)
		{}
		if(Cookie.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Authcatino Failed");
			
		}
		else
			
		{	MyFrame fr = new MyFrame();
		fr.setPreferredSize(new Dimension(400,130));
		
		fr.pack();
		fr.setVisible(true);
		
			
		 Object localObject2 = new BigInteger(1, hexStringToByteArray("A174175A38BB230AC19C0593B2A130F02D0D451D2E5BCA99A915FA16AC98989AB0D21D5C23910A2429D8691CA1159C4D931CBAF54538DFC72B5DEF9EE62E89DB64BA75FE66D4235E9D6959B0238B80CAE469BFF21765E7288EEDD0ABF9DD735D8BF26992A17998CDCDE8ECBA1ED9810508934E316F0CF6D74F9A2E362C27B7F5"));
		//"f775643ae98f4cc3b6d8ad984cd62ffc"
		 //localObject2.toString()
	System.out.println("abcde".charAt(1));
			
		}
	
	}
	  public static final String RSA_EXPONENT = "010001";
	  public static final String RSA_MODULUS = "A174175A38BB230AC19C0593B2A130F02D0D451D2E5BCA99A915FA16AC98989AB0D21D5C23910A2429D8691CA1159C4D931CBAF54538DFC72B5DEF9EE62E89DB64BA75FE66D4235E9D6959B0238B80CAE469BFF21765E7288EEDD0ABF9DD735D8BF26992A17998CDCDE8ECBA1ED9810508934E316F0CF6D74F9A2E362C27B7F5";
	  
	  
	//  static String generate(String paramString)
	//  {
	//    Object localObject1 = paramString.getBytes();
	//    Object localObject2 = new BigInteger(1, hexStringToByteArray("A174175A38BB230AC19C0593B2A130F02D0D451D2E5BCA99A915FA16AC98989AB0D21D5C23910A2429D8691CA1159C4D931CBAF54538DFC72B5DEF9EE62E89DB64BA75FE66D4235E9D6959B0238B80CAE469BFF21765E7288EEDD0ABF9DD735D8BF26992A17998CDCDE8ECBA1ED9810508934E316F0CF6D74F9A2E362C27B7F5"));
	////    Object localObject3 = new BigInteger(1, hexStringToByteArray("010001"));
	 ///   try
	//    {
	 //     localObject2 = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec((BigInteger)localObject2, (BigInteger)localObject3));
	 //     InstantCredential.access$000().d("encodeCredentialUsingRsa(), pubKey (%s)", new Object[] { localObject2 });
	 //     localObject3 = Cipher.getInstance("RSA/None/PKCS1Padding");
	     // ((Cipher)localObject3).init(1, (Key)localObject2);
	 //     localObject1 = ((Cipher)localObject3).doFinal((byte[])localObject1);
	  //    localObject1 = new e(false).encode((byte[])localObject1);
	  //    return (String)localObject1;
	  //  }
	   // catch (Exception localException)
	  //  {
	     //InstantCredential.access$000().e("Exception occured during issuing credential with token : " + paramString, localException);
	  // }
	  //  return "";
	  //}
	  
	  static byte[] hexStringToByteArray(String paramString)
	  {
	    int j = paramString.length();
	    byte[] arrayOfByte = new byte[j / 2];
	    int i = 0;
	    while (i < j)
	    {
	      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
	      i += 2;
	    }
	    return arrayOfByte;
	  }
}
