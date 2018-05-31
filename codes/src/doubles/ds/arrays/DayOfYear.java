package doubles.ds.arrays;

import java.util.Scanner;

// 그 해 경과 일 수를 구하기
public class DayOfYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int retry; // 다시한번 수행

        System.out.println("그 해 경과 일수를 구하기");

        do {
            System.out.print("년 : ");
            int year = scanner.nextInt();
            System.out.print("월 : ");
            int month = scanner.nextInt();
            System.out.print("일 : ");
            int day = scanner.nextInt();

            System.out.printf("그 해 %d일째입니다.", dayOfYear(year, month, day));
            System.out.println("한번 더할까요? (1.예 / 0.아니오)");
            retry = scanner.nextInt();
        } while (retry ==1);
    }

    // 각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    // 서기 year은 윤년인가? (윤년은 1, 평년은 0)
    private static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // year month day의 그해 경과일수를 구함
    private static int dayOfYear(int year, int month, int day) {
        int days = day;

        // 1월 ~ (month - 1)월의 일 수를 더함
        for (int i = 1; i < month; i++) {
            days += mdays[isLeap(year)][i - 1];
        }
        return days;
    }

}
