package Level1;

import java.util.Arrays;

public class Fruiterer {
    public static void main(String[] args) {
        /*
            과일 장수
            문제 설명
            과일 장수가 사과 상자를 포장하고 있습니다. 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며, k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 사과 한 상자의 가격은 다음과 같이 결정됩니다.

            한 상자에 사과를 m개씩 담아 포장합니다.
            상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
            과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.(사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)

            예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면, 다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.

            (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
            사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때, 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.

            제한사항
            3 ≤ k ≤ 9
            3 ≤ m ≤ 10
            7 ≤ score의 길이 ≤ 1,000,000
            1 ≤ score[i] ≤ k
            이익이 발생하지 않는 경우에는 0을 return 해주세요.
            입출력 예
            k	m	        score	                       result
            3	4	[1, 2, 3, 1, 2, 3, 1]	                8
            4	3	[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]	33
            입출력 예 설명
            입출력 예 #1

            문제의 예시와 같습니다.
            입출력 예 #2

            다음과 같이 사과 상자를 포장하여 모두 팔면 최대 이익을 낼 수 있습니다.
            사과 상자	가격
            [1, 1, 2]	1 x 3 = 3
            [2, 2, 2]	2 x 3 = 6
            [4, 4, 4]	4 x 3 = 12
            [4, 4, 4]	4 x 3 = 12
            따라서 (1 x 3 x 1) + (2 x 3 x 1) + (4 x 3 x 2) = 33을 return합니다.
         */

        /* TC1 */
        /*int k = 3; // 사과의 최대 점수
        int m = 4;  // 한 상자에 들어가는 사과의 수
        int[] score = {1, 2, 3, 1, 2, 3, 1}; // 사과들의 점수*/

        /* TC2 */
        int k = 4; // 사과의 최대 점수
        int m = 3;  // 한 상자에 들어가는 사과의 수
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}; // 사과들의 점수

        int result = 0; //반환 값
        int amount = 0; //상자에 담겨있는 사과 개수
        int index = k; // 배열의 인덱스 위치 (k값이 사과의 최대 점수이므로 k보다 큰 사과 점수는 없다. 따라서 k번째부터 시작)
        int[] ints = new int[10]; // 0 ~ 9
        for (int i = 0; i < score.length; i++) ints[score[i]]++; // 각 점수 별로 나눈다.

        // k값이 사과의 최대 점수이므로 k보다 큰 사과 점수는 없다. 따라서 k번째부터 시작
        while (index > 0) {
            if (ints[index] == 0) { //해당 사과 점수에서 더 이상 담을 사과가 없을 경우 다음으로 넘어간다.
                index--;
                continue;
            }

            amount++;
            ints[index]--;

            if (amount == m) { // 해당 상자에 사과가 모두 담겼을 경우
                amount = 0; // 새 상자에 담아야하므로 값 초기화
                result += index * m; // 현재 담아둔 사과 점수 * 상자에 담겨있는 사과 개수 (마지막에 담아둔 사과 점수가 해당 상자에 최저 점수이다.)
                continue;
            }
        }

        System.out.println(result);
    }
}