import java.io.*;
import java.util.StringTokenizer;
public class Enigma
{
	Rotor[] rotor=new Rotor[3];
	char[][] reflector;
	Enigma(String s)
	{
		StringTokenizer st=new StringTokenizer(s);
		setReflector(st.nextToken());
		rotor[2]=new Rotor(st.nextToken());
		rotor[1]=new Rotor(st.nextToken());
		rotor[0]=new Rotor(st.nextToken());
		s=st.nextToken();
		for(int i=1;i<s.length();i++)
			rotor[s.length()-i-1].setInitial(s.charAt(i));
	}
	void setReflector(String s)
	{
		if(s.equals("B"))
		{
			reflector=new char[][]{{'A','Y'},{'B','R'},{'C','U'},{'D','H'},{'E','Q'},{'F','S'},{'G','L'},{'I','P'},{'J','X'},{'K','N'},{'M','O'},{'T','Z'},{'V','W'}};
		}
	    else if(s.equals("C"))
	    {
	    	reflector=new char[][]{{'A','F'},{'B','V'},{'C','P'},{'D','J'},{'E','I'},{'G','O'},{'H','Y'},{'K','R'},{'L','Z'},{'M','X'},{'N','W'},{'T','Q'},{'S','U'}};
	    }
	    else
		{
			System.out.println("Invalid Reflector Type. Setting to default B type reflector.");
			reflector=new char[][]{{'A','Y'},{'B','R'},{'C','U'},{'D','H'},{'E','Q'},{'F','S'},{'G','L'},{'I','P'},{'J','X'},{'K','N'},{'M','O'},{'T','Z'},{'V','W'}};
		}
	}
	char reflector(char c)
	{
		char[][] ar={{'A','Y'},{'B','R'},{'C','U'},{'D','H'},{'E','Q'},{'F','S'},{'G','L'},{'I','P'},{'J','X'},{'K','N'},{'M','O'},{'T','Z'},{'V','W'}};
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[i].length;j++)
				if(ar[i][j]==c)
				{
					return ar[i][(j+1)%2];
				}
		}
		return c;
	}
	void decode()throws IOException
	{
		BufferedReader buff=new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw=new PrintWriter(new FileWriter("output.txt"));
		String s;
		int i=0;
	    while((s=buff.readLine())!=null)
	    {
	    	s=s.toUpperCase();
	    	for(int j=0;j<s.length();j++)
	    	{
	    		char c=s.charAt(j);
	    		if(c==' ')
	    			continue;
			    if(rotor[0].isAtNotch())
				{
					if(rotor[1].isAtNotch())
					{
						if(rotor[2].isAtNotch())
							rotor[1].shift();
						rotor[2].shift();
					}
					
				    rotor[1].shift();
				}
				rotor[0].shift();
				c=rotor[0].nextChar(c,1);
				c=rotor[1].nextChar(c,1);
				c=rotor[2].nextChar(c,1);
				c=reflector(c);
				c=rotor[2].nextChar(c,-1);
				c=rotor[1].nextChar(c,-1);
				c=rotor[0].nextChar(c,-1);
				pw.print(c);i++;
				if(i%23==0)
				{
					i=0;
					pw.println();
				}
				else if(i%5==0)
					pw.print(" ");
				
			}
		}
		pw.close();
		buff.close();
	}
}