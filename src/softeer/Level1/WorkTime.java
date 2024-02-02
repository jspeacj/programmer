package softeer.Level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkTime {
    public static void main(String[] args) throws ParseException{
        /*
            근무시간 (Level 1)

            당신은 인사팀 직원으로, 각 직원의 근태를 확인하고자 한다.
            당신의 회사는 자율출퇴근제를 실시하기 때문에 각 직원이 정확히 몇 시에 출근하는 것은 중요하지 않고,
            총 근로 시간이 몇 분인지가 중요하다. 총 근로 시간이 법정근로시간을 초과하지 않아야 하면서, 회사와 직원 사이에 계약한 시간 이상이어야 하기 때문이다.
            직원이 하루 동안 근무한 시간은 출근 시각과 퇴근 시각 사이의 시간으로 정의한다. 이 문제에서는 식사 시간 등 근무 외 시간을 근무 시간에서 제외하지 않음에 유의하라.
            월요일부터 금요일까지 휴가를 쓰지 않은 직원이 매 요일 언제 출근하고 언제 퇴근했는지가 주어질 때, 이 직원이 5일 동안 총 몇 분을 근무했는지를 구하는 프로그램을 작성하라.

            제약조건
            직원은 밤을 새서 일하지 않았다. 즉, 출근 시각과 퇴근 시각은 00:00 이후, 24:00 이전에 이루어졌다.

            출퇴근 시각은 HH:MM과 같은 형식으로 주어진다.
            HH는 00, 01, 02, .., 22, 23 중 하나이다.
            MM는 00, 01, 02, .., 58, 59 중 하나이다.
            직원은 매일 1분 이상은 일하였다.

            입력형식
            첫 번째 줄에는 월요일에 출근한 시각과 월요일에 퇴근한 시각이 공백 하나를 사이로 두고 주어진다.
            두 번째 줄에는 화요일에 출근한 시각과 화요일에 퇴근한 시각이 공백 하나를 사이로 두고 주어진다.
            세 번째 줄에는 수요일에 출근한 시각과 수요일에 퇴근한 시각이 공백 하나를 사이로 두고 주어진다.
            네 번째 줄에는 목요일에 출근한 시각과 목요일에 퇴근한 시각이 공백 하나를 사이로 두고 주어진다.
            다섯 번째 줄에는 금요일에 출근한 시각과 금요일에 퇴근한 시각이 공백 하나를 사이로 두고 주어진다.

            출력형식
            첫 번째 줄에 직원의 총 근무 시간을 분 단위로 출력한다.

            입력예제1
            10:00 19:00
            09:00 15:00
            10:00 11:00
            11:00 22:00
            09:00 15:00

            출력예제1
            1980
            월요일에 9시간, 화요일에 6시간, 수요일에 1시간, 목요일에 11시간, 금요일에 6시간을 근무하였다. 총 근무 시간은 9 + 6 + 1 + 11 + 6 = 33시간, 즉 33 × 60 = 1980분이다.

            입력예제2
            09:17 18:34
            09:17 18:34
            09:17 18:34
            09:17 18:34
            09:17 18:34

            출력예제2
            2785
            매일 9시간 17분을 근무하였으므로, 5일간 46시간 25분을 근무하였다.

            입력예제3
            09:17 19:24
            10:11 18:45
            09:34 18:27
            10:47 15:33
            08:47 18:32

            출력예제3
            2525
         */

        Scanner scan = new Scanner(System.in);
        long answer = 0;
        for (int i = 0; i < 5; i++) {
            answer += checkWorkTime(scan.next(), scan.next());
        }

        System.out.println(answer);
    }

    public static long checkWorkTime(String startTime, String endTime) throws ParseException {
        Date strDate = new SimpleDateFormat("HH:mm").parse(startTime);
        Date endDate = new SimpleDateFormat("HH:mm").parse(endTime);

        return (endDate.getTime() - strDate.getTime()) / (1000 * 60);
    }
}
