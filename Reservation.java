import java.io.*;
import java.util.Scanner;

class Reservation
{
    static int a[] = {0,0,0,0,0,0,0,0,0,0,0};
    static int book;
    private static void reserveSeat() 
    {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter seat number");
        book = sc1.nextInt();
        if(book >=1 && book<a.length )
        {
        if(a[book]==0)
        {
            a[book]=1;
            System.out.println("Seat Reserved");
        }
        else if (a[book]==1){
            System.out.println("Seat is Resverd please choose another");

                             }
        }
        else{
            System.out.println("Invalid Length!!!!!!!!!!!");
            System.out.println("Please enter between 1 - 10");
        }
    }

    private static void viewSeatMap() {
    
    for(int i =1;i<a.length;i++)
    {
        System.out.print(a[i]+"  ");
    }
    System.out.println();
    System.out.println("1 - Seat is Reserved By Someone");
    System.out.println("0 - Seat is Not Reserved By Someone");
    System.out.println();
}
    private static void cancelReservation()
    {
        System.out.println("Enter Seat No");
        Scanner sc2 = new Scanner(System.in);
        int Cancel;
        Cancel=sc2.nextInt();
        if(a[Cancel]==1)
        {
            a[Cancel]=a[Cancel]-1;
            System.out.println("Booking cancled");
        }
        
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
       int choice,n=1;
       System.out.println("#################    Welcome     ################# ");
       System.out.println();
        while (n>=0) 
      {
        System.out.println("1: Reserve Seat");
        System.out.println("2: View Seat"); 
        System.out.println("3: Cancle Reservation"); 
        System.out.println("4:Exit");
        choice=sc.nextInt();
                  
        
        switch (choice)
        {
            case 1:
            System.out.println("Reserve Seat");
            reserveSeat();
            break;

            case 2:
            System.out.println("View  Map ");
            viewSeatMap();
            break;


            case 3:
            System.out.println("Cancle Reservation");
            cancelReservation();
            break;

            case 4:
            System.out.println("Exit");
            System.exit(0);
            break;
        }
      }
    }
}