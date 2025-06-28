package lesson07;

/*

[사용자 입력] > controller > service > Repo > DTO 저장

*/

import java.time.LocalDate;
import java.util.*;

// 데이터 상자 역할, 전달 전용 객체, DB처럼 값을 담고 주고받을 때 사용함.
class WordDTO {
    // 데이터 베이스에 저장할 내용이 있다면 그거랑 동일하게 필드를 구성하는 객체 이면서, 이걸 서비스 단으로 주고받고 할겨
    private String word; //영단어
    private String meaning; // 한국어
    private String level;
    private LocalDate regDate;
    // private로 막아뒀기 때문에 getter, setter로 가져와서 써야함.

    // 생성자 만들기 (마우스 우클릭으로 다 선택해서 만들어버령)
    public WordDTO(String word, String meaning, String level) {
        this.word = word;
        this.meaning = meaning;
        this.level = level;
        this.regDate = LocalDate.now();
    }

    // getter/setter도 마우스 우클릭으로 다 만들기
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public LocalDate getRegDate() {
        return regDate;
    }
    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "[단어] : " + word + " | 뜻 : " + meaning + " | 레벨 : " + level + " | 등록일 : " + regDate;
    }
}

// 사용자 요청을 처리하는 역할 (등록을 받으면, wordService에 전달, 2번의 요청도 여기서 받음)
class WordController {
    private final WordService service = new WordService();

    // 단어 등록
    public void register(String word, String meaning, int levelNum) {
        String level = ConvertLevel(levelNum);
        // 레벨부터 필터링
        if(level == null) {
            System.out.println("잘못된 레벨입니다.(1: 초급, 2: 중급, 3: 고급)");
            return;
        }
        try{
            WordDTO dto = new WordDTO(word, meaning, level);
            service.registerWord(dto);

        } catch(IllegalArgumentException e) { //파라미터가 문제 있다면
            System.out.println("등록 실패 : " + e.getMessage());
        }
    }
    // 전체 단어 조회
    public void printAllWords() {
        List<WordDTO> list = service.getAllwords();
        if(list.isEmpty()) {
            System.out.println("등록된 단어가 없습니다");
        } else {
            System.out.println("등록된 단어 목록");
            for(WordDTO dto : list) {
                System.out.println("- " + dto);
            }
        }
    }

    // 단어 상세 조회
    public void getWord(String word) {
        WordDTO dto = service.getWord(word);
        if(dto == null) {
            System.out.println(word + " 단어는 등록되어있지 않습니다.");
        } else {
            System.out.println("- " + dto);
        }
    }


    // 레벨에 대한 함수 (그냥 만듦)
    private String ConvertLevel(int levelNum) {
        return switch (levelNum) {
            case 1 -> "초급";
            case 2 -> "중급";
            case 3 -> "고급";
            default -> null;
        };
    }
}
// controller와 Repository 사이에서 중간 다리 역할
class WordService {
    private final WordRepository repository = new WordRepository();
    // 단어 등록 : 유효성 검사 하고 Repo로 전달
    public void registerWord(WordDTO dto) {
        if(dto.getWord().isBlank() || dto.getMeaning().isBlank()) {throw new IllegalArgumentException("단어와 뜻은 반드시 입력해야 합니다.");}
        repository.save(dto);
    }
    // 전체 단어 조회 : controller에서 요청 오면 바로 Repo에 요청
    public List<WordDTO> getAllwords() {
        return repository.findAll();
    }
    // 단어 상세 조회
    public WordDTO getWord(String word) {
        return repository.findWord(word);
    }

}

// 임시 DB 역할 : 나중에 DB 연결 시 이 부분만 바꾸면 됨. 실제로 단어를 저장하고 불러오는 역할
class WordRepository {
    private final Map<String, WordDTO> wordMap = new HashMap<>();
    // 단어 저장
    public void save(WordDTO dto) {
        wordMap.put(dto.getWord(), dto);
        System.out.println("저장 완료: " + dto.getWord());
    }
    // 단어 전체 조회하는 것 (value들만 뽑아서 array에 담아줄게)
    public List<WordDTO> findAll() {
        return new ArrayList<>(wordMap.values());
    }
    public WordDTO findWord(String word) {
        return wordMap.get(word);
    }
}

// 프로그램 시작점 + 사용자 입력 받는 콘솔 UI
public class Ex06_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordController controller = new WordController();

        while(true) {
            System.out.println("영어 단어 사전");
            System.out.println("1. 단어 등록");
            System.out.println("2. 전체 단어 목록 보기");
            System.out.println("3. 단어 상세 조회하기");
            System.out.println("0. 종료하기");
            System.out.print("선택 : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 0 -> {
                    System.out.println("종료");
                    sc.close();
                    return; //메인 메소드 빠져나가기
                }
                case 1 -> {
                    System.out.print("영단어 입력: ");
                    String word = sc.nextLine();

                    System.out.print("뜻 입력: ");
                    String meaning = sc.nextLine();

                    System.out.print("레벨 선택 (1: 초급, 2: 중급, 3: 고급): ");
                    int level = Integer.parseInt(sc.nextLine());

                    controller.register(word, meaning, level);
                }
                case 2 -> {
                    controller.printAllWords();
                }
                case 3 -> {
                    System.out.println("조회할 영단어 입력 :");
                    String word = sc.nextLine();
                    controller.getWord(word);
                    // 입력한 단어만 출력하는 것
                }
                default -> System.out.println("잘못된 메뉴 입니다");
            }
        }
    }
}
