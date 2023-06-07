package Java_230407;

public class TvRemocon2 {
	public int limit_up_vol; // 최대 볼륨
	public int limit_down_vol; // 최소 볼륨
	public int vol; // 현재 볼륨
	public String volHelp; // 메세지

	public int limit_up_channel; // 최대 채널
	public int limit_down_channel; // 최소 채널
	public int channel; // 현재 채널
	public String chHelp; // 채널 메세지
	
	public String help; // 메세지
	

	TvRemocon2() { // 기본 볼륨, 채널 세팅
		limit_up_vol = 5; // 최대 볼륨 10 설정
		limit_down_vol = 0; // 최소 볼륨 0 설정
		vol = 1; // 현재 볼륨
		volHelp = "기본 볼륨 1"; // 세팅 값

		limit_up_channel = 10; // 최대 채널
		limit_down_channel = 0; // 최소 채널
		channel = 1; // 현재 채널
		chHelp = "기본 채널 1"; // 세팅 값

	}

	void volUp() { // 볼륨이 올라감
		if (vol == limit_up_vol) { // 볼륨이 최대 볼륨과 같다면
			volHelp = "최대 볼륨입니다."; // 메세지 문구 대입
		} else { // 최대볼륨이 아닐 때
			vol++; // 1씩 올라감
			volHelp = String.format("볼륨 %d 입니다", vol); // 현재 볼륨 값 volHelp에 대입
		}
	}

	void volDown() { // 볼륨이 내려감
		if (vol == limit_down_vol) { // 최저 볼륨일 때
			volHelp = "최소 불륨입니다."; // 메세지 문구 대입
		} else { // 최저 볼륨이 아닐 때
			vol--; // 1씩 내려감
			volHelp = String.format("볼륨 %d 입니다", vol); // 현재 볼륨 값 volHelp에 대입
		}
	}

	// 올릴 볼륨의 크기를 지정해서 그만큼 올라가도록 한다
	void volUp(int u) { // 크기를 인자로 받는 volUp 함수
		for (int i = 0; i < u; i++) { // 인자값 만큼 반복
			this.volUp(); // this를 쓰면 명확해짐 volUp() 함수 실행
		}
	}

	// 내릴 볼륨의 크기를 지정해서 그만큼 내려가도록 한다
	void volDown(int u) { // 크기를 인자로 받는 volUp 함수
		for (int i = 0; i < u; i++) { // 인자값 만큼 반복
			this.volDown(); // this를 쓰면 명확해짐 volUp() 함수 실행
		}
	}

	// 볼륨의 메세지 출력
	void volMsg(String id) {
		System.out.printf("%s => [%s], 최대볼륨[%d] 최소볼륨[%d] 현재볼륨[%d]\n", id, volHelp, limit_up_vol, limit_down_vol, vol);
	} // 최대볼륨, 최소볼륨, 현재볼륨 출력

	void channelUp() { // 채널이 올라감
		if (channel == limit_up_channel) { // 채널이 최대 채널과 같다면
			chHelp = "마지막 채널입니다."; // 메세지 문구 대입
		} else {// 채널이 최대 채널과 같지 않다면
			channel++; // 1씩 올라감
			chHelp = String.format("채널 %d 입니다", channel); // 메세지 문구 대입
		}
	}

	void channelDown() { // 채널이 내려감
		if (channel == limit_down_channel) { // 채널이 최소 채널과 같다면
			chHelp = "처음 채널입니다."; // 메세지 문구 대입
		} else { // 채널이 최소 채널과 같지않다면
			channel--; // 1씩 올라감
			chHelp = String.format("채널 %d 입니다", channel); // 메세지 문구 대입
		}
	}

	// 올릴 채널의 크기를 지정해서 그만큼 올라가도록 한다
	void channelUp(int u) { // 크기를 인자로 받는 channelUp 함수
		for (int i = 0; i < u; i++) { // 인자값 만큼 반복
			this.channelUp(); // this를 쓰면 명확해짐 channelUp() 함수 실행
		}
	}

	// 내릴 채널의 크기를 지정해서 그만큼 내려가도록 한다
	void channelDown(int u) { // 크기를 인자로 받는 channelDown 함수
		for (int i = 0; i < u; i++) { // 인자값 만큼 반복
			this.channelDown(); // this를 쓰면 명확해짐 channelDown() 함수 실행
		}
	}

	// 채널 메세지 출력
	void chMsg(String id) {
		System.out.printf("%s => [%s], 최대채널[%d] 최소채널[%d] 현재채널[%d]\n", id, chHelp, limit_up_channel, limit_down_channel,
				channel);
	} // 최대볼륨, 최소볼륨, 현재볼륨 출력

}
