package com.saraya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.model.Kettle;

@Service //-> stereotype annotation and there are 4 : Controller, Repository, Service and Component
public class KettleService {

	private static ArrayList<Kettle> kettles=new ArrayList<Kettle>();
	private static int count=10;
	
	static {
		kettles.add(new Kettle(1,2019," HOBBS RUSSEL","ZJM11","https://static.fnac-static.com/multimedia/Images/FD/Comete/65238/CCP_IMG_ORIGINAL/796355.jpg"));
		kettles.add(new Kettle(2,2017,"CAVENDISH","GTK10W-19","https://i5.walmartimages.ca/images/Large/794/168/794168.jpg"));
		kettles.add(new Kettle(3,2021,"BOSCH SILICONE","TWK7S05","https://www.fagor-sda.com/700/bouilloire-programmable.jpg"));
		kettles.add(new Kettle(4,2021,"Russel Hobbs","ZJP05","https://www.cuisinart.ca/on/demandware.static/-/Sites-master-ca/default/dw4733aa04/CPK-17C.jpg"));
		kettles.add(new Kettle(5,2021,"Magimix","electric-D","https://www.lhommemoderne.fr/7721301-130339603-thickbox/bouilloire-electrique-filtrante-brita.jpg"));
		kettles.add(new Kettle(6,2020,"Dualit Kettle","Smeg50","https://www.riviera-et-bar.fr/376-large_default/bouilloire-inox-a-temperature-reglable-siena.jpg"));
		kettles.add(new Kettle(7,2020,"Tesco-Electric","KBZ3001","https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/2382/3.jpg?6434"));
		kettles.add(new Kettle(8,2020,"Cuisinart","CPK17","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWp2xXfL6RiZcDg8AUNJs-eVDcXR-D_VTa9EuttJTUj2fv6EZFIwRf1UBwzOU81iZM4OA&usqp=CAU"));
		kettles.add(new Kettle(9,2020,"Brewed-Coffee","Stainless","https://cacsenegal.com/wp-content/uploads/2020/04/bouilloire-electrique-en-verre-bouilloire-electriq-1.jpg"));
		kettles.add(new Kettle(10,2020,"Oxo-Brew-Cordless","overall-D22","https://sen-soxla.com/image/cache/catalog/000001/ddfds-550x550.jpg"));
	}
	
	public List<Kettle> getAllKettles(){
		return kettles;
	}
	public void addKettle(int year, String make, String model,String image) {
		kettles.add(new Kettle(++count,year,make,model,image));
	}
	public void deleteKettle(int id) {
		Iterator<Kettle> iterate=kettles.iterator();
		while(iterate.hasNext()) {
			Kettle kettle=iterate.next();
			if(kettle.getId()==id) {
				iterate.remove();
	}
	
}
}
	public Kettle findById(int id) {
	for(Kettle k:kettles) {
		if(k.getId()==id) {
			return k;
		}
	}
	return null;
}
	public void updateByKettle(Kettle k) {
		kettles.remove(k);
		kettles.add(k);
	}
}