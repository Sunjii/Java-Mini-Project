
public class Stat {
	protected String measureDay;	//���� �Ͻ�
	protected String location;	//�����Ҹ�
	protected double nppm;		//�̻�ȭ����
	protected double oppm;		//������
	protected double cppm;		//�̻�ȭź��
	protected double appm;		//��Ȳ�갡��
	protected int dust;		//�̼�����
	protected int mdust;		//�ʹ̼�����
	
	public Stat(double nppm, double oppm, double cppm, double appm, int dust, int mdust) {
		this.nppm = nppm;
		this.oppm = oppm;
		this.cppm = cppm;
		this.appm = appm;
		this.dust = dust;
		this.mdust = mdust;
	}
	
	
	
}
