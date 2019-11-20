
public class Stat {
	protected String measureDay;	//측정 일시
	protected String location;	//측정소명
	protected double nppm;		//이산화질소
	protected double oppm;		//오존농도
	protected double cppm;		//이산화탄소
	protected double appm;		//아황산가스
	protected int dust;		//미세먼지
	protected int mdust;		//초미세먼지
	
	public Stat(double nppm, double oppm, double cppm, double appm, int dust, int mdust) {
		this.nppm = nppm;
		this.oppm = oppm;
		this.cppm = cppm;
		this.appm = appm;
		this.dust = dust;
		this.mdust = mdust;
	}
	
	
	
}
