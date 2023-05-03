package Level1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RunningRace {
    public static void main(String[] args) {
        /*
            달리기 경주

            문제 설명

            얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
            예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
            해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
            즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

            선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
            경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

            제한사항
            5 ≤ players의 길이 ≤ 50,000
            players[i]는 i번째 선수의 이름을 의미합니다.
            players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
            players에는 중복된 값이 들어가 있지 않습니다.
            3 ≤ players[i]의 길이 ≤ 10
            2 ≤ callings의 길이 ≤ 1,000,000
            callings는 players의 원소들로만 이루어져 있습니다.
            경주 진행중 1등인 선수의 이름은 불리지 않습니다.

            입출력 예
                        players	                            callings	                            result
            ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]

            입출력 예 설명
            입출력 예 #1
            4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다.
            5등인 "mine" 선수가 2번 추월하여 4등, 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다.
            1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.
         */

        /* TC 1 result : ["mumu", "kai", "mine", "soe", "poe"] */
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        /*
        List<String> list = new ArrayList<>();

        for (String str : players) list.add(str);
        System.out.println(list);

        for (String str : callings) {
            int playerIndex = list.indexOf(str);
            list.remove(playerIndex);
            list.add(playerIndex - 1, str);
        }

        String[] answer = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(answer));
        */

        /*
        Map<String, Position> map = new HashMap<>();
        String[] answer = new String[players.length];

        for (int index = 0; index < players.length; index++) {
            Position position = null;
            if (index == 0) position = new Position(index, players[index],"", players[index+1]);
            else if (index == players.length - 1) position = new Position(index, players[index], players[index-1], "");
            else position = new Position(index, players[index], players[index-1], players[index+1]);

            map.put(players[index], position);
        }

        for (String str : callings) {
            Position callPosition = map.get(str);
            Position frontPosition = map.get(callPosition.getFrontPlayer());
            Position beforePosition = map.get(callPosition.getBeforePlayer());

            settingPosition(callPosition, frontPosition, beforePosition);
        }

        for (String str : map.keySet()) answer[map.get(str).getIndex()] = str;

        System.out.println(Arrays.toString(answer));
        */


        /*
        Queue<String> queue = new LinkedList<>();
        String[] answer = new String[players.length];

        for (String str : players) queue.add(str);

        for (String str : callings) {
            settingQueue(str, queue);
        }

        for (int i = 0; i < answer.length; i++) answer[i] = queue.poll();

        System.out.println(Arrays.toString(answer));
        */

        Map<String, Integer> player = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();
        String[] answer = new String[players.length];

        for (int index = 0; index < players.length; index++) {
            player.put(players[index], index);
            indexMap.put(index, players[index]);
        }

        for (String str : callings) {
            int playerIndex = player.get(str);
            String frontPlayer = indexMap.get(playerIndex - 1);
            player.put(str, playerIndex-1);
            player.put(frontPlayer, player.get(frontPlayer) + 1);
        }

        for (String str : player.keySet()) answer[player.get(str)] = str;

        System.out.println(Arrays.toString(answer));

    }

    private static void settingQueue(String str, Queue<String> queue) {
        for (int i = 0; i < queue.size(); i++) {
            String player = queue.poll();
            if (str.equals(queue.peek())) {
                String nextPlayer = queue.poll();
                queue.add(nextPlayer);
                queue.add(player);
                i++;
            } else {
                queue.add(player);
            }
        }
    }

    private static void settingPosition(Position callPosition, Position frontPosition, Position beforePosition) {
        String callPositionBeforePlayer = "";

        if (callPosition != null) {
            callPositionBeforePlayer = callPosition.getBeforePlayer();
            callPosition.setIndex(callPosition.getIndex() - 1);

            if (callPosition != null) {
                callPosition.setFrontPlayer(frontPosition.getFrontPlayer());
                callPosition.setBeforePlayer(frontPosition.getPlayer());
            }
        }

        if (frontPosition != null) {
            frontPosition.setIndex(frontPosition.getIndex() + 1);
            if (callPosition != null) frontPosition.setFrontPlayer(callPosition.getPlayer());
            frontPosition.setBeforePlayer(callPositionBeforePlayer);
        }

        if (beforePosition != null && frontPosition != null) beforePosition.setFrontPlayer(frontPosition.getPlayer());
    }

    public static class Position {
        private int index;

        private String player;
        private String frontPlayer;
        private String beforePlayer;

        public Position(int index, String player, String frontPlayer, String beforePlayer) {
            this.index = index;
            this.player = player;
            this.frontPlayer = frontPlayer;
            this.beforePlayer = beforePlayer;
        }

        public int getIndex() {
            return index;
        }

        public String getPlayer() {
            return player;
        }

        public String getFrontPlayer() {
            return frontPlayer;
        }

        public String getBeforePlayer() {
            return beforePlayer;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPlayer(String player) {
            this.player = player;
        }

        public void setFrontPlayer(String frontPlayer) {
            this.frontPlayer = frontPlayer;
        }

        public void setBeforePlayer(String beforePlayer) {
            this.beforePlayer = beforePlayer;
        }
    }
}
