package Level2;

import java.util.*;

public class Level2_test2 {
    public static void main(String[] args) {
        /*
            혼자 놀기의 달인
            문제 설명
            혼자서도 잘 노는 범희는 어느 날 방구석에 있는 숫자 카드 더미를 보더니 혼자 할 수 있는 재미있는 게임을 생각해냈습니다.

            숫자 카드 더미에는 카드가 총 100장 있으며, 각 카드에는 1부터 100까지 숫자가 하나씩 적혀있습니다.
            2 이상 100 이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자 카드들을 준비하고,
            준비한 카드의 수만큼 작은 상자를 준비하면 게임을 시작할 수 있으며 게임 방법은 다음과 같습니다.

            준비된 상자에 카드를 한 장씩 넣고, 상자를 무작위로 섞어 일렬로 나열합니다.
            상자가 일렬로 나열되면 상자가 나열된 순서에 따라 1번부터 순차적으로 증가하는 번호를 붙입니다.

            그 다음 임의의 상자를 하나 선택하여 선택한 상자 안의 숫자 카드를 확인합니다.
            다음으로 확인한 카드에 적힌 번호에 해당하는 상자를 열어 안에 담긴 카드에 적힌 숫자를 확인합니다.
            마찬가지로 숫자에 해당하는 번호를 가진 상자를 계속해서 열어가며, 열어야 하는 상자가 이미 열려있을 때까지 반복합니다.

            이렇게 연 상자들은 1번 상자 그룹입니다. 이제 1번 상자 그룹을 다른 상자들과 섞이지 않도록 따로 둡니다.
            만약 1번 상자 그룹을 제외하고 남는 상자가 없으면 그대로 게임이 종료되며, 이때 획득하는 점수는 0점입니다.

            그렇지 않다면 남은 상자 중 다시 임의의 상자 하나를 골라 같은 방식으로 이미 열려있는 상자를 만날 때까지 상자를 엽니다.
            이렇게 연 상자들은 2번 상자 그룹입니다.

            1번 상자 그룹에 속한 상자의 수와 2번 상자 그룹에 속한 상자의 수를 곱한 값이 게임의 점수입니다.

            상자 안에 들어있는 카드 번호가 순서대로 담긴 배열 cards가 매개변수로 주어질 때,
            범희가 이 게임에서 얻을 수 있는 최고 점수를 구해서 return 하도록 solution 함수를 완성해주세요.

            제한사항
            2 ≤ cards의 길이 ≤ 100
            cards의 원소는 cards의 길이 이하인 임의의 자연수입니다.
            cards에는 중복되는 원소가 존재하지 않습니다.
            cards[i]는 i + 1번 상자에 담긴 카드에 적힌 숫자를 의미합니다.
            입출력 예
            cards	            result
            [8,6,3,7,2,5,1,4]	  12
            입출력 예 설명
            1, 4, 7, 8이 속하는 상자의 그룹과 2, 5, 6이 속하는 상자의 그룹과 3이 속하는 상자의 그룹이 존재합니다.
            따라서 3번 상자를 고르지 않았을 때, 두 번의 시행에서 3과 4를 기록하며 최고 점수 12를 얻을 수 있습니다.
         */

        /* TC 1 */
        //int[] cards = {8,6,3,7,2,5,1,4};

        /* TC 2 */
        //int[] cards = {2, 3, 4, 5, 6, 1};

        /* TC 3 */
        int[] cards = {6, 1, 4, 3, 7, 2, 5};

        int[] openBoxed = new int[cards.length];
        int cnt = 0;
        int index = 0;
        PriorityQueue<Integer> prQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            if (openBoxed[i] == 1) continue;
            else {
                cnt = 0;
                index = cards[i] - 1;

                while (true) {
                    if (openBoxed[index] == 1) break;
                    else {
                        cnt++;
                        openBoxed[index] = 1;
                        index = cards[index] - 1;
                    }
                }

                if (cnt ==  cards.length) {
                    System.out.println("0종료"); //정답에서는 return 0 으로 수정
                    break;
                } else prQueue.add(cnt);
            }
        }

        System.out.println(prQueue.poll() * prQueue.poll());

    }
}
