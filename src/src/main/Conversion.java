import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.math.*;

public class Conversion{

	//private String hexMessage= "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
	private String hexMessage = "686974207468652062756c6c277320657965";
	private String XORStartValue = "1c0111001f010100061a024b53535009181c";
	private String stringMessage;
	private String base64Message;
	private byte[] convertedBytes;

	public Conversion(){
		System.out.println(XORMath(XORStartValue));
	//	this.stringMessage = ConvertHexToString(this.hexMessage);
	//	this.base64Message = ConvertStringToBase64();
	//	System.out.println(GetHexMessage());
	//	System.out.println(GetStringMessage());
	//	System.out.println(GetBase64Message());
	}
	
	public Conversion(String userDefinedHexMessage){
		this.hexMessage = userDefinedHexMessage;
		this.stringMessage = ConvertHexToString(this.hexMessage);
		this.base64Message = ConvertStringToBase64();
	}
	
	public String ConvertHexToString(String passedHex){
		byte[] messageBytes = passedHex.getBytes();
		Hex hexConversion = new Hex();
		try{
			this.convertedBytes = hexConversion.decode(messageBytes);
			//this.stringMessage = new String(this.convertedBytes);
		} catch(DecoderException de){
			System.err.println(de);
			return "" + de;
		}
		return new String(this.convertedBytes);
	}
	
	public int XORMath(String passedValue){
		String firstConvertedHex = ConvertHexToString(XORStartValue);
		firstConvertedHex = ConvertStringToBase64(firstConvertedHex);
		System.out.println("First Hex: " + firstConvertedHex);
		String XORValue = "686974207468652062756c6c277320657965";
		String convertedHexFromXOR = ConvertHexToString(XORValue);
		convertedHexFromXOR = ConvertStringToBase64(convertedHexFromXOR);
		System.out.println("Second Hex: " + convertedHexFromXOR);
		return Integer.parseInt(firstConvertedHex) ^ (Integer.parseInt(convertedHexFromXOR));
		
	}
	
	public String ConvertStringToBase64(){
		return Base64.getEncoder().encodeToString(this.convertedBytes);
	}
	
	public String ConvertStringToBase64(String userPassedString){
		byte[] stringSplit = userPassedString.getBytes();
		return Base64.getEncoder().encodeToString(stringSplit);
	}
	
	public String GetHexMessage(){
		return this.hexMessage;
	}
	
	public String GetBase64Message(){
		return this.base64Message;
	}
	
	public String GetStringMessage(){
		return this.stringMessage;
	}
	
	public static void main(String[] args){
		Conversion convert = new Conversion();
	}

}