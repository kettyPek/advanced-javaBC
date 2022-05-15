package ajbc.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		
		List<Tent> tents = Arrays.asList(
				new Tent(1,5.1,6,7),
				new Tent(2,6.1,8,3),
				new Tent(5,7,8,7),
				new Tent(6,3,5,7),
				new Tent(2,5.1,6,1),
				new Tent(4,8.1,3,2),
				new Tent(5,5.1,5,6),
				new Tent(7,6.1,7,8),
				new Tent(5,6.1,9,12),
				new Tent(1,7.1,6,7));
		
		List<Tent> sortedTentsByArea = soretdTentsByArea(tents);
		System.out.println("sorted tents by area: ");
		sortedTentsByArea.forEach(tent -> System.out.println(tent));
		
		List<Tent> sortedByPeople = sortedTentsByPeople(tents,5);
		System.out.println("sorted tents by number of people:");
		sortedByPeople.forEach(tent -> System.out.println(tent));
		
		Tent max = new Tent(7,6.1,7,8);
		System.out.println("is highest: " + isTentHighest(tents,max));
		
		HashMap<Double,List<Tent>> tentsInMap =  hightAsKey(tents);
		System.out.println(tentsInMap);
		
		List<Tent> tentsInRange = hightAsKey(tentsInMap,2,5);
		System.out.println(tentsInRange);

	}
	
	public static List<Tent> soretdTentsByArea(List<Tent> tents){
		List<Tent> sortedTents = tents;
		sortedTents = sortedTents.stream().sorted((tent1,tent2) -> (int)(tent1.getWidth()*tent1.getLength() - tent2.getWidth()*tent2.getLength()))
		.collect(Collectors.toList());
		return sortedTents;
	}
	
	public static List<Tent> sortedTentsByPeople(List<Tent> tents, int num){
		List<Tent> sortedTents = tents;
		sortedTents = tents.stream().filter(tent -> tent.getNumPeople()>=num)
				.sorted((tent1,tent2)-> tent1.getNumPeople()-tent2.getNumPeople())
				.collect(Collectors.toList());
		return sortedTents;
	}
	
	public static boolean isTentHighest(List<Tent> tents,Tent max) {
		 Optional<Tent> tentMax = tents.stream().max((tent1,tent2)->(int)(tent1.getHeight()-tent2.getHeight()));
		return tentMax.get().getHeight() < max.getHeight();
	}
	
	public static HashMap<Double,List<Tent>> hightAsKey(List<Tent> tents){
		HashMap<Double,List<Tent>> tentsByHight = new HashMap<>();
		tents.stream().forEach(tent -> {
			if(tentsByHight.containsKey(tent.getHeight())) {	
				List<Tent> tentValuse = tentsByHight.get(tent.getHeight());
				tentValuse.add(tent);
				tentsByHight.get(tent.getHeight()).add(tent);}
			else
				tentsByHight.put(tent.getHeight(),Arrays.asList(tent));
		});
		return tentsByHight;
	}
	
	public static List<Tent> hightAsKey(HashMap<Double,List<Tent>> tents, double maxHeight, double minHeight){
		List<Tent> tentsInRange ;
		tentsInRange = tents.entrySet().stream().filter(tent -> tent.getKey()>=minHeight && tent.getKey()<=maxHeight).
				map(tent -> tent.getValue()).collect(null);
		return tentsInRange;
	}
	
	
	
	
	
	

}
