package Infra;

public class SimpleThread  extends Thread {
    
    public SimpleThread(String name) {
        super(name);   
    }
   
    
    
    public void run() {
        for (int i = 0; i < 10; i++) {  
        	ReporterTest.addStepToReportFile(getName(), ReportStatus.INFO);
            System.out.println(i + " " + getName());
            GeneralTools.reportPassOrFail((i<5), "The iteration number is less then 5. it's " + i, "The iteration number is less then 5. it's " + i);
        }
        ReporterTest.addStepToReportFile("DONE! " + getName(), ReportStatus.INFO);
        System.out.println("DONE! " + getName());
    }
}
