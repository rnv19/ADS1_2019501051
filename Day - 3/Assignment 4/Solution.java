import java.util.Arrays;

class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		int n = teams.length;
		if(n != 1){
			for(int i = 1; i < n; i++){
				for(int j = i; j > 0; j--){
					if(teams[j].compareTo(teams[j-1]) < 0){
						swap(teams, j, j-1);
					}
				}
			}
		}return teams;
	}
		public Team[] swap(Team[] teams, int a, int b){
			Team temp = teams[b];
			teams[b] = teams[a];
			teams[a] = temp;
			return teams; 
		}

		public static void main(String[] args) {
			Solution s = new Solution();
			Team[] teams = {new Team("England",4,2,3), new Team("India",5,2,4),new Team("Australia",6,2,3), new Team("SouthAfrica",5,3,4), new Team("Bangladesh",3,4,2), new Team("Zimbabwe",3,4,6), new Team("Ireland",3,4,1)};
			System.out.println(Arrays.toString(s.sort(teams)));
		}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;

	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return teamName + "," + noOfWins + "," + noOfLosses + "," + noOfDraws;
	}

	public int compareTo(Team team){
		if(team.noOfWins != this.noOfWins){
			return (team.noOfWins - this.noOfWins);
		}else if(team.noOfLosses != this.noOfLosses){
			return (this.noOfLosses - team.noOfLosses);
		}else if(this.noOfDraws != team.noOfDraws){
			return (team.noOfDraws - this.noOfDraws);
		}else return 0;
	}


}