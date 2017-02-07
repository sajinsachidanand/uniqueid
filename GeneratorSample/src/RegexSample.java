import java.util.TreeSet;

import nl.flotsam.xeger.Xeger;

public class RegexSample {

	public static void main(String[] args) {
		
		String regex;
		Xeger generator;
		String result;
		
		TreeSet<String> unique = new TreeSet<String>();
        for (int i = 0 ; i<10000000; i++)
        {
            regex = "[A-Z]{2}-[0-9]{5}-[A-Z]{3}";
            generator = new Xeger(regex);
            result = generator.generate();
           // System.out.println(result);
            if(!unique.add(result)){
              	System.out.println("Duplicate Entry is: "+result);
               }

        }

	}

}
