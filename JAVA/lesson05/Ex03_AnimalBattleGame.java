package lesson05;

import java.util.Random;
import java.util.Scanner;

// 공통으로 적용될 동물들의 속성
abstract class Animal {
    String name;
    int maxHp;
    int hp;
    int power;
    int maxSkillCount; // 필살기 최대 횟수
    int skillCount;

    // 생성자로 전달 받기
    public Animal(String name, int power, int maxHp, int maxSkillCount) {
        this.name = name;
        this.power = power;
        this.maxHp = maxHp;
        this.hp = maxHp; // 처음에는 최대치와 동일하기 때문
        this.maxSkillCount = maxSkillCount;
        this.skillCount = maxSkillCount; // 처음에는 최대치와 동일하기 때문
    }

    // 공통적으로 필요한 메서드 정의 (캐릭터마다 다를 수 있어서 껍데기만 만듦)
    abstract void attack(); //일반 공격 필요
    abstract int getAttackPower(); //공격할 때 hp를 얼마나 깎는지
    abstract String getSkillName(); //공격 이름 가져오기
    abstract void useSkill(Animal enemy); //누구한테 공격을 썼는지, 적군에 대한 동물 객체를 넣기

    // 모든 동물이 동일하게 갖고 있는 것.
    // 생사 여부
    boolean isAlive() {
        return hp > 0; // 살았으면 T, 아니면 F
    }
    // 필살기를 쓸 수 있는지? 갯수 확인
    boolean canUseSkill() {
        return skillCount > 0; //현재 skillCount가 0보다 큰지
    }
    // 데미지를 얼마나 받았는지 계속 측정
    void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0; //체력이 음수가 될 수 없기 때문에 0으로 맞춰주기
    }
    // 현재 상황을 찍어주는 것.
    void printStatus() {
        System.out.println(name + " 체력: " + hp + "/" + maxHp + " | 스킬 남은 횟수: " + skillCount + "/" + maxSkillCount);
    }
}
// abstract Animal을 상속받아서 동물별로 세부 설정 해주기
class Dragon extends Animal {
    // 변하지 않는 고정 설정
    public Dragon() {
        super("드래곤", 30, 180, 3);
    }
    // 메서드 구현 (재정의로 하면 구현하지 않아도 되는 것 까지 다 나옴)
    @Override
    void attack() {
        System.out.println("🔥 드래곤이 불을 내뿜는다!");
    }

    @Override
    int getAttackPower() {
        return power + new Random().nextInt(20);
        // 30~49까지의 랜덤한 공격력이 나올 것
    }

    @Override
    String getSkillName() {
        return "파이어 브레스";
    }

    @Override
    // 남은 스킬 횟수 계산 & 스킬 사용하기
    void useSkill(Animal enemy) {
        if (canUseSkill()) {
            skillCount--; // 스킬 사용 횟수 1개 차감
            int damage = 40 + new Random().nextInt(20); // 40~59
            System.out.println("🔥 드래곤의 스킬! 파이어 브레스!! (불꽃 데미지 " + damage + ")");
            enemy.takeDamage(damage); // 상대방 객체에게 데미지를 주는 것
        } else {
            System.out.println("❌ 드래곤은 더 이상 스킬을 사용할 수 없습니다!");
        }
    }
}

class Wolf extends Animal {
    public Wolf() {
        super("늑대", 25, 160, 2); // 체력 상향, 스킬 2회
    }

    @Override
    void attack() {
        System.out.println("🌕 늑대가 어둠 속에서 덮친다!");
    }

    @Override
    int getAttackPower() {
        return power + new Random().nextInt(15); // 25~39
    }

    @Override
    String getSkillName() {
        return "달빛 어금니";
    }

    @Override
    void useSkill(Animal enemy) {
        if (canUseSkill()) {
            skillCount--;
            int damage = 35 + new Random().nextInt(15); // 35~49
            System.out.println("🌙 늑대의 스킬! 달빛 어금니!! (강력 데미지 " + damage + ")");
            enemy.takeDamage(damage);
        } else {
            System.out.println("❌ 늑대는 더 이상 스킬을 사용할 수 없습니다!");
        }
    }
}

class Bear extends Animal {
    public Bear() {
        super("곰", 20, 200, 1);
    }

    @Override
    void attack() {
        System.out.println("🐻 곰이 앞발로 내려친다!");
    }

    @Override
    int getAttackPower() {
        return power + new Random().nextInt(10); // 20~29
    }

    @Override
    String getSkillName() {
        return "대지 강타";
    }

    @Override
    void useSkill(Animal enemy) {
        if (canUseSkill()) {
            skillCount--;
            int damage = (int)(enemy.hp * 0.3);
            if (damage < 25) damage = 25;
            System.out.println("🌍 곰의 스킬! 대지 강타!! (적 체력의 30% 데미지: " + damage + ")");
            enemy.takeDamage(damage);
        } else {
            System.out.println("❌ 곰은 더 이상 스킬을 사용할 수 없습니다!");
        }
    }
}

