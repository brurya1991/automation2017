package Yael;



public class Utils {
	/** 
	 * This function compare between titles and call to throwException for handling
	 * @param currentTitle
	 * @param exceptedTitle
	 * @param tagForEx
	 * @throws Exception
	 */
	public static void compareTitle(String currentTitle,String exceptedTitle,Boolean tagForEx)throws Exception {
		throwException(currentTitle.equals(exceptedTitle),currentTitle+" is the excepted title",currentTitle+" isn't the excepted title",tagForEx);
		
		}
		
	
	
	
	/**
	 * This function get condition and print respectively to console the failed\success message +throw exception according to forExcTag tag
	 * @param conditionOut
	 * @param trueMessage
	 * @param falseMessage
	 * @param forExcTag
	 * @throws Exception
	 */
	public static void throwException(Boolean conditionOut,String trueMessage,String falseMessage,Boolean forExcTag)throws Exception  {
		if (conditionOut) {System.out.println(trueMessage);
		if (forExcTag) {throw new Exception(trueMessage);}}
		else {System.out.println(falseMessage);
		if (forExcTag==false) throw new Exception(falseMessage);}
	}


}
