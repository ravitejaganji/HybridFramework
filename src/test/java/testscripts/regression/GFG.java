package testscripts.regression;

public class GFG {
	 
    // Main driver method
    public static void main(String[] args)
    {
        String str = "To verify whether the data displayed is same as the selected data in Book hotel page";
        String op = "";
 
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
 
            // Checking whether is white space or not
            if (!Character.isWhitespace(ch)) {
                op += ch;
            }
        }
        System.out.println(op);
    }
}