package validacija;

public class Validacija {

	public boolean daliSuPasswordIRepeatedPasswordIsti(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean daLiJePasswordValidan(String password) {
	
		 boolean daLiJeValidan = true;
         if (password.length() > 15 || password.length() < 8)
         {
                 System.out.println("Password mora imati manje od 15 i vise od 8 karaktera.");
                 daLiJeValidan = false;
         }
         String velikaSlova = "(.*[A-Z].*)";
         if (!password.matches(velikaSlova ))
         {
                 System.out.println("Password mora sadrzati bar jedno veliko slovo");
                 daLiJeValidan = false;
         }
         String malaSlova = "(.*[a-z].*)";
         if (!password.matches(malaSlova ))
         {
                 System.out.println("Password mora sadrzati bar jedno malo slovo");
                 daLiJeValidan = false;
         }
         String brojevi = "(.*[0-9].*)";
         if (!password.matches(brojevi ))
         {
                 System.out.println("Password mora sadrzati bar jedan broj");
                 daLiJeValidan = false;
         }
         String simboli = "(.*[@,#,$,%].*$)";
         if (!password.matches(simboli ))
         {
                 System.out.println("Password mora sadrzati bar jedan simbol od ponudjenih @#$%");
                 daLiJeValidan = false;
         }
         return daLiJeValidan; 
	}
	
	public boolean daLiJeBroj(String s) {
		
		for(int i = 0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	

}
