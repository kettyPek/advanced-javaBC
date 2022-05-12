package ajbc.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ajbc.exercise.GameCharacter.Continent;

public class Runner {

	public static void main(String[] args) {

		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000,
						Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100,
						Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100,
						Continent.Eastern_Kingdoms));
		
		
		System.out.println("------kalimdor resindents------");
		List<String> kalimdorCharacters = characters.stream()
				.filter((character)-> character.getContinent()==Continent.Kalimdor)
				.map(character->character.getName())
				.collect(Collectors.toList());
		kalimdorCharacters.forEach(System.out::println);
		
		System.out.println("\n------sorted characters by hit points------");
		characters.stream().sorted((char1,char2)-> {
			double diff = char1.getHitPoints() - char2.getHitPoints();
			return diff == 0.0 ? 0 : (diff > 0.0 ? 1 : -1);}).forEach(System.out::println);
		
		double avarageHitPoints = characters.stream()
				.filter(character->character.getLevel()==120)
				.map(character -> character.getHitPoints()).reduce(0.0,(acc,next) -> acc + next)/characters.size();
		System.out.println("\nHit points avarage of players in 120 level: " + avarageHitPoints);
		
		System.out.println("");
		List<String> names = Arrays.asList("ketty","gal","alex","dani","nadav");
		List<GameCharacter> newCharacers = names.stream()
				.map(name -> new GameCharacter(name, "Lich King", "Icecrown", 80, 1500, Continent.Northrend))
				.collect(Collectors.toList());
		newCharacers.forEach(System.out::println);	
		
		
	}

}
