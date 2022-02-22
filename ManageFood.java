package RMS;

import java.util.ArrayList;
import java.util.Scanner;


public class ManageFood {
	ArrayList<Food> foodlist = new ArrayList<Food>();
	ArrayList<GuestsOrder> guestsorder = new ArrayList<GuestsOrder>();
	Food food;
	public GuestsOrder GuestsOrder;
	public int SelectFood;
	
	public ManageFood() {
	}
	
		Scanner bp = new Scanner(System.in);
		
		
		public void bp() {
			System.out.println("Enter the Number of Food Items that are needed to bei Added in Menu ");
			int n = Integer.parseInt(bp.nextLine());
			for(int i = 0; i < n; i++) {
				Food food = new Food();
				food.input();
				foodlist.add(food);
				
				
			}
		
		
	}
		public void print() {
			for(int i = 0; i < foodlist.size(); i++) {
				System.out.println((i+1)+"."+foodlist.get(i).detail());
				
			}
		}
	
public void Price() {
	float PriceFood = 0;
	float Totalpayment = 0;
	int number;
	GuestsOrder guest = new GuestsOrder();
	guest.input();
	guestsorder.add(guest);
	for (int i = 0;i < 10; i++) {
		System.out.println("Select Food Item"+(i+1));
		SelectFood = bp.nextInt();
		if(SelectFood==0) {
			guest.setTotalpayment(Totalpayment);
			System.out.println("Total Payment");
			System.out.println(Totalpayment);
			System.out.println("THANK YOU, VISIT AGAIN");
			break;
		}else {
			System.out.println("Enter Food Item Number");
			number=bp.nextInt();
			Food food = foodlist.get(SelectFood-1);
			guest.setEatList(food);
			PriceFood = food.Price*number;
			}
		Totalpayment+=PriceFood;
		System.out.println("Order Completed");
		System.out.println("Payment "+(i+1)+"  is:");
		System.out.println(""+PriceFood);
		System.out.println("To End Your Order Enter 0");
		}
}
public void PrintOrder() {
	for(int i = 0; i < guestsorder.size(); i++) {
	 guestsorder.get(i).print();
	}
}
public void search() {
	Scanner bp = new Scanner(System.in);
	String idtable;
	int up=0;
	System.out.println("Enter the Table Number to Check its Payment: ");
	idtable = bp.nextLine();
	for(int i = 0; i < guestsorder.size(); i++) {
		if(guestsorder.get(i).getIdTable().equalsIgnoreCase(idtable)) {
		 guestsorder.get(i).print();
			up++;
			}
	}
	if(up==0) {
		System.out.println("Given Table Number is not Available "+idtable);
		
	}
	
	}
public String EditName() {
	
	System.out.println("Enter the Food Name to be Edited");
	return bp.nextLine();
}
public float EditPrice() {
	
	System.out.println("Enter the Food Price to be Edited");
	return bp.nextFloat();
}

public void EditFood(){
	String namefood;
	int up=0;
	System.out.println("Enter the Food Name to be Fixed ");
	namefood=bp.nextLine();
	for(int i=0; i < foodlist.size(); i++) {
		if(foodlist.get(i).getName().equals(namefood)) {
			up++;
			foodlist.get(i).setName(EditName());
			foodlist.get(i).setPrice(EditPrice());
			break;
			
		}
		
	}if(up==0) {
		System.out.println("Given Food Name is not matched "+namefood);
	}
}
public void Deletefood() {
	String deletefood;
	int up=0;
	System.out.println("Enter the Food Name to be Deleted");
	deletefood=bp.nextLine();
	for(int i=0; i < foodlist.size(); i++) {
		if(foodlist.get(i).getName().equals(deletefood)) {
			up++;
			foodlist.remove(i);
		System.out.println("Deletion Completed");
			break;
			
		}
		
	}if(up==0) {
		System.out.println("Given Food Name is not available "+deletefood);
	}
	
	
}
	
}




