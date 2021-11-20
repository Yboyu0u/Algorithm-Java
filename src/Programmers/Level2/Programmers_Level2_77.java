package Programmers.Level2;



// 1초당 가장 많은 경험치를 획득할 수 있는 몬스터를 잡아야 한다

// player: 체력, 공격력, 방어력
// monster: 이름, 경험치, 체력, 공격력, 방어력

// 게임 진행 방식
    // 1. 플레이어가 몬스터를 공격 몬스터 체력 (플레이어 공격력 - 몬스터 방어력) 만큼 감소
        // ()이 0이하면 몬스터 체력 감소 X
    // 2. 몬스터의 체력이 0 이하가 되면 몬스터가 죽고, 전투가 종료
    // 3. 몬스터가 플레이어 공격, 플레이어 체력 (몬스터 공격력 - 플레이어의 방어력) 만큼 감소
        // 3-1. ()이 0 이하인 경우 플레이어의 체력 감소 X
    // 4. 플레이어의 체력이 0 이하가 되면 플레이어가 죽고, 전투가 종료
    // 5. 플레이어가 안 죽었으면 피해를 모두 회복하고 원래 체력으로

// 몬스터를 잡으면 해당 몬스터가 주는 경험치를 획득
    // 전투가 영원히 종료되지 않거나, 플레이어가 먼저 죽는다면 해당 몬스터를 잡을 수 없다고 판단
    // 몬스터를 한 번 공격하는데 1초가 걸린다
    // 한 번에 한 마리의 몬스터와 전투 진행

// character: 플레이어의 정보를 뜻하는 문자열
// monsters: 몬스터들의 정보가 담긴 문자열 배열


// 만약 1초당 가장 많은 경험치를 주는 몬스터가 여러 마리라면,
// 그중 한 마리를 잡았을 때 가장 많은 경험치를 주는 몬스터를 return
// 주는 경험치도 같다면 monsters 배열에서 먼저 주어진 몬스터를 return


import java.util.ArrayList;
import java.util.Collections;


public class Programmers_Level2_77 {
    private static class Catch implements Comparable<Catch>{
        String name;
        int time;
        int exp;
        double expByT;

        public Catch(int time, int exp, String name, double expByT) {
            this.name = name;
            this.time = time;
            this.exp = exp;
            this.expByT = expByT;
        }

        @Override
        public int compareTo(Catch o) {
            if(this.expByT<o.expByT){
                return 1;
            }
            else if(this.expByT>o.expByT){
                return -1;
            }

            return o.exp-this.exp;
        }
    }

    private static class Solution {
        public String solution(String character, String[] monsters) {
            String answer = "";
            ArrayList<Catch> list = new ArrayList<>();
            String[] player = character.split(" ");
            int playerHp = Integer.parseInt(player[0]);
            int playerPw = Integer.parseInt(player[1]);
            int playerDp = Integer.parseInt(player[2]);

            // player: 체력, 공격력, 방어력
            // monster: 이름, 경험치, 체력, 공격력, 방어력
            // 1. monsters 당 초 당 얼마의 경험치(초/경험치)를 획득할 수 있는지 check
            for(String mons: monsters){
                String[] monster = mons.split(" ");
                String name = monster[0];
                int exp = Integer.parseInt(monster[1]);
                int hp = Integer.parseInt(monster[2]);
                int pw = Integer.parseInt(monster[3]);
                int dp = Integer.parseInt(monster[4]);

                int cnt = 0;
                int subPlayerHp=playerHp;
                // 전투 시작
                while(subPlayerHp>0){
                    cnt++;
                    if(playerPw-dp<=0) break;
                    hp-=playerPw-dp;

                    if(hp<=0){
                        list.add(new Catch(cnt,exp,name,(double)exp/(double)cnt));
                        break;
                    }

                    if(pw-playerDp>0) subPlayerHp-=pw-playerDp;

                    if(subPlayerHp<0) break;

                    subPlayerHp=playerHp;
                }

            }

            Collections.sort(list);

            answer=list.get(0).name;

            return answer;
        }
    }
}
