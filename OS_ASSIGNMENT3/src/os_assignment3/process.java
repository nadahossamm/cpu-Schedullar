package os_assignment3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MIC
 */
public class process {
    private String Name_of_process;
    private int burstnum;
    private int arrivalnum;
    private int context;
    private int start_time;
    private int end_time;
    private int waiting_time;
    private int turnarround_time;


    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public int getTurnarround_time() {
        return turnarround_time;
    }

    public void setTurnarround_time(int turnarround_time) {
        this.turnarround_time = turnarround_time;
    }

    public void setBurstnum(int burstnum) {
        this.burstnum = burstnum;
    }

    public void setArrivalnum(int arrivalnum) {
        this.arrivalnum = arrivalnum;
    }

    public void setName_of_process(String Name_of_process) {
        this.Name_of_process = Name_of_process;
    }

    public void setContext(int context) {
        this.context = context;
    }

    public int getBurstnum() {
        return burstnum;
    }

    public int getArrivalnum() {
        return arrivalnum;
    }

    public String getName_of_process() {
        return Name_of_process;
    }

    public int getContext() {
        return context;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public process() {
        start_time = -1;
        end_time = 0;
        context = 0;
        Name_of_process = "";
        burstnum = 0;
        arrivalnum = 0;
        turnarround_time = 0;
        waiting_time = 0;

    }

    @Override
    public String toString() {
        return "process{" + "Name_of_process=" + Name_of_process + ", burstnum=" + burstnum + ", arrivalnum=" + arrivalnum + ", context=" + context + ", start_time=" + start_time + ", end_time=" + end_time + ", waiting_time=" + waiting_time + ", turnarround_time=" + turnarround_time + '}';
    }

  
}
