package Programs;
import java.util.*;
import java.text.*;
public class Assign1 {

	public static void main(String[] args) {
		double pepPizza = 12.0, plnPizza = 10.0, 
		pieSlice = 2.0, wholePie = 10.0, charm = 50.0, total =0, payment=0;
		int countPlain=0, countPep=0, countSlice=0, countPie=0, countCharm=0;
		int orderChoice;
		boolean hasPieCard = false, checkout=false, hasPizza=false, hasPie = false, hasCharm = false;
		Scanner inScan = new Scanner(System.in);
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		
		System.out.println("Welcome to Pies, Pies, and Pis!\nIs there a customer in line? y/n: ");
		String cus = inScan.next();
		if(cus.equalsIgnoreCase("y") || cus.equalsIgnoreCase("yes"))
		{
			System.out.println("Do you have a Pie Card? y/n: ");
			String cardAns = inScan.next();
			if(cardAns.equalsIgnoreCase("y") || cardAns.equalsIgnoreCase("yes"))
			{
				hasPieCard=true;
				pepPizza = 10.0;
				pieSlice = 1.75;
				wholePie = 8.0;
				charm = charm - (charm*.1);
				System.out.println("Good! You're the smart customer.");
			}
				
			System.out.println("Here are the menu prices");
			if(cardAns.equalsIgnoreCase("n") || cardAns.equals("no"))
			{
				System.out.println("Just think of the money you could've saved if you had a card!");
			}
			System.out.println("Pizzas\n\tPlain Pizza:\t\t"+formatter.format(plnPizza)+"\n\tPepperoni Pizza:\t"+formatter.format(pepPizza));
			System.out.println("Pies\n\tPie Slice:\t\t"+formatter.format(pieSlice)+"\n\tWhole Pie:\t\t"+formatter.format(wholePie));
			System.out.println("Pis\n\tPi Gold Charm:\t\t" + formatter.format(charm));
			System.out.println("What would you like to do?");
			System.out.println("\t1)Update Pizza Order\n\t2)Update Pie Order\n\t3)Update Gold Charm order\n\t4)Checkout");
			orderChoice = inScan.nextInt();
			while(!checkout)
			{
				if(orderChoice == 1)
				{
					System.out.println("Here is your current order: ");
					if(!hasPizza)
					{
						System.out.println("\tNo pizzas ordered.");
					}
					else
					{
						System.out.println(countPlain + " plain pizzas");
						System.out.println(countPep + " pepperoni pizzas");
					}
					System.out.println("How many plain pizzas would you like for " + formatter.format(plnPizza) + " each?");
					countPlain += inScan.nextInt();
					System.out.println("How many pepperoni pizzas would you like for " + formatter.format(pepPizza) + " each?");
					countPep += inScan.nextInt();
					if(countPlain >=0 || countPep >= 0)
					{
						hasPizza = true;
					}
				}
			    if(orderChoice == 2)
			    {
			    	System.out.println("Here is your current order: ");
			    	if(!hasPie)
			    	{
			    		System.out.println("\tNo pies or pie slices ordered");
			    	}
			    	else
					{
						System.out.println(countSlice + " pie slices");
						System.out.println(countPie + " whole pies");
					}
			    	System.out.println("How many pie slices would you like for " + formatter.format(pieSlice) + " each?");
					countSlice += inScan.nextInt();
					System.out.println("How many whole pies would you like for " + formatter.format(wholePie) + " each?");
					countPie += inScan.nextInt();
					if(countSlice >=0 || countPie >= 0)
					{
						hasPie = true;
					}
					while(countSlice>=6)
					{
						countPie+=1;
						countSlice-=6;
					}
			    	
			    }
			    if(orderChoice==3)
			    {
			    	System.out.println("Here is your current order: ");
					if(!hasCharm)
					{
						System.out.println("\tNo pi charms ordered.");
					}
					else
					{
						System.out.println(countCharm + " pi charms");
					}
					System.out.println("How many pi charms would you like for " + formatter.format(charm) + " each?");
					countCharm += inScan.nextInt();
					if(countCharm >=0)
					{
						hasCharm = true;
					}
			    }
			    if(orderChoice == 4)
			    {
			    	checkout=true;
			    	break;
			    }
				System.out.println("What would you like to do?");
				System.out.println("\t1)Update Pizza Order\n\t2)Update Pie Order\n\t3)Update Gold Charm order\n\t4)Checkout");
				orderChoice = inScan.nextInt();
			}
			if(checkout)
			{
				System.out.println("Here is your subtotal: "+"\n");
				if(countPlain>0)
				{
					System.out.print("\t"+countPlain + " plain pizzas @ " + formatter.format(plnPizza) + "ea.: ");
					System.out.print("\t\t" + formatter.format(plnPizza*countPlain)+"\n");
				}
				if(countPep>0)
				{
					System.out.print("\t"+countPep + " pepperoni pizzas @ " + formatter.format(pepPizza) + "ea.: ");
					System.out.print("\t" + formatter.format(pepPizza*countPep)+"\n");
				}
				if(countSlice>0)
				{
					System.out.print("\t"+countSlice + " pie slices @ " + formatter.format(pieSlice) + "ea.: ");
					System.out.print("\t\t" + formatter.format(pieSlice*countSlice)+"\n");
				}
				if(countPie>0)
				{
					System.out.print("\t"+countPie + " whole pies @ " + formatter.format(wholePie) + "ea.: ");
					System.out.print("\t\t" + formatter.format(wholePie*countPie)+"\n");
				}
				if(countCharm>0)
				{
					System.out.print("\t"+countCharm + " gold charms @ " + formatter.format(charm) + "ea.: ");
					System.out.print("\t\t" + formatter.format(charm*countCharm)+"\n");
				}
				System.out.println("\t\t\t\t\t\t-------");
				total = (pieSlice*countSlice)+(wholePie*countPie)+(charm*countCharm)+(pepPizza*countPep)+(plnPizza*countPlain);
				System.out.println("Subtotal:\t\t\t\t\t" + formatter.format(total));
				if(hasPieCard && total>=100.0)
				{
					System.out.println("Discount:\t\t\t\t\t" + formatter.format((total*.1)));
					total= total-(total*.1);
					System.out.println("\t\t\t\t\t\t-------");
					System.out.println("New Subtotal:\t\t\t\t\t" + formatter.format(total));
				}
				System.out.println("Tax:\t\t\t\t\t\t" + formatter.format((total*.07)));
				total = total +(total*.07);
				System.out.println("\t\t\t\t\t\t-------");
				System.out.println("\nTotal:\t\t\t\t\t\t" + formatter.format(total));
				System.out.print("\nEnter your payement amount:\t\t\t$");
				payment = inScan.nextDouble();
				while(payment<total)
				{
					System.out.print("\nEnter your payement amount:\t\t\t$");
					payment = inScan.nextInt();
				}
				total=payment-total;
				System.out.println("Your change:\t\t\t\t\t" + formatter.format(total));
				
			}
			
			
		}
		
		else if(cus.equalsIgnoreCase("n") || cus.equalsIgnoreCase("no"))
		{
			System.out.print("Good, we're closed anyway.");
		}
		
		else
		{
			System.out.print(cus + " is not a valid repsonse.");
		}
		

	}

}
