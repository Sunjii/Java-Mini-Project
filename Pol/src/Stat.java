
public class Stat {
	protected double nppm;		//�̻�ȭ����
	protected double oppm;		//������
	protected double cppm;		//�̻�ȭź��
	protected double appm;		//��Ȳ�갡��
	//protected int dust;		//�̼�����
	//protected int mdust;		//�ʹ̼�����
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
