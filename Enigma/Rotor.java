class Rotor
{
	char notch[],order[][],shift='A';
	boolean isAtNotch()
	{
		for(int i=0;i<notch.length;i++)
			if(notch[i]==shift)
				return true;
		return false;
	}
	Rotor(String s)
	{
		int val=romanValue(s);
		switch(val){
		case 1:order=new char[][]{{'A','E','L','T','P','H','Q','X','R','U'},{'B','K','N','W'},{'C','M','O','Y'},{'D','F','G'},{'I','V'},{'J','Z'},{'S'}};
			notch=new char[]{'Q'};break;
	    case 2:order=new char[][]{{'F','I','X','V','Y','O','M','W'},{'C','D','K','L','H','U','P'},{'E','S','Z'},{'B','J'},{'G','R'},{'N','T'},{'A'},{'Q'}};
			notch=new char[]{'E'};break;
		case 3:order=new char[][]{{'A','B','D','H','P','E','J','T'},{'C','F','L','V','M','Z','O','Y','Q','I','R','W','U','K','X','S','G'},{'N'}};
			notch=new char[]{'V'};break;
		case 4:order=new char[][]{{'A','E','P','L','I','Y','W','C','O','X','M','R','F','Z','B','S','T','G','J','Q','N','H'},{'D','V'},{'K','U'}};
			notch=new char[]{'J'};break;
		case 5:order=new char[][]{{'A','V','O','L','D','R','W','F','I','U','Q'},{'B','Z','K','S','M','N','H','Y','C'},{'E','G','T','J','P','X'}};
			notch=new char[]{'Z'};break;
		case 6:order=new char[][]{{'A','J','Q','D','V','L','E','O','Z','W','I','Y','T','S'},{'C','G','M','N','H','H','F','U','X'},{'B','P','R','K'}};
			notch=new char[]{'Z','M'};break;
		case 7:order=new char[][]{{'A','N','O','U','P','F','R','I','M','B','Z','T','L','W','K','S','V','E','G','C','Y','D','H','X','Q'}};
			notch=new char[]{'Z','M'};break;
		case 8:order=new char[][]{{'A','F','L','S','E','T','W','U','D','H','O','Z','V','I','C','Q'},{'B','K','J'},{'G','X','Y'},{'M','P','R'}};
			notch=new char[]{'Z','M'};
		}
	}
	void setInitial(char c)
	{
		shift(c-shift+0);
		shift=c;
	}
	void shift()
	{
		shift(1);
	}
	void shift(int change)
	{
		for(int i=0;i<order.length;i++)
		{
			for(int j=0;j<order[i].length;j++)
			{
				order[i][j]-=change;
				if(order[i][j]<65)
					order[i][j]+=26;
			}
		}
		shift+=change;
		if(shift>90)
			shift-=26;
	}
	int romanValue(String s)
	{
		if(s.equals("IV"))
			return 4;
		int val=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='I')
				val++;
			else 
				val+=5;
		}
		return val;
	}
	char nextChar(char ch,int val)
	{
		for(int i=0;i<order.length;i++)
		{
			for(int j=0;j<order[i].length;j++)
				if(order[i][j]==ch)
					return order[i][(j+val+order[i].length)%order[i].length];
		}
		return ch;
	}
}