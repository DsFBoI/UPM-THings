public class A6 {
    // Exercise 1
    static double finalPrice (int p) {
        if (p>=200 && p<600)
            return p*0.88;
        else if (p>=600)
            return p*0.8;
            else 
                return p;
    }
    //Exercise 2
    static double monthlyInterest (int I){
        if (I>=100 && I<=1000)
            return I + (I*0.04);
        else if (I>1000 && I<=3000 )
            return I + (I*0.045);
            else if (I>3000)
                return I + (I*0.05);
                else 
                    return I;
    }
    //Exercise 3
    static String DaysOfTheWeek (int D){
        if (D==1)
            return "Monday";
            else if (D==2)
                return "Tuesday";
                else if (D==3)
                    return "Wednesday";
                    else if (D==4)
                        return "Thursday";
                        else if (D==5)
                            return "Friday";
                            else if (D==6)
                                return "Saturday";
                                else if (D==7)
                                    return "Sunday";
                                    else 
                                        return "There is no day of the week associated with that number";
    
    }
    //Exercise 4
    static String daysOfMonth (int m, int y){
        if (m==1||m==3||m==5||m==7||m==9||m==11)
            return "31";
            else if (m==4||m==6||m==8||m==10||m==12)
                return "30";
                else if (m==2 && y%4==0)
                    return "29";
                    else if (m==2 && y%4!=0)
                        return "28";
                        else 
                            return "error";
    
    }
    //Exercise 5
    static String translateCardinaPoints (char c){
        if (c=='N'||c=='n')
            return "North";
            else if (c=='S'||c=='s')
                return "South";
                else if (c=='W'||c=='w')
                    return "West";
                    else if (c=='E'||c=='e')
                        return "East";
                        else
                            return "Wrong Cardinal Point";
    }
    //Exercise 6
    static double TripHawaii (int s){
        if (s>=100)
            return s*200 ;
            else if (s>=50 && s<=99)
                return s*330 ;
                else if (s>=30 && s<=49)
                    return s*500 ;
                    else
                        return 15000;

    }
    //Exercise 8
    static String Notas(double n){
        if (n>=9)
            return "A";
            else if (n>=7 && n<=8.99)
                return "B";
                else if (n>=6 && n<=6.99)
                    return "C";
                    else if (n>=5 && n<=5.99)
                        return "D";
                        else 
                            return "F";
    }
        
    public static void main(String[] args) {
        
        System.out.println(finalPrice(150));
        System.out.println(finalPrice(350));
        System.out.println(finalPrice(650));

        System.out.println(monthlyInterest(90));
        System.out.println(monthlyInterest(900));
        System.out.println(monthlyInterest(1900));
        System.out.println(monthlyInterest(9000));
        System.out.println(DaysOfTheWeek(1));
        System.out.println(DaysOfTheWeek(2));
        System.out.println(DaysOfTheWeek(3));
        System.out.println(DaysOfTheWeek(4));
        System.out.println(DaysOfTheWeek(5));
        System.out.println(DaysOfTheWeek(6));
        System.out.println(DaysOfTheWeek(7));
        System.out.println(DaysOfTheWeek(8));
        System.out.println(daysOfMonth(1,2020));
        System.out.println(daysOfMonth(4,2019));
        System.out.println(daysOfMonth(2,2020));
        System.out.println(daysOfMonth(2,2019));
        System.out.println(daysOfMonth(14,2020));
        System.out.println(translateCardinaPoints('N'));
        System.out.println(translateCardinaPoints('s'));
        System.out.println(translateCardinaPoints('W'));
        System.out.println(translateCardinaPoints('e'));
        System.out.println(translateCardinaPoints('F'));
        System.out.println(TripHawaii(20));
        System.out.println(TripHawaii(45));
        System.out.println(TripHawaii(75));
        System.out.println(TripHawaii(110));
        System.out.println(TripHawaii(2));
        System.out.println(Notas(9.75));
        System.out.println(Notas(7.6));
        System.out.println(Notas(6.4));
        System.out.println(Notas(5.25));
        System.out.println(Notas(3.75));
    }
}
