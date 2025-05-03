package Maman12;

public class BusArrivalStudentTester
{
    public static void main(String[] args) {
        System.out.println("********** Test BusArrival - Started **********");

        //=====================================================================
        System.out.println("\n\n1. Testing Constructors and toString:");
        System.out.println("\n\t1. Testing Constructor with 5 parameters BusArrival(int lineNum, int pass, int h, int m, int s):");
        BusArrival ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\tBusArrival ba1 is: (should be: Bus no. 18 arrived at 10:25:40 with 3 passengers)\n\t"+ba1);
        System.out.println("\n\t2. Testing Constructor with 3 parameters BusArrival(int lineNum, int pass, Time1 t):");
        Time1 t1 = new Time1(12,30,55);
        BusArrival ba2=new BusArrival(9,15,t1);
        System.out.println("\tBusArrival ba2 is: (should be: Bus no. 9 arrived at 12:30:55 with 15 passengers)\n\t"+ba2);        
        System.out.println("\n\t3. Testing Copy Constructor parameters BusArrival(BusArrival other):");
        BusArrival ba3= new BusArrival(ba1);
        System.out.println("\tBusArrival ba2 (constructed using ba1) is: (should be: Bus no. 18 arrived at 10:25:40 with 3 passengers)\n\t"+ba3);

        //=====================================================================
        System.out.println("\n\n2.1. Testing accessors (getters):");
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        System.out.println("\n\t1. Testing getLineNum():");
        System.out.println("\tline number is :"+ba1.getLineNum() + " (should be 18)");
        System.out.println("\n\t2. Testing getNoOfPass():");
        System.out.println("\tnumber of passengers is :"+ba1.getNoOfPass() + " (should be 3)");
        System.out.println("\n\t3. Testing getArrivalTime():");
        System.out.println("\tarrival time is:"+ba1.getArrivalTime() + " (should be: 10:25:40)");

        System.out.println("\n\n2.2. Testing mutators (setters):");
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        System.out.println("\n\t1. Testing setLineNum(int num):");
        ba1.setLineNum(25);
        System.out.println("\tline number is : "+ba1.getLineNum() + " (was 18, but now should be 25)");
        System.out.println("\n\t2. Testing setNoOfPass(int num):");
        ba1.setNoOfPass(14);
        System.out.println("\tnumber of passengers is : "+ba1.getNoOfPass() + " (was 3, but now should be 14)");
        System.out.println("\n\t3. Testing setArrivalTime(Time1 t):");
        Time1 t2 = new Time1(16,15,20);
        ba1.setArrivalTime(t2);
        System.out.println("\tarrival time is : "+ba1.getArrivalTime() + " (was 10:25:40, but now should be: 16:15:20)");

        //=====================================================================

        System.out.println("\n\n3. Testing equals() method:");
        ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        ba2=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba2 is:\n\t"+ba2);
        System.out.println("\n\tTest results:");
        if(ba1.equals(ba2))
            System.out.println("\tPassed: bas1 is the same BusArrival as ba2");
        else 
            System.out.println("\tErrors: ba1 isn't the same BusArrival as ba2");

        //=====================================================================

        System.out.println("\n\n4. Testing fuller() method:");
        ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        ba2=new BusArrival(28,13,10,40,45);
        System.out.println("\n\tBusArrival ba2 is:\n\t"+ba2);
        System.out.println("\n\tTest results:");
        if(ba1.fuller(ba2))
            System.out.println("\tError: ba1 (3 passengers) is fuller than ba2 (13 passengers)");
        else 
            System.out.println("\tPassed: ba2 (13 passengers) is fuller than ba1 (3 passengers)");

        //=====================================================================

        System.out.println("\n\n5. Testing before() method:");
        ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        ba2=new BusArrival(28,13,10,40,45);
        System.out.println("\n\tBusArrival ba2 is:\n\t"+ba2);
        System.out.println("\n\tTest results:");
        if(ba1.before(ba2))
            System.out.println("\tPassed: ba1 arrival time (10:25:40) is before ba2 arrival time (10:40:45)");
        else 
            System.out.println("\tError : ba2 arrival time (10:40:45) is before ba1 arrival time (10:25:40)");

        //=====================================================================

        System.out.println("\n\n6. Testing isFull() method:");
        ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        if(ba1.isFull())
            System.out.println("\tError: ba1 (3 passengers) is full");
        else 
            System.out.println("\tPassed: ba1 (3 passengers) is NOT full");

        //=====================================================================        

        System.out.println("\n\n7. Testing elapsedTime() method:");
        ba1=new BusArrival(18,3,10,25,40);
        System.out.println("\n\tBusArrival ba1 is:\n\t"+ba1);
        ba2=new BusArrival(28,13,10,40,45);
        System.out.println("\n\tBusArrival ba2 is:\n\t"+ba2);
        System.out.println("\n\tTest results:");
        if(ba1.elapsedTime(ba2) ==15) //15
            System.out.println("\tPASSED: ba1.elapsedTime(b2) == 15");
        else 
            System.out.println("\tERROR:  ba1.elapsedTime(b2) != 15 while it should be == 15");
        
    }
}