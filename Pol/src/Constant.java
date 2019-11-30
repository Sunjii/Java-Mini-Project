// 상수 정의 클래스
public class Constant {
	// 오염물질
	static final String[] pollut = { "이산화질소", "오존농도", "이산화탄소", "아황산가스", "미세먼지", "초미세먼지" };
	// 오염물질의 최대값
	static final double pollut_max[] = {0.060, 0.060, 3, 0.050, 200, 130};
	
	static final String header[] = { "지역", "날짜", Constant.pollut[0], Constant.pollut[1], Constant.pollut[2],
			Constant.pollut[3], Constant.pollut[4], Constant.pollut[5] };

	
	
	
	
	/*	데이터 상의 범위
	 * 이산화질소 : 0.000 ~ 0.150 // 0.06 
	 * 오존농도 : 0.000 ~ 0.300 // 0.06 기준치 
	 * 이산화탄소 : 0 ~ 3
	 * // 아황산가스 : 0.001 ~ 0.150 // 0.05 
	 * 미세먼지 : 0 ~ 200 int형 // 100 
	 * 초미세먼지 : 0 ~ 130 int형 // 35
	 */
	
	/*	권고기준 - 출처 : 한국환경공단.
	 * 파랑 - 녹색 - 노랑 - 빨강
	 * 이산화질소 : 0~0.030 좋음, 0.031~0.060 보통, 0.061~0.200 나쁨, 0.201~ 매우나쁨
	 * 오존농도    : 0~0.030 좋음, 0.030~0.090 보통, 0.091~0.150 나쁨, 0.151~ 매우나쁨
	 * 이산화탄소 : 0~2 좋음, 2~9 보통, 9~15 나쁨, 15~ 매우나쁨
	 * 아황산가스 : 0~0.020 좋음, 0.021~0.050 보통, 0.051~0.150 나쁨, 0.151~ 매우나쁨
	 * 미세먼지 : 0~30 좋음, 31~80 보통, 81~150 나쁨, 151~ 매우나쁨
	 * 초미세먼지 : 0~15 좋음, 16~35 보통, 36~75 나쁨, 76~ 매우나쁨
	 */
	
	static final double[] nppm_lv = {0.030, 0.060, 0.200};
	static final double[] oppm_lv = {0.030, 0.090, 0.150};
	static final double[] cppm_lv = {2, 9, 15};
	static final double[] appm_lv = {0.020, 0.050, 0.150};
	static final double[] dust_lv = {30, 80, 150};
	static final double[] mdust_lv = {15, 35, 75};
	
	

	// 지역목록
	static final String[] locations = { "전체", "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구",
			"구로구", "궁동", "금천구", "남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구", "성동구",
			"성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구", "중랑구",
			"천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };

	// 대화상자 사이즈
	static final int dial_W = 600;
	static final int dial_H = 350;

}
