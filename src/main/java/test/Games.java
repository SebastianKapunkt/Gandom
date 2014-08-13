
package test;

import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Games{
   	private Number game_count;
   	private Set<Game> games;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
   	
 	public Number getGame_count(){
		return this.game_count;
	}
	public void setGame_count(Number game_count){
		this.game_count = game_count;
	}
 	public Set<Game> getGames(){
		return this.games;
	}
	public void setGames(Set<Game> games){
		this.games = games;
	}
}
