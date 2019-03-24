package Assignment;


public class Control {

	public static void main(String[] args) {
		Ai test = new Ai();
		test.ReadData();
		Gui screen = new Gui("Ai");
		DataOptions f = new DataOptions();
		f.countOptions("ham");
		f.countOptions("ham");
		System.out.println(f.toString());
		

	}
	

}
