
import java.util.*;

/*Crea  un programa en Java amb l’estructura de domini de les classes:
Video: esta format por una URL, un títol i una llista de tags*.
Usuari: esta format per un nom, cognom, password i una data de registre.
Un usuari pot crear nous vídeos i veure un llistat dels seus videos.
Un tag es un text amb una paraula, tenir en compte que un video pot tenir varis tags.
La estructura no ha de permetre afegir camps buits, 
en cas de que n’hi hagi ha de retornar una excepció.
*/
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numUsers = 0;
		int option = 0;
		User currentUser = new User();
		List<User> users = new ArrayList<User>();

		System.out.println("Indica el numero d'usuaris a generar: ");
		numUsers = sc.nextInt();

		for (int i = 0; i < numUsers; i++) {
			users.add(genUser());
		}

		for (User user : users) {
			System.out.println(user);
		}

		do {
			System.out.println("(1)Loguear (2)Crear videos  (3)Llistar videos (4)Sortir");
			option = sc.nextInt();

			switch (option) {

			case 1:

				do {
					currentUser = checkUser(users, sc);
				} while (currentUser == null);

				break;

			case 2:

				currentUser.AddVideo(GenVideo(sc));

				break;

			case 3:

				currentUser.ShowVideos();

				break;

			case 4:
				currentUser = null;
				System.out.println("EXIT!!!! ");

				break;

			default:

				System.out.println("Opció incorrecte!!!");
			}

		} while (option != 4);
	}

	public static User genUser() {
		Scanner sc = new Scanner(System.in);
		String inputName;
		String surname;
		String password;
		Calendar calendar = Calendar.getInstance();
		Date date;
		
		
		System.out.println("Indica el nom d'usuari");
		inputName = sc.next();
		System.out.println("Indica el cognom");
		surname = sc.next();
		System.out.println("Indica el password");
		password = sc.next();
		date = calendar.getTime();
		User inputUser = new User(inputName, surname, password, date);
		
		
		return inputUser;
	}

	public static Video GenVideo(Scanner sc) {
		String url;
		String title;

		System.out.println("Indica la url: ");
		url = sc.next();
		sc.nextLine();
		System.out.println("Indica el titol: ");
		title = sc.nextLine();

		Video vid = new Video(url, title, genTag());
		return vid;
	}

	public static List<String> genTag() {
		Scanner sc = new Scanner(System.in);
		String tag = "";
		int finalTag;
		List<String> tags = new ArrayList<String>();
		
		while (!tag.equals("end")) {
			System.out.println("Indica el tag,'end' para terminar:");
			tag = sc.next();
			tags.add(tag);
		}
		finalTag=tags.size();
		tags.remove(finalTag-1);
		return tags;
	}

	public static User checkUser(List<User> users, Scanner sc) {
		String inputName = "";
		String inputPassword = "";
		boolean loginOk = false;
		User currentUser = null;

		System.out.println("Indica el nom d'usuari");
		inputName = sc.next();
		System.out.println("Indica el password d'usuari");
		inputPassword = sc.next();

		for (User user : users) {
			if (user.getName().equals(inputName) && user.getPassword().equals(inputPassword)) {
				currentUser = user;
				loginOk = true;
			}
		}
		loginOkBool(loginOk);
		return currentUser;
	}

	public static boolean loginOkBool(boolean loginOk) {
		if (loginOk) {
			System.out.println("Login correcte!!!");
		} else {
			System.out.println("Login incorrecte!!!");
			loginOk = false;
		}

		return loginOk;
	}
}
