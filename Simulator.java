import java.util.Scanner;
public class Simulator
{
	public static void main(String args[])
	{
		System.out.println("Please ensure your input is saved in input.txt file");
		System.out.println("Enter the Enigma settings in the format:\n <Reflector Type> <Rotor 3 Type> <Rotor 2 Type> <Rotor 1 Type> <Ignored character+Initial Positions>");
		System.out.println("For example: B IV II II LOVE\n Here B is reflector type, IV, II, II are rotor types from slowest to fastest and in LOVE, L is ignored character and OVE are the initial positions of rotors from slowest to fastest.");
		try{
			Scanner sc=new Scanner(System.in);
			Enigma obj=new Enigma(sc.nextLine());
			obj.decode();
			System.out.println("Decoding complete. Please check output.txt for results.");
			sc.close();	
		}
		catch(Exception e)
		{	
			System.out.print(e);
			System.out.println(" Unable to process your request due to above error. Please ensure your input format is correct.");
		}
	}
}