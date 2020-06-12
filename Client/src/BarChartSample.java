import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class BarChartSample extends Application {
    
    private ArrayList<Integer> count = new ArrayList<Integer>();
    private HashMap<String,Integer> plecare = new HashMap<String,Integer>();
    private HashMap<String,Integer> sosire = new HashMap<String,Integer>();
    private HashMap<String,Integer> preturi = new HashMap<String,Integer>();
    
    private TrenPersistent t = new TrenPersistent();
    private BiletPersistent b = new BiletPersistent();
    private static String[] limba = {"Statistici trenuri","Grafic","Criteriu","Valoare","Statie plecare","Statie destinatie","Pret"};
   
    public static void updateLimba(String[] nouaLimba) {
    	limba=nouaLimba;
    }
 
    
    public void start(Stage stage) {
	
			stage.setTitle(limba[0]);
	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = 
	            new BarChart<String,Number>(xAxis,yAxis);
	        bc.setTitle(limba[1]);
	        xAxis.setLabel(limba[2]);       
	        yAxis.setLabel(limba[3]);
	        
	        count=b.idTrenuri();
	        
	        for(int i=0;i<count.size();i++) {
	        	String date=t.date(count.get(i));
	        	String[] atribute = date.split(" ");
	        	float pret = Float.parseFloat(atribute[2]);
	        	if(plecare.containsKey(atribute[0])) plecare.put(atribute[0], plecare.get(atribute[0])+1);
	        	else plecare.put(atribute[0], 1);
	        	
	        	if(sosire.containsKey(atribute[1])) sosire.put(atribute[1], sosire.get(atribute[1])+1);
	        	else sosire.put(atribute[1], 1);
	        	for(int k=10;k<=150;k=k+10)
	        	if(pret<k) if(preturi.containsKey("<"+k)) preturi.put("<"+k, preturi.get("<"+k)+1);
	        	else preturi.put("<"+k, 1);
	        	
	        }
	        
	        
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName(limba[4]);
	        plecare.entrySet().forEach(entry->{
	        	series1.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
	         });  
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName(limba[5]);
	        sosire.entrySet().forEach(entry->{
	            series2.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
	         });
	        
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName(limba[6]);
	        	preturi.entrySet().forEach(entry->{
	            	series3.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
	             });  
	        
	        Scene scene  = new Scene(bc,800,600);
	        bc.getData().addAll(series1, series2,series3);
	        stage.setScene(scene);
	        stage.show();
		}
 
    public static void main(String[] args) {
        launch(args);
    }
}