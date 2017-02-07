
import java.util.Random;
import java.util.TreeSet;

public class GenenrateFinder {

	public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String CHECK = "0123456789" + ALPHA; 


	public String getNewVerificationNumber(String customerCode, String idNo, String product_type){
		String alphacode=customerCode + idNo +product_type;				
		int Multi1[] = { 9, 4, 9, 4, 9, 4, 9, 4, 9, 4, 9, 4, 9 };
		int Multi2[] = {13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i<13; i++){			
			sum1 += (CHECK.indexOf(alphacode.charAt(i)) + 1) * Multi1[i];
			sum2 += (CHECK.indexOf(alphacode.charAt(i)) + 1) * Multi2[i];
		}

		char V1 = ALPHA.charAt(sum1 % ALPHA.length());
		char V2 = ALPHA.charAt(sum2 % ALPHA.length());		
		return customerCode+ V1 + V2 + product_type;	
	}
	
	private String getProductType(String keyFinderType){

		String product_type = null;
		
		if(keyFinderType.equals("KeyFinder")){
			product_type="Y";
		}else if(keyFinderType.equals("FonFinder")){
			product_type="F";
		}else if(keyFinderType.equals("RescueFinder")){
			product_type="R";
		}else if(keyFinderType.equals("PetFinder")){
			product_type="P";
		}else if(keyFinderType.equals("BagFinder")){
			product_type="B";
		}else if(keyFinderType.equals("KidFinder")){
			product_type="K";
		}else if(keyFinderType.equals("SeniorFinder")){
			product_type="S";
		}else {
			product_type="Y";
		}
		
		return product_type;
	}


	public String getIdentificationNumber(){

		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(genAlphabeticLetters(2));
		stringBuffer.append(Integer.toString(generateFiveNumber()));
		stringBuffer.append(genAlphabeticLetters(3));
		return stringBuffer.toString();
	}

	private String genAlphabeticLetters(int letter_size){
		StringBuffer stringBuffer=new StringBuffer();
		Random random=new Random();
		int characterLoction=0;		
		for(int i=0;i<letter_size;i++){
			characterLoction=random.nextInt(ALPHA.length());
			stringBuffer.append(ALPHA.charAt(characterLoction));
		}
		return stringBuffer.toString();
	}//public String genAlphabeticLetters(int letter_size)

	private int generateFiveNumber(){
		Random random = new Random();

		int [] sizeTable = { 0, 9, 99, 999, 9999,99999};
		int highest = sizeTable[5] + 1;  
		int lowest = sizeTable[4] + 1;

		int companyCode = random.nextInt(highest);

		if( companyCode < lowest ) { 
			companyCode = generateFiveNumber();
		}

		return companyCode;
	}

	public static void main(String[] args) {
         GenenrateFinder finder = new GenenrateFinder();
         
         String idno = null;
         String type = null;
         
         TreeSet<String> unique = new TreeSet<String>();
         for (int i = 0 ; i<10000000; i++)
         {
        	 idno = finder.getIdentificationNumber();
             type = finder.getProductType("RescueFinder");
             if(!unique.add(idno)){
            	System.out.println("Duplicate Entry is: "+idno);
                break;
                }

         }
	}

}
