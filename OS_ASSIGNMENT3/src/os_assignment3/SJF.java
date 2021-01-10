package os_assignment3;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MIC
 */
public class SJF {

    private int Number_of_processes;
    private int burstnum;
    private int burstnum2;
    private int arrivalnum;
    private int context;
    private String Name_of_process;
    private ArrayList<process> process1 = new ArrayList<process>();
    private ArrayList<process> process_done = new ArrayList<process>();
    private ArrayList<process> process2 = new ArrayList<process>();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    public void SJF_program() {

        System.out.println("Enter Number of processes ");
        Number_of_processes = scanner2.nextInt();
        System.out.println("Enter context switching");
        context = scanner2.nextInt();

        for (int i = 0; i < Number_of_processes; i++) {
            process p = new process();
            process p1 = new process();
            p.setContext(context);
            System.out.println("Enter name of process "+ (i + 1));
            Name_of_process = scanner.nextLine();
            p.setName_of_process(Name_of_process);
            p1.setName_of_process(Name_of_process);
            System.out.println("Enter arrival time of process "+ (i + 1));
            arrivalnum = scanner2.nextInt();
            p.setArrivalnum(arrivalnum);
            p1.setArrivalnum(arrivalnum);
            System.out.println("Enter burst time of process "+ (i + 1));
            burstnum = scanner2.nextInt();
            //burstnum2 = scanner2.nextInt();
            p.setBurstnum(burstnum);
            p1.setBurstnum(burstnum);
            process1.add(p);
            process_done.add(p1);

        }
       // process_done=process1;
        run();
        
        
       // x();
        
       
    }
   
    
    
    
    private void run ()
    {
        
        
        int min = find_min_arrival(0);
        int time = 0;
        process p2 = new process();
        p2 = process1.get(min);
        p2.setStart_time(time);
        int total_arrival=get_Total_burst_time();
        while(total_arrival>0)
        {
            total_arrival--;
          
            time++;
            int a=process1.get(min).getBurstnum();
            a=a-1;     
            process1.get(min).setBurstnum(a);
          int min2=find_min_arrival(time);
          //  System.out.println("min2"+min2);
          if (min2!=min)
          {
              
              p2.setEnd_time(time);
              time=time+context; 
              process2.add(p2);
              min=find_min_arrival(time);
              if(min==-1)
                  break;
              p2=process1.get(min);
              if(p2.getStart_time()==-1)
              {
                   p2.setStart_time(time);
              }
               
           //   min=min2;
          
          } 
         
        }
        find_Output();
        print();
        
    }
            
    private int find_min_arrival(int min) {
       int min3 = 0;
       ArrayList<process> arr=new ArrayList<process>();
        for (int i = 0; i < process1.size(); i++) {
            if(process1.get(i).getArrivalnum()<=min)
            {
                if(process1.get(i).getBurstnum()>0)
                        arr.add(process1.get(i));
            }
                
        }
        if(arr.size()>1)
        {
            int x=arr.get(0).getBurstnum();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getBurstnum()< x)
            {
                
                x=process1.get(i).getBurstnum();
               // System.out.println(x);
                min3=i;
            }
          /*  else
            {
             // System.out.println("in else ");

                 min3=i+1;
            }*/
               
        }
        
        
         }
        else
        {
         // System.out.println("in else 2");

            min3=0;
        }
        if(arr.size()!=0)
        {
         for (int i = 0; i < process1.size(); i++) {
             //System.out.println("min3 "+min3);
            //System.out.println("i"+i);
            
            if(process1.get(i)==arr.get(min3))
            {
                //System.out.println("min3 "+min3);
               // System.out.println("i"+i);
                return i;
            }
        }
        }
       
        return -1;
        
     
    }

    public void print()
    {
        System.out.println("process execution: ");
           for (int i=0;i<process2.size();i++)
        {
            System.out.print(process2.get(i).getName_of_process()+" ");
        }
           System.out.println("");
        for (int i=0;i<process_done.size();i++)
        {
            System.out.println(process_done.get(i).toString());
         
        }
        
        Average_waiting();
        Average_turnarroud();
        
      
    }
    private int get_Total_burst_time()
    {
        int sum=0;
        for(int i=0;i<process1.size();i++)
            sum=sum+process1.get(i).getBurstnum();
        return sum;
    }
    
    private void find_Output()
    {
     //get start and end
        for(int i=0;i<process_done.size();i++)
        {
       
        
            for(int j=0;j<process2.size();j++)
            {
                if(process_done.get(i).getName_of_process().equals(process2.get(j).getName_of_process()))
                {
                   process_done.get(i).setStart_time(process2.get(j).getStart_time()) ;
                   process_done.get(i).setEnd_time(process2.get(j).getEnd_time());
                   
                }
            }
        }
        
        //get waiting time
        for(int i=0;i<process_done.size();i++)
        {
            int wait=process_done.get(i).getEnd_time()-process_done.get(i).getBurstnum()-process_done.get(i).getArrivalnum();
            
            process_done.get(i).setWaiting_time(wait);
        }
        ///get turnarround
        
        
        for(int i=0;i<process_done.size();i++)
        {
            int turnarround=process_done.get(i).getWaiting_time()+process_done.get(i).getBurstnum();
            
            process_done.get(i).setTurnarround_time(turnarround);
        }
    
    }
    private void Average_waiting()
    {
        int sum=0;
         for(int i=0;i<process_done.size();i++)
         {         
             sum=sum+process_done.get(i).getWaiting_time();
        }
         sum=sum/process_done.size();
         System.out.println("Average waiting "+sum);
    }
     private void Average_turnarroud()
    {
        double sum=0;
         for(int i=0;i<process_done.size();i++)
         {         
             sum=sum+process_done.get(i).getTurnarround_time();
         }
         sum=sum/process_done.size();
         System.out.println("Average turnarround "+sum);
    }
      
            
}
