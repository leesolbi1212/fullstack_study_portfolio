package lesson07;

import java.time.LocalDate;
import java.util.*;

record Ex08_WordDTO(String word, String meaning, String level, LocalDate regDate ) {
    public Ex08_WordDTO(String word, String meaning, String level) {
        this(word, meaning, level, LocalDate.now());
    }
    @Override
    public String toString() {
        return "[단어] " + word + " | 뜻: " + meaning + " | 레벨: " + level + " | 등록일: " + regDate;
    }
}

//컨트롤러
class Ex08_WordController {
    private final Ex08_WordService wordService = new Ex08_WordService();

    public void register(String word, String meaning, int levelNum) {
        String level = convertLevel(levelNum);
        if (level == null) {
            System.out.println("잘못된 레벨입니다.(1:초급, 2:중급, 3:고급)");
            return;
        }
        try {
            Ex08_WordDTO dto = new Ex08_WordDTO(word, meaning, level);
            wordService.registerWord(dto);
        } catch (IllegalArgumentException e) {
            System.out.println("등록 실패: " + e.getMessage());
        }
    }

    public void printAllWords() {
        List<Ex08_WordDTO> list = wordService.getAllWords();
        if (list.isEmpty()) {
            System.out.println("📂 등록된 단어가 없습니다.");
        } else {
            System.out.println("📘 등록된 단어 목록:");
            for (Ex08_WordDTO dto : list) {
                System.out.println("- " + dto);
            }
        }
    }

    public void query(String word) {
        Ex08_WordDTO dto = wordService.findWord(word);
        if (dto == null) {
            System.out.println("🔍 '" + word + "' 단어는 등록되어 있지 않습니다.");
        } else {
            System.out.println("🔎 조회 결과: " + dto);
        }
    }

    private String convertLevel(int levelNum) {
        return switch (levelNum) {
            case 1 -> "초급";
            case 2 -> "중급";
            case 3 -> "고급";
            default -> null;
        };
    }
}

//서비스 클래스
class Ex08_WordService {
    private final Ex08_WordRepository repository = new Ex08_WordRepository();

    public void registerWord(Ex08_WordDTO dto) {
        if (dto.word().isBlank() || dto.meaning().isBlank()) {
            // getter/setter을 만들어준 것 같은데 이게 뭔 지 어떻게 알아요? () 안에 아무것도 없으면 getter, 안에 뭐가 있으면 setter
            throw new IllegalArgumentException("단어와 뜻은 반드시 입력해야 합니다.");
        }
        repository.save(dto);
    }

    public List<Ex08_WordDTO> getAllWords() {
        return repository.findAll();
    }

    public Ex08_WordDTO findWord(String word) {
        return repository.findByWord(word);
    }
}

//레파지토리 데이터 저장
class Ex08_WordRepository {
    private final Map<String, Ex08_WordDTO> wordMap = new HashMap<>();
//    private final HashMap<String, WordDTO> meaningMap = new HashMap<>();

    public void save(Ex08_WordDTO dto) {
        wordMap.put(dto.word(), dto);
        System.out.println("저장 완료: " + dto.word());
    }

    public List<Ex08_WordDTO> findAll() {
        return new ArrayList<>(wordMap.values());
    }

    public Ex08_WordDTO findByWord(String word) {
        return wordMap.get(word);
    }
}


public class Ex08_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex08_WordController controller = new Ex08_WordController(); // con

        while (true) {
            System.out.println("영어 단어 사전");
            System.out.println("1. 단어 등록");
            System.out.println("2. 전체 단어 목록 보기");
            System.out.println("3. 단어 상세 조회");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
                case 1 -> {
                    System.out.print("영단어를 입력: ");
                    String word = sc.nextLine();
                    System.out.print("뜻 입력: ");
                    String meaning = sc.nextLine();
                    System.out.print("레벨 선택(1:초급, 2:중급, 3:고급): ");
                    int level = Integer.parseInt(sc.nextLine());
                    controller.register(word, meaning, level);
                }
                case 2 -> controller.printAllWords();
                case 3 -> {
                    System.out.print("조회할 영단어 입력: ");
                    String word = sc.nextLine();
                    controller.query(word);
                }
                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}