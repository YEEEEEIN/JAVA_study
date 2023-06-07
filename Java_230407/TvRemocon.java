package Java_230407;

public class TvRemocon {
	int k23_limit_up_vol = 5; // 최대 볼륨
	int k23_limit_down_vol = 0; // 최소 볼륨

	int k23_limit_up_channel = 10; // 최대 채널
	int k23_limit_down_channel = 0; // 최저 채널

	int k23_vol = 1; // 현재 볼륨
	int k23_channel = 1; // 현재 채널
	String k23_help; // 메세지 문구

	void k23_VolUp() { // 볼륨이 올라가는 함수
		if (k23_vol == k23_limit_up_vol) { // 최대 볼륨일 때
			k23_help = "최대 볼륨입니다."; // 메세지 문구 대입
		} else { // 최대볼륨이 아닐 때
			k23_vol++; // 1씩 올라감
			k23_help = String.format("볼륨 %d 입니다", k23_vol); // 메세지 문구 대입
		}
	}

	void k23_VolDown() { // 볼륨이 내려가는 함수
		if (k23_vol == k23_limit_down_vol) { // 최저 볼륨일 때
			k23_help = "최소 불륨입니다."; // 메세지 문구 대입
		} else { // 최저 볼륨이 아닐 때
			k23_vol--; // 1씩 올라감
			k23_help = String.format("볼륨 %d 입니다", k23_vol); // 메세지 문구 대입
		}
	}

	void k23_ChannelUp() { // 채널이 올라가는 함수
		if (k23_channel == k23_limit_up_channel) { // 최대 채널일 때
			k23_help = "마지막 채널입니다."; // 메세지 문구 대입
		} else { // 최대 채널이 아닐 때
			k23_channel++; // 1씩 올라감
			k23_help = String.format("채널 %d 입니다", k23_channel); // 메세지 문구 대입
		}
	}

	void k23_ChannelDown() { // 채널이 내려가는 함수
		if (k23_channel == k23_limit_down_channel) { // 최저 채널일 때
			k23_help = "처음 채널입니다."; // 메세지 문구 대입
		} else { // 최저 채널이 아닐 때
			k23_channel--; // 처음 채널이 아닐때 1씩 올라감
			k23_help = String.format("채널 %d 입니다", k23_channel); // 메세지 문구 대입
		}
	}
}
