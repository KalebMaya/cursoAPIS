import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LectorEmail {
	
	public void LeeCorreos() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("C:\\Users\\Dell5458\\Desktop\\correos.txt"));
        String input = scanner.nextLine();
 
        Pattern pattern = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
        Matcher matcher = pattern.matcher(input);
 
        while(matcher.find()){
            System.out.println(matcher.group());
        }
	}
	
	public static void main(String []args) throws FileNotFoundException {
		LectorEmail lectorEmail = new LectorEmail();
		lectorEmail.LeeCorreos();
	}

}
