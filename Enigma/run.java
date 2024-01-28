class run
{
	public static void main(String args[])
	{
		try{
		Enigma obj=new Enigma("B IV II II LOVE");
		obj.decode();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}