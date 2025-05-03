package Maman12;

public class Time2StudentTester
{
    public static void main(String[] args) {
        
        System.out.println("********** Test Time2 - Started **********");

        //=====================================================================
        System.out.println("\n\n1. Testing Constructors and toString:");
        System.out.println("\n\t1. Testing Constructor with 3 parameters Time2(int h, int m, int s):");
        Time2 t1 = new Time2(10,25,40);
        System.out.println("\tTime2 t1 is: (should be: 10:25:40)\n\t"+ t1);
        System.out.println("\n\t2. Testing Copy Constructor Time2(Time2 other):");
        Time2 t2 = new Time2(t1);
        System.out.println("\tTime2 t2 (constructed using t1) is: (should be 10:25:40)\n\t"+ t2);

        //=====================================================================
        System.out.println("\n\n2.1. Testing accessors (getters):");
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        System.out.println("\n\t1. Testing getHour():");
        System.out.println("\tstudent result is : "+t1.getHour() + " (should be 10)");
        System.out.println("\n\t2. Testing getMinutes():");
        System.out.println("\tstudent result is : "+t1.getMinute() + " (should be 25)");
        System.out.println("\n\t3. Testing getSeconds():");
        System.out.println("\tstudent result is : "+t1.getSecond() + " (should be 40)");

        System.out.println("\n\n2.2. Testing mutators (setters):");
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        System.out.println("\n\t1. Testing setHour(int num):");
        t1.setHour(12);
        System.out.println("\thour after set is : "+ t1.getHour() + " (was 10, but now should be 12)");
        System.out.println("\n\t2. Testing setMinute(int num):");
        t1.setMinute(14);
        System.out.println("\tminute after set is : "+ t1.getMinute() + " (was 25, but now should be 14)");
        System.out.println("\n\t3. Testing setSecond(int num):");
        t1.setSecond(35);
        System.out.println("\tsecond after set is : "+ t1.getSecond() + " (was 40, but now should be 35)");

        //=====================================================================

        System.out.println("\n\n3. Testing secFromMidnight() method:");
        t1= new Time2(10,25,40);
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        System.out.println("\n\tTest results:");
        if(t1.secFromMidnight() == 37540)
            System.out.println("\tPassed: t1 (10:25:40) secoFromMidnight() return 37540");
        else 
            System.out.println("\tErrors: t1 (10:25:40) secoFromMidnight() return: " +t1.secFromMidnight() + " instead of 37540");

        //=====================================================================
        
        System.out.println("\n\n4. Testing equals() method:");
        t1= new Time2(10,25,40);
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        t2= new Time2(10,25,40);
        System.out.println("\n\tTime2 t2 is:\n\t"+ t2);
        System.out.println("\n\tTest results (t1.equals(t2)):");
        if(t1.equals(t2))
            System.out.println("\tPassed: Time t1 is the same Time2 as t2");
        else 
            System.out.println("\tError: your code return false for t1 (10:25:40) equals t2 (10:25:40) while it should return true");

        //=====================================================================

        System.out.println("\n\n5. Testing before() method:");
        t1= new Time2(10,25,40);
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        t2= new Time2(10,40,45);
        System.out.println("\n\tTime2 t2 is:\n\t"+ t2);
        System.out.println("\n\tTest results: (t1.before(t2))");
        if(t1.before(t2))
            System.out.println("\tPassed: Time2 t1 (10:25:40) is before Time2 t2 (10:40:45)");
        else 
            System.out.println("\tError: your code return false t1 (10:25:40) before t2 (10:40:45) while it should return true");

        //=====================================================================
        
        System.out.println("\n\n6. Testing after() method:");
        t1= new Time2(10,25,40);
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        t2= new Time2(10,40,45);
        System.out.println("\n\tTime2 t2 is:\n\t"+ t2);
        System.out.println("\n\tTest results (t2.after(t1)):");
        if(t2.after(t1))
            System.out.println("\tPassed: Time2 t2 (10:40:45) is after Time2 t1 (10:25:40)");
        else 
            System.out.println("\tError: your code return false for t2 (10:40:45) is after t1 (10:25:40) while it should return true");
            
        //=====================================================================      

        System.out.println("\n\n7. Testing difference() method:");
        t1= new Time2(10,25,40);
        System.out.println("\n\tTime2 t1 is:\n\t"+ t1);
        t2= new Time2(10,40,45);
        System.out.println("\n\tTime2 t2 is:\n\t"+ t2);
        System.out.println("\n\tTest results (t2.difference(t1)):");
        if(t2.difference(t1) == 905)
            System.out.println("\tPassed: t2.difference(t1) returned 905");
        else 
            System.out.println("\tErrors: t2 (10:40:45) difference from t1 (10:25:40) returned: " +t2.difference(t1) + " instead of 905");
    }
}