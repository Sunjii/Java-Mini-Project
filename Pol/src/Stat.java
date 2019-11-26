
public class Stat {
	protected double nppm;		//이산화질소
	protected double oppm;		//오존농도
	protected double cppm;		//이산화탄소
	protected double appm;		//아황산가스
	//protected int dust;		//미세먼지
	//protected int mdust;		//초미세먼지
	protected double dust;
	protected double mdust;
	
	
	public Stat(double nppm, double oppm, double cppm, double appm, double dust, double mdust) {
		this.nppm = nppm;
		this.oppm = oppm;
		this.cppm = cppm;
		this.appm = appm;
		this.dust = dust;
		this.mdust = mdust;
	}

	public Stat(String nppm, String oppm, String cppm, String appm, String dust, String mdust) {
		this.nppm = Double.parseDouble(nppm);
		this.oppm = Double.parseDouble(oppm);
		this.cppm = Double.parseDouble(cppm);
		this.appm = Double.parseDouble(appm);
		this.dust = Integer.parseInt(dust);
		this.mdust = Integer.parseInt(mdust);
		
		
		
		
	}
	
	
	
}
