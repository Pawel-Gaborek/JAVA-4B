
import javax.swing.*;
import java.util.Random;
import java.lang.*;

public class Java4b_Aufgabe_4 
{	
	private static int IDnumberGenerator(int[][]table)
	{
		Random generator = new Random();
		Boolean stop=false;
		int ID = Math.abs(generator.nextInt());
		while(stop!=true)
		{
			ID = Math.abs(generator.nextInt());
			for (int i=0 ; i<table.length ; i++)
			{
				if (table[i][0]==ID) {stop=false;}
				else {stop=true;}
			}
		}
		return ID;
	}
	private static void createTable(int[][]table)
	{
		for (int i=0 ; i<table.length; i++)
		{
			for(int j=0 ; j<table[0].length ; j++)
			{
				table[i][j]=0;
			}
		}
	}
	private static boolean createNewBox(int[][]table) 
	{
		int i=0;
		while(i!=table.length)
		{
			if (table[i][0]==0)
			{
				table[i][0]=IDnumberGenerator(table);
				table[i][1]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte die Breite an: "));
				table[i][2]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte die Lenge an: "));
				table[i][3]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte die Hoehe an: "));
				return true;
			}
			i++;
		}
		return false;
	};
	private static boolean deleteBox(int[][]table, int ID) 
	{
		int i=0;
		while(i!=table.length)
		{
			if (table[i][0]==ID)
			{
				table[i][0]=0;
				table[i][1]=0;
				table[i][2]=0;
				table[i][3]=0;
				return true;
			}
			i++;
		}
		return false;
	};
	private static boolean changeBox(int[][]table, int ID) 
	{
		int i=0;
		while(i!=table.length)
		{
			if (table[i][0]==ID)
			{
				table[i][1]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte NEUE Breite an: "));
				table[i][2]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte NEUE Lenge an: "));
				table[i][3]=Integer.valueOf(JOptionPane.showInputDialog("Geben Sie bitte NEUE Hoehe an: "));
				return true;
			}
			i++;
		}
		return false;
	};
	private static void printOneBox(int[][]table, int Nummer)
	{
		if (table[Nummer][0]!=0)
		{
			String stringToPrint="_Kiste Nr:_" +Nummer+ "||_ID Nr:_" +table[Nummer][0]+ "||_Breite:_" +table[Nummer][1]+ "||_Lenge:_" +table[Nummer][2]+ "||_Hoehe:_" +table[Nummer][3]+ "\n";
			JOptionPane.showMessageDialog(null, stringToPrint);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Die Kiste ist leer");
		}
	};
	private static void printAllBox(int[][]table) 
	{
		String stringToPrint = "";
		for(int i=0 ; i<table.length; i++)
		{
			if (table[i][0]!=0)
			{
				stringToPrint += "_Kiste Nr:_" + String.valueOf(i+1)  + "||_ID Nr:_" +String.valueOf(table[i][0])+ "||_Breite:_" +String.valueOf(table[i][1])+ "||_Lenge:_" +String.valueOf(table[i][2])+ "||_Hoehe:_" +String.valueOf(table[i][3])+ "\n";
			}
			else
			{
				stringToPrint += "Kiste ist leer\n";
			}
		}
		JOptionPane.showMessageDialog(null, stringToPrint);
	};
	
	public static void main(String[] args)
	{ 
		int[][]table = new int[75][4];
		createTable(table);
		if(createNewBox(table)==true) {JOptionPane.showMessageDialog(null,"Die Kiste wurde korrekt erstellt");}else{JOptionPane.showMessageDialog(null,"Die Kiste wurde nicht erstellt");};
		if(createNewBox(table)==true) {JOptionPane.showMessageDialog(null,"Die Kiste wurde korrekt erstellt");}else{JOptionPane.showMessageDialog(null,"Die Kiste wurde nicht erstellt");};
		if(createNewBox(table)==true) {JOptionPane.showMessageDialog(null,"Die Kiste wurde korrekt erstellt");}else{JOptionPane.showMessageDialog(null,"Die Kiste wurde nicht erstellt");};
		if(changeBox(table,table[1][0])==true) {JOptionPane.showMessageDialog(null,"Die Aenderungen wurden eingetragen");}else{JOptionPane.showMessageDialog(null,"Die Aenderungen wurden nicht eingetragen");};
		printOneBox(table, 2);
		printOneBox(table, 10);
		printAllBox(table); 
	}
}