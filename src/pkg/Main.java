package pkg;
import java.lang.String;
import pkg.Menus.Menus;

public class Main {
	
	private static Loja loja = new Loja();
	
	public static void main(String[] args) {
		Menus menu = new Menus(loja);
		menu.MenuClienteOuAdm();
	}
}
