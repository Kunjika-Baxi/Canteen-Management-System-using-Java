import java.util.*;
public class Canteen_Management_System
{
    public static Scanner sc=new Scanner(System.in);
    public static int ino[]=new int[10],iqty[]=new int[10],n,nino,nd;
    public static int iprice[]=new int[10],itemno,qty;
    public static String iname[]=new String[10],oiname[]=new String[10];
    public static double amt=0;
    public static int price[]=new int[10],qtyi[]=new int[10],amtp[]=new int[10],oino[]=new int[10];
    public static void add()
    {
        System.out.println("\nEnter Total Number of Items to add : ");
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("\n-----Enter Data of Item "+(i+1)+" -----");
            System.out.println("Enter Item Name : ");
            sc.nextLine();
            iname[i]=sc.nextLine();
            System.out.println("Enter Item Number : ");
            ino[i]=sc.nextInt();
            System.out.println("Enter Item Quantity : ");
            iqty[i]=sc.nextInt();
            System.out.println("Enter Price of Item : ");
            iprice[i]=sc.nextInt();
        }
        System.out.println("\nData Added Successfully...\n");
    }
    public static void update()
    {
        System.out.println("Enter Item Number whose Data you want to Update : ");
        nino=sc.nextInt();int flag=0,s=0,e=n;char c;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(ino[mid]==nino)
            {
                flag=1;
                System.out.println("Do you want to change Item Price ? (y/n) : ");
                c=sc.next().charAt(0);
                if(c=='y')
                {
                    System.out.println("Enter New Item Price : ");
                    iprice[mid]=sc.nextInt();
                }
                System.out.println("Do you want to change Item Quantity ? (y/n) : ");
                c=sc.next().charAt(0);
                if(c=='y')
                {
                    System.out.println("Enter New Item Quantity : ");
                    iqty[mid]=sc.nextInt();
                }
                System.out.println("Do you want to change Item Name ? (y/n) : ");
                c=sc.next().charAt(0);
                if(c=='y')
                {
                    System.out.println("Enter New Item Name : ");
                    sc.nextLine();
                    iname[mid]=sc.nextLine();
                }
                break;
            }
            else if(ino[mid]>nino)
            e=mid-1;
            else 
            s=mid+1;
        }
        if(flag==0)
        {
            System.out.println("Data Not Found !! \n");
        }
    }
    public static void delete()
    {
        System.out.println("Enter Item Number whose Data you want to Delete : ");
        nd=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(ino[i]==nd)
            {
                for(int j=i;j<n-1;j++)
                {
                    ino[j]=ino[j+1];
                    iname[j]=iname[j+1];
                    iprice[j]=iprice[j+1];
                    iqty[j]=iqty[j+1];
                }
                n--;
            }
        }
    }
    public static void display()
    {
        System.out.println("\t       ----------MENU----------");
        System.out.println("Item No.\tItem Name     \tItem Price  \tItem Quantity");
        for(int i=0;i<n;i++)
        {
            System.out.print(ino[i]+"\t\t"+iname[i]+" \t\t"+iprice[i]+"\t\t"+iqty[i]);
            System.out.println();
        }
    }
    public static void order()
    {
        char ch;int count=0,k=0;int bmax=20000,bmin=1,tmax=20,tmin=1;
        while(true)
        {
        System.out.println("Enter Item Number you want to Order : ");
        itemno=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(ino[i]==itemno)
            {
                count++;
                System.out.println("Enter Quantity : ");
                qty=sc.nextInt();
                if(qty<iqty[i])
                {
                    iqty[i]=iqty[i]-qty;
                    qtyi[k]=qty;
                    price[k]=iprice[i];
                    oino[k]=ino[i];
                    amtp[k]=(iprice[i]*qty);
                    amt+=(iprice[i]*qty);
                    oiname[k]=iname[i];
                    k++;
                }
                else
                {
                    System.out.println("Invalid Quantity !! ");
                }
            }
        }
        System.out.println("Do you want to Order more Food ? (y/n) : ");
        ch=sc.next().charAt(0);
        if(ch=='n')
        break;
        }
        System.out.println("____________________________________________________________________");
        System.out.println("\t\t        JOY Canteen");
        System.out.println("____________________________________________________________________");
        double tno,bno;
        tno=Math.random()*(tmax-tmin+1)+tmin;
        bno=Math.random()*(bmax-bmin+1)+bmin;
        System.out.println("Table Number : "+(int)tno);
        System.out.println("Bill Number  : "+(int)bno);
        System.out.println("____________________________________________________________________");
        System.out.println("Item No.\tItem Name\tQuantity\tPrice\tAmount");
        for(int i=0;i<count;i++)
        {
            System.out.println(oino[i]+"\t\t"+oiname[i]+" \t\t"+qtyi[i]+" \t\t"+price[i]+" \t"+amtp[i]);
        }
        System.out.println("____________________________________________________________________\n");
        System.out.println("Amount         : "+amt);
        System.out.println("GST : 5%       : "+(0.05*amt));
        if(amt>1000 && amt<2500)
        {
        System.out.println("Discount : 7%  : "+(0.07*amt));
        System.out.println("TOTAL Amount   : "+(amt+(0.05*amt)-(0.07*amt)));
        }
        else if(amt>2500)
        {
        System.out.println("Discount : 10% : "+(0.1*amt));
        System.out.println("TOTAL Amount   : "+(amt+(0.05*amt)-(0.1*amt)));
        }
        else 
        {
        System.out.println("TOTAL Amount   : "+(amt+(0.05*amt)));
        }
        System.out.println("____________________________________________________________________");
        System.out.println("\t     THANK YOU ! COME BACK SOON !!");
        System.out.println("____________________________________________________________________");
    }
    public static void main()
    {
        Scanner sc=new Scanner(System.in);int ch,ans;String uname="admin",pass="admin",euname="",epass="";
        System.out.println("-----JOY Canteen-----");
        while(true)
        {
        System.out.println("\nEnter : \n1.Admin\n2.User\n3.EXIT");
        ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println("----------Welcome to JOY Canteen----------");
            System.out.println("Enter User Name : ");
            euname=sc.next();
            System.out.println("Enter Password : ");
            epass=sc.next();
            if(euname.equals(uname) && epass.equals(pass))
            {
            while(true)
            {
                System.out.println("\nEnter : \n1.Add Item\n2.Update Item\n3.Delete Item\n4.Display Menu\n5.Exit");
                System.out.println("Enter your Choice : ");
                ans=sc.nextInt();
                if(ans==5)
                break;
                else
                {
                switch(ans)
                {
                    case 1 : add();break;
                    case 2 : update();break;
                    case 3 : delete();break;
                    case 4 : display();break;
                    default : System.out.println("Invalid Choice");
                }
                }
            }
           }
           else 
           {
               System.out.println("Invalid User Name / Password");
           }
        }
        else if(ch==2)
        {
            System.out.println("----------Welcome to JOY Canteen----------");
            while(true)
            {
                System.out.println("\nEnter : \n1.Display Menu\n2.Order Food\n3.Exit");
                System.out.println("Enter your Choice : ");
                ans=sc.nextInt();
                if(ans==3)
                break;
                else 
                {
                switch(ans)
                {
                    case 1 : display();break;
                    case 2 : order();break;
                    default : System.out.println("Invalid Choice");
                }
                }
            }
        }
        else if(ch==3)
        System.exit(0);
        else
        System.out.println("Invalid Choice");
    }
    }
}