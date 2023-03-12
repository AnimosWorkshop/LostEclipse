package general;

import java.time.LocalDate;

public class GameManager {
	
	public static void log(String str)
	{
		System.out.println(LocalDate.now().toString() + ": " + str);
	}
	
}