// === 메인 게임 ===

public class Ex03_AnimalBattleGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal[] allAnimals = { new Dragon(), new Wolf(), new Bear() };
        Animal[] playerTeam = new Animal[2];
        Animal[] enemyTeam = new Animal[2];
        Random rand = new Random(); // 랜덤 객체를 만들어두기

        System.out.println("🧙 : 전설의 포켓동물 배틀에 오신 걸 환영합니다!");
        System.out.println("<< 두 마리의 포켓동물을 선택하세요 >>>");

        for (int i = 0; i < 2; i++) {
            // 2바퀴를 돌면서 2개의 동물을 선택하게 만들어줘야함.
            System.out.println("1. 드래곤 🐉\n2. 늑대 🐺\n3. 곰 🐻");
            System.out.print((i + 1) + "번째 동물 선택: ");
            int choice = sc.nextInt(); // 숫자를 입력 받기
            playerTeam[i] = copyAnimal(allAnimals[choice - 1]);
        }

        // 적 팀 랜덤 구성
        for (int i = 0; i < 2; i++) {
            // 무한 루프 돌리기
            while (true) {
                // 랜덤을 돌려서 적군 동물을 생성해준다.
                Animal enemy = copyAnimal(allAnimals[rand.nextInt(3)]);
                // 동일한 동물이 나오지 않도록 조건 걸기
                boolean exists = false; // 기본 값 false
                for (int j = 0; j < i; j++) {
                    if (enemy.name.equals(enemyTeam[j].name)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    enemyTeam[i] = enemy;
                    break;
                }
            }
        }
        // 0번, 1번 2개 있는데 그 중 0번을 먼저 출연 시키려고 하는 것
        int playerIdx = 0;
        int enemyIdx = 0;

        while (true) {
            Animal player = playerTeam[playerIdx];
            Animal enemy = enemyTeam[enemyIdx];

            System.out.println("\n=======================================");
            System.out.println("👊 현재 전투 중인 포켓동물");
            player.printStatus(); // 현재 상태 찍어주기
            enemy.printStatus(); // 현재 상태 찍어주기

            // 플레이어 턴
            System.out.println("\n[당신의 턴]");
            System.out.println("1. 일반 공격");
            System.out.println("2. 스킬 사용 (" + player.getSkillName() + ")");
            System.out.println("3. 동물 교체");
            System.out.print("선택 >> ");
            int action = sc.nextInt();

            if (action == 1) {
                player.attack();
                int damage = player.getAttackPower();
                System.out.println("💥 공격력: " + damage);
                enemy.takeDamage(damage);
            } else if (action == 2) {
                player.useSkill(enemy);
            } else if (action == 3) {
                int otherIdx = 1 - playerIdx;
                if (!playerTeam[otherIdx].isAlive()) {
                    System.out.println("⚠️ 다른 동물이 전투불능입니다!");
                    continue;
                }
                playerIdx = otherIdx;
                System.out.println("🔁 포켓동물 교체!");
                continue;
            }

            if (!enemy.isAlive()) {
                System.out.println("✅ 적 " + enemy.name + "이(가) 쓰러졌습니다!");
                enemyIdx++;
                if (enemyIdx >= 2) {
                    System.out.println("🎉 당신이 승리했습니다!!");
                    break;
                }
            }

            // 적 턴
            Animal currEnemy = enemyTeam[enemyIdx];
            Animal currPlayer = playerTeam[playerIdx];
            System.out.println("\n[👾 적의 턴: " + currEnemy.name + "]");

            int enemyChoice;
            if (currEnemy.hp < 60 && currEnemy.canUseSkill() && rand.nextInt(100) < 70) {
                enemyChoice = 1;
            } else {
                enemyChoice = 0;
            }

            if (enemyChoice == 0) {
                System.out.println("👾 적이 일반 공격을 선택합니다!");
                currEnemy.attack();
                int damage = currEnemy.getAttackPower();
                System.out.println("💥 공격력: " + damage);
                currPlayer.takeDamage(damage);
            } else {
                System.out.println("👾 적이 스킬 '" + currEnemy.getSkillName() + "'을(를) 사용합니다!");
                currEnemy.useSkill(currPlayer);
            }

            if (!currPlayer.isAlive()) {
                System.out.println("☠️ 당신의 " + currPlayer.name + "이(가) 쓰러졌습니다!");
                if (!playerTeam[1 - playerIdx].isAlive()) {
                    System.out.println("💀 모든 포켓동물이 쓰러졌습니다. 패배...");
                    break;
                } else {
                    playerIdx = 1 - playerIdx;
                    System.out.println("🔁 자동으로 다른 포켓동물로 교체합니다!");
                }
            }
        }

        sc.close();
    }

    public static Animal copyAnimal(Animal original) {
        // 객체를 받아서 새로운 객체를 리턴시켜주는 것
        if (original.name.equals("드래곤")) return new Dragon();
        else if (original.name.equals("늑대")) return new Wolf();
        else return new Bear();
    }
}